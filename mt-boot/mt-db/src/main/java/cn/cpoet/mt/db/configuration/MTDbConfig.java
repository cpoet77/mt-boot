package cn.cpoet.mt.db.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Import;

/**
 * 数据库相关配置
 *
 * @author CPoet
 */
@EntityScan("cn.cpoet.mt.entity")
@Import({EBeanConfig.class})
public class MTDbConfig {
}
