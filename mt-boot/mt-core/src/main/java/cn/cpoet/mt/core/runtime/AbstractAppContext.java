package cn.cpoet.mt.core.runtime;

import cn.cpoet.mt.api.auth.AuthContext;
import cn.cpoet.mt.api.runtime.AppContext;
import cn.cpoet.mt.api.runtime.RunModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

/**
 * 应用上下文
 *
 * @author CPoet
 */
@SuppressWarnings("all")
public abstract class AbstractAppContext implements AppContext {
    /**
     * 认证上下文
     */
    @Autowired
    protected AuthContext authContext;

    /**
     * Spring应用上下文
     */
    @Autowired
    protected ApplicationContext applicationContext;

    public AbstractAppContext() {
        AppContextUtil.initAppContext(this);
    }

    @Override
    public RunModel getRunModel() {
        return RunModel.NONE;
    }

    @Override
    public AuthContext getAuthContext() {
        return authContext;
    }

    @Override
    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }
}
