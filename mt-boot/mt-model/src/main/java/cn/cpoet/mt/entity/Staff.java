package cn.cpoet.mt.entity;

import cn.cpoet.mt.entity.base.BaseTenantable;
import cn.cpoet.mt.entity.constant.DbColLenConst;
import cn.cpoet.mt.entity.constant.DbTypeConst;
import io.ebean.annotation.Index;
import lombok.Data;
import lombok.experimental.FieldNameConstants;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 人员
 *
 * @author CPoet
 */
@Data
@Entity
@FieldNameConstants
@Table(name = "mt_staff")
public class Staff extends BaseTenantable {
    /**
     * 姓名
     */
    @Column(name = "staff_name", length = DbColLenConst.STAFF_NAME, nullable = false)
    private String staffName;

    /**
     * 账号
     */
    @Index
    @Column(name = "account", length = DbColLenConst.ACCOUNT, nullable = false)
    private String account;

    /**
     * 邮箱
     */
    @Index
    @Column(name = "email", length = DbColLenConst.EMAIL)
    private String email;

    /**
     * 头像
     */
    @Column(name = "avatar", length = DbColLenConst.AVATAR)
    private String avatar;

    /**
     * 手机号
     */
    @Index
    @Column(name = "mobile", length = DbColLenConst.MOBILE)
    private String mobile;

    /**
     * 密码，已加密处理
     */
    @Column(name = "password", length = 128, nullable = false)
    private String password;

    /**
     * 个人介绍
     */
    @Column(name = "description", columnDefinition = DbTypeConst.TEXT)
    private String description;
}
