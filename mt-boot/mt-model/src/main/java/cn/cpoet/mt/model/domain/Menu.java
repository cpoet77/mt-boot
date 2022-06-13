package cn.cpoet.mt.model.domain;

import cn.cpoet.mt.model.base.BaseTenantable;
import lombok.Data;

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
@Table(name = "mt_menu")
public class Menu extends BaseTenantable {

}
