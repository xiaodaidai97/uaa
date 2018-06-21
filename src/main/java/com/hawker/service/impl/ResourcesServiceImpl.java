package com.hawker.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hawker.entity.UaaResources;
import com.hawker.entity.UaaResourcesExample;
import com.hawker.mapper.ResourcesMapper;
import com.hawker.mapper.UaaResourcesMapper;
import com.hawker.model.Resources;
import com.hawker.service.ResourcesService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by yangqj on 2017/4/25.
 */
@Service("resourcesService")
public class ResourcesServiceImpl extends BaseService<Resources> implements ResourcesService {
   @Resource
    private ResourcesMapper resourcesMapper;

    @Autowired
    private UaaResourcesMapper uaaResourcesMapper;

    @Override
    public PageInfo<Resources> selectByPage(Resources resources, int start, int length) {
        int page = start/length+1;
        Example example = new Example(Resources.class);
        if(StringUtils.isNotBlank(resources.getName())){
            example.createCriteria().andEqualTo("name",resources.getName());
        }
        if(StringUtils.isNotBlank(resources.getResurl())){
            example.createCriteria().andLike("resurl",resources.getResurl());
        }
        if(StringUtils.isNotBlank(resources.getSysId())){
            example.createCriteria().andEqualTo("sysId",resources.getSysId());
        }
        //分页查询
        PageHelper.startPage(page, length);
        List<Resources> userList = selectByExample(example);
        return new PageInfo<>(userList);
    }

    @Override
    public List<UaaResources> queryAll(){
        UaaResourcesExample example = new UaaResourcesExample();
        example.setOrderByClause("GMT_CREATED DESC");
        return uaaResourcesMapper.selectByExample(example);
    }

    @Override
    @Cacheable(cacheNames="resources",key="#map['userid'].toString()+#map['type']")
    public List<Resources> loadUserResources(Map<String, Object> map) {
        return resourcesMapper.loadUserResources(map);
    }

    @Override
    public List<Resources> queryResourcesListWithSelected(Integer rid) {
        return resourcesMapper.queryResourcesListWithSelected(rid);
    }
}
