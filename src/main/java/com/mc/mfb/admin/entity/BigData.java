package com.mc.mfb.admin.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Created with IDEA
 * @author:麻超
 * @Date:2019/5/17
 * @Time:11:37
 **/
@Data
@TableName("big_data")
public class BigData {
    @Excel(name="编号")
    private Integer id;
    @Excel(name="姓名")
    private String name;
    @Excel(name="年龄")
    private Integer age;
    @Excel(name="电子邮箱")
    private String email;

}
