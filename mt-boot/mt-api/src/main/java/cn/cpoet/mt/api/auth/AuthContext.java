package cn.cpoet.mt.api.auth;

/**
 * 认证上下文
 *
 * @author CPoet
 */
public interface AuthContext {
    /**
     * 获取当前主体
     *
     * @return 主体
     */
    Subject currentSubject();
}
