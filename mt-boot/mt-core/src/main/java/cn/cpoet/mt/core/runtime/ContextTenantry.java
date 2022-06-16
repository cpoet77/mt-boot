package cn.cpoet.mt.core.runtime;

import cn.cpoet.mt.api.constant.SystemConst;
import cn.cpoet.mt.api.tenant.Tenantry;
import cn.cpoet.mt.model.base.BaseTenantry;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * 应用环境下租户信息
 *
 * @author CPoet
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ContextTenantry extends BaseTenantry {
    /**
     * 系统级租户
     */
    public static final ContextTenantry SYS_TENANT;

    static {
        SYS_TENANT = new Builder()
            .withId(SystemConst.SYS_TENANT_ID)
            .withName(null)
            .withStartTime(LocalDateTime.MIN)
            .withEndTime(LocalDateTime.MAX)
            .withLeases(Duration.between(LocalDateTime.MIN, LocalDateTime.MAX))
            .build();

    }

    public static class Builder {
        private final ContextTenantry tenantry = new ContextTenantry();

        public Builder withTenantry(Tenantry tt) {
            return withId(tt.getId())
                .withName(tt.getName())
                .withStartTime(tt.getStartTime())
                .withEndTime(tt.getEndTime())
                .withLeases(tt.getLeases());
        }

        public Builder withId(long id) {
            tenantry.setId(id);
            return this;
        }

        public Builder withName(String name) {
            tenantry.setName(name);
            return this;
        }

        public Builder withStartTime(LocalDateTime startTime) {
            tenantry.setStartTime(startTime);
            return this;
        }

        public Builder withEndTime(LocalDateTime endTime) {
            tenantry.setEndTime(endTime);
            return this;
        }

        public Builder withLeases(Duration leases) {
            tenantry.setLeases(leases);
            return this;
        }

        public ContextTenantry build() {
            return tenantry;
        }
    }
}
