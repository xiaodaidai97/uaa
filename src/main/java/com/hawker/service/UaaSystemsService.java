package com.hawker.service;

import com.hawker.entity.UaaSystems;
import com.hawker.entity.dataobject.RequestParameter;

import java.util.List;

/**
 * Created by yylc
 *
 * @author zmf
 * @date 2018/6/15 AND 9:53
 */
public interface UaaSystemsService {

    /*
    * 添加系统
    *
    * */
    public int addOneSystem(UaaSystems uaaSystems);

    /*
    * 查询当前用户下的系统
    *
    * */
    public List<UaaSystems> findAllSystemByUser(RequestParameter requestParameter);

    /*
    *
    * 修改系统信息
    *
    * */
    public int updateOneSystemById(UaaSystems uaaSystems);

    /*
    *
    * 查询单个系统的所有信息
    *
    * */
    public UaaSystems findOneSystemById(UaaSystems uaaSystems);
}
