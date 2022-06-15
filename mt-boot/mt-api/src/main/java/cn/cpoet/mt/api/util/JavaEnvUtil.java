package cn.cpoet.mt.api.util;

import cn.cpoet.mt.api.constant.OSTypes;
import sun.awt.OSInfo;

/**
 * Java环境工具
 *
 * @author CPoet
 */
public class JavaEnvUtil {
    /**
     * 获取当前虚拟机运行的平台系统类型
     *
     * @return 系统类型
     */
    public static OSTypes getOsType() {
        OSInfo.OSType osType = OSInfo.getOSType();
        switch (osType) {
            case WINDOWS:
                return OSTypes.WINDOWS;
            case LINUX:
                return OSTypes.LINUX;
            case SOLARIS:
                return OSTypes.SOLARIS;
            case MACOSX:
                return OSTypes.MACOS;
            default:
                return OSTypes.UNKNOWN;
        }
    }

    private JavaEnvUtil() {
    }
}
