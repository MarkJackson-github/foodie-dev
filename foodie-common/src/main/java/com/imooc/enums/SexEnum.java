package com.imooc.enums;

/**
 * 性别枚举
 */
public enum SexEnum {
    WOMAN(0,"女"),
    MAN(1,"男"),
    SECRET(2,"保密");

    private Integer code;
    private String msg;

    SexEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
