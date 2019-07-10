package com.mc.mfb.admin;

import com.mc.mfb.admin.entity.ExcelModel.Key;
import com.mc.mfb.admin.entity.ResultEntity;
import com.mc.mfb.admin.entity.User;
import com.mc.mfb.admin.serivce.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Created with IDEA
 * @author:麻超
 * @Date:2019/5/7
 * @Time:17:08
 **/
@RestController
public class AcconutController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login",method=RequestMethod.GET)
    private Object doLogin(@ModelAttribute User user){

        User users = userService.doLogin(user.getUsername(), user.getPassword());
        if(users==null){
            return new ResultEntity(500,false,"账号密码错误",null);
        }
        return new ResultEntity(200,true,"登陆成功",null);
    }


    @RequestMapping("/test")
    public Object testDoit(String sql){
        return userService.getAllUser(sql);
    }


    @RequestMapping("/test1")
    public Object testDoit(@ModelAttribute User zs, @ModelAttribute Key ls){


        return "";
    }

    @RequestMapping("/hello")
    public Object hello(String hello){
        return "HELLO "+hello;
    }
}
