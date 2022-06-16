package cn.cpoet.mt.db.exception;

import cn.cpoet.mt.api.exception.AppException;

/**
 * 持久层相关异常
 *
 * @author CPoet
 */
public class DbException extends AppException {
    public DbException(String message) {
        super(message);
    }

    public DbException(String message, Throwable cause) {
        super(message, cause);
    }

    public DbException(Throwable cause) {
        super(cause);
    }
}
