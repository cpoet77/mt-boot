package cn.cpoet.mt.core.auth;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

/**
 * 认证定制化
 *
 * @author CPoet
 */
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            // 禁用CSRF
            .csrf().disable()
            // 禁用Session，全局采用Token认证
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
            // 禁用登录页面
            .formLogin().disable()
            // 过滤请求
            .authorizeRequests()
            // 认证页面可匿名访问
            .antMatchers("/auth").anonymous()
            // 所有需要认证的页面
            .anyRequest().authenticated().and()
            .headers().frameOptions().disable();
    }
}
