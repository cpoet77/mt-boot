package cn.cpoet.mt.model.domain;

import cn.cpoet.mt.model.base.BaseRecordTenantable;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 操作日志
 *
 * @author CPoet
 */
@Data
@Entity
@Table(name = "mt_operator_log")
public class OperatorLog extends BaseRecordTenantable {
}
