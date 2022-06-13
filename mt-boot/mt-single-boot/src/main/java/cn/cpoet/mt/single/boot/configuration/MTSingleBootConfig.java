package cn.cpoet.mt.single.boot.configuration;

import cn.cpoet.mt.api.runtime.AppContext;
import cn.cpoet.mt.core.comm.SnowFlakeIdGenerator;
import cn.cpoet.mt.core.configuration.auto.SnowFlakeProperties;
import cn.cpoet.mt.single.boot.runtime.SingleAppContext;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * 单体应用配置
 *
 * @author CPoet
 */
public class MTSingleBootConfig {
    @Bean
    @Primary
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public AppContext appContext() {
        return new SingleAppContext();
    }

    @Bean
    @ConditionalOnMissingBean
    public SnowFlakeIdGenerator snowFlakeIdGenerator(SnowFlakeProperties snowFlakeProperties) {
        return new SnowFlakeIdGenerator(snowFlakeProperties.getWorkerId(), snowFlakeProperties.getSequence());
    }
}
