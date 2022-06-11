package cn.cpoet.mt.entity;

import cn.cpoet.mt.entity.base.BaseTenantry;
import lombok.Data;
import lombok.experimental.FieldNameConstants;

import javax.persistence.Entity;

/**
 * 租户
 *
 * @author CPoet
 */
@Data
@Entity
@FieldNameConstants
public class Tenan extends BaseTenantry {
}
