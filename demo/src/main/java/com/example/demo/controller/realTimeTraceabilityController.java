package com.example.demo.controller;

import com.example.demo.service.RealTimeTraceabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.NoSuchAlgorithmException;
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
}
