package com.krstar.infopublishing.prize.dao;

import com.krstar.infopublishing.prize.entity.Prize;

import java.util.ArrayList;

public interface PrizeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Prize record);

    int insertSelective(Prize record);

    Prize selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Prize record);

    int updateByPrimaryKey(Prize record);

    Prize selectCurrentPrize();

    ArrayList selectAcademyOfJoiners(Integer prizeId);
}
