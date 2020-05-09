package com.imooc.enums;

/**
 * 异常信息枚举
 */
public enum ExceptionEnum {
    NULL_POINTER_ERROR("空指针异常"),
    INTERNAL_SERVER_ERROR("服务器内部错误");

    private String msg;

    ExceptionEnum(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
