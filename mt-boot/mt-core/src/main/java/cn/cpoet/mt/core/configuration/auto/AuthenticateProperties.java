package cn.cpoet.mt.core.configuration.auto;

import lombok.Data;

import java.time.Duration;

/**
 * 认证相关配置
 *
 * @author wanggf
 */
@Data
public class AuthenticateProperties {
    /**
     * token header中的名称
     */
    private String tokenHeader = "Authorization";

    /**
     * token的有效时长
     */
    private Duration tokenDuration = Duration.ofMinutes(120);

    /**
     * 刷新token区间
     */
    private Duration refreshTokenBwt = Duration.ofMinutes(10);
}
