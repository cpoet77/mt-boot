package cn.cpoet.mt.web.gateway.feign;

import cn.cpoet.mt.web.gateway.constant.GatewayConst;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 用户信息
 *
 * @author CPoet
 */
@FeignClient(name = GatewayConst.MODULE_WEB_SUPPORT, contextId = "StaffFeign")
public interface StaffFeign {
    /**
     * say hello
     *
     * @return hello
     */
    @RequestMapping(value = "/staff/hello", method = RequestMethod.GET)
    String hello();
}
