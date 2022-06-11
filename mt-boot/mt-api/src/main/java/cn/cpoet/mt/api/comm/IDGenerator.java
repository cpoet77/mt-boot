package cn.cpoet.mt.api.comm;

/**
 * ID生成器
 *
 * @author CPoet
 */
public interface IDGenerator<T> {
    /**
     * 获取生成器名称
     *
     * @return 生成器名称
     */
    String getName();

    /**
     * 获取id
     *
     * @return id
     */
    T nextId();

    /**
     * 获取id
     *
     * @param defaultId 异常时返回的默认值
     * @return id
     */
    default T nextId(T defaultId) {
        try {
            return nextId();
        } catch (Exception ignored) {
        }
        return defaultId;
    }
}
