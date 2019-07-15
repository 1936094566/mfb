package com.mc.mfb.admin;

import com.mc.mfb.admin.entity.ResultEntity;
import com.mc.mfb.admin.entity.User;
import com.mc.mfb.admin.serivce.UserService;
import com.mc.mfb.admin.util.Constant;
import com.mc.mfb.admin.util.JwtUtil;
import com.mc.mfb.admin.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;


/**
 * @Created with IDEA
 * @author:麻超
 * @Date:2019/5/7
 * @Time:17:08
 **/
@RestController
public class AccountController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisUtil redisUtil;

    @PostMapping(value = "/login")
    private Object login(@ModelAttribute User user, HttpServletResponse response)  {
        User users = userService.doLogin(user.getUsername(), user.getPassword());
        if(users==null){
            return new ResultEntity(500,false,"账号密码错误",null);
        }
        //清除存在的权限信息
        if(redisUtil.isHaveKey(Constant.PREFIX_SHIRO_CACHE+users.getUsername())){
            redisUtil.del(Constant.PREFIX_SHIRO_CACHE+users.getUsername());
        }
        String currentMillis= System.currentTimeMillis()+"";
        //返回jwt签名字符串
        String token = JwtUtil.sign(user.getUsername(),currentMillis);
        redisUtil.set(Constant.PREFIX_SHIRO_REFRESH_TOKEN + users.getUsername(), currentMillis, Constant.EXRP_MINUTE);
        response.setHeader("Authorization", token);
        response.setHeader("Access-Control-Expose-Headers", "Authorization");
        return new ResultEntity(200,true,"登陆成功",token);
    }
    @PostMapping("/test")
    public Object test(){
        return "helloworld";
    }
}
