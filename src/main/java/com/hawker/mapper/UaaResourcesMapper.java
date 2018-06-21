package com.hawker.mapper;

import com.hawker.entity.UaaResources;
import com.hawker.entity.UaaResourcesExample;
import com.hawker.entity.dataobject.UaaResMenu;

import java.util.List;

public interface UaaResourcesMapper {
    long countByExample(UaaResourcesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UaaResources record);

    int insertSelective(UaaResources record);

    List<UaaResources> selectByExample(UaaResourcesExample example);

    UaaResources selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UaaResources record);

    int updateByPrimaryKey(UaaResources record);

    //查询资源（权限）树
    /*@Select("SELECT *\n" +
            "FROM (SELECT * FROM resources WHERE SYS_ID = #{sysId}) p INNER JOIN resources s\n" +
            "ON p.ID=s.PARENT_ID\n" +
            "WHERE p.ID=s.PARENT_ID")@Param("sysId")*/
    List<UaaResMenu> selectResourcesForMenu(Integer sysId);

}