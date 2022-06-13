package cn.cpoet.mt.api.exception;

/**
 * 应用上下文初始化异常
 *
 * @author CPoet
 */
public class AppContextReadyException extends MTException {
    public AppContextReadyException(String message) {
        super(message);
    }

    public AppContextReadyException(String message, Throwable cause) {
        super(message, cause);
    }

    public AppContextReadyException(Throwable cause) {
        super(cause);
    }
}
