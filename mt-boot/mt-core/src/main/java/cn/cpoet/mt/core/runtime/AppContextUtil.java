package cn.cpoet.mt.core.runtime;

import cn.cpoet.mt.api.runtime.AppContext;
import org.springframework.context.ApplicationContext;

/**
 * 应用上下文静态工具
 *
 * @author CPoet
 */
public final class AppContextUtil {
    private static AppContext appContextHold;

    static void initAppContext(AppContext appContext) {
        appContextHold = appContext;
    }

    public static AppContext getAppContext() {
        return appContextHold;
    }

    public static ApplicationContext getApplicationContext() {
        return appContextHold.getApplicationContext();
    }
}
