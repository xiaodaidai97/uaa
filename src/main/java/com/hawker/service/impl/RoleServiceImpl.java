package com.hawker.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hawker.mapper.RoleMapper;
import com.hawker.mapper.RoleResourcesMapper;
import com.hawker.model.Role;
import com.hawker.model.RoleResources;
import com.hawker.service.RoleService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service("roleService")
public class RoleServiceImpl extends BaseService<Role> implements RoleService{

    @Resource
    private RoleMapper roleMapper;
    @Resource
    private RoleResourcesMapper roleResourcesMapper;

    @Override
    public List<Role> queryRoleListWithSelected(Integer uid) {
        return roleMapper.queryRoleListWithSelected(uid);
    }

    @Override
    public PageInfo<Role> selectByPage(Role role, int start, int length) {
        int page = start/length+1;
        Example example = new Example(Role.class);
        //分页查询
        PageHelper.startPage(page, length);
        if(StringUtils.isNotBlank(role.getName())){
            example.createCriteria().andLike("name",role.getName());
        }
        if(StringUtils.isNotBlank(role.getType())){
            example.createCriteria().andEqualTo("type",role.getType());
        }
        if(StringUtils.isNotBlank(role.getSysId())){
            example.createCriteria().andEqualTo("sysId",role.getSysId());
        }
        List<Role> rolesList = selectByExample(example);

        return new PageInfo<>(rolesList);
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false,rollbackFor={Exception.class})
    public void delRole(Integer roleid) {
        //删除角色
        mapper.deleteByPrimaryKey(roleid);
        //删除角色资源
        Example example = new Example(RoleResources.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("roleId",roleid);
        roleResourcesMapper.deleteByExample(example);

    }
}
