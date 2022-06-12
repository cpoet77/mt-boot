package cn.cpoet.mt.entity;

import cn.cpoet.mt.entity.base.BaseTenantable;
import lombok.Data;
import lombok.experimental.FieldNameConstants;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.Duration;
import java.time.LocalDateTime;

/**
 * 用户在线信息
 * <p>由WebSocket记录</p>
 *
 * @author CPoet
 */
@Data
@Entity
@FieldNameConstants
@Table(name = "mt_online")
public class Online extends BaseTenantable {
    /**
     * 登录日志信息
     */
    @Column(name = "login_id", nullable = false)
    private Long loginId;

    /**
     * Token
     */
    @Column(name = "token", nullable = false)
    private String token;

    /**
     * 开始时间
     */
    @Column(name = "start_time", nullable = false)
    private LocalDateTime startTime;

    /**
     * 结束时间
     */
    @Column(name = "end_time", nullable = false)
    private LocalDateTime endTime;

    /**
     * 在线时长
     */
    @Column(name = "duration", nullable = false)
    private Duration duration;
}
