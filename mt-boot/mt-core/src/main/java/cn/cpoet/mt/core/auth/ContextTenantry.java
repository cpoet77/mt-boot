package cn.cpoet.mt.core.auth;

import cn.cpoet.mt.api.constant.SystemConst;
import cn.cpoet.mt.api.tenant.Tenantry;
import lombok.AccessLevel;
import lombok.Setter;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * 租户信息
 *
 * @author CPoet
 */
@Setter(AccessLevel.PACKAGE)
public class ContextTenantry implements Tenantry {
    /**
     * 系统级租户
     */
    public static final ContextTenantry SYS_TENANT;

    static {
        SYS_TENANT = new ContextTenantry();
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
    public LocalDateTime getStartTime() {
        return null;
    }

    @Override
    public LocalDateTime getEndTime() {
        return null;
    }

    @Override
    public Duration getLeases() {
        return null;
    }

}
