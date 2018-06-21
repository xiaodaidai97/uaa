package com.hawker.mapper;

import com.hawker.entity.UaaUser;
import com.hawker.entity.UaaUserExample;

import java.util.List;

public interface UaaUserMapper {
    long countByExample(UaaUserExample example);

    int deleteByPrimaryKey(String userId);

    int insert(UaaUser record);

    int insertSelective(UaaUser record);

    List<UaaUser> selectByExample(UaaUserExample example);

    UaaUser selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(UaaUser record);

    int updateByPrimaryKey(UaaUser record);
}