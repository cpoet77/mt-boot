package cn.cpoet.mt.model.domain;

import cn.cpoet.mt.model.base.BaseTenantry;
import cn.cpoet.mt.model.constant.CommStatus;
import cn.cpoet.mt.db.constant.TenantDSType;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 租户
 *
 * @author CPoet
 */
@Data
@Entity
@Table(name = "mt_tenant")
public class Tenant extends BaseTenantry {
    /**
     * 公司id
     */
    @Column(name = "company_id", nullable = false)
    private Long companyId;

    /**
     * 使用的数据源类型
     */
    @Column(name = "ds_type", nullable = false)
    private TenantDSType dsType;

    /**
     * 状态
     */
    @Column(name = "status", nullable = false)
    private CommStatus status;
}
