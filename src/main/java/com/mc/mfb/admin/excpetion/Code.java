package com.mc.mfb.admin.excpetion;

/**
 * 错误状态枚举类
 */
public enum Code{

    Add_Failed(12,"添加失败");
    /**
     * Code 状态码
     */
    private Integer code;
    /**
     * desc 描述
     */
    private String desc;

    Code(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
