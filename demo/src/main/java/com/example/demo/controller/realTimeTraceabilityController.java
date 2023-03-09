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
     * 获取所有直接子键key
     * @return
     */
    @GetMapping("/getAllDirectSubChainKey")
    public List<String> getAllDirectSubChainKey(String mainKey) {
        return realTimeTraceabilityService.generateKey(mainKey);
    }

    /**
     * 通过追溯凭证tokenId请求主链追溯凭证
     * @return
     */
    @GetMapping("/getMainChainTraceData")
    public MainChainTraceDto getMainChainData(String tokenId) {
        return realTimeTraceabilityService.getMainChainTraceData(tokenId);
    }

    /**
     * 通过追溯凭证tokenId请求子链追溯凭证
     * @return
     */
    @GetMapping("/getSubChainTraceData")
    public SubChainTraceDto getSubChainData(String tokenId) {
        return realTimeTraceabilityService.getSubChainTraceData(tokenId);
    }
}
