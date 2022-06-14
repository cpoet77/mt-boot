package cn.cpoet.mt.db.tenant;

import cn.cpoet.mt.api.runtime.AppContext;
import cn.cpoet.mt.api.runtime.AppContextHolder;
import cn.cpoet.mt.api.tenant.Tenantry;

/**
 * 租户DB信息
 *
 * @author CPoet
 */
public class TenantDb {

    private final static TenantDbContext CONTEXT = TenantDbContext.getInstance();

    public static <T> T agent(Class<T> tClass) {
        return null;
    }

    public static <T> T agent() {
        AppContext appContext = AppContextHolder.getAppContext();
        Tenantry tenantry = appContext.getTenantry();
        return null;
    }
}
