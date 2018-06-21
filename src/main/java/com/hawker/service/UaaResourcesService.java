package com.hawker.service;

import com.hawker.entity.UaaResources;
import com.hawker.entity.dataobject.UaaResMenu;

import java.util.List;

/**
 * Created by yylc
 *
 * @author zmf
 * @date 2018/6/14 AND 17:21
 */
public interface UaaResourcesService {

    /*
    * 查询所有的资源（权限）
    *
    * */
    public List<UaaResources> findAllResources(UaaResources uaaResources);

    /*
    * 添加资源（权限）
    *
    * */
    public int addOneResources(UaaResources uaaResources);

    /*
    *
    * 查询资源（权限）树
    *
    * */
    public List<UaaResMenu> findResourcestTree(UaaResMenu uaaResMenu);

    /*
    *
    * 修改资源（权限）
    *
    * */
    public int updateOneResourcesById(UaaResources uaaResources);

    /*
    *
    * 查询单个资源（权限）
    *
    * */

    public UaaResources findOneResourcesById(UaaResources uaaResources);
}
