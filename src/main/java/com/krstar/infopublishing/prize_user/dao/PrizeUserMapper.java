package com.krstar.infopublishing.prize_user.dao;

import com.krstar.infopublishing.prize_user.entity.PrizeUser;
import com.krstar.infopublishing.student.entity.Student;

import java.util.List;

public interface PrizeUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PrizeUser record);

    int insertSelective(PrizeUser record);

    PrizeUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PrizeUser record);

    int updateByPrimaryKey(PrizeUser record);

    Integer selectAccountByPrizeId(Integer prizeId);

    List selectAcademyOfJoiners(Integer prizeId);

    List<String> selectJoinersByPrizeId(Integer currentPrizeId);


    PrizeUser selectJoinersByUserId(String studentId, Integer currentPrizeId);
}