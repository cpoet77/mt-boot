package cn.cpoet.mt.core.auth;

import cn.cpoet.mt.api.auth.AuthContext;
import cn.cpoet.mt.api.auth.Subject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.request.RequestContextHolder;

/**
 * 简单应用认证上下文
 *
 * @author CPoet
 */
@Slf4j
public class SimpleAuthContext implements AuthContext {
    private final static ThreadLocal<Subject> SUBJECT_THREAD_LOCAL = ThreadLocal
        .withInitial(SimpleAuthContext::getCurrentSubject);

    @Override
    public Subject currentSubject() {
        return SUBJECT_THREAD_LOCAL.get();
    }

    /**
     * 获取当前上下文中的认证主体
     *
     * @return 认证主体
     */
    public static Subject getCurrentSubject() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            // 判断是否存在请求上下文，存在则为游客访问
            try {
                RequestContextHolder.currentRequestAttributes();
                return GuestSubject.INSTANCE;
            } catch (Exception e) {
                log.debug("No request context exists: {}", e.getMessage(), e);
            }
            // 默认系统主体
            return SystemSubject.INSTANCE;
        }
        // 解析认证主体信息
        return ((TokenUser) authentication.getDetails()).getStaffSubject();
    }
}
