package cn.cpoet.mt.model.domain;

import cn.cpoet.mt.model.base.BaseTenantable;
import cn.cpoet.mt.model.constant.GroupType;
import lombok.Data;

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
@Table(name = "mt_group")
public class Group extends BaseTenantable {
    /**
     * 父级ID
     */
    @Column(name = "parent_id", nullable = false)
    private Long parentId;

    /**
     * 组编码
     */
    @Column(name = "code", nullable = false)
    private String code;

    /**
     * 用户组名
     */
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * 组类型
     */
    @Column(name = "type", nullable = false)
    private GroupType type;

    /**
     * 用户组介绍
     */
    @Column(name = "description")
    private String description;
}
