package cn.cpoet.mt.entity;

import cn.cpoet.mt.entity.base.BaseTenantable;
import cn.cpoet.mt.entity.constant.CommStatus;
import cn.cpoet.mt.entity.constant.DbColLenConst;
import cn.cpoet.mt.entity.constant.DbTypeConst;
import cn.cpoet.mt.entity.constant.PermissionType;
import lombok.Data;
import lombok.experimental.FieldNameConstants;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 资源
 *
 * @author CPoet
 */
@Data
@Entity
@FieldNameConstants
@Table(name = "mt_permission")
public class Permission extends BaseTenantable {
    /**
     * 父级ID，默认为{@link cn.cpoet.mt.api.constant.SystemConst#DEFAULT_PARENT_ID}
     */
    @Column(name = "parent_id", nullable = false)
    private Long parentId;

    /**
     * 编码，用于资源权限判断
     */
    @Column(name = "code", unique = true, nullable = false)
    private String code;

    /**
     * 资源名称
     */
    @Column(name = "name", unique = true, nullable = false)
    private String name;

    /**
     * 资源图标
     */
    @Column(name = "icon", length = DbColLenConst.URL)
    private String icon;

    /**
     * 资源说明介绍
     */
    @Column(name = "description", columnDefinition = DbTypeConst.TEXT)
    private String description;

    /**
     * 是否内置
     */
    @Column(name = "is_built_in", nullable = false)
    private Boolean isBuiltIn;

    /**
     * 资源状态
     */
    @Column(name = "status", nullable = false)
    private CommStatus status;

    /**
     * 排序
     */
    @Column(name = "order", nullable = false)
    private Integer order;

    /**
     * 资源类型
     */
    @Column(name = "type", nullable = false)
    private PermissionType type;

    /**
     * 存在判断公式
     */
    @Column(name = "is_formula", nullable = false)
    private Boolean isFormula;
}
