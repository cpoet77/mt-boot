package cn.cpoet.mt.db.configuration;

import cn.cpoet.mt.api.comm.IDGenerator;
import cn.cpoet.mt.db.comm.IdGeneratorWrapper;
import cn.cpoet.mt.db.configuration.auto.DataSourceProperties;
import io.ebean.Database;
import io.ebean.DatabaseFactory;
import io.ebean.config.DatabaseConfig;
import io.ebean.datasource.DataSourceConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * ebean相关配置
 *
 * @author wanggf
 */
@Configuration
@RequiredArgsConstructor
public class EBeanConfig {
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    @ConditionalOnMissingBean
    public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @ConditionalOnMissingBean
    public DatabaseConfig databaseConfig(DataSourceProperties dataSourceProperties,
//                                         AuthContext authContext,
                                         List<IDGenerator<?>> idGenerators) {
        DatabaseConfig config = new DatabaseConfig();
        // 数据源名称
        config.setName(dataSourceProperties.getName());
        // 当前用户上下文信息
        config.setCurrentUserProvider(() -> -1);
        // 当前租户信息
        config.setCurrentTenantProvider(() -> -1);
        DataSourceConfig dsConfig = new DataSourceConfig();
        dsConfig.setDriver(dataSourceProperties.getDriverClassName());
        dsConfig.setUrl(dataSourceProperties.getUrl());
        dsConfig.setUsername(dataSourceProperties.getUsername());
        dsConfig.setPassword(dataSourceProperties.getPassword());
        config.setDataSourceConfig(dsConfig);
        // ID生成器注册
        if (!CollectionUtils.isEmpty(idGenerators)) {
            config.setIdGenerators(idGenerators
                .stream()
                .map(IdGeneratorWrapper::new)
                .collect(Collectors.toList()));
        }
        return config;
    }

    @Bean
    @ConditionalOnMissingBean
    public Database customDatabase(DatabaseConfig databaseConfig) {
        return DatabaseFactory.create(databaseConfig);
    }
}
