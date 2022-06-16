package cn.cpoet.mt.web.gateway.configuration;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

/**
 * @author CPoet
 */
@Configuration
@EnableFeignClients("cn.cpoet.mt.web.gateway.feign")
public class FeignConfig {
}
