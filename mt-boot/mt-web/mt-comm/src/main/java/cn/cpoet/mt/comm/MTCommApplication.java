package cn.cpoet.mt.comm;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author CPoet
 */
@SpringBootApplication
public class MTCommApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(MTCommApplication.class)
            .bannerMode(Banner.Mode.OFF)
            .build(args)
            .run();
    }
}
