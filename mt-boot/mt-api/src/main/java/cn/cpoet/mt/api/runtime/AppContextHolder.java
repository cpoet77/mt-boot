package cn.cpoet.mt.api.runtime;

import cn.cpoet.mt.api.exception.AppContextReadyException;
import org.springframework.util.CollectionUtils;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

/**
 * 上下文工具
 *
 * @author CPoet
 */
public final class AppContextHolder {
    /**
     * 是否准备就绪
     */
    private static volatile boolean isReady = false;

    /**
     * 有效应用上下文
     */
    private static AppContext thisAppContext;

    /**
     * 临时等待消费对象，用于初始化加载前
     */
    private static List<Consumer<AppContext>> briefConsumers;

    /**
     * 判断环境是否已就绪
     *
     * @return bool
     */
    public static boolean isReady() {
        return isReady;
    }

    /**
     * 获取应用上下文，未就绪会抛出异常
     *
     * @return 应用上下文
     */
    public static AppContext getAppContext() {
        if (!isReady) {
            throw new AppContextReadyException("the app-context is not ready");
        }
        return thisAppContext;
    }

    /**
     * 消费就绪已经就绪的上下文
     *
     * @param consumer 消费上下文
     */
    public static void consume(Consumer<AppContext> consumer) {
        if (!isReady) {
            synchronized (AppContextHolder.class) {
                if (!isReady) {
                    if (briefConsumers == null) {
                        briefConsumers = new LinkedList<>();
                    }
                    briefConsumers.add(consumer);
                } else {
                    consumer.accept(thisAppContext);
                }
            }
        } else {
            consumer.accept(thisAppContext);
        }
    }

    /**
     * 设置应用上下文
     *
     * @param appContext 应用上下文
     */
    static void setAppContext(AppContext appContext) {
        if (!isReady) {
            synchronized (AppContextHolder.class) {
                if (!isReady) {
                    thisAppContext = appContext;
                    // 通知等待的消费者
                    if (!CollectionUtils.isEmpty(briefConsumers)) {
                        briefConsumers.forEach(bc -> bc.accept(thisAppContext));
                    }
                    briefConsumers = null;
                    isReady = true;
                }
            }
        }
    }
}
