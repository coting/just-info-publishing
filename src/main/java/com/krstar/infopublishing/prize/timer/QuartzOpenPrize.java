package com.krstar.infopublishing.prize.timer;

import com.krstar.infopublishing.prize.dao.PrizeMapper;
import com.krstar.infopublishing.prize.entity.Prize;
import com.krstar.infopublishing.prize_user.dao.PrizeUserMapper;
import com.krstar.infopublishing.prize_user.entity.PrizeUser;
import com.krstar.infopublishing.student.dao.StudentMapper;
import com.krstar.infopublishing.student.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/*
    *@Author:jhy
    *@Despriction
    *@Date:Created in 17:45 2018/5/5
    *@Modify By:
    */
@Component
@Configurable
@EnableScheduling
public class QuartzOpenPrize {

    @Autowired
    private PrizeUserMapper prizeUserMapper;

    @Autowired
    private PrizeMapper prizeMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Scheduled(cron = "0 0 10 5 * ?  ") // 每月30日10：00执行
    public void goWork() throws Exception {
        System.out.println("每月30日10：00执行");
        Prize currentPrize=prizeMapper.selectCurrentPrize();
        Integer currentPrizeId=currentPrize.getId();
        List<String> joiners=new ArrayList();
        joiners=prizeUserMapper.selectJoinersByPrizeId(currentPrizeId);
        System.out.println(joiners);
        Integer length=joiners.size();
        Random random=new Random();
        System.out.println(random.nextInt(length));
        String winnerId=joiners.get(random.nextInt(length));
//        Student winner=studentMapper.selectByPrimaryKey(winnerId);
        currentPrize.setGmtOpen(winnerId);
        prizeMapper.updateByPrimaryKeySelective(currentPrize);
    }

//    @Scheduled(fixedRate = 10000)
//    public void work() throws Exception {
//        Prize currentPrize=prizeMapper.selectCurrentPrize();
//        Integer currentPrizeId=currentPrize.getId();
//        List<String> joiners=new ArrayList();
//        joiners=prizeUserMapper.selectJoinersByPrizeId(currentPrizeId);
//        System.out.println(joiners);
//        Integer length=joiners.size();
//        Random random=new Random();
//        System.out.println(random.nextInt(length));
//        String winnerId=joiners.get(random.nextInt(length));
//        Student winner=studentMapper.selectByPrimaryKey(winnerId);
//        currentPrize.setGmtOpen(winnerId);
//        prizeMapper.updateByPrimaryKeySelective(currentPrize);
//    }
//
//
//    @Scheduled(fixedRate = 5000)//每10秒执行一次
//    public void play() throws Exception {
//        Prize currentPrize=prizeMapper.selectCurrentPrize();
//        Integer currentPrizeId=currentPrize.getId();
//        List<String> joiners=new ArrayList();
//        joiners=prizeUserMapper.selectJoinersByPrizeId(currentPrizeId);
//        System.out.println(joiners);
//    }
//
//
//
//    @Scheduled(cron = "0/2 * * * * ?") //每2秒执行一次
//    public void doSomething() throws Exception {
//        System.out.println("每2秒执行一个的定时任务："+new Date());
//    }






}
