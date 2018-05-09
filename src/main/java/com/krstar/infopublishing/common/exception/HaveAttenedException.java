package com.krstar.infopublishing.common.exception;/*
    *@Author:jhy
    *@Despriction
    *@Date:Created in 16:06 2018/5/9
    *@Modify By:
    */

import com.krstar.infopublishing.common.enums.ResultEnum;

public class HaveAttenedException extends InfoPublishException {
    public HaveAttenedException(ResultEnum resultEnum) {
        super(resultEnum);
    }
}
