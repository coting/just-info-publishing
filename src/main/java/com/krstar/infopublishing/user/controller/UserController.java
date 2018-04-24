package com.krstar.infopublishing.user.controller;

import com.krstar.infopublishing.common.vo.ApiResult;
import com.krstar.infopublishing.common.utils.ResultUtil;
import com.krstar.infopublishing.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ethanp
 * @version V1.0
 * @Package com.krstar.infopublishing.user.controller
 * @Description: TODO
 * @date 2018/4/24 14:35
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;
    @RequestMapping("/test")
    public ApiResult test(){
        return ResultUtil.success(userService.getUser("oOor05XvJvLYuqPtre_pDvjotfs4"));
    }
}
