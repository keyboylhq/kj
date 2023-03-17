package com.example.demo.controller;

import com.example.demo.service.RealTimeTraceabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/realTimeTraceability")
public class realTimeTraceabilityController {

    @Autowired
    RealTimeTraceabilityService realTimeTraceabilityService;

    /**
     * 获取所有直接子件key
     * @return
     */
    @GetMapping("/getAllDirectSubComponentKey")
    public List<String> getAllDirectChildComponentKey(String parentComponentKey) {
        return realTimeTraceabilityService.getAllDirectChildComponentKey(parentComponentKey);
    }

    /**
     * 获取直接子件key
     * @return
     */
    @GetMapping("/getDirectSubComponentKey")
    public List<String> getDirectChildComponentKey(String parentComponentKey, String childComponentType) {
        return realTimeTraceabilityService.getDirectChildComponentKey(parentComponentKey, childComponentType);
    }

    /**
     * 获取直接母件key
     * @return
     */
    @GetMapping("/getDirectParentComponentKey")
    public List<String> getDirectParentComponentKey(String childComponentKey) {
        return realTimeTraceabilityService.getDirectParentComponentKey(childComponentKey);
    }

    /**
     * 获取间接子件Key
     * @return
     */
    @GetMapping("/getIndirectChildComponentKey")
    public List<String> getIndirectChildComponentKey(String parentComponentKey, String childComponentType) {
        return realTimeTraceabilityService.getIndirectChildComponentKey(parentComponentKey, childComponentType);
    }

    /**
     * 获取间接母件Key
     * @return
     */
    @GetMapping("/getIndirectParentComponentKey")
    public List<String> getIndirectParentComponentKey(String childComponentKey, String parentComponentType) {
        return realTimeTraceabilityService.getIndirectParentComponentKey(childComponentKey, parentComponentType);
    }

    /**
     * 获取Owner某时间段同种产品品类的Key集合
     * @return
     */
    @GetMapping("/getKey")
    public List<String> getKeyList(String owner, String parentComponentType, String startTime, String endTime) {
        return realTimeTraceabilityService.getKeyList(owner, parentComponentType, startTime, endTime);
    }
}
