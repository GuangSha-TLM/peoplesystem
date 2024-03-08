package com.tlm.people.utils;

import com.tlm.people.result.ResultCodeEnum;
import lombok.Data;

@Data
public class GuiguException extends RuntimeException {

    private String code;//状态码
    private String msg;//描述信息

    public GuiguException(String code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    /**
     * 接收枚举类型对象
     * @param resultCodeEnum
     */
    public GuiguException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
        this.msg = resultCodeEnum.getMessage();
    }

    @Override
    public String toString() {
        return "GuliException{" +
                "code=" + code +
                ", message=" + this.getMessage() +
                '}';
    }
}
