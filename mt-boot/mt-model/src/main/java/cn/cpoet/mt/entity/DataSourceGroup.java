package cn.cpoet.mt.entity;

import cn.cpoet.mt.entity.base.BaseModel;
import cn.cpoet.mt.entity.constant.DbTypeConst;
import lombok.Data;
import lombok.experimental.FieldNameConstants;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 数据源组
 *
 * @author CPoet
 */
@Data
@Entity
@FieldNameConstants
@Table(name = "mt_datasource_group")
public class DataSourceGroup extends BaseModel {
    /**
     * 组名
     */
    @Column(name = "name", unique = true, nullable = false)
    private String name;

    /**
     * 说明
     */
    @Column(name = "description", columnDefinition = DbTypeConst.TEXT)
    private String description;
}
