package cn.cpoet.mt.model.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * 持久化配置
 *
 * @author CPoet
 */
@EntityScan("cn.cpoet.mt.model.entity")
@ComponentScan("cn.cpoet.mt.model.dao")
public class MTModelConfig {
}
