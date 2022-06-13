package cn.cpoet.mt.single.boot.runtime;

import cn.cpoet.mt.api.runtime.RunModel;
import cn.cpoet.mt.core.runtime.AbstractAppContext;

/**
 * 单体应用上下文
 *
 * @author CPoet
 */
public class SingleAppContext extends AbstractAppContext {
    @Override
    public RunModel getRunModel() {
        return RunModel.SINGLE;
    }
}
