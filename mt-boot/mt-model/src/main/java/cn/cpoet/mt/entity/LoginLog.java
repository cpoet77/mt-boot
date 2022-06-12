package cn.cpoet.mt.entity;

import cn.cpoet.mt.entity.base.BaseRecordTenantable;
import cn.cpoet.mt.entity.constant.DbColLenConst;
import cn.cpoet.mt.entity.constant.LoginType;
import lombok.Data;
import lombok.experimental.FieldNameConstants;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

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
    /**
     * 用户id
     */
    @Column(name = "staff_id", nullable = false)
    private Long staffId;

    /**
     * 登录账号
     */
    @Column(name = "account", nullable = false, length = DbColLenConst.ACCOUNT)
    private String account;

    /**
     * 登录类型
     */
    @Column(name = "login_type", nullable = false)
    private LoginType loginType;

    /**
     * 登录IP地址
     */
    @Column(name = "ip_addr", length = DbColLenConst.IP)
    private String ipAddr;

    /**
     * UA信息
     */
    @Column(name = "user_agent")
    private String userAgent;

    /**
     * 操作系统
     */
    @Column(name = "os")
    private String os;

    /**
     * 分辨率信息
     */
    @Column(name = "screen")
    private String screen;

    /**
     * 登录时间
     */
    @Column(name = "login_time", nullable = false)
    private LocalDateTime loginTime;
}
