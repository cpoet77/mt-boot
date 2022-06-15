package cn.cpoet.mt.api.constant;

import cn.cpoet.mt.api.util.JavaEnvUtil;

/**
 * 系统类型
 *
 * @author CPoet
 * @see sun.awt.OSInfo.OSType
 */
public enum OSTypes {
    /**
     * WINDOWS系统
     */
    WINDOWS,

    /**
     * Linux系统
     */
    LINUX,

    /**
     * SOLARIS系统
     */
    SOLARIS,

    /**
     * MACOS系统
     */
    MACOS,

    /**
     * 其它未知系统
     */
    UNKNOWN;

    /**
     * 当前系统类型
     */
    public final static OSTypes CURRENT_OS = JavaEnvUtil.getOsType();
}
