package cn.cpoet.mt.api.tenant;

/**
 * 租凭资源
 *
 * @author CPoet
 */
public interface Tenantable {
    /**
     * 获取租户id
     *
     * @return 租户id
     */
    Long getTenantId();
}
