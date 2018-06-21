package com.hawker.mapper;

import com.hawker.model.Role;
import com.hawker.util.MyMapper;

import java.util.List;

public interface RoleMapper extends MyMapper<Role> {
    public List<Role> queryRoleListWithSelected(Integer id);

//    @Select("select id,roleDesc,name,type,ext_info from role"+
//            " <where>  1=1 " +
//            " <if test=\"id!= null\">AND id=#{id}</if> " +
//            " <if test=\"roleDesc != null\"> AND role_desc=#{roleDesc}</if> " +
//            " <if test=\"name != null\"> AND name=#{name}</if> " +
//            " <if test=\"type != null\"> AND type=#{type}</if> " +
//            " <if test=\"extInfo != null\"> AND ext_info=#{extInfo}</if> " +
//            " </where> " )
    public List<Role> select(Role role);

//    @Insert("insert into role(role_desc,name,type,ext_info) values (#{roleDesc},#{name},#{type},#{extInfo})")
    public int insert(Role role);
}