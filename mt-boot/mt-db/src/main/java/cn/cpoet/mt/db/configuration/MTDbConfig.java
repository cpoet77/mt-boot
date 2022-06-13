package cn.cpoet.mt.db.configuration;

import cn.cpoet.mt.api.auth.AuthContext;
import cn.cpoet.mt.db.tenant.DefaultTenantDb;
import cn.cpoet.mt.db.tenant.DefaultTenantDbContext;
import cn.cpoet.mt.db.tenant.TenantDb;
import cn.cpoet.mt.db.tenant.TenantDbContext;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * 数据库相关配置
 *
 * @author CPoet
 */
@EntityScan("cn.cpoet.mt.entity")
@ComponentScan("cn.cpoet.mt.db.dao")
@Import({EBeanConfig.class})
public class MTDbConfig {
    @Bean
    @ConditionalOnMissingBean
    public TenantDbContext tenantDbContext() {
        return new DefaultTenantDbContext();
    }

    @Bean
    @ConditionalOnMissingBean
    public TenantDb tenantDb(ObjectProvider<AuthContext> authContext) {
        DefaultTenantDb tenantDb = new DefaultTenantDb();
        authContext.ifUnique(tenantDb::setAuthContext);
        return tenantDb;
    }
}
