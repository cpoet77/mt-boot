package cn.cpoet.mt.cloud.boot.constant;

/**
 * 预见性微服务模块
 *
 * @author CPoet
 */
public interface CloudModules {
    /**
     * 全局前缀
     */
    String GLOBAL_PREFIX = "mt-";

    /**
     * 网关
     */
    String WEB_GATEWAY = GLOBAL_PREFIX + "web-gateway";

    /**
     * 垂直支撑模块
     */
    String WEB_SUPPORT = GLOBAL_PREFIX + "web-support";
}
