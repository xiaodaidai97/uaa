package com.hawker.service;

import com.hawker.entity.UaaRole;
import com.hawker.entity.UaaRoleResources;

import java.util.List;

/**
 * Created by yylc
 *
 * @author zmf
 * @date 2018/6/15 AND 13:49
 */
public interface UaaRoleService {
    /*
    *
    * 添加角色
    *
    * */
    public int addOneRole(UaaRole uaaRole);

    /*
    *
    * 查看所有的角色
    *
    * */
    public List<UaaRole> findAllRolesBySystem(UaaRole uaaRole);

    /*
    *
    * 为某个角色分配权限
    *
    * */
    public int addResourcesForRole(List<UaaRoleResources> uaaRoleResources);
}
