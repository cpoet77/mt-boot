package cn.cpoet.mt.core.configuration;

import cn.cpoet.mt.api.comm.UUIDGenerator;
import cn.cpoet.mt.api.constant.SystemConst;
import cn.cpoet.mt.core.comm.SimpleUUIDGenerator;
import cn.cpoet.mt.core.configuration.auto.SnowFlakeProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

/**
 * 核心配置
 *
 * @author CPoet
 */
@Import({CoreAuthConfig.class})
public class MTCoreConfig {
    @Bean
    @ConfigurationProperties(prefix = "cpoet.mt.snow-flake")
    public SnowFlakeProperties snowFlakeProperties() {
        return new SnowFlakeProperties();
    }

    /**
     * 全局UUID生成器注册
     * <p>不同于雪花算法，不具有人为的机器差异化</p>
     *
     * @return UUID生成器
     */
    @Bean(SystemConst.UUID_GRT_NAME)
    public UUIDGenerator uuidGenerator() {
        return SimpleUUIDGenerator.INSTANCE;
    }
}
