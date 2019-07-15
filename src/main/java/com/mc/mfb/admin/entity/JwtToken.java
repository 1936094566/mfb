package com.mc.mfb.admin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author machao
 * @date 2019/7/12
 * @time 16:05
 * @description token包装类
 **/
@Data
@AllArgsConstructor
public class JwtToken  implements AuthenticationToken {
    private String token;

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
