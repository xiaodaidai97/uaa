package com.hawker.service;

import com.github.pagehelper.PageInfo;
import com.hawker.entity.UaaResources;
import com.hawker.model.Resources;

import java.util.List;
import java.util.Map;

/**
 * Created by yangqj on 2017/4/25.
 */
public interface ResourcesService extends IService<Resources> {
    PageInfo<Resources> selectByPage(Resources resources, int start, int length);

    public List<UaaResources> queryAll();

    public List<Resources> loadUserResources(Map<String, Object> map);

    public List<Resources> queryResourcesListWithSelected(Integer rid);
}
