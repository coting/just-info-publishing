package com.krstar.infopublishing.prize.entity;/*
    *@Author:jhy
    *@Despriction
    *@Date:Created in 18:52 2018/5/5
    *@Modify By:
    */

import com.krstar.infopublishing.student.entity.Student;
import lombok.Data;

@Data
public class Winner {

    private Student student;

    private Prize prize;
}
