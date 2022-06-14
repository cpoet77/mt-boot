package cn.cpoet.mt.core.auth;

import cn.cpoet.mt.core.auth.TokenUser.TokenUserBuilder;
import cn.cpoet.mt.model.domain.Role;
import cn.cpoet.mt.model.domain.Staff;
import cn.cpoet.mt.model.domain.query.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户信息获取
 *
 * @author CPoet
 */
public class UserDetailsServiceImpl implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Staff staff = new QStaff().account.eq(username).findOne();
        if (staff == null) {
            throw new UsernameNotFoundException("User does not exist");
        }
        StaffSubject staffSubject = new StaffSubject();
        staffSubject.setStaffId(staff.getId());
        staffSubject.setAccount(staff.getAccount());
        staffSubject.setStaffName(staff.getStaffName());
        ContextTenantry tenantInfo = new ContextTenantry();
        tenantInfo.setTenantId(staff.getTenantId());
        tenantInfo.setTenantName(null);
        staffSubject.setTenantInfo(tenantInfo);
        TokenUserBuilder builder = new TokenUserBuilder()
            .staffSubject(staffSubject)
            .expireTime(staff.getExpireTime())
            .status(staff.getStatus());
        List<Long> roleIds = new QStaffRole()
            .select(QStaffRole.alias().roleId)
            .staffId.eq(staff.getId())
            .tenantId.eq(staff.getTenantId())
            .asDto(Long.class)
            .findList();
        if (CollectionUtils.isEmpty(roleIds)) {
            return builder.build();
        }
        List<Role> roles = new QRole()
            .select(QRole.alias().id, QRole.alias().name)
            .id.in(roleIds)
            .tenantId.eq(staff.getTenantId())
            .findList();
        if (CollectionUtils.isEmpty(roles)) {
            return builder.build();
        }
        List<String> roleCodes = roles
            .stream()
            .map(Role::getCode)
            .collect(Collectors.toList());
        List<Long> permissionIds = new QRolePermission()
            .select(QRolePermission.alias().permissionId)
            .roleId.in(roles.stream().map(Role::getId).collect(Collectors.toList()))
            .tenantId.eq(staff.getTenantId())
            .asDto(Long.class)
            .findList();
        if (CollectionUtils.isEmpty(permissionIds)) {
            return builder.roles(roleCodes).build();
        }
        List<String> permissionCodes = new QPermission()
            .select(QPermission.alias().code)
            .id.in(permissionIds)
            .tenantId.eq(staff.getTenantId())
            .asDto(String.class)
            .findList();
        return builder.roles(roleCodes).permissions(permissionCodes).build();
    }
}
