package com.krstar.infopublishing.common.utils;/*
    *@Author:jhy
    *@Despriction
    *@Date:Created in 13:42 2018/4/24
    *@Modify By:
    */

import com.krstar.infopublishing.common.response.ApiResult;

public class ResultUtil {
    public static ApiResult success(Object data){
        ApiResult apiResult=new ApiResult();
        apiResult.setCode(200);
        apiResult.setData(data);
        return apiResult;
    }
    public static ApiResult success(){
        return success(null);
    }
    public static ApiResult error(Integer code, String msg){
        ApiResult apiResult=new ApiResult();
        apiResult.setCode(code);
        apiResult.setMsg(msg);
        return apiResult;
    }
}
