package com.mc.mfb.admin.entity;

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
    private int code;
    private boolean success;
    private String message;
    private Object data;
}
