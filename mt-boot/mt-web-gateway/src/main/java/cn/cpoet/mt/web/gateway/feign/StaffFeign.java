package cn.cpoet.mt.web.gateway.feign;

import cn.cpoet.mt.web.gateway.constant.GatewayConst;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 用户信息
 *
 * @author CPoet
 */
@FeignClient(contextId = GatewayConst.MODULE_WEB_SUPPORT, url = "/staff")
public interface StaffFeign {
    /**
     * say hello
     *
     * @return hello
     */
    @GetMapping("/hello")
    String hello();
}
