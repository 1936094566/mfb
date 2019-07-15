package com.mc.mfb.admin.excpetion;


public class MfbException extends RuntimeException {

    private Integer code;

    private String message;

    public MfbException(String message) {
        super(message);
        this.message = message;
    }

    public MfbException(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }
    public MfbException(Code errorCode, Object ...values) {
    	super(String.format(errorCode.getDesc(), values));
    	this.code = errorCode.getCode();
    	this.message = String.format(errorCode.getDesc(), values);
    }

    public MfbException(Code errorCode, String format, Object ... values) {
    	super(String.format(format, values));
    	this.code = errorCode.getCode();
    	this.message = String.format(format, values);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
