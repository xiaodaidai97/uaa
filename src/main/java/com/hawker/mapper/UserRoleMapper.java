package com.hawker.mapper;

import com.hawker.model.UserRole;
import com.hawker.util.MyMapper;

import java.util.List;

public interface UserRoleMapper extends MyMapper<UserRole> {
    public List<Integer> findUserIdByRoleId(Integer roleId);

    public List<UserRole> select(UserRole role);

//    @Insert("insert into user_role (user_id,role_id) values (#{userId},#{roleId})")
    public int insert(UserRole role);
}