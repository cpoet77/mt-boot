package cn.cpoet.mt.entity;

import cn.cpoet.mt.entity.base.BaseTenantable;
import cn.cpoet.mt.entity.constant.CommStatus;
import cn.cpoet.mt.entity.constant.DbTypeConst;
import lombok.Data;
import lombok.experimental.FieldNameConstants;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 角色
 *
 * @author CPoet
 */
@Data
@Entity
@FieldNameConstants
@Table(name = "mt_role")
public class Role extends BaseTenantable {
    /**
     * 角色名称
     */
    @Column(name = "name", unique = true, nullable = false)
    private String name;

    /**
     * 排序
     */
    @Column(name = "order", nullable = false)
    private Integer order;

    /**
     * 介绍
     */
    @Column(name = "description", columnDefinition = DbTypeConst.TEXT)
    private String description;

    /**
     * 状态
     */
    @Column(name = "status", nullable = false)
    private CommStatus status;

    /**
     * 是否系统内置
     */
    @Column(name = "is_built_in", nullable = false)
    private Boolean isBuiltIn;
}
