package cn.cpoet.mt.db.comm;

import io.ebean.config.IdGenerator;

/**
 * id生成器包装
 *
 * @author wanggf
 * @see cn.cpoet.mt.api.comm.IDGenerator
 * @see IdGenerator
 */
public class IdGeneratorWrapper implements IdGenerator {
    private final cn.cpoet.mt.api.comm.IDGenerator<?> thisIdGenerator;

    public IdGeneratorWrapper(cn.cpoet.mt.api.comm.IDGenerator<?> thisIdGenerator) {
        this.thisIdGenerator = thisIdGenerator;
    }

    @Override
    public String getName() {
        return thisIdGenerator.getName();
    }

    @Override
    public Object nextValue() {
        return thisIdGenerator.nextId();
    }
}
