package com.krstar.infopublishing.prize.controller;
/*
    *@Author:jhy
    *@Despriction
    *@Date:Created in 10:21 2018/5/4
    *@Modify By:
    */

import com.krstar.infopublishing.common.utils.ResultUtil;
import com.krstar.infopublishing.common.vo.ApiResult;
import com.krstar.infopublishing.prize.entity.Prize;
import com.krstar.infopublishing.prize.service.PrizeService;
import com.mysql.jdbc.util.ResultSetUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
        prizeService.addPrize(prize);
        return ResultUtil.success(prize);
    }

    /**
     * 参加抽奖
     */
    @RequestMapping(value = "/joinPrize",method = RequestMethod.POST)
    public ApiResult joinPrize(String username){
        prizeService.joinPrize(username);
        return ResultUtil.success();
    }

}
