package com.example.demo.controller;

import com.example.demo.dto.MainChainDto;
import com.example.demo.dto.SubChainDto;
import com.example.demo.service.IdentityGenerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@RequestMapping("identityGeneration")
public class identityGenerationController {
    @Autowired
    IdentityGenerationService identityGenerationService;
    // 接收前端数据标识，解析出结构化数据

    /**
     * 查找url
     * @return
     */
    @GetMapping("/parseIdentifier")
    public List<String> parseIdentifier(String identifier, String subChainId) {
        return identityGenerationService.GetUrl(identifier, subChainId);
    }

    /**
     * 请求主链数据
     * @return
     */
    @GetMapping("/MainChainData")
    public MainChainDto getMainChainData(String subChainId) {
        return identityGenerationService.GetMainChainData(subChainId);
    }

    /**
     * 请求子链数据
     * @return
     */
    @GetMapping("/SubChainData")
    public SubChainDto getSubChainData(String subChainId) {
        return identityGenerationService.GetSubChainData(subChainId);
    }
}
