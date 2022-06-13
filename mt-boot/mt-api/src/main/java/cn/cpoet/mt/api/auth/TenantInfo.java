package cn.cpoet.mt.api.auth;

/**
 * 租户信息
 *
 * @author CPoet
 */
public interface TenantInfo {
    /**
     * 获取租户ID
     *
     * @return 租户ID
     */
    Long getId();

    /**
     * 获取租户名称
     *
     * @return 租户名称
     */
    String getName();
}
