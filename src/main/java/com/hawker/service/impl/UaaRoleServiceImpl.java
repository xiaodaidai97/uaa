package com.hawker.service.impl;

import com.hawker.entity.UaaRole;
import com.hawker.entity.UaaRoleExample;
import com.hawker.entity.UaaRoleResources;
import com.hawker.mapper.UaaRoleMapper;
import com.hawker.mapper.UaaRoleResourcesMapper;
import com.hawker.service.UaaRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by yylc
 *
 * @author zmf
 * @date 2018/6/15 AND 13:58
 */
@Service
public class UaaRoleServiceImpl implements UaaRoleService {

    @Autowired
    private UaaRoleMapper uaaRoleMapper;

    @Autowired
    private UaaRoleResourcesMapper uaaRoleResourcesMapper;

    @Override
    public int addOneRole(UaaRole uaaRole) {
        //如果是全局角色，把系统ID为0
        if("全局角色".equals(uaaRole.getRoleType())){
            uaaRole.setSysId(0);
        }
        uaaRole.setGmtCreated(new Date());
        return uaaRoleMapper.insertSelective(uaaRole);
    }

    @Override
    public List<UaaRole> findAllRolesBySystem(UaaRole uaaRole) {
        UaaRoleExample example = new UaaRoleExample();
        example.setOrderByClause("GMT_CREATED DESC");
        UaaRoleExample.Criteria criteria = example.createCriteria();
        List<Integer> list = new ArrayList<Integer>();
        list.add(0);
        list.add(uaaRole.getSysId());
        criteria.andSysIdIn(list);
        return uaaRoleMapper.selectByExample(example);
    }

    @Override
    public int addResourcesForRole(List<UaaRoleResources> uaaRoleResources) {
        return uaaRoleResourcesMapper.insertUaaRoleResources(uaaRoleResources);
    }
}
