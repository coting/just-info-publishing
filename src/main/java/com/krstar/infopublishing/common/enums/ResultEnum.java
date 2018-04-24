package com.krstar.infopublishing.common.enums;

/*
    *@Author:jhy
    *@Despriction
    *@Date:Created in 13:31 2018/4/24
    *@Modify By:
    */

public enum  ResultEnum{
    UNKONW_ERROR(500,"未知错误"),
    SUCCSEE(200,"成功");

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
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
