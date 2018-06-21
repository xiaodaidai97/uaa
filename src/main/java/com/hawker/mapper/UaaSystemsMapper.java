package com.hawker.mapper;

import com.hawker.entity.UaaSystems;
import com.hawker.entity.UaaSystemsExample;

import java.util.List;

public interface UaaSystemsMapper {
    long countByExample(UaaSystemsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UaaSystems record);

    int insertSelective(UaaSystems record);

    List<UaaSystems> selectByExample(UaaSystemsExample example);

    UaaSystems selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UaaSystems record);

    int updateByPrimaryKey(UaaSystems record);
}