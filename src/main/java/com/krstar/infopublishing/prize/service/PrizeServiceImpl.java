package com.krstar.infopublishing.prize.service;/*
    *@Author:jhy
    *@Despriction
    *@Date:Created in 14:09 2018/5/4
    *@Modify By:
    */

import com.alibaba.druid.pool.vendor.InformixExceptionSorter;
import com.krstar.infopublishing.common.enums.ResultEnum;
import com.krstar.infopublishing.common.exception.HaveAttenedException;
import com.krstar.infopublishing.common.exception.HaveOpenedException;
import com.krstar.infopublishing.common.exception.InfoPublishException;
import com.krstar.infopublishing.prize.dao.PrizeMapper;
import com.krstar.infopublishing.prize.entity.AcademyJoiner;
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

import java.util.*;

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
        Prize p=prizeMapper.selectCurrentPrize();
        if(p.getGmtOpen()!=null){
            throw new HaveOpenedException(ResultEnum.PRIZE_HAVE_OPENED);
        }
        Student student=null;
        if(studentId==null){
            throw new InfoPublishException(ResultEnum.NULL_OBJECT);
        }

        try {
            Prize currentPrize=prizeMapper.selectCurrentPrize();
            Integer currentPrizeId=currentPrize.getId();
            //判断是否重复参与抽奖
            PrizeUser  pu=prizeUserMapper.selectJoinersByUserId( studentId,currentPrizeId );
            if(pu!=null){
                throw new HaveAttenedException(ResultEnum.JOIN_PRIZE_ALREADY);
            }else{
                student=studentMapper.selectByPrimaryKey(studentId);
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
            }
        }catch (HaveOpenedException e){
            throw new HaveOpenedException(ResultEnum.PRIZE_HAVE_OPENED);
        }catch (HaveAttenedException e){
            throw new HaveAttenedException(ResultEnum.JOIN_PRIZE_ALREADY);
        }catch (InfoPublishException e){
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
            List<Map.Entry<String,Integer>> resultList=new ArrayList<Map.Entry<String,Integer>>(resultMap.entrySet());
            Collections.sort(resultList,new Comparator<Map.Entry<String,Integer>>(){

                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    return o2.getValue().compareTo(o1.getValue());
                }
            });
            System.out.println(resultList);
            List<AcademyJoiner> resultAjList=new ArrayList();

            System.out.println(resultList);
            for(Map.Entry<String,Integer> mapping:resultList){
                AcademyJoiner aj=new AcademyJoiner();
                aj.setName(mapping.getKey());
                aj.setNumber(mapping.getValue());
                resultAjList.add(aj);
            }


            Student student=studentMapper.selectByPrimaryKey(prize.getGmtOpen());

            PrizeElement pe=new PrizeElement();
            pe.setPrize(prize);
            pe.setTotalJoiners(AccountOfJoiners+"");
            pe.setRankAcademy(resultAjList);
            pe.setStudent(student);
            return pe;


        }catch (Exception e){
            throw  new InfoPublishException(ResultEnum.GET_PRIZE_ERROR);
        }
    }


}
