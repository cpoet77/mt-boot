package cn.cpoet.mt.single;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * 单体应用
 *
 * @author CPoet
 */
@SpringBootApplication
public class MTSingleApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(MTSingleApplication.class)
            .bannerMode(Banner.Mode.OFF)
            .build(args)
            .run();
    }
}
