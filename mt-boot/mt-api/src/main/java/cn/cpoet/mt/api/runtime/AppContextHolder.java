package cn.cpoet.mt.api.runtime;

import cn.cpoet.mt.api.exception.AppContextReadyException;

/**
 * 上下文工具
 *
 * @author CPoet
 */
public final class AppContextHolder {

    private static AppContext thisAppContext;

    /**
     * 判断环境是否已就绪
     *
     * @return bool
     */
    public static boolean isReady() {
        return thisAppContext != null;
    }

    /**
     * 获取应用上下文，未就绪会抛出异常
     *
     * @return 应用上下文
     */
    public static AppContext getAppContext() {
        AppContext appContext = thisAppContext;
        if (appContext == null) {
            throw new AppContextReadyException("the app-context is not ready");
        }
        return appContext;
    }

    /**
     * 设置应用上下文
     *
     * @param appContext 应用上下文
     */
    static void setAppContext(AppContext appContext) {
        thisAppContext = appContext;
    }
}
