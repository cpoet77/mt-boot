package cn.cpoet.mt.entity;

import cn.cpoet.mt.entity.base.BaseTenantable;
import lombok.Data;
import lombok.experimental.FieldNameConstants;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 用户组
 *
 * @author CPoet
 */
@Data
@Entity
@FieldNameConstants
@Table(name = "mt_group")
public class Group extends BaseTenantable {
    /**
     * 父级ID
     */
    @Column(name = "parent_id", nullable = false)
    private Long parentId;

    /**
     * 用户组名
     */
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * 用户组介绍
     */
    @Column(name = "description")
    private String description;
}
