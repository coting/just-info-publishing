package com.krstar.infopublishing.prize.controller;
/*
    *@Author:jhy
    *@Despriction
    *@Date:Created in 10:21 2018/5/4
    *@Modify By:
    */

import com.krstar.infopublishing.common.enums.ResultEnum;
import com.krstar.infopublishing.common.utils.ResultUtil;
import com.krstar.infopublishing.common.vo.ApiResult;
import com.krstar.infopublishing.prize.entity.Prize;
import com.krstar.infopublishing.prize.entity.PrizeElement;
import com.krstar.infopublishing.prize.entity.Winner;
import com.krstar.infopublishing.prize.service.PrizeService;
import com.krstar.infopublishing.student.entity.Student;
import com.mysql.jdbc.util.ResultSetUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.sound.sampled.Line;
import java.util.Date;

@RestController
@RequestMapping("prize")
public class PrizeController {
    @Autowired
    @Qualifier("prizeServiceImpl")
    @Lazy
    private PrizeService prizeService;

    /**
     * 新增一个抽奖活动
     * @param prize
     * @return
     */
    @RequestMapping(value ="/addPrize",method = RequestMethod.POST)
    public ApiResult addPrice(@RequestBody Prize prize){
        prize.setGmtCreate(new Date()+"");
        try {
            prizeService.addPrize(prize);
            return ResultUtil.success(prize);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error(ResultEnum.ADD_PRIZE_ERROR.getCode(),ResultEnum.ADD_PRIZE_ERROR.getMsg());
        }
    }

    /**
     * 参加抽奖
     */
    @RequestMapping(value = "/joinPrize",method = RequestMethod.POST)
    public ApiResult joinPrize(String username){
        try {
            Student result=prizeService.joinPrize(username);
            return ResultUtil.success(result);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error(ResultEnum.JOIN_PRIZE_ERROR.getCode(),ResultEnum.JOIN_PRIZE_ERROR.getMsg());
        }
    }

    /**
     * 获取当前抽奖的报名情况
     */

    @RequestMapping(value = "/getCurrentData", method = RequestMethod.GET)
    public ApiResult getCurrentData(){
        try {
            PrizeElement pe= prizeService.getCurrentData();
            return ResultUtil.success(pe);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error(ResultEnum.GET_PRIZE_ERROR.getCode(),ResultEnum.GET_PRIZE_ERROR.getMsg());
        }
    }

    /**
     * 获取开奖信息（包含中奖者信息以及奖品信息）
     */
    @RequestMapping(value = "/getWinner",method = RequestMethod.GET)
    public ApiResult openPrize(){
        try{
            Winner winner=prizeService.openPrize();
            return ResultUtil.success(winner);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error(ResultEnum.GET_WINNER_ERROR.getCode(),ResultEnum.GET_WINNER_ERROR.getMsg());
        }
    }

}
