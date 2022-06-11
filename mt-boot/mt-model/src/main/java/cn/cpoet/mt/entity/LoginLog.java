package cn.cpoet.mt.entity;

import cn.cpoet.mt.entity.base.BaseRecordTenantable;
import lombok.Data;
import lombok.experimental.FieldNameConstants;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 登录日志
 *
 * @author CPoet
 */
@Data
@Entity
@FieldNameConstants
@Table(name = "mt_login_log")
public class LoginLog extends BaseRecordTenantable {
}
