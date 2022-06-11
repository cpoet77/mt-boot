package cn.cpoet.mt.core.comm;


import cn.cpoet.mt.api.comm.UUIDGenerator;
import cn.cpoet.mt.core.util.UUIDUtil;

/**
 * 默认uuid实现
 *
 * @author wanggf
 */
public class SimpleUUIDGenerator implements UUIDGenerator {
    /**
     * 全局公用
     */
    public final static UUIDGenerator INSTANCE = new SimpleUUIDGenerator();

    @Override
    public String nextId() {
        return UUIDUtil.randomPure();
    }
}
