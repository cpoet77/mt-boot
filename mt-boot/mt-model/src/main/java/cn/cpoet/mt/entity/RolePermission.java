package cn.cpoet.mt.entity;

import cn.cpoet.mt.entity.base.BaseRecordTenantable;
import lombok.Data;
import lombok.experimental.FieldNameConstants;

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
@FieldNameConstants
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
