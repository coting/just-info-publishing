package com.krstar.infopublishing.student.controller;/*
    *@Author:jhy
    *@Despriction
    *@Date:Created in 17:52 2018/5/4
    *@Modify By:
    */

import com.krstar.infopublishing.common.utils.ResultUtil;
import com.krstar.infopublishing.common.vo.ApiResult;
import com.krstar.infopublishing.student.service.StudentService;
import com.mysql.jdbc.util.ResultSetUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("student")
public class StudentController {
    @Autowired
    @Qualifier("studentServiceImpl")
    @Lazy
    private StudentService studentService;

    /**
     * 通过id获取学生实体
     */
    @RequestMapping(value = "/getStudent",method = RequestMethod.POST)
    public ApiResult getStudentById(String username){
        studentService.getStudentById(username);
        return ResultUtil.success();
    }
}
