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
@FieldNameConstants
@Table(name = "mt_group_staff")
public class GroupStaff extends BaseRecordTenantable {
    @Column(name = "group_id", nullable = false)
    private Long groupId;

    @Column(name = "staff_id", nullable = false)
    private Long staffId;
}
