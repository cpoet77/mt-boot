package cn.cpoet.mt.cloud.boot.feign;

import cn.cpoet.mt.api.comm.LongGenerator;
import cn.cpoet.mt.cloud.boot.constant.CloudModules;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Id生成器
 *
 * @author CPoet
 */
@FeignClient(name = CloudModules.WEB_SUPPORT, contextId = "IdGeneratorFeign")
public interface IdGeneratorFeign extends LongGenerator {
    /**
     * 获取下一个有效id
     *
     * @return 有效id
     */
    @Override
    @RequestMapping(value = "/idGenerator/nextId", method = RequestMethod.GET)
    Long nextId();
}
