package cn.cpoet.mt.entity;

import cn.cpoet.mt.entity.base.BaseTenantable;
import lombok.Data;
import lombok.experimental.FieldNameConstants;

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
}
