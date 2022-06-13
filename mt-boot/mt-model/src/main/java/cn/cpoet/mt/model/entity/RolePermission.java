package cn.cpoet.mt.model.entity;

import cn.cpoet.mt.model.entity.base.BaseRecordTenantable;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 角色权限
 *
 * @author CPoet
 */
@Data
@Entity
@Table(name = "mt_role_permission")
public class RolePermission extends BaseRecordTenantable {
    /**
     * 角色id
     */
    @Column(name = "role_id")
    private Long roleId;

    /**
     * 权限id
     */
    @Column(name = "permission_id")
    private Long permissionId;
}
