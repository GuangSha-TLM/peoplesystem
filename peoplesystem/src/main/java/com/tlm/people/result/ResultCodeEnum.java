package com.tlm.people.result;

import lombok.Getter;

@Getter
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
}
