package cn.cpoet.mt.entity;

import cn.cpoet.mt.entity.base.BaseModel;
import cn.cpoet.mt.entity.constant.DbColLenConst;
import cn.cpoet.mt.entity.constant.DbTypeConst;
import lombok.Data;
import lombok.experimental.FieldNameConstants;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 公司信息
 *
 * @author CPoet
 */
@Data
@Entity
@FieldNameConstants
@Table(name = "mt_company")
public class Company extends BaseModel {
    /**
     * 公司名称
     */
    @Column(name = "name", unique = true, nullable = false)
    private String name;

    /**
     * 公司logo
     */
    @Column(name = "logo", length = DbColLenConst.URL)
    private String logo;

    /**
     * 负责人姓名
     */
    @Column(name = "principal", length = DbColLenConst.STAFF_NAME, nullable = false)
    private String principal;

    /**
     * 联系电话
     */
    @Column(name = "mobile", length = DbColLenConst.MOBILE, nullable = false)
    private String mobile;

    /**
     * 公司电话
     */
    @Column(name = "telephone", length = DbColLenConst.TELEPHONE)
    private String telephone;

    /**
     * 邮箱信息
     */
    @Column(name = "email", length = DbColLenConst.EMAIL)
    private String email;

    /**
     * 公司地址
     */
    @Column(name = "address")
    private String address;

    /**
     * 公司介绍
     */
    @Column(name = "description", columnDefinition = DbTypeConst.TEXT)
    private String description;

    /**
     * 扩展字段1
     */
    @Column(name = "ext01", columnDefinition = DbTypeConst.TEXT)
    private String ext01;

    /**
     * 扩展字段2
     */
    @Column(name = "ext02", columnDefinition = DbTypeConst.TEXT)
    private String ext02;

    /**
     * 扩展字段3
     */
    @Column(name = "ext03", columnDefinition = DbTypeConst.TEXT)
    private String ext03;
}
