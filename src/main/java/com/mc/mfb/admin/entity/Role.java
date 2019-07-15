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
@TableName("t_mfb_role")
public class Role {
    @Id
    @TableId(type=IdType.AUTO)
    private int id;
    private String roleName;
    private String roleCode;
    private String descprition;

}
