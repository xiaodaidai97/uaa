package com.hawker.service;

import com.github.pagehelper.PageInfo;
import com.hawker.model.RbacSys;

import java.util.List;

public interface RbacSysService {
    PageInfo<RbacSys> selectByPage(RbacSys sys, int start, int length);

    public int insert(RbacSys sys);
}
