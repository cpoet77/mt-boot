package cn.cpoet.mt.single.boot.configuration;

import cn.cpoet.mt.core.comm.SnowFlakeIdGenerator;
import cn.cpoet.mt.core.configuration.auto.SnowFlakeProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

/**
 * 单体应用配置
 *
 * @author CPoet
 */
public class MTSingleBootConfig {
    @Bean
    @ConditionalOnMissingBean
    public SnowFlakeIdGenerator snowFlakeIdGenerator(SnowFlakeProperties snowFlakeProperties) {
        return new SnowFlakeIdGenerator(snowFlakeProperties.getWorkerId(), snowFlakeProperties.getSequence());
    }
}
