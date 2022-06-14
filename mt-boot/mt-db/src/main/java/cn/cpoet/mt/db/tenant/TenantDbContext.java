package cn.cpoet.mt.db.tenant;

import io.ebean.Database;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 租户数据源信息
 *
 * @author CPoet
 */
public class TenantDbContext {
    private static final TenantDbContext INSTANCE = new TenantDbContext();

    private final Map<Long, TenantDatabaseHolder> hp = new ConcurrentHashMap<>();

    private TenantDbContext() {
    }

    public Database getMaster(Long tenantId) {
        TenantDatabaseHolder holder = hp.get(tenantId);
        return holder == null ? null : holder.getMaster();
    }

    public Database getSalve(Long tenantId) {
        TenantDatabaseHolder holder = hp.get(tenantId);
        return holder == null ? null : holder.getSlave();
    }

    public Database getSalve(Long tenantId, String dbName) {
        TenantDatabaseHolder holder = hp.get(tenantId);
        return holder == null ? null : holder.getSlave(dbName);
    }

    public void addMasterDb(Long tenantId, Database database) {
        TenantDatabaseHolder holder = hp.computeIfAbsent(tenantId, TenantDatabaseHolder::new);
        holder.setMaster(database);
    }

    public void addSalveDb(Long tenantId, Database database) {
        TenantDatabaseHolder holder = hp.computeIfAbsent(tenantId, TenantDatabaseHolder::new);
        holder.addSlave(database);
    }

    public static TenantDbContext getInstance() {
        return INSTANCE;
    }
}
