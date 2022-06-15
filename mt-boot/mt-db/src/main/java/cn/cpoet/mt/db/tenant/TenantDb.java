package cn.cpoet.mt.db.tenant;

import cn.cpoet.mt.api.runtime.AppContext;
import cn.cpoet.mt.api.runtime.AppContextHolder;
import cn.cpoet.mt.api.tenant.Tenantry;
import cn.cpoet.mt.db.exception.TenantDbException;
import io.ebean.DB;
import io.ebean.Database;
import io.ebean.typequery.TQRootBean;
import org.springframework.util.Assert;
import org.springframework.util.ReflectionUtils;

import java.util.function.Function;

/**
 * 租户DB信息
 *
 * @author CPoet
 */
public class TenantDb {

    private final static TenantDbContext CONTEXT = TenantDbContext.getInstance();

    public static <T> T better(Function<Database, T> func) {
        Assert.notNull(func, "func不能为null");
        return func.apply(CONTEXT.getSalve(getTenantry().getId()));
    }

    @SuppressWarnings("unchecked")
    public static <T> T better(Class<? extends TQRootBean<?, T>> tClass) {
        Assert.notNull(tClass, "");
        try {
            return (T) ReflectionUtils
                .accessibleConstructor(tClass, Database.class)
                .newInstance(CONTEXT.getSalve(getTenantry().getId()));
        } catch (Exception e) {
            throw new TenantDbException("");
        }
    }

    private static Tenantry getTenantry() {
        AppContext appContext = AppContextHolder.getAppContext();
        return appContext.getTenantry();
    }
}
