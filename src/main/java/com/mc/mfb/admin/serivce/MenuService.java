package com.mc.mfb.admin.serivce;

import com.mc.mfb.admin.entity.Menu;

import java.util.List;

/**
 * @Created with IDEA
 * @author:麻超
 * @Date:2019/5/9
 * @Time:9:47
 **/
public interface MenuService {

    /**
     *
     * @return
     */
    List<Menu> getMenus(Integer belong);

}
