package com.krstar.infopublishing.student.dao;

import com.krstar.infopublishing.student.entity.Student;

public interface StudentMapper {
    int deleteByPrimaryKey(String username);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(String username);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}