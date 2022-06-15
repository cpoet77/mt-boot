package cn.cpoet.mt.db.exception;

/**
 * 租户数据源异常
 *
 * @author CPoet
 */
public class TenantDbException extends DbException {
    public TenantDbException(String message) {
        super(message);
    }

    public TenantDbException(String message, Throwable cause) {
        super(message, cause);
    }

    public TenantDbException(Throwable cause) {
        super(cause);
    }
}
