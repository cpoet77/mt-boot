package cn.cpoet.mt.api.runtime;

import cn.cpoet.mt.api.exception.AppContextReadyException;

import java.util.List;
import java.util.function.Consumer;

/**
 * 上下文工具
 *
 * @author CPoet
 */
public final class AppContextHolder {

    private static AppContext thisAppContext;

    private static List<Consumer<AppContext>> briefConsumer;

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
     * 消费就绪已经就绪的上下文
     *
     * @param consumer 消费上下文
     */
    public static void consume(Consumer<AppContext> consumer) {
        if (thisAppContext == null) {
            synchronized (AppContextHolder.class) {

            }
        }
        consumer.accept(thisAppContext);
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
