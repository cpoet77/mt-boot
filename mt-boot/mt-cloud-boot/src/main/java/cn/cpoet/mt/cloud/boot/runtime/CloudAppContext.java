package cn.cpoet.mt.cloud.boot.runtime;

import cn.cpoet.mt.api.runtime.RunModel;
import cn.cpoet.mt.core.runtime.AbstractAppContext;

/**
 * 微服务应用上下文
 *
 * @author CPoet
 */
public class CloudAppContext extends AbstractAppContext {
    @Override
    public RunModel getRunModel() {
        return RunModel.CLOUD;
    }
}
