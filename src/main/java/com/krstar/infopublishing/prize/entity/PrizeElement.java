package com.krstar.infopublishing.prize.entity;/*
    *@Author:jhy
    *@Despriction
    *@Date:Created in 14:59 2018/5/4
    *@Modify By:
    */

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Data
public class PrizeElement {
    private Prize prize;
    private String totalJoiners;
    private Map<String,Integer> rankAcademy;
}
