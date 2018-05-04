package com.krstar.infopublishing.prize.service;/*
    *@Author:jhy
    *@Despriction
    *@Date:Created in 14:09 2018/5/4
    *@Modify By:
    */

import com.alibaba.druid.pool.vendor.InformixExceptionSorter;
import com.krstar.infopublishing.common.enums.ResultEnum;
import com.krstar.infopublishing.common.exception.InfoPublishException;
import com.krstar.infopublishing.prize.dao.PrizeMapper;
import com.krstar.infopublishing.prize.entity.Prize;
import com.krstar.infopublishing.prize.entity.PrizeElement;
import com.krstar.infopublishing.prize_user.dao.PrizeUserMapper;
import com.krstar.infopublishing.prize_user.entity.PrizeUser;
import com.krstar.infopublishing.student.dao.StudentMapper;
import com.krstar.infopublishing.student.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class PrizeServiceImpl implements PrizeService {

    @Autowired
    private PrizeMapper prizeMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private PrizeUserMapper prizeUserMapper;

    @Override
    public Prize addPrize(Prize prize) {
        if (prize==null){
            throw new InfoPublishException(ResultEnum.NULL_OBJECT);
        }
        try {
            prizeMapper.insertSelective(prize);
        }catch (Exception e){
            e.printStackTrace();
        }
        return prize;
    }

    @Override
    public Prize getCurrentPrize() {
        Prize currentPrize=null;
        try{
             currentPrize=prizeMapper.selectCurrentPrize();
        }catch (Exception e){
            throw  new InfoPublishException(ResultEnum.GET_PRIZE_ERROR);
        }
        return currentPrize;
    }

    @Override
    public Student joinPrize(String studentId) {
        Student student=null;
        PrizeUser prizeUser=null;

        if(studentId==null){
            throw new InfoPublishException(ResultEnum.NULL_OBJECT);
        }
        try {
            student=studentMapper.selectByPrimaryKey(studentId);
            Prize currentPrize=prizeMapper.selectCurrentPrize();
            Integer currentPrizeId=currentPrize.getId();
            if(student==null){
                throw new InfoPublishException(ResultEnum.NULL_OBJECT);
            }else{
                prizeUser.setUserId(student.getUsername());
                prizeUser.setPrizeId(currentPrizeId);
                try{
                    prizeUserMapper.insertSelective(prizeUser);
                }catch (Exception e){
                    throw  new InfoPublishException(ResultEnum.JOIN_PRIZE_ERROR);
                }
            }
        }catch (Exception e){
            throw new InfoPublishException(ResultEnum.FIND_STUDENT_ERROR);
        }
        return student;
    }

    @Override
    public PrizeUser openPrize() {
        return null;
    }

    @Override
    public PrizeElement getCurrentRank() {
        Prize prize=null;
        PrizeElement pe=null;
        List<String> rankAcademy=new ArrayList<String>();
        List<String> rakGrade=new ArrayList<String>();
        try {
            //获取当前抽奖实体
            prize=prizeMapper.selectCurrentPrize();
            //根据抽奖实体id来获取参与者的总人数，学院热度，年级热度
            Integer prizeId=prize.getId();
            Integer AccountOfJoiners=prizeUserMapper.selectAccountByPrizeId(prizeId);
            ArrayList academyList=prizeMapper.selectAcademyOfJoiners(prizeId);


        }catch (Exception e){
            throw  new InfoPublishException(ResultEnum.GET_PRIZE_ERROR);
        }
        return null;
    }


}
