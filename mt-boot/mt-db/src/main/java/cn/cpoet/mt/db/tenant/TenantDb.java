package cn.cpoet.mt.db.tenant;

import io.ebean.Database;

import java.util.List;

/**
 * 租户DB信息
 *
 * @author CPoet
 */
public interface TenantDb {
    Database getDatabase();

    Database getWriteDatabase();

    Database getReadDatabase();

    List<Database> getAllReadDatabase();
}
