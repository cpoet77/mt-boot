package cn.cpoet.mt.model.domain;

import cn.cpoet.mt.model.base.BaseTenantable;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 系统配置
 *
 * @author CPoet
 */
@Data
@Entity
@Table(name = "mt_option")
public class Option extends BaseTenantable {
}
