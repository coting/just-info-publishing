package com.krstar.infopublishing.prize.entity;/*
    *@Author:jhy
    *@Despriction
    *@Date:Created in 14:59 2018/5/4
    *@Modify By:
    */

import lombok.Data;

import java.util.ArrayList;

@Data
public class PrizeElement {
    private Prize prize;
    private String totalJoiners;
    private ArrayList<String> rankAcademy;
    private ArrayList<String> rankGrade;
}
