package com.mc.mfb.admin.entity.ExcelModel;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Created with IDEA
 * @author:麻超
 * @Date:2019/5/18
 * @Time:11:09
 **/
@TableName("keytest")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Key {
    private Integer id;
    private String name;

}
