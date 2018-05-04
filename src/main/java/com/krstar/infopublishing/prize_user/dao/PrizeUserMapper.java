package com.krstar.infopublishing.prize_user.dao;

import com.krstar.infopublishing.prize_user.entity.PrizeUser;

public interface PrizeUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PrizeUser record);

    int insertSelective(PrizeUser record);

    PrizeUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PrizeUser record);

    int updateByPrimaryKey(PrizeUser record);

    Integer selectAccountByPrizeId(Integer prizeId);
}