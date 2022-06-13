package cn.cpoet.mt.model.entity;

import cn.cpoet.mt.model.entity.base.BaseTenantable;
import cn.cpoet.mt.model.entity.constant.CommStatus;
import cn.cpoet.mt.model.entity.constant.DbColLenConst;
import cn.cpoet.mt.model.entity.constant.DbTypeConst;
import io.ebean.annotation.Index;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * 人员
 *
 * @author CPoet
 */
@Data
@Entity
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

    /**
     * 过期时间
     */
    @Column(name = "expire_time")
    private LocalDateTime expireTime;

    /**
     * 用户状态
     */
    @Column(name = "status", nullable = false)
    private CommStatus status;
}
