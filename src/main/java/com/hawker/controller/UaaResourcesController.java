package com.hawker.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hawker.entity.UaaResources;
import com.hawker.entity.dataobject.JsonResult;
import com.hawker.entity.dataobject.UaaResMenu;
import com.hawker.service.UaaResourcesService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by yylc
 *
 * @author zmf
 * @date 2018/6/14 AND 17:16
 */
@RestController
@RequestMapping("/resources")
@CrossOrigin
public class UaaResourcesController {

    private static final Logger LOGGER = Logger.getLogger(UaaResourcesController.class);

    @Autowired
    private UaaResourcesService uaaResourcesService;

    @RequestMapping(value = "/saveOneResources", method = RequestMethod.POST)
    public ResponseEntity<JsonResult> saveOneResources(@RequestBody UaaResources uaaResources){
        LOGGER.info("添加资源（权限）：saveOneResources开始...");
        JsonResult jsonResult= new JsonResult();
        if(uaaResourcesService.addOneResources(uaaResources)>0){
            jsonResult.setCode("0");
            jsonResult.setRows(1);
        }
        return ResponseEntity.ok(jsonResult);
    }

    @RequestMapping(value = "/showAllResources", method = RequestMethod.POST)
    public JsonResult showAllResources(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize, @RequestBody UaaResources uaaResources){
        LOGGER.info("查询所有的资源（权限）：showAllResources开始...");
        JsonResult jsonResult= new JsonResult();
        PageHelper.startPage(pageNum,pageSize);

        List<UaaResources> allResources = uaaResourcesService.findAllResources(uaaResources);

        //分页后，实际返回的结果list类型是Page<E>，如果想取出分页信息，需要强制转换为Page<E>，
        Page<UaaResources> page = (Page<UaaResources>)allResources;

        jsonResult.setCode("0");
        jsonResult.setRows((int)page.getTotal());
        jsonResult.setData(page);
        return jsonResult;
    }

    @RequestMapping(value = "/menu", method = RequestMethod.POST)
    public JsonResult showResourcesForMenu(@RequestBody UaaResMenu uaaResMenu){
        LOGGER.info("显示资源树：showResourcesForMenu开始...");
        JsonResult jsonResult= new JsonResult();

        List<UaaResMenu> resourcestTree = uaaResourcesService.findResourcestTree(uaaResMenu);

        jsonResult.setCode("0");
        jsonResult.setData(resourcestTree);
        return jsonResult;
    }

    @RequestMapping(value = "updateOneResources",method = RequestMethod.POST)
    public ResponseEntity<JsonResult> updateOneResources(@RequestBody UaaResources uaaResources){
        LOGGER.info("更新资源（权限）：updateOneResources开始...");
        JsonResult jsonResult= new JsonResult();
        if(uaaResourcesService.updateOneResourcesById(uaaResources)>0){
            jsonResult.setCode("0");
            jsonResult.setRows(1);
        }
        return ResponseEntity.ok(jsonResult);
    }

    @RequestMapping(value = "showOneResourcesById",method = RequestMethod.POST)
    public JsonResult showOneResourcesById(@RequestBody UaaResources uaaResources){
        LOGGER.info("查询单个资源（权限）：showOneResourcesById开始...");
        JsonResult jsonResult= new JsonResult();
        UaaResources oneResourcesById = uaaResourcesService.findOneResourcesById(uaaResources);
        jsonResult.setData(oneResourcesById);
        jsonResult.setCode("0");
        jsonResult.setRows(1);

        return jsonResult;
    }
}
