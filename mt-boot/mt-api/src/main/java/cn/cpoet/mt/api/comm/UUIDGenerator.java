package cn.cpoet.mt.api.comm;

import cn.cpoet.mt.api.constant.SystemConst;

/**
 * UUID生成器
 *
 * @author CPoet
 */
public interface UUIDGenerator extends StringGenerator {
    @Override
    default String getName() {
        return SystemConst.UUID_GRT_NAME;
    }
}
