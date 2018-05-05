package com.krstar.infopublishing.student.service;/*
    *@Author:jhy
    *@Despriction
    *@Date:Created in 17:54 2018/5/4
    *@Modify By:
    */

import com.krstar.infopublishing.student.dao.StudentMapper;
import com.krstar.infopublishing.student.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;
    @Override
    public Student getStudentById(String username) {
        Student student=null;
        student=studentMapper.selectByPrimaryKey(username);
        return student;
    }
}
