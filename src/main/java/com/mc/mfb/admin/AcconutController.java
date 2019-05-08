package com.mc.mfb.admin;

import com.mc.mfb.admin.entity.ResultEntity;
import com.mc.mfb.admin.serivce.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(value = "/login",method=RequestMethod.POST)
    private ResultEntity doLogin(String username,String password){
            return new ResultEntity();
    }

}
