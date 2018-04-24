package com.krstar.infopublishing.common.vo;

/*
    *@Author:jhy
    *@Despriction
    *@Date:Created in 13:37 2018/4/24
    *@Modify By:
    */

import lombok.Data;

@Data
public class ApiResult<T> {
    private int code;
    private String msg;
    private T data;
}

