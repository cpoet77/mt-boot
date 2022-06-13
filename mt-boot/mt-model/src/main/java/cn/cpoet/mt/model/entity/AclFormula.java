package cn.cpoet.mt.model.entity;

import cn.cpoet.mt.model.entity.base.BaseTenantable;
import cn.cpoet.mt.model.entity.constant.AclFormulaSymbol;
import cn.cpoet.mt.model.entity.constant.AclFormulaType;
import cn.cpoet.mt.model.entity.constant.CommStatus;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 访问控制授权表达式
 * <p>以断言形式判定</p>
 *
 * @author CPoet
 */
@Data
@Entity
@Table(name = "mt_acl_formula")
public class AclFormula extends BaseTenantable {
    /**
     * 判定式名称
     */
    @Column(name = "name", unique = true, nullable = false)
    private String name;

    /**
     * 左边表达式
     */
    @Column(name = "left_formula", nullable = false)
    private String leftFormula;

    /**
     * 左边表达式类型
     */
    @Column(name = "left_type", nullable = false)
    private AclFormulaType leftType;

    /**
     * 比较符号
     */
    @Column(name = "symbol", nullable = false)
    private AclFormulaSymbol symbol;

    /**
     * 右边表达式
     */
    @Column(name = "right_formula", nullable = false)
    private String rightFormula;

    /**
     * 右边表达式类型
     */
    @Column(name = "right_type", nullable = false)
    private AclFormulaType rightType;

    /**
     * 状态
     */
    @Column(name = "status", nullable = false)
    private CommStatus status;
}
