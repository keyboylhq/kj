package com.example.demo.controller;

import com.example.demo.dto.MainChainTraceDto;
import com.example.demo.dto.SubChainTraceDto;
import com.example.demo.service.RealTimeTraceabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

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
    public List<String> getDirectChildComponentKey(String parentComponentKey, String type) {
        return realTimeTraceabilityService.getDirectChildComponentKey(parentComponentKey, type);
    }

    /**
     * 获取直接母件key
     * @return
     */
    @GetMapping("/getDirectParentComponentKey")
    public String getDirectParentComponentKey(String childComponentKey, String tokenId) {
        return realTimeTraceabilityService.getDirectParentComponentKey(childComponentKey, tokenId);
    }

    /**
     * 获取间接子件Key
     * @return
     */
    @GetMapping("/getIndirectChildComponentKey")
    public Map<String, String> getIndirectChildComponentKey(String parentComponentKey, String type) {
        return realTimeTraceabilityService.getIndirectChildComponentKey(parentComponentKey, type);
    }

    /**
     * 通过追溯凭证tokenId请求主链追溯凭证
     * @return
     */
    @GetMapping("/getMainChainTraceData")
    public MainChainTraceDto getMainChainTraceData(String parentComponentKey, String tokenId) {
        return realTimeTraceabilityService.getMainChainTraceData(parentComponentKey, tokenId);
    }

    /**
     * 通过追溯凭证tokenId请求子链追溯凭证
     * @return
     */
    @GetMapping("/getSubChainTraceData")
    public SubChainTraceDto getSubChainTraceData(String childComponentKey, String tokenId) {
        return realTimeTraceabilityService.getSubChainTraceData(childComponentKey, tokenId);
    }
}
