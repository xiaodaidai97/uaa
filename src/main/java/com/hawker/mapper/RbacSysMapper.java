package com.hawker.mapper;

import com.hawker.model.RbacSys;
import com.hawker.util.MyMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface RbacSysMapper extends MyMapper<RbacSys> {


//    @Select("select id,code,name,user_id,remark,optime,ext_info from rbac_sys"+
//            " <where>  1=1 " +
//            " <if test=\"id!= null\">AND id=#{id}</if> " +
//            " <if test=\"code != null\"> AND code=#{code}</if> " +
//            " <if test=\"name != null\"> AND name=#{name}</if> " +
//            " <if test=\"userId != null\"> AND user_id=#{userId}</if> " +
//            " <if test=\"extInfo != null\"> AND ext_info=#{extInfo}</if> " +
//            " </where> " )
//    public List<RbacSys> select(RbacSys rbacSys);
//
//    @Insert("insert into rbac_sys(code,name,user_id,remark,ext_info) values (#{code},#{name},#{userId},#{remark},#{extInfo})")
//    public int insert(RbacSys rbacSys);
}
