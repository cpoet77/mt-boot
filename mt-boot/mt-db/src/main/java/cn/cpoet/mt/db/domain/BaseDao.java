package cn.cpoet.mt.db.domain;

/**
 * {@link BaseFinder}透明化
 *
 * @author CPoet
 */
public abstract class BaseDao<T> extends BaseFinder<Long, T> {
    /**
     * 保存
     *
     * @param entity 实体
     */
    public void save(T entity) {
        db().save(entity);
    }

    /**
     * 删除数据
     *
     * @param entity 实体
     */
    public void delete(T entity) {
        db().delete(entity);
    }
}
