package cn.cpoet.mt.api.tenant;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * 租户
 *
 * @author CPoet
 */
public interface Tenantry {
    /**
     * 获取租户id
     *
     * @return 租户id
     */
    Long getId();

    /**
     * 获取租户名称
     *
     * @return 租户名称
     */
    String getName();

    /**
     * 获取租期开始时间
     *
     * @return 开始时间
     */
    LocalDateTime getStartTime();

    /**
     * 获取租期结束时间
     *
     * @return 结束时间
     */
    LocalDateTime getEndTime();

    /**
     * 获取租期
     *
     * @return 租期
     */
    Duration getLeases();
}
