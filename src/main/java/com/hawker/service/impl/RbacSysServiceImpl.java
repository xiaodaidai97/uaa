package com.hawker.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hawker.mapper.RbacSysMapper;
import com.hawker.model.RbacSys;
import com.hawker.model.Resources;
import com.hawker.service.RbacSysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class RbacSysServiceImpl implements RbacSysService{
    @Autowired
    RbacSysMapper mapper;

    @Override
    public PageInfo<RbacSys> selectByPage(RbacSys sys, int start, int length) {
        int page = start/length+1;
        Example example = new Example(Resources.class);
        //分页查询
        PageHelper.startPage(page, length);
        List<RbacSys> userList = mapper.select(sys);
        return new PageInfo<>(userList);
    }

    @Override
    public int insert(RbacSys sys) {
        sys.setClientId(java.util.UUID.randomUUID().toString().replaceAll("\\-", ""));
        sys.setClientSecret("2."+java.util.UUID.randomUUID().toString().replaceAll("\\-", ""));
        return mapper.insert(sys);
    }
}
