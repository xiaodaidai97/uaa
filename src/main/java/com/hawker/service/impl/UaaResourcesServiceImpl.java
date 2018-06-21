package com.hawker.service.impl;

import com.hawker.entity.UaaResources;
import com.hawker.entity.UaaResourcesExample;
import com.hawker.entity.dataobject.UaaResMenu;
import com.hawker.mapper.UaaResourcesMapper;
import com.hawker.service.UaaResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by yylc
 *
 * @author zmf
 * @date 2018/6/14 AND 17:34
 */
@Service
public class UaaResourcesServiceImpl implements UaaResourcesService {

    @Autowired
    private UaaResourcesMapper uaaResourcesMapper;

    @Override
    public List<UaaResources> findAllResources(UaaResources uaaResources) {
        UaaResourcesExample example = new UaaResourcesExample();
        example.setOrderByClause("GMT_CREATED DESC");
        UaaResourcesExample.Criteria criteria = example.createCriteria();
        criteria.andSysIdEqualTo(uaaResources.getSysId());
        return uaaResourcesMapper.selectByExample(example);
    }

    @Override
    public int addOneResources(UaaResources uaaResources){
        uaaResources.setGmtCreated(new Date());
        return uaaResourcesMapper.insertSelective(uaaResources);
    }

    @Override
    public List<UaaResMenu> findResourcestTree(UaaResMenu uaaResMenu) {
        return uaaResourcesMapper.selectResourcesForMenu(uaaResMenu.getSysId());
    }

    @Override
    public int updateOneResourcesById(UaaResources uaaResources) {
        return uaaResourcesMapper.updateByPrimaryKeySelective(uaaResources);
    }

    @Override
    public UaaResources findOneResourcesById(UaaResources uaaResources) {
        return uaaResourcesMapper.selectByPrimaryKey(uaaResources.getId());
    }
}
