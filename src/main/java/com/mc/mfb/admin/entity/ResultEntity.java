package com.mc.mfb.admin.entity;

import lombok.Data;

/**
 * @Created with IDEA
 * @author:麻超
 * @Date:2019/5/7
 * @Time:17:04
 * 结果返回类
 **/
@Data
public class ResultEntity {
    private int code;
    private boolean success;
    private String message;
    private Object data;
}
