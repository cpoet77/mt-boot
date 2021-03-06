package cn.cpoet.mt.model.domain;

import cn.cpoet.mt.model.base.BaseRecordTenantable;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 用户角色绑定
 *
 * @author CPoet
 */
@Data
@Entity
@Table(name = "mt_staff_role")
public class StaffRole extends BaseRecordTenantable {
    /**
     * 用户id
     */
    @Column(name = "staff_id", nullable = false)
    private Long staffId;

    /**
     * 角色id
     */
    @Column(name = "role_id", nullable = false)
    private Long roleId;
}
