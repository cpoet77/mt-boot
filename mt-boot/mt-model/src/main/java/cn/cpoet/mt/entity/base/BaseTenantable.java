package cn.cpoet.mt.entity.base;

import cn.cpoet.mt.api.tenant.Tenantable;
import lombok.Data;
import lombok.experimental.FieldNameConstants;

/**
 * 资源
 *
 * @author CPoet
 */
@Data
@FieldNameConstants
public abstract class BaseTenantable extends BaseModel implements Tenantable {
    /**
     * 租户id
     */
    private Long tenantId;
}
