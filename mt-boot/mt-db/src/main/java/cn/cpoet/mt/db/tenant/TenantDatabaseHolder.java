package cn.cpoet.mt.db.tenant;

import io.ebean.Database;

import java.util.List;

/**
 * 租户数据库信息信息
 *
 * @author CPoet
 */
class TenantDatabaseHolder {
    /**
     * 租户ID
     */
    private Long tenantId;

    /**
     * 主库，写库
     *
     * @see cn.cpoet.mt.entity.constant.DataSourceType#MASTER_MA
     * @see cn.cpoet.mt.entity.constant.DataSourceType#VICE_MA
     */
    private Database master;

    /**
     * 从库，读库
     *
     * @see cn.cpoet.mt.entity.constant.DataSourceType#MASTER_VI
     * @see cn.cpoet.mt.entity.constant.DataSourceType#VICE_VI
     */
    private List<Database> vices;
}
