package cn.cpoet.mt.api.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/**
 * 摘要工具
 *
 * @author wanggf
 */
public class DigestUtil {
    /**
     * md5算法,32位
     */
    public final static String MD5 = "MD5";

    /**
     * sha1算法,40位
     */
    public final static String SHA1 = "SHA1";

    /**
     * 计算摘要
     *
     * @param str 字符数据
     * @return 摘要
     */
    public static String md5hex(String str) {
        return md5hex(str.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * 计算sha1
     *
     * @param str 字符数据
     * @return sha1
     */
    public static String sha1hex(String str) {
        return sha1hex(str.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * 计算摘要
     *
     * @param bytes 字节数据
     * @return 摘要
     */
    public static String md5hex(byte[] bytes) {
        return binary2hex(digest(MD5, bytes));
    }

    /**
     * 计算sha1
     *
     * @param bytes 字节数据
     * @return sha1
     */
    public static String sha1hex(byte[] bytes) {
        return binary2hex(digest(SHA1, bytes));
    }

    /**
     * 计算二进制md5摘要
     *
     * @param algorithm 算法
     * @param bytes     字节数据
     * @return 摘要数据
     */
    public static byte[] digest(String algorithm, byte[] bytes) {
        MessageDigest message;
        try {
            message = MessageDigest.getInstance(algorithm);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return message.digest(bytes);
    }

    /**
     * 二进制转十六进制
     *
     * @param bytes 二进制字节信息
     * @return 十六进制字符串
     */
    public static String binary2hex(byte[] bytes) {
        StringBuilder md5str = new StringBuilder();
        int digital;
        for (byte bit : bytes) {
            digital = bit;
            if (digital < 0) {
                digital &= 0xFF;
            }
            if (digital < 0x10) {
                md5str.append("0");
            }
            md5str.append(Integer.toHexString(digital));
        }
        return md5str.toString();
    }

    private DigestUtil() {
    }
}
