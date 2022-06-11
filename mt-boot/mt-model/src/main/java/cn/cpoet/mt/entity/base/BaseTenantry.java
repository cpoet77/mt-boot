package cn.cpoet.mt.entity.base;

import cn.cpoet.mt.api.tenant.Tenantry;
import lombok.Data;
import lombok.experimental.FieldNameConstants;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * 租户
 *
 * @author CPoet
 */
@Data
@FieldNameConstants
public abstract class BaseTenantry extends BaseModel implements Tenantry {
    /**
     * 开始时间
     */
    private LocalDateTime startTime;

    /**
     * 结束时间
     */
    private LocalDateTime endTime;

    /**
     * 租期（冗余字段）
     */
    private Duration leases;
}
