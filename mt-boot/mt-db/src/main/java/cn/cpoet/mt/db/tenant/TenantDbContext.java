package cn.cpoet.mt.db.tenant;

/**
 * 租户数据源信息
 *
 * @author CPoet
 */
public interface TenantDbContext {
    boolean remove(Long tenantId, String name);
}
