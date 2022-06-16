package cn.cpoet.mt.db.configuration;

import cn.cpoet.mt.db.configuration.auto.DataSourceProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

/**
 * 数据库相关配置
 *
 * @author CPoet
 */
@Import({InitDbConfig.class})
public class DbConfig {
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    @ConditionalOnMissingBean
    public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }
}
