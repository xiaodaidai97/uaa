package com.hawker.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hawker.entity.UaaSystems;
import com.hawker.entity.dataobject.JsonResult;
import com.hawker.entity.dataobject.RequestParameter;
import com.hawker.service.UaaSystemsService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by yylc
 *
 * @author zmf
 * @date 2018/6/15 AND 10:11
 */
@RestController
@RequestMapping("/system")
@CrossOrigin
public class UaaSystemsController {

    private static final Logger LOGGER = Logger.getLogger(UaaSystemsController.class);

    @Autowired
    private UaaSystemsService uaaSystemsService;

    @RequestMapping(value = "/showAllSystemByUser", method = RequestMethod.POST)
    public JsonResult showAllSystemByUser(@RequestBody RequestParameter requestParameter){
        LOGGER.info("查询所有当前用户的系统：showAllSystemByUser开始...");
        JsonResult jsonResult= new JsonResult();
        System.out.println(requestParameter.getPageNum());
        System.out.println(requestParameter.getPageSize());
        PageHelper.startPage(requestParameter.getPageNum(),requestParameter.getPageSize());
        List<UaaSystems> allSystemByUser = uaaSystemsService.findAllSystemByUser(requestParameter);
        Page<UaaSystems> page = (Page<UaaSystems>)allSystemByUser;
        jsonResult.setCode("0");
        jsonResult.setRows((int)page.getTotal());
        jsonResult.setData(page);

        return jsonResult;
    }

    @RequestMapping(value = "insertOneSystem",method = RequestMethod.POST)
    public ResponseEntity<JsonResult> insertOneSystem(@RequestBody UaaSystems uaaSystems){
        LOGGER.info("添加系统：insertOneSystem开始...");
        JsonResult jsonResult= new JsonResult();
        if(uaaSystemsService.addOneSystem(uaaSystems)>0){
            jsonResult.setCode("0");
            jsonResult.setRows(1);
        }
        return ResponseEntity.ok(jsonResult);
    }

    @RequestMapping(value = "updateOneSystem",method = RequestMethod.POST)
    public ResponseEntity<JsonResult> updateOneSystem(@RequestBody UaaSystems uaaSystems){
        LOGGER.info("更新系统：updateOneSystem开始...");
        JsonResult jsonResult= new JsonResult();
        if(uaaSystemsService.updateOneSystemById(uaaSystems)>0){
            jsonResult.setCode("0");
            jsonResult.setRows(1);
        }
        return ResponseEntity.ok(jsonResult);
    }

    @RequestMapping(value = "showOneSystemById",method = RequestMethod.POST)
    public JsonResult showOneSystemById(@RequestBody UaaSystems uaaSystems){
        LOGGER.info("查询单个系统：showOneSystemById开始...");
        JsonResult jsonResult= new JsonResult();
        UaaSystems oneSystemById = uaaSystemsService.findOneSystemById(uaaSystems);
        jsonResult.setData(oneSystemById);
        jsonResult.setCode("0");
        jsonResult.setRows(1);

        return jsonResult;
    }
}
