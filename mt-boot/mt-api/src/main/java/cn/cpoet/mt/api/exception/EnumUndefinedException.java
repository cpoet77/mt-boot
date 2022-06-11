package cn.cpoet.mt.api.exception;

/**
 * 枚举未定义异常
 *
 * @author CPoet
 */
public class EnumUndefinedException extends MTException {

    public final static EnumUndefinedException DEFAULT = new EnumUndefinedException("undefined enum type.");

    public EnumUndefinedException(String message) {
        super(message);
    }

    public EnumUndefinedException(String message, Throwable cause) {
        super(message, cause);
    }

    public EnumUndefinedException(Throwable cause) {
        super(cause);
    }
}
