package cn.cpoet.mt.db.domain;

import cn.cpoet.mt.api.constant.SystemConst;
import cn.cpoet.mt.db.tenant.TenantDbContext;
import io.ebean.Database;

import javax.persistence.MappedSuperclass;

/**
 * 定制化Model
 *
 * @author CPoet
 */
@MappedSuperclass
public abstract class BaseDbModel extends io.ebean.Model {
    @Override
    public Database db() {
        return TenantDbContext
            .getInstance()
            .getMaster(SystemConst.SYS_TENANT_ID);
    }
}
