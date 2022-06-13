package cn.cpoet.mt.model.base;

import cn.cpoet.mt.api.tenant.Tenantable;
import io.ebean.annotation.TenantId;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * 资源
 *
 * @author CPoet
 */
@Data
@MappedSuperclass
public abstract class BaseTenantable extends BaseModel implements Tenantable {
    /**
     * 租户id
     */
    @TenantId
    @Column(name = "tenant_id", nullable = false)
    private Long tenantId;
}
