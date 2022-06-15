package cn.cpoet.mt.core.util;

import java.time.Duration;
import java.util.EmptyStackException;
import java.util.Stack;
import java.util.concurrent.TimeUnit;

/**
 * 线程运行计时工具
 *
 * @author CPoet
 */
public class TimingUtil {

    private final static ThreadLocal<Stack<Long>> TL = ThreadLocal.withInitial(Stack::new);

    /**
     * 开始记录
     *
     * @return 开始时间
     */
    public static long start() {
        long cm = System.currentTimeMillis();
        start(cm, TimeUnit.MILLISECONDS);
        return cm;
    }

    /**
     * 开始记录
     *
     * @param cm   开始时间
     * @param unit 单位
     */
    public static void start(long cm, TimeUnit unit) {
        TL.get().add(unit.toMillis(cm));
    }

    /**
     * 结束记录
     *
     * @return 记录时长
     */
    public static long end() {
        try {
            return System.currentTimeMillis() - TL.get().pop();
        } catch (EmptyStackException ignored) {
        }
        return 0;
    }

    /**
     * 结束记录
     *
     * @return 记录时长
     */
    public static Duration endUnit() {
        return Duration.ofMillis(end());
    }
}
