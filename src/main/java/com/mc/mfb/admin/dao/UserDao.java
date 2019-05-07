package com.mc.mfb.admin.dao;

import com.mc.mfb.admin.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Created with IDEA
 * @author:麻超
 * @Date:2019/5/7
 * @Time:8:55
 **/
public interface UserDao extends JpaRepository<User, Integer> {
}
