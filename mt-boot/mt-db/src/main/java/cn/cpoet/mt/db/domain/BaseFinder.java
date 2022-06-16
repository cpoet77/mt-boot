package cn.cpoet.mt.db.domain;

import cn.cpoet.mt.api.util.GenericsUtil;
import cn.cpoet.mt.db.tenant.TenantDbContext;
import io.avaje.lang.Nullable;
import io.ebean.*;

import java.util.List;

/**
 * 基本查询Dao
 *
 * @author CPoet
 * @see io.ebean.Finder
 */
@SuppressWarnings("unchecked")
abstract class BaseFinder<ID, ENTITY> {
    private final Class<ENTITY> type;

    public BaseFinder() {
        type = (Class<ENTITY>) GenericsUtil.getActualTypeArg(getClass());
    }

    /**
     * @see Finder#currentTransaction()
     */
    public Transaction currentTransaction() {
        return db().currentTransaction();
    }

    /**
     * @see Finder#flush()
     */
    public void flush() {
        db().flush();
    }

    /**
     * @see Finder#db()
     */
    public Database db() {
        return TenantDbContext.getInstance().getMaster(0L);
    }

    /**
     * @see Finder#db(String)
     */
    public Database db(String databaseName) {
        return TenantDbContext.getInstance().getMaster(0L);
    }

    /**
     * @see Finder#ref(Object)
     */
    public ENTITY ref(ID id) {
        return db().reference(type, id);
    }

    /**
     * @see Finder#byId(Object)
     */
    @Nullable
    public ENTITY byId(ID id) {
        return db().find(type, id);
    }

    /**
     * @see Finder#deleteById(Object)
     */
    public void deleteById(ID id) {
        db().delete(type, id);
    }

    /**
     * @see Finder#all()
     */
    public List<ENTITY> all() {
        return query().findList();
    }

    /**
     * @see Finder#update()
     */
    public UpdateQuery<ENTITY> update() {
        return db().update(type);
    }

    /**
     * @see Finder#query()
     */
    public Query<ENTITY> query() {
        return db().find(type);
    }

    /**
     * @see Finder#nativeSql(String)
     */
    public Query<ENTITY> nativeSql(String nativeSql) {
        return db().findNative(type, nativeSql);
    }

    /**
     * @see Finder#query()
     */
    public Query<ENTITY> query(String ormQuery) {
        return db().createQuery(type, ormQuery);
    }
}
