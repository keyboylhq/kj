package com.example.demo.controller;

import com.example.demo.dto.MainChainTraceDto;
import com.example.demo.dto.SubChainTraceDto;
import com.example.demo.service.RealTimeTraceabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/realTimeTraceability")
public class realTimeTraceabilityController {

    @Autowired
    RealTimeTraceabilityService realTimeTraceabilityService;

    /**
     * 获取所有直接子件key
     * @return
     */
    @GetMapping("/getAllDirectSubComponentKey")
    public List<String> getAllDirectChildComponentKey(String parentKey) {
        return realTimeTraceabilityService.getAllDirectChildComponentKey(parentKey);
    }

    /**
     * 获取直接子件key
     * @return
     */
    @GetMapping("/getDirectSubComponentKey")
    public List<String> getDirectChildComponentKey(String parentKey, String type) {
        return realTimeTraceabilityService.getDirectChildComponentKey(parentKey, type);
    }

    /**
     * 获取直接母件key
     * @return
     */
    @GetMapping("/getDirectParentComponentKey")
    public String getDirectParentComponentKey(String childKey, String type) {
        return realTimeTraceabilityService.getDirectParentComponentKey(childKey);
    }

    /**
     * 通过追溯凭证tokenId请求主链追溯凭证
     * @return
     */
    @GetMapping("/getMainChainTraceData")
    public MainChainTraceDto getMainChainTraceData(String tokenId) {
        return realTimeTraceabilityService.getMainChainTraceData(tokenId);
    }

    /**
     * 通过追溯凭证tokenId请求子链追溯凭证
     * @return
     */
    @GetMapping("/getSubChainTraceData")
    public SubChainTraceDto getSubChainTraceData(String tokenId) {
        return realTimeTraceabilityService.getSubChainTraceData(tokenId);
    }
}
