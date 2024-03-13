package com.tlm.people.result;


public enum ResultCodeEnum {

    SUCCESS("0x200","成功"),
    FAIL("201", "失败"),
    LOGIN_ERROR("208","认证失败")
    ;

    private String code;
    private String message;

    private ResultCodeEnum(String code,String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
