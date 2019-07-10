package com.mc.mfb.admin.controller;

import com.mc.mfb.admin.entity.Menu;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Created with IDEA
 * @author:麻超
 * @Date:2019/6/24
 * @Time:10:57 菜单控制层
 **/
@RestController
@RequestMapping("/menu")
public class MenuController {

    @GetMapping
    public Object getMenu(Menu menu){

        return null;
    }
}
