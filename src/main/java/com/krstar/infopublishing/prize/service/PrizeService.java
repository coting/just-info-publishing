package com.krstar.infopublishing.prize.service;
/*
    *@Author:jhy
    *@Despriction
    *@Date:Created in 10:30 2018/5/4
    *@Modify By:
    */

import com.krstar.infopublishing.common.vo.ApiResult;
import com.krstar.infopublishing.prize.entity.Prize;
import com.krstar.infopublishing.prize.entity.PrizeElement;
import com.krstar.infopublishing.prize.entity.Winner;
import com.krstar.infopublishing.prize_user.entity.PrizeUser;
import com.krstar.infopublishing.student.entity.Student;

public interface PrizeService {
    /**
     * 新增奖品
     */

    Prize addPrize(Prize prize);

    /**
     * 获取当前抽奖实体
     */

    Prize getCurrentPrize();

    /**
     * 参与抽奖
     */

    Student joinPrize(String studentId);

    /**
     * 获取抽奖结果
     */

    Winner openPrize();

    /**
     * 显示实时参与情况
     */

    PrizeElement getCurrentData();






}
