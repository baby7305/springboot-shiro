package com.example.demo.config;

import com.example.demo.domain.SysResource;
import com.example.demo.domain.SysRole;
import com.example.demo.domain.SysUser;
import com.example.demo.service.SysUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private SysUserService sysUserService;

    /**
     * 身份认证 --- 登录.
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        /*
         *  1、获取用户输入的账号.
         *  2、通过userName 从数据库中进行查找，找到SysUser对象.
         *  3、加密. 使用SimpleAuthenticationInfo 进行身份处理.
         *  4、返回身份处理对象.
         */
        //1、 获取用户输入的账号.
        String username = (String) token.getPrincipal();

        //2、通过userName 从数据库中进行查找，找到SysUser对象.
        SysUser sysUser = sysUserService.findByUserName(username);
        if (sysUser == null) {
            return null;
        }
        //3、加密. 使用SimpleAuthenticationInfo 进行身份处理.
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(sysUser, sysUser.getUserPassword(), ByteSource.Util.bytes(sysUser.getUserNameAndSalt()), getName());

        //4、返回身份处理对象.
        return simpleAuthenticationInfo;
    }

    /**
     * 权限认证.
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        //这是shiro提供的.
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        //获取到用户的权限信息.
        SysUser sysUser = (SysUser) principals.getPrimaryPrincipal();
        for (SysRole role : sysUser.getSysRoles()) {
            //添加角色.
            authorizationInfo.addRole(role.getRoleName());
            //添加权限.
            for (SysResource resource : role.getSysResources()) {
                authorizationInfo.addStringPermission(resource.getResourcePermission());
            }
        }
        return authorizationInfo;
    }

}
