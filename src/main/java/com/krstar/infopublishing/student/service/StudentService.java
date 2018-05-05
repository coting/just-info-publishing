package com.krstar.infopublishing.student.service;
/*
    *@Author:jhy
    *@Despriction
    *@Date:Created in 17:53 2018/5/4
    *@Modify By:
    */

import com.krstar.infopublishing.student.entity.Student;

public interface StudentService {

    /**
     * 根据id获取学生实体
     */
    public Student getStudentById(String username);
}
