package com.mc.mfb.admin.entity;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Created with IDEA
 * @author:麻超
 * @Date:2019/5/7
 * @Time:17:04
 * 结果返回类
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultEntity {
    private Integer code;
    private boolean success;
    private String message;
    private Object data;

    public ResultEntity(Integer code ,String message, Boolean success){
        this.code = code;
        this.success = success;
        this.message = message;
    }
}
