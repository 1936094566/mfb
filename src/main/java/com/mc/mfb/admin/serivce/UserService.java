package com.mc.mfb.admin.serivce;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mc.mfb.admin.entity.User;

import java.util.List;

/**
 * @Created with IDEA
 * @author:麻超
 * @Date:2019/5/7
 * @Time:8:52
 **/
public interface UserService extends IService<User> {

     List<User> getAllUser();

    /**
     * 账号密码登录
     * @param username
     * @param password
     * @return
     */
     User doLogin(String username,String password);

     List<User> getAllUser(String sql);

     User findByUserName(String username);


}
