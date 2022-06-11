package cn.cpoet.mt.api.exception;

/**
 * 全局异常
 *
 * @author CPoet
 */
public class MTException extends RuntimeException {
    public MTException(String message) {
        super(message);
    }

    public MTException(String message, Throwable cause) {
        super(message, cause);
    }

    public MTException(Throwable cause) {
        super(cause);
    }
}
