package com.krstar.infopublishing.common.enums;

/*
    *@Author:jhy
    *@Despriction
    *@Date:Created in 13:31 2018/4/24
    *@Modify By:
    */

public enum  ResultEnum{
    UNKONW_ERROR(500,"未知错误"),
    SUCCSEE(200,"成功"),
    NULL_OBJECT(501,"实体为空"),
    ADD_PRIZE_ERROR(502,"插入奖品失败"),
    GET_PRIZE_ERROR(503,"获取当前抽奖失败"),
    JOIN_PRIZE_ERROR(504,"参与抽奖失败"),
    GET_WINNER_ERROR(505,"获取开奖信息失败"),
    FIND_STUDENT_ERROR(601,"查询指定学号的学生失败");

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
