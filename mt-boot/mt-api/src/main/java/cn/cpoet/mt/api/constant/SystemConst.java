package cn.cpoet.mt.api.constant;

/**
 * 系统级常量
 *
 * @author CPoet
 */
public interface SystemConst {
    /**
     * 系统id
     */
    long SYSTEM_ID = 0;

    /**
     * 系统租户ID
     */
    long SYS_TENANT_ID = SYSTEM_ID;

    /**
     * 默认实体id
     */
    long DEFAULT_ENTITY_ID = -1;

    /**
     * 默认父级ID
     */
    long DEFAULT_PARENT_ID = DEFAULT_ENTITY_ID;

    /**
     * 游客id
     */
    long GUEST_ID = -2;

    /**
     * 默认ID生成器名称
     */
    String DEFAULT_ID_GRT_NAME = "cn.cpoet.mt#global-id-generator";

    /**
     * UUID生成器
     */
    String UUID_GRT_NAME = "cn.cpoet.mt#uuid-id-generator";

    /**
     * EBean使用的ID生成器名称
     */
    String EBEAN_ID_GRT_NAME = DEFAULT_ID_GRT_NAME;
}
