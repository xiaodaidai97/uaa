package com.hawker.mapper;

import com.hawker.model.RoleResources;
import com.hawker.util.MyMapper;

import java.util.List;

public interface RoleResourcesMapper extends MyMapper<RoleResources> {
//    @Select("select id,role_id,resources_id,action from role_resources"+
//            " <where>  1=1 " +
//            " <if test=\"id!= null\">AND id=#{id}</if> " +
//            " <if test=\"roleId != null\"> AND role_id=#{roleId}</if> " +
//            " <if test=\"resourcesId != null\"> AND resources_id=#{resourcesId}</if> " +
//            " <if test=\"action != null\"> AND action=#{action}</if> " +
//            " </where> " )
    public List<RoleResources> select(RoleResources role);

//    @Insert("insert into role_resources(role_id,resources_id,action) values (#{roleId},#{resourcesId},#{action})")
    public int insert(RoleResources role);
}