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
import com.krstar.infopublishing.prize.entity.Winner;
import com.krstar.infopublishing.prize_user.dao.PrizeUserMapper;
import com.krstar.infopublishing.prize_user.entity.PrizeUser;
import com.krstar.infopublishing.student.dao.StudentMapper;
import com.krstar.infopublishing.student.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            throw new InfoPublishException(ResultEnum.ADD_PRIZE_ERROR);
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
        if(studentId==null){
            throw new InfoPublishException(ResultEnum.NULL_OBJECT);
        }
        try {
            student=studentMapper.selectByPrimaryKey(studentId);
            Prize currentPrize=prizeMapper.selectCurrentPrize();
            Integer currentPrizeId=currentPrize.getId();
            if(student==null || currentPrizeId==null){
                throw new InfoPublishException(ResultEnum.NULL_OBJECT);
            }else{
                PrizeUser prizeUser=new PrizeUser();
                prizeUser.setPrizeId(currentPrizeId);
                prizeUser.setUserId(student.getUsername());
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
    public Winner openPrize() {
        Winner winner=new Winner();
        Prize prize=prizeMapper.selectCurrentPrize();
        Student student=studentMapper.selectByPrimaryKey(prize.getGmtOpen());
        winner.setPrize(prize);
        winner.setStudent(student);
        return winner;
    }

    @Override
    public PrizeElement getCurrentData() {
        Prize prize;
        try {
            //获取当前抽奖实体
            prize=prizeMapper.selectCurrentPrize();
            //根据抽奖实体id来获取参与者的总人数
            Integer prizeId=prize.getId();
            Integer AccountOfJoiners=prizeUserMapper.selectAccountByPrizeId(prizeId);
            //根据抽奖实体id来获取参与者的学院热度
            List<String> academyList=new ArrayList();
            academyList=prizeUserMapper.selectAcademyOfJoiners(prizeId);
            List<String> result=new ArrayList();
            Map<String,Integer> resultMap=new HashMap<>();
            for(String i:academyList){
                boolean flag=false;
                for(String j:result){
                   if(j.equals(i)){
                       flag=true;
                       int temp=resultMap.get(i)+1;
                       resultMap.put(i,temp);
                       break;
                   }
                }
                if(!flag){
                    result.add(i);
                    resultMap.put(i,1);
                }
            }
            PrizeElement pe=new PrizeElement();
            pe.setPrize(prize);
            pe.setTotalJoiners(AccountOfJoiners+"");
            pe.setRankAcademy(resultMap);
            return pe;
        }catch (Exception e){
            throw  new InfoPublishException(ResultEnum.GET_PRIZE_ERROR);
        }
    }


}
