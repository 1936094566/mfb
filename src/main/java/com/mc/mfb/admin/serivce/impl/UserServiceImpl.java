package com.mc.mfb.admin.serivce.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mc.mfb.admin.dao.UserDao;
import com.mc.mfb.admin.entity.User;
import com.mc.mfb.admin.serivce.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * @Created with IDEA
 * @author:麻超
 * @Date:2019/5/7
 * @Time:8:52
 **/
@Service
public class UserServiceImpl implements UserService {

    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getAllUser() {
        return userDao.selectList(null);
    }

    @Override
    public User doLogin(String username,String password) {

        User user = userDao.selectOne(new QueryWrapper<User>()
                .eq("username", username)
                .eq("password", password));

        return user;

    }
}
