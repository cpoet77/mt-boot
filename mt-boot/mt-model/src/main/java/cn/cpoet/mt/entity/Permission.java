package cn.cpoet.mt.entity;

import cn.cpoet.mt.entity.base.BaseTenantable;
import lombok.Data;
import lombok.experimental.FieldNameConstants;

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
}
