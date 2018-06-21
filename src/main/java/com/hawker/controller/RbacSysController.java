package com.hawker.controller;

import com.github.pagehelper.PageInfo;
import com.hawker.model.RbacSys;
import com.hawker.model.Resources;
import com.hawker.service.RbacSysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/rbacsys")
public class RbacSysController {

    @Autowired
    RbacSysService service;
    @RequestMapping
    public Map<String,Object> getAll(RbacSys RbacSys, String draw,
                                     @RequestParam(required = false, defaultValue = "1") int start,
                                     @RequestParam(required = false, defaultValue = "10") int length){
        Map<String,Object> map = new HashMap<>();
        PageInfo<RbacSys> pageInfo = service.selectByPage(RbacSys, start, length);
        System.out.println("pageInfo.getTotal():"+pageInfo.getTotal());
        map.put("draw",draw);
        map.put("recordsTotal",pageInfo.getTotal());
        map.put("recordsFiltered",pageInfo.getTotal());
        map.put("data", pageInfo.getList());
        return map;
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String insert(RbacSys sys){
        if(service.insert(sys)>0)return "success";
        return "failed";
    }

}
