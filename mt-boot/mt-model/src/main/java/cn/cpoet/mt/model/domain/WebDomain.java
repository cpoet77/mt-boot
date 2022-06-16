package cn.cpoet.mt.model.domain;

import cn.cpoet.mt.model.base.BaseModel;
import cn.cpoet.mt.model.constant.CommStatus;
import cn.cpoet.mt.model.constant.DbTypeConst;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * 网络域名
 *
 * @author CPoet
 */
@Data
@Entity
@Table(name = "mt_web_domain")
public class WebDomain extends BaseModel {
    /**
     * 域名地址
     */
    @Column(name = "domain", unique = true, nullable = false)
    private String domain;

    /**
     * 网络备案号
     */
    @Column(name = "ipc_no")
    private String icpNo;

    /**
     * 拥有人
     */
    @Column(name = "owner")
    private String owner;

    /**
     * 邮箱地址
     */
    @Column(name = "email")
    private String email;

    /**
     * 注册商
     */
    @Column(name = "register")
    private String register;

    /**
     * 创建时间
     */
    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    /**
     * 过期时间
     */
    @Column(name = "expiration_date")
    private LocalDateTime expirationDate;

    /**
     * 使用的租户Id，默认为系统租户
     */
    @Column(name = "tenant_id", nullable = false)
    private Long tenantId;

    /**
     * 域名的相关介绍
     */
    @Column(name = "description", columnDefinition = DbTypeConst.TEXT)
    private String description;

    /**
     * 状态
     */
    @Column(name = "status", nullable = false)
    private CommStatus status;
}
