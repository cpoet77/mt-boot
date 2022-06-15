package cn.cpoet.mt.db.tenant;

import cn.cpoet.mt.api.constant.SystemConst;
import io.ebean.Database;
import io.ebean.typequery.TQRootBean;
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
        return func.apply(CONTEXT.getSalve(SystemConst.SYS_TENANT_ID));
    }

    @SuppressWarnings("unchecked")
    public static <T> T better(Class<? extends TQRootBean<?, T>> tClass) {
        try {
            return (T) ReflectionUtils
                .accessibleConstructor(tClass, Database.class)
                .newInstance(CONTEXT.getSalve(SystemConst.SYS_TENANT_ID));
        } catch (Exception e) {
            throw new RuntimeException("");
        }
    }
}
