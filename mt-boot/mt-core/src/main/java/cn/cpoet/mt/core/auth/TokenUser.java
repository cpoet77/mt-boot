package cn.cpoet.mt.core.auth;

import cn.cpoet.mt.model.constant.CommStatus;
import lombok.AccessLevel;
import lombok.Builder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.*;

/**
 * 用户信息
 *
 * @author CPoet
 */
@Builder(access = AccessLevel.PACKAGE)
public class TokenUser implements UserDetails {
    /**
     * 标识角色前缀
     */
    public final static String ROLE_PREFIX = "ROLE_";

    private StaffSubject staffSubject;

    private List<String> roles;

    private List<String> permissions;

    private LocalDateTime expireTime;

    private CommStatus status;

    /**
     * 获取主体信息
     *
     * @return 主体信息
     */
    public StaffSubject getStaffSubject() {
        return staffSubject;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (CollectionUtils.isEmpty(roles) && CollectionUtils.isEmpty(permissions)) {
            return Collections.emptySet();
        }
        Set<GrantedAuthority> authorities = new HashSet<>(roles.size() + permissions.size());
        for (String role : roles) {
            authorities.add(() -> ROLE_PREFIX + role);
        }
        for (String permission : permissions) {
            // 避免恶意越权操作
            if (!permission.startsWith(ROLE_PREFIX)) {
                authorities.add(() -> permission);
            }
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return staffSubject.getAccount();
    }

    @Override
    public String getUsername() {
        return staffSubject.getAccount();
    }

    @Override
    public boolean isAccountNonExpired() {
        return expireTime == null || LocalDateTime.now().isBefore(expireTime);
    }

    @Override
    public boolean isAccountNonLocked() {
        return !CommStatus.LOCKED.equals(status);
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return !CommStatus.DISABLED.equals(status);
    }
}
