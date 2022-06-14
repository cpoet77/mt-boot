package cn.cpoet.mt.db.configuration;

import cn.cpoet.mt.api.comm.IDGenerator;
import cn.cpoet.mt.api.constant.SystemConst;
import cn.cpoet.mt.api.runtime.AppContext;
import cn.cpoet.mt.db.comm.IdGeneratorWrapper;
import cn.cpoet.mt.db.configuration.auto.DataSourceConfig;
import cn.cpoet.mt.db.configuration.auto.DataSourceProperties;
import cn.cpoet.mt.db.constant.DataSourceType;
import cn.cpoet.mt.db.tenant.TenantDbContext;
import com.alibaba.druid.pool.DruidDataSource;
import io.ebean.Database;
import io.ebean.DatabaseFactory;
import io.ebean.config.DatabaseConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * ebean相关配置
 *
 * @author wanggf
 */
@Configuration
@RequiredArgsConstructor
public class InitDbConfig {
    private final List<IDGenerator<?>> idGenerators;
    private final DataSourceProperties dataSourceProperties;

    @Bean
    @Primary
    public Database getAndInitMainDb() {
        TenantDbContext context = TenantDbContext.getInstance();
        Database masterDb = createDatabase(dataSourceProperties, DataSourceType.MAIN_MASTER.name());
        context.addMasterDb(SystemConst.SYS_TENANT_ID, masterDb);
        List<DataSourceConfig> slaves = dataSourceProperties.getSlaves();
        if (!CollectionUtils.isEmpty(slaves)) {
            for (DataSourceConfig slaveDsConfig : slaves) {
                Database database = createDatabase(slaveDsConfig, DataSourceType.MAIN_SLAVE.name() + System.currentTimeMillis());
                context.addSalveDb(SystemConst.SYS_TENANT_ID, database);
            }
        }
        return masterDb;
    }

    private Database createDatabase(DataSourceConfig dsConfig, String defaultName) {
        String dbName = StringUtils.hasText(dsConfig.getName()) ? dsConfig.getName() : defaultName;
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setName(dbName);
        druidDataSource.setUrl(dsConfig.getUrl());
        druidDataSource.setUsername(dsConfig.getUsername());
        druidDataSource.setPassword(dsConfig.getPassword());
        DatabaseConfig config = new DatabaseConfig();
        // 数据源名称
        config.setName(dbName);
        // 当前用户上下文信息
        config.setCurrentUserProvider(() -> -1L);
        // 当前租户信息
        config.setCurrentTenantProvider(() -> SystemConst.SYS_TENANT_ID);
        config.setDataSource(druidDataSource);
        // ID生成器注册
        if (!CollectionUtils.isEmpty(idGenerators)) {
            config.setIdGenerators(idGenerators
                .stream()
                .map(IdGeneratorWrapper::new)
                .collect(Collectors.toList()));
        }
        return DatabaseFactory.create(config);

    }
}
