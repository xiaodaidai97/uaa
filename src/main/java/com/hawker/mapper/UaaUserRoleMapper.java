package com.hawker.mapper;

import com.hawker.entity.UaaUserRole;
import com.hawker.entity.UaaUserRoleExample;

import java.util.List;

public interface UaaUserRoleMapper {
    long countByExample(UaaUserRoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UaaUserRole record);

    int insertSelective(UaaUserRole record);

    List<UaaUserRole> selectByExample(UaaUserRoleExample example);

    UaaUserRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UaaUserRole record);

    int updateByPrimaryKey(UaaUserRole record);
}