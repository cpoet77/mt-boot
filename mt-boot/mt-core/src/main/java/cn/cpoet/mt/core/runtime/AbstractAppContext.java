package cn.cpoet.mt.core.runtime;

import cn.cpoet.mt.api.auth.AuthContext;
import cn.cpoet.mt.api.auth.Subject;
import cn.cpoet.mt.api.constant.SystemConst;
import cn.cpoet.mt.api.runtime.AppContext;
import cn.cpoet.mt.api.runtime.RunModel;
import cn.cpoet.mt.api.tenant.Tenantry;
import cn.cpoet.mt.model.domain.Tenant;
import cn.cpoet.mt.model.domain.query.QTenant;
import cn.cpoet.mt.model.domain.query.QWebDomain;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * 应用上下文
 *
 * @author CPoet
 */
@Slf4j
@SuppressWarnings("all")
public abstract class AbstractAppContext implements AppContext {
    /**
     * 认证上下文
     */
    @Autowired
    protected AuthContext authContext;

    /**
     * Spring应用上下文
     */
    @Autowired
    protected ApplicationContext applicationContext;

    @Override
    public RunModel getRunModel() {
        return RunModel.NONE;
    }

    @Override
    public Tenantry getTenantry() {
        Subject subject = authContext.currentSubject();
        // 已登录的情况下，租户信息明确
        if (subject.logged()) {
            return subject.getTenantry();
        }
        // 否则从请求环境中判断当前访问的租户域
        HttpServletRequest request = currentReqeust();
        if (request == null) {
            return ContextTenantry.SYS_TENANT;
        }
        String serverName = request.getServerName();
        // 解析域名，获取当前域名对应的租户
        log.info("serverName: {}", serverName);
        Long tenantId = new QWebDomain()
            .select(QWebDomain.alias().tenantId)
            .domain.eq(serverName)
            .asDto(Long.class)
            .findOne();
        // 非系统租户
        if (!Objects.equals(tenantId, SystemConst.SYS_TENANT_ID)) {
            // 读取租户信息
            Tenant tenant = new QTenant()
                .id.eq(tenantId)
                .findOne();
            if (tenant != null) {
                return tenant;
            }
        }
        return ContextTenantry.SYS_TENANT;
    }

    @Override
    public AuthContext getAuthContext() {
        return authContext;
    }

    @Override
    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * 获取当前请求上下文
     *
     * @return 请求上下文
     */
    protected final HttpServletRequest currentReqeust() {
        try {
            return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        } catch (Exception igonred) {
        }
        return null;
    }
}
