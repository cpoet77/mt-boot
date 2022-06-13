package cn.cpoet.mt.model.base;

import cn.cpoet.mt.api.tenant.Tenantable;
import io.ebean.annotation.TenantId;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * 记录型实体
 *
 * @author CPoet
 */
@Data
@MappedSuperclass
public abstract class BaseRecordTenantable extends BaseRecordModel implements Tenantable {
    /**
     * 租户id
     */
    @TenantId
    @Column(name = "tenant_id", nullable = false)
    private Long tenantId;
}
