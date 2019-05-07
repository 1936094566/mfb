package com.mc.mfb.admin.controller;

import com.mc.mfb.admin.serivce.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Created with IDEA
 * @author:麻超
 * @Date:2019/5/7
 * @Time:9:08
 **/
@RestController
@RequestMapping("/admin")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method=RequestMethod.GET)
    public String getAllUser(){
        return userService.getAllUser().toString();
    }
}
