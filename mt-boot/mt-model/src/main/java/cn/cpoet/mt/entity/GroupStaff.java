package cn.cpoet.mt.entity;

import cn.cpoet.mt.entity.base.BaseRecordTenantable;
import lombok.Data;
import lombok.experimental.FieldNameConstants;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 用户组关联
 *
 * @author CPoet
 */
@Data
@Entity
@Table(name = "mt_group_staff")
public class GroupStaff extends BaseRecordTenantable {
    /**
     * 组id
     */
    @Column(name = "group_id", nullable = false)
    private Long groupId;

    /**
     * 用户id
     */
    @Column(name = "staff_id", nullable = false)
    private Long staffId;

    /**
     * 职务id
     */
    @Column(name = "post_id")
    private Long postId;

    /**
     * 是否主身份
     */
    @Column(name = "is_main", nullable = false)
    private Boolean isMain;
}
