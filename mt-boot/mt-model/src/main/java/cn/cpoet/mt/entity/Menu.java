package cn.cpoet.mt.entity;

import cn.cpoet.mt.entity.base.BaseTenantable;
import lombok.Data;
import lombok.experimental.FieldNameConstants;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 菜单
 * <p>用于用户个性化配置，和{@link Permission}联动</p>
 *
 * @author CPoet
 */
@Data
@Entity
@FieldNameConstants
@Table(name = "mt_menu")
public class Menu extends BaseTenantable {

}
