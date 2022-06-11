package cn.cpoet.mt.api.comm;

import cn.cpoet.mt.api.constant.SystemConst;

/**
 * {@link Long}类ID生成器，作为默认ID生成器
 *
 * @author CPoet
 */
public interface LongGenerator extends IDGenerator<Long> {
    @Override
    default String getName() {
        return SystemConst.EBEAN_ID_GRT_NAME;
    }
}
