package cn.cpoet.mt.db.configuration;

import cn.cpoet.mt.api.comm.IDGenerator;
import cn.cpoet.mt.api.runtime.AppContext;
import cn.cpoet.mt.db.configuration.auto.DataSourceProperties;
import io.ebean.Database;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.List;

/**
 * ebean相关配置
 *
 * @author wanggf
 */
@Configuration
@RequiredArgsConstructor
public class InitDbConfig {
    private final AppContext appContext;
    private final List<IDGenerator<?>> idGenerators;
    private final DataSourceProperties dataSourceProperties;

    @Bean
    @Primary
    public Database initDbGetMaster() {
//        DatabaseConfig config = new DatabaseConfig();
//        // 数据源名称
//        config.setName(dataSourceProperties.getName());
//        // 当前用户上下文信息
//        config.setCurrentUserProvider(() -> -1);
//        // 当前租户信息
//        config.setCurrentTenantProvider(() -> -1);
//        DataSourceConfig dsConfig = new DataSourceConfig();
//        dsConfig.setDriver(dataSourceProperties.getDriverClassName());
//        dsConfig.setUrl(dataSourceProperties.getUrl());
//        dsConfig.setUsername(dataSourceProperties.getUsername());
//        dsConfig.setPassword(dataSourceProperties.getPassword());
//        config.setDataSourceConfig(dsConfig);
//        // ID生成器注册
//        if (!CollectionUtils.isEmpty(idGenerators)) {
//            config.setIdGenerators(idGenerators
//                .stream()
//                .map(IdGeneratorWrapper::new)
//                .collect(Collectors.toList()));
//        }
//        return config;
        return null;
    }
}
