package cn.cpoet.mt.entity;

import cn.cpoet.mt.entity.base.BaseRecordTenantable;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 操作日志
 *
 * @author CPoet
 */
@Data
@Entity
@RequiredArgsConstructor
@Table(name = "mt_operator_log")
public class OperatorLog extends BaseRecordTenantable {
}
