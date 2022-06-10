package cn.cpoet.mt.core.auth;

/**
 * 当前主体
 * <p>系统/登录用户/游客</p>
 *
 * @author CPoet
 */
public interface Subject {
    /**
     * 获取用户id
     *
     * @return 用户id
     */
    long getId();

    /**
     * 获取用户账号名
     *
     * @return 账号名
     */
    String getAccount();

    /**
     * 获取用户姓名
     *
     * @return 用户姓名
     */
    String getStaffName();

    /**
     * 获取租户信息
     *
     * @return 租户信息
     */
    TenantInfo getTenantInfo();

    /**
     * 判断是否已登录
     *
     * @return bool
     */
    boolean logged();

    /**
     * 判断主体类型
     *
     * @param st 主体类型
     * @return bool
     */
    default boolean isSubjectType(SubjectTypes st) {
        return getType().equals(st);
    }

    /**
     * 返回当前主体类型
     *
     * @return 主体类型
     */
    SubjectTypes getType();
}
