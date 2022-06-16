package cn.cpoet.mt.web.single;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * 单体应用
 *
 * @author CPoet
 */
@SpringBootApplication
public class WebSingleApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(WebSingleApplication.class)
            .bannerMode(Banner.Mode.OFF)
            .build(args)
            .run();
    }
}
