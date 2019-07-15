package com.mc.mfb.admin.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
/**
*
*  @author machao
*/

@TableName("t_mfb_menu")
@Data
public class Menu implements Serializable {

    private static final long serialVersionUID = 1557365973770L;


    /**
    * 主键
    * 
    * isNullAble:0
    */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
    * 中文名称
    * isNullAble:1
    */
    private String name;

    /**
    * 请求地址
    * isNullAble:1
    */
    private String url;

    /**
    * url
    * isNullAble:1
    */
    private String code;

    /**
    * 
    * isNullAble:1
    */
    private Integer pid;

    /**
    * 
    * isNullAble:1
    */
    private String level;

    /**
    * 图标
    * isNullAble:1
    */
    private String icon;

    /**
    * 提示
    * isNullAble:1
    */
    private String tips;

    /**
    * 菜单状态
    * isNullAble:1
    */
    private String status;

    /**
    * 0-前台,1-后台
    * isNullAble:1
    */
    private Integer belong;

    /**
    * 排序
    * isNullAble:1
    */
    private Integer num;

    /**
    * 0-是菜单,1不是菜单
    * isNullAble:1
    */
    private Integer ismenu;


    /**
     * 权限Code
     */
    private String perCode;
}
