package com.mc.mfb.admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * @Created with IDEA
 * @author:麻超
 * @Date:2019/5/7
 * @Time:8:51
 **/
@Data
@TableName("t_mfb_user")
public class User {
    @Id
    @TableId(type=IdType.AUTO)
    private int id;
    private String username;
    private String password;
    private String email;
    @TableField("create_time")
    private Date createTime;
    @TableField("last_login_time")
    private Date lastLoginTime;
    private String state;
    private String relname;
    private String sex;
    private Date birthday;
    private String salt;
    @TableField("user_type")
    private int userType;
}
