package cn.cpoet.mt.cloud.boot.configuration;

import cn.cpoet.mt.api.runtime.AppContext;
import cn.cpoet.mt.cloud.boot.runtime.CloudAppContext;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * @author CPoet
 */
@EnableFeignClients("cn.cpoet.mt.cloud.boot.feign")
public class CloudBootConfig {
    @Bean
    @Primary
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public AppContext appContext() {
        return new CloudAppContext();
    }
}
