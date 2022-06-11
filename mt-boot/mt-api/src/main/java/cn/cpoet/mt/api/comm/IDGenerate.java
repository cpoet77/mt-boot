package cn.cpoet.mt.api.comm;

/**
 * ID生成器
 *
 * @author CPoet
 */
public interface IDGenerate<T> {
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
