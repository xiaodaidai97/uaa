package com.hawker.shiro;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;


import com.hawker.config.ShiroConfig;
import com.hawker.model.Resources;
import com.hawker.model.UserRole;
import com.hawker.service.ResourcesService;
import com.hawker.service.UserRoleService;
import com.hawker.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cas.CasRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * Created by hdwang on 2017/6/20.
 * 安全数据源
 */
public class MyShiroRealm extends CasRealm{

    private static final Logger logger = LoggerFactory.getLogger(MyShiroRealm.class);

    @Resource
    private ResourcesService resourcesService;

    @Resource
    private UserRoleService userRoleService;

    @PostConstruct
    public void initProperty(){
//      setDefaultRoles("ROLE_USER");
        setCasServerUrlPrefix(ShiroConfig.casServerUrlPrefix);
        // 客户端回调地址
        setCasService(ShiroConfig.shiroServerUrlPrefix + ShiroConfig.casFilterUrlPattern);
    }

//    /**
//     * 1、CAS认证 ,验证用户身份
//     * 2、将用户基本信息设置到会话中(不用了，随时可以获取的)
//     */
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) {
//
//        AuthenticationInfo authc = super.doGetAuthenticationInfo(token);
//
//        String account = (String) authc.getPrincipals().getPrimaryPrincipal();
//
//        User user = userDao.getByName(account);
//        //将用户信息存入session中
//        SecurityUtils.getSubject().getSession().setAttribute("user", user);
//
//        return authc;
//    }

    /**
     * 权限认证，为当前登录的Subject授予角色和权限
     * @see ：本例中该方法的调用时机为需授权资源被访问时
     * @see ：并且每次访问需授权资源时都会执行该方法中的逻辑，这表明本例中默认并未启用AuthorizationCache
     * @see ：如果连续访问同一个URL（比如刷新），该方法不会被重复调用，Shiro有一个时间间隔（也就是cache时间，在ehcache-shiro.xml中配置），超过这个时间间隔再刷新页面，该方法会被执行
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username=(String)principalCollection.getPrimaryPrincipal();
        //每个用户进来都赋予admin角色，即权限中心都菜单都可见
        UserRole userRole = new UserRole();
        userRole.setUserId(username);
        userRole.setRoleId("1");
        userRoleService.addUserRole(userRole);

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("userid",username);
        List<Resources> resourcesList = resourcesService.loadUserResources(map);
        // 权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        for(Resources resources: resourcesList){
            info.addStringPermission(resources.getResurl());
        }
        return info;

    }

}