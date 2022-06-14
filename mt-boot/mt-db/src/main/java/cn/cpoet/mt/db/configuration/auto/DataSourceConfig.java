package cn.cpoet.mt.db.configuration.auto;

import lombok.Data;

/**
 * 数据库配置
 *
 * @author CPoet
 */
@Data
public class DataSourceConfig {
    /**
     * 数据源名称
     */
    private String name;

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
