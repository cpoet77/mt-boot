package cn.cpoet.mt.model.base;

import cn.cpoet.mt.api.tenant.Tenantry;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.Duration;
import java.time.LocalDateTime;

/**
 * 租户
 *
 * @author CPoet
 */
@Data
@MappedSuperclass
public abstract class BaseTenantry extends BaseModel implements Tenantry {
    /**
     * 开始时间
     */
    @Column(name = "start_time", nullable = false)
    private LocalDateTime startTime;

    /**
     * 结束时间
     */
    @Column(name = "end_time", nullable = false)
    private LocalDateTime endTime;

    /**
     * 租期（冗余字段）
     */
    @Column(name = "leases", nullable = false)
    private Duration leases;
}
