package com.hawker.service.impl;

import com.hawker.entity.UaaSystems;
import com.hawker.entity.UaaSystemsExample;
import com.hawker.entity.dataobject.RequestParameter;
import com.hawker.mapper.UaaSystemsMapper;
import com.hawker.service.UaaSystemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by yylc
 *
 * @author zmf
 * @date 2018/6/15 AND 9:55
 */
@Service
public class UaaSystemsServiceImpl implements UaaSystemsService {

    @Autowired
    private UaaSystemsMapper uaaSystemsMapper;
    @Override
    public int addOneSystem(UaaSystems uaaSystems) {
        uaaSystems.setGmtCreated(new Date());
        uaaSystems.setClientId(java.util.UUID.randomUUID().toString().replaceAll("\\-", ""));
        uaaSystems.setClientSecret("2."+java.util.UUID.randomUUID().toString().replaceAll("\\-", ""));
        return uaaSystemsMapper.insertSelective(uaaSystems);
    }

    @Override
    public List<UaaSystems> findAllSystemByUser(RequestParameter requestParameter) {
        UaaSystemsExample example = new UaaSystemsExample();
        example.setOrderByClause("GMT_CREATED DESC");
        UaaSystemsExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(requestParameter.getUserId());
        return uaaSystemsMapper.selectByExample(example);
    }

    @Override
    public int updateOneSystemById(UaaSystems uaaSystems) {
        return uaaSystemsMapper.updateByPrimaryKeySelective(uaaSystems);
    }

    @Override
    public UaaSystems findOneSystemById(UaaSystems uaaSystems) {
        return uaaSystemsMapper.selectByPrimaryKey(uaaSystems.getId());
    }
}
