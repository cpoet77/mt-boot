package cn.cpoet.mt.entity;

import cn.cpoet.mt.entity.base.BaseModel;
import cn.cpoet.mt.entity.constant.DataSourceType;
import cn.cpoet.mt.entity.constant.DbColLenConst;
import lombok.Data;
import lombok.experimental.FieldNameConstants;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 数据源
 *
 * @author CPoet
 */
@Data
@Entity
@FieldNameConstants
@Table(name = "mt_datasource")
public class DataSource extends BaseModel {
    /**
     * 数据源名称
     */
    @Column(name = "name", unique = true, nullable = false)
    private String name;

    /**
     * 所属数据源组
     */
    @Column(name = "group_id", nullable = false)
    private Long groupId;

    /**
     * 连接url
     */
    @Column(name = "url", length = DbColLenConst.URL, nullable = false)
    private String url;

    /**
     * 用户名
     */
    @Column(name = "username", length = 48, nullable = false)
    private String username;

    /**
     * 密码
     */
    @Column(name = "password", length = 128, nullable = false)
    private String password;

    /**
     * 驱动信息
     */
    @Column(name = "driver_name", length = 68, nullable = false)
    private String driverName;

    /**
     * 数据源类型
     */
    @Column(name = "type", nullable = false)
    private DataSourceType type;

    /**
     * 备注
     */
    @Column(name = "remark", length = 512)
    private String remark;
}
