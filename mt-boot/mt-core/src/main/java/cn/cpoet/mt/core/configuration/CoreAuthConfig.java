package cn.cpoet.mt.core.configuration;

import cn.cpoet.mt.api.auth.AuthContext;
import cn.cpoet.mt.core.auth.SimpleAuthContext;
import cn.cpoet.mt.core.auth.WebSecurityConfigurer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

/**
 * 核心认证配置
 *
 * @author CPoet
 */
@Configuration
@EnableWebSecurity
public class CoreAuthConfig {
    @Bean
    @ConditionalOnMissingBean
    public AuthContext authContext() {
        return new SimpleAuthContext();
    }

    @Bean
    @ConditionalOnMissingBean
    public WebSecurityConfigurer webSecurityConfigurer() {
        return new WebSecurityConfigurer();
    }
}
