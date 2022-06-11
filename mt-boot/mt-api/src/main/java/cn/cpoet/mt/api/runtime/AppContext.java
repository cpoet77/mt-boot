package cn.cpoet.mt.api.runtime;

import cn.cpoet.mt.api.auth.AuthContext;

/**
 * 应用上下文
 *
 * @author CPoet
 */
public interface AppContext {
    /**
     * 获取当前运行模式
     *
     * @return 支持模式
     */
    RunModel getRunModel();

    /**
     * 获取认证上下文
     *
     * @return 认证上下文
     */
    AuthContext getAuthContext();
}
