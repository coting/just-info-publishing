package com.krstar.infopublishing.common.exception;/*
    *@Author:jhy
    *@Despriction
    *@Date:Created in 16:27 2018/5/9
    *@Modify By:
    */

import com.krstar.infopublishing.common.enums.ResultEnum;

public class HaveOpenedException extends InfoPublishException {
    public HaveOpenedException(ResultEnum resultEnum) {
        super(resultEnum);
    }
}
