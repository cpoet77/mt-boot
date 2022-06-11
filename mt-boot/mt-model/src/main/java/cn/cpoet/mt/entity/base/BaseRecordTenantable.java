package cn.cpoet.mt.entity.base;

import cn.cpoet.mt.api.tenant.Tenantable;
import lombok.Data;
import lombok.experimental.FieldNameConstants;

/**
 * 记录型实体
 *
 * @author CPoet
 */
@Data
@FieldNameConstants
public class BaseRecordTenantable extends BaseRecordModel implements Tenantable {
    /**
     * 租户id
     */
    private Long tenantId;
}
