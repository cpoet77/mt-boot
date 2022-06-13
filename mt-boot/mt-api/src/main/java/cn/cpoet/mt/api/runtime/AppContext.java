package cn.cpoet.mt.api.runtime;

import cn.cpoet.mt.api.auth.AuthContext;
import cn.cpoet.mt.api.tenant.Tenantry;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;

/**
 * 应用上下文
 *
 * @author CPoet
 */
public interface AppContext extends InitializingBean {
    /**
     * 获取当前运行模式
     *
     * @return 支持模式
     */
    RunModel getRunModel();

    /**
     * 获取当前上下文中的租户信息
     *
     * @return 上下文中的有效租户信息
     */
    Tenantry getTenantry();

    /**
     * 获取认证上下文
     *
     * @return 认证上下文
     */
    AuthContext getAuthContext();

    /**
     * 获取Spring应用上下文
     *
     * @return Spring应用上下文
     */
    ApplicationContext getApplicationContext();

    /**
     * 应用上下文设置（必需）
     */
    @Override
    default void afterPropertiesSet() {
        AppContextHolder.setAppContext(this);
    }
}
