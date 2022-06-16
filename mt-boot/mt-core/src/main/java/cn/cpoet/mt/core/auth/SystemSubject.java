package cn.cpoet.mt.core.auth;

import cn.cpoet.mt.api.auth.Subject;
import cn.cpoet.mt.api.auth.SubjectTypes;
import cn.cpoet.mt.api.constant.SystemConst;
import cn.cpoet.mt.api.tenant.Tenantry;
import cn.cpoet.mt.core.runtime.ContextTenantry;

/**
 * @author CPoet
 */
public class SystemSubject implements Subject {
    public final static SystemSubject INSTANCE = new SystemSubject();

    @Override
    public Long getId() {
        return SystemConst.SYSTEM_ID;
    }

    @Override
    public String getAccount() {
        return null;
    }

    @Override
    public String getStaffName() {
        return null;
    }

    @Override
    public Tenantry getTenantry() {
        return ContextTenantry.SYS_TENANT;
    }

    @Override
    public boolean logged() {
        return false;
    }

    @Override
    public SubjectTypes getType() {
        return SubjectTypes.SYSTEM;
    }
}
