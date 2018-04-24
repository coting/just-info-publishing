package com.krstar.infopublishing.common.exception;/*
    *@Author:jhy
    *@Despriction
    *@Date:Created in 13:30 2018/4/24
    *@Modify By:
    */

import com.krstar.infopublishing.common.enums.ResultEnum;

public class InfoPublishException extends RuntimeException{
    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public InfoPublishException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code=resultEnum.getCode();

    }
}
