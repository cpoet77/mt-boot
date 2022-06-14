package cn.cpoet.mt.db.tenant;

import io.ebean.Database;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 租户数据库信息信息
 *
 * @author CPoet
 */
@RequiredArgsConstructor
class TenantDatabaseHolder {
    /**
     * 租户ID
     */
    @Getter
    private final Long tenantId;

    /**
     * 主库全称
     */
    private String masterName;

    /**
     * 主库
     */
    private Database master;

    /**
     * 从库
     */
    private SlaveDbHolder slave;

    private Map<String, SlaveDbHolder> slaveMap;

    public String getMasterName() {
        return masterName;
    }

    public void setMaster(Database database) {
        setMaster(database.name(), database);
    }

    public void setMaster(String dbName, Database database) {
        masterName = dbName;
        master = database;
    }

    public Database getMaster() {
        return master;
    }

    public void addSlave(Database database) {
        addSlave(database.name(), database);
    }

    public void addSlave(String dbName, Database database) {
        if (!Objects.equals(dbName, masterName)) {
            if (slaveMap == null) {
                slaveMap = new ConcurrentHashMap<>();
            }
            SlaveDbHolder slaveDbHolder = slaveMap.get(dbName);
            if (slaveDbHolder != null) {
                slaveDbHolder.db = database;
            } else {
                SlaveDbHolder newSlave = new SlaveDbHolder();
                newSlave.db = database;
                if (slave == null) {
                    slave = newSlave;
                    slave.pre = newSlave;
                    slave.next = newSlave;
                } else {
                    newSlave.next = slave.next;
                    slave.next.pre = newSlave;
                    slave.next = newSlave;
                    newSlave.pre = slave;
                }
                slaveMap.put(dbName, newSlave);
            }
        }
    }

    public void removeSlave(String dbName) {
        if (!Objects.equals(dbName, masterName) && !slaveMap.isEmpty()) {
            SlaveDbHolder slaveNode = slaveMap.remove(dbName);
            if (slaveNode != null) {
                if (slaveMap.isEmpty()) {
                    slave = null;
                    slaveMap = null;
                }
                slaveNode.next.pre = slaveNode.pre;
                slaveNode.pre.next = slaveNode.next;
            }
        }
    }

    public Database getSlave(String dbName) {
        if (Objects.equals(dbName, masterName)) {
            return master;
        }
        SlaveDbHolder slaveDbHolder = slaveMap.get(dbName);
        return slaveDbHolder == null ? null : slaveDbHolder.db;
    }

    public Database getSlave() {
        if (slave == null) {
            return master;
        }
        SlaveDbHolder sdh = slave;
        slave = slave.next;
        return sdh.db;
    }

    private static class SlaveDbHolder {
        /**
         * 上个节点
         */
        private SlaveDbHolder pre;

        /**
         * 下个节点
         */
        private SlaveDbHolder next;

        /**
         * 数据库信息
         */
        private Database db;
    }
}
