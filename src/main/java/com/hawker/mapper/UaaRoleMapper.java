package com.hawker.mapper;

import com.hawker.entity.UaaRole;
import com.hawker.entity.UaaRoleExample;

import java.util.List;

public interface UaaRoleMapper {
    long countByExample(UaaRoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UaaRole record);

    int insertSelective(UaaRole record);

    List<UaaRole> selectByExample(UaaRoleExample example);

    UaaRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UaaRole record);

    int updateByPrimaryKey(UaaRole record);


}