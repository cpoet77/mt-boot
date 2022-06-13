package cn.cpoet.mt.core.auth;

import cn.cpoet.mt.api.auth.SubjectTypes;
import cn.cpoet.mt.api.tenant.Tenantry;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * 用户主体
 *
 * @author CPoet
 */
@Setter(AccessLevel.PACKAGE)
@RequiredArgsConstructor
public class StaffSubject extends GuestSubject {
    /**
     * 用户ID
     */
    private Long staffId;

    /**
     * 姓名
     */
    private String staffName;

    /**
     * 账号
     */
    private String account;

    /**
     * 租户信息
     */
    private ContextTenantry tenantInfo;

    @Override
    public Long getId() {
        return staffId;
    }

    @Override
    public String getAccount() {
        return account;
    }

    @Override
    public String getStaffName() {
        return staffName;
    }

    @Override
    public Tenantry getTenantry() {
        return tenantInfo;
    }

    @Override
    public boolean logged() {
        return true;
    }

    @Override
    public SubjectTypes getType() {
        return SubjectTypes.STAFF;
    }
}
