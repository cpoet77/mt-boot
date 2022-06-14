package cn.cpoet.mt.db.configuration.auto;

import lombok.Data;

/**
 * custom-datasource
 *
 * @author CPoet
 */
@Data
public class DataSourceProperties extends DataSourceConfig {
    private DataSourceConfig slave;
}
