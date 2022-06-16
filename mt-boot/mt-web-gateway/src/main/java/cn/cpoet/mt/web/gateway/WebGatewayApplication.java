package cn.cpoet.mt.web.gateway;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author CPoet
 */
@SpringBootApplication
public class WebGatewayApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(WebGatewayApplication.class)
            .bannerMode(Banner.Mode.OFF)
            .build(args)
            .run();
    }
}
