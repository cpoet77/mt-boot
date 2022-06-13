package cn.cpoet.mt.db.tenant;

import cn.cpoet.mt.api.auth.AuthContext;
import io.ebean.Database;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * 默认租户Db
 *
 * @author CPoet
 * @see io.ebean.DB
 */
@RequiredArgsConstructor
public class DefaultTenantDb implements TenantDb {
    @Setter
    private AuthContext authContext;

    @Override
    public Database getDatabase() {
        return null;
    }

    @Override
    public Database getWriteDatabase() {
        return null;
    }

    @Override
    public Database getReadDatabase() {
        return null;
    }

    @Override
    public List<Database> getAllReadDatabase() {
        return null;
    }
}
