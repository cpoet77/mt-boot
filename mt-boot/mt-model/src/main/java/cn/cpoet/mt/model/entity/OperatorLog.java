package cn.cpoet.mt.model.entity;

import cn.cpoet.mt.model.entity.base.BaseRecordTenantable;
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
