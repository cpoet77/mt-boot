package cn.cpoet.mt.core.auth;

import cn.cpoet.mt.api.auth.TenantInfo;
import cn.cpoet.mt.api.constant.SystemConst;
import lombok.AccessLevel;
import lombok.Setter;

/**
 * 租户信息
 *
 * @author CPoet
 */
@Setter(AccessLevel.PACKAGE)
public class TenantInfoHolder implements TenantInfo {
    /**
     * 系统级租户
     */
    public static final TenantInfoHolder SYS_TENANT;

    static {
        SYS_TENANT = new TenantInfoHolder();
        SYS_TENANT.setTenantId(SystemConst.SYS_TENANT_ID);
        SYS_TENANT.setTenantName(null);
    }

    /**
     * 租户ID
     */
    private Long tenantId;

    /**
     * 租户名称
     */
    private String tenantName;

    @Override
    public Long getId() {
        return tenantId;
    }

    @Override
    public String getName() {
        return tenantName;
    }
}
