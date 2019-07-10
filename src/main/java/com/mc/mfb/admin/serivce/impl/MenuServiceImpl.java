package com.mc.mfb.admin.serivce.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mc.mfb.admin.dao.MenuDao;
import com.mc.mfb.admin.entity.Menu;
import com.mc.mfb.admin.serivce.MenuService;
import com.mc.mfb.admin.util.ToolUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Created with IDEA
 * @author:麻超
 * @Date:2019/5/9
 * @Time:9:47
 **/
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuDao menuDao;

    @Override
    public List<Menu> getMenus(Menu menu) {
        QueryWrapper<Menu> wrapper = new QueryWrapper<>();
        wrapper.eq(ToolUtil.isNotEmpty(menu.getBelong()),"belong",menu.getBelong());
        wrapper.eq(ToolUtil.isNotEmpty(menu.getStatus()),"status",menu.getStatus()).like(ToolUtil.isNotEmpty(menu.getName()),"name",menu.getName());
        return null;
    }
}
