package cn.cpoet.mt.db.configuration.auto;

import lombok.Data;

import java.util.List;

/**
 * custom-datasource
 *
 * @author CPoet
 */
@Data
public class DataSourceProperties extends DataSourceConfig {
    /**
     * 从库配置
     */
    private List<DataSourceConfig> slaves;
}
