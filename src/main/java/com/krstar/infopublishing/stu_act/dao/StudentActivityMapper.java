package com.krstar.infopublishing.stu_act.dao;

import com.krstar.infopublishing.stu_act.entity.StudentActivity;

public interface StudentActivityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StudentActivity record);

    int insertSelective(StudentActivity record);

    StudentActivity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StudentActivity record);

    int updateByPrimaryKey(StudentActivity record);
}