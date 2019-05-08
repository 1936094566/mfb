package com.mc.mfb.admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * @Created with IDEA
 * @author:麻超
 * @Date:2019/5/7
 * @Time:15:25
 **/
@Data
@TableName("t_mfb_permission")
public class Permission {
    @Id
    @TableId(type=IdType.AUTO)
    private int id;
    private String url;
    private String requesttype;
    private String cname;
    private Integer pid;
    private String code;
    private String pcode;
    private String order;
    private String isMenu;
}
