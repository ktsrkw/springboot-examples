package com.wt.config;

import com.wt.mapper.UserMapper;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {
    @Autowired
    UserMapper userMapper;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了=>授权doGetAuthorizationInfo");

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermission("user:add");//给所有用户都赋予add权限

        //真实情况是，用户的权限user:add是存放在数据库中的，通过从当前用户的信息来判断是否又某些权限
        //例如，拿到了当前用户对象currentUser，通过这个对象的属性（存放权限的属性）perms来addStringPermission
        //info.addStringPermission(currentUser.getPerms());

        return info;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行了=>认证doGetAuthenticationInfo");

        //用户名，密码，数据库中取，这里先伪造
//        String username = "wt";
//        String password = "111111";

        UsernamePasswordToken userToken = (UsernamePasswordToken) authenticationToken;

//        if (!userToken.getUsername().equals(username)){//如果找不到用户名
//            return null;//这个return null 会自动抛出异常（UnknownAccountException）
//        }

        //从真实的数据库中取数据
        if(userMapper.getUserByUsername(userToken.getUsername()) == null){//数据库中查不到用户
            return null;
        }

        //密码认证，shiro来做
        return new SimpleAuthenticationInfo("",userMapper.getUserByUsername(userToken.getUsername()).getPwd(),"");
    }
}
