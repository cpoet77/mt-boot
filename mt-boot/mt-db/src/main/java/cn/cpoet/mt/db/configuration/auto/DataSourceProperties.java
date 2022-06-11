package cn.cpoet.mt.db.configuration.auto;

import cn.cpoet.mt.entity.constant.DataSourceType;
import lombok.Data;

/**
 * custom-datasource
 *
 * @author CPoet
 */
@Data
public class DataSourceProperties {
    /**
     * 数据源名称
     */
    private String name = DataSourceType.MASTER_MA.name();

    /**
     * 数据库驱动
     */
    private String driverClassName;

    /**
     * 数据库连接地址
     */
    private String url;

    /**
     * 数据库用户名
     */
    private String username;

    /**
     * 数据库密码
     */
    private String password;
}
