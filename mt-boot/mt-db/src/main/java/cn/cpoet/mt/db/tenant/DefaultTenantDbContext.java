package cn.cpoet.mt.db.tenant;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 数据源管理
 * <p>参考io.ebean.DbContext</p>
 *
 * @author CPoet
 */
public class DefaultTenantDbContext implements TenantDbContext {
    /**
     * 主数据库信息
     */
    private TenantDatabaseHolder masterTdh;

    /**
     * 所有数据库信息
     */
    private final Map<Long, TenantDatabaseHolder> tdhMap = new ConcurrentHashMap<>();

    @Override
    public boolean remove(Long tenantId, String name) {
        return false;
    }
}
