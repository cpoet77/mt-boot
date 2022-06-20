package cn.cpoet.mt.web.support.controller;

import cn.cpoet.mt.api.comm.IDGenerator;
import cn.cpoet.mt.cloud.boot.feign.IdGeneratorFeign;
import cn.cpoet.mt.core.comm.SnowFlakeIdGenerator;
import cn.cpoet.mt.core.configuration.auto.SnowFlakeProperties;
import org.springframework.web.bind.annotation.RestController;

/**
 * Id生成器对外提供
 *
 * @author CPoet
 */
@RestController
public class IdGeneratorController implements IdGeneratorFeign {
    private final IDGenerator<Long> idGenerator;

    public IdGeneratorController(SnowFlakeProperties snowFlakeProperties) {
        idGenerator = new SnowFlakeIdGenerator(snowFlakeProperties.getWorkerId(), snowFlakeProperties.getSequence());
    }

    @Override
    public Long nextId() {
        return idGenerator.nextId();
    }
}
