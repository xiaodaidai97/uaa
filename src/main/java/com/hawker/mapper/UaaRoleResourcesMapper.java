package com.hawker.mapper;

import com.hawker.entity.UaaRoleResources;
import com.hawker.entity.UaaRoleResourcesExample;

import java.util.List;

public interface UaaRoleResourcesMapper {
    long countByExample(UaaRoleResourcesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UaaRoleResources record);

    int insertSelective(UaaRoleResources record);

    List<UaaRoleResources> selectByExample(UaaRoleResourcesExample example);

    UaaRoleResources selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UaaRoleResources record);

    int updateByPrimaryKey(UaaRoleResources record);

    //批量插入
    int insertUaaRoleResources(List<UaaRoleResources> roleResources);

    //批量修改
    int updateUaaRoleResources(List<UaaRoleResources> roleResources);
}