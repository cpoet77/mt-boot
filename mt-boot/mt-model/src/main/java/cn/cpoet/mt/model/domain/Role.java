package cn.cpoet.mt.model.domain;

import cn.cpoet.mt.model.base.BaseTenantable;
import cn.cpoet.mt.model.constant.CommStatus;
import cn.cpoet.mt.model.constant.DbTypeConst;
import lombok.Data;

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
    @Column(name = "sorted", nullable = false)
    private Integer sorted;

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

    /**
     * 存在判断公式，用于更加细粒度的授权
     *
     * @see AclFormula
     */
    @Column(name = "is_formula", nullable = false)
    private Boolean isFormula;
}
