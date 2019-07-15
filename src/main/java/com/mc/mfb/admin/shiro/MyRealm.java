package com.mc.mfb.admin.shiro;

import com.mc.mfb.admin.entity.JwtToken;
import com.mc.mfb.admin.entity.User;
import com.mc.mfb.admin.serivce.UserService;
import com.mc.mfb.admin.util.Constant;
import com.mc.mfb.admin.util.JwtUtil;
import com.mc.mfb.admin.util.RedisUtil;
import com.mc.mfb.admin.util.ToolUtil;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author machao
 * @date 2019/7/12
 * @time 16:20
 * @description shiro认证类
 **/
@Component
public class MyRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;

    @Autowired
    private RedisUtil redisUtil;

    /**
     * 必须重写此方法,不然Shiro会报错
     *
     * @param authenticationToken
     * @return
     */
    @Override
    public boolean supports(AuthenticationToken authenticationToken) {
        return authenticationToken instanceof JwtToken;
    }

    /**
     * 检测用户权限的时候会调用此方法
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //String username = JwtUtil.getUsername(principalCollection.toString());
        //User user = userService.findByUserName(username);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        return simpleAuthorizationInfo;
    }

    /**
     * 默认使用此方法进行用户名正确与否判断,错误抛出异常
     *
     * @param auth
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth)  {
        String token = (String) auth.getCredentials();
        String username = JwtUtil.getClaim(token, Constant.ACCOUNT);
        if (ToolUtil.isEmpty(username)) {
            throw new AuthenticationException("token无效");
        }
        User user = userService.findByUserName(username);
        if (ToolUtil.isEmpty(user)) {
            throw new AuthenticationException("用户名不存在");
        }
        if(JwtUtil.verify(token)&&redisUtil.isHaveKey(Constant.PREFIX_SHIRO_REFRESH_TOKEN + username)){
            if(JwtUtil.getClaim(token,Constant.CURRENT_TIME_MILLIS).equals(String.valueOf(redisUtil.get(Constant.PREFIX_SHIRO_REFRESH_TOKEN + username)))){
                return new SimpleAuthenticationInfo(token, token, this.getClass().getName());
            }
        }
        throw new AuthenticationException("Token已过期(Token expired or incorrect.)");
    }
}
