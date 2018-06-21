package com.hawker.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hawker.entity.UaaRole;
import com.hawker.entity.UaaRoleResources;
import com.hawker.entity.dataobject.JsonResult;
import com.hawker.service.UaaRoleService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by yylc
 *
 * @author zmf
 * @date 2018/6/15 AND 14:26
 */
@RestController
@RequestMapping("/role")
@CrossOrigin
public class UaaRoleController {

    private static final Logger LOGGER = Logger.getLogger(UaaResourcesController.class);

    @Autowired
    private UaaRoleService uaaRoleService;

    @RequestMapping(value = "/insertOneRole", method = RequestMethod.POST)
    public ResponseEntity<JsonResult> insertOneRole(@RequestBody UaaRole uaaRole){
        LOGGER.info("添加角色：insertOneRole开始...");
        JsonResult jsonResult= new JsonResult();
        if(uaaRoleService.addOneRole(uaaRole)>0){
            jsonResult.setCode("0");
            jsonResult.setRows(1);
        }
        return ResponseEntity.ok(jsonResult);
    }

    @RequestMapping(value = "/showAllRoles", method = RequestMethod.POST)
    public JsonResult showAllRoles(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize, @RequestBody UaaRole uaaRole){
        LOGGER.info("查询所有的角色：showAllRoles开始...");
        JsonResult jsonResult= new JsonResult();
        PageHelper.startPage(pageNum,pageSize);

        List<UaaRole> allRoles = uaaRoleService.findAllRolesBySystem(uaaRole);

        //分页后，实际返回的结果list类型是Page<E>，如果想取出分页信息，需要强制转换为Page<E>，
        Page<UaaRole> page = (Page<UaaRole>)allRoles;

        jsonResult.setCode("0");
        jsonResult.setRows((int)page.getTotal());
        jsonResult.setData(page);
        return jsonResult;
    }

    @RequestMapping(value = "/addResourcesForRole", method = RequestMethod.POST)
    public ResponseEntity<JsonResult> addResourcesForRole(@RequestBody List<UaaRoleResources> uaaRoleResources){
        LOGGER.info("为角色添加资源（权限）：addResourcesForRole开始...");
        JsonResult jsonResult= new JsonResult();
        // TODO: 2018/6/15 为角色添加资源（权限）时传入的参数形式
        if(uaaRoleService.addResourcesForRole(uaaRoleResources)>0){
            jsonResult.setCode("0");
            jsonResult.setRows(1);
        }
        return ResponseEntity.ok(jsonResult);
    }
}
