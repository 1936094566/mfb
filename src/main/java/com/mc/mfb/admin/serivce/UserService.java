package com.mc.mfb.admin.serivce;

import com.mc.mfb.admin.entity.User;

import java.util.List;

/**
 * @Created with IDEA
 * @author:麻超
 * @Date:2019/5/7
 * @Time:8:52
 **/
public interface UserService {

     List<User> getAllUser();

     User doLogin(String username,String password);

     List<User> getAllUser(String sql);

}
