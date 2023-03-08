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

    /**
     * 获得url
     * @return
     */
    @GetMapping("/getUrl")
    public List<String> getUrl(String identifier, String subChainId) {
        return identityGenerationService.getUrl(identifier, subChainId);
    }

    /**
     * 获得数据标识
     * @return
     */
    @GetMapping("/getIdentify")
    public String getIdentifier(String owner, String code) {
        return identityGenerationService.getIdentifier(owner, code);
    }

    /**
     * 通过主链ID或标识所有者请求主链数据
     * @return
     */
    @GetMapping("/MainChainData")
    public MainChainDto getMainChainData(String mainChainId, String owner) {
        return identityGenerationService.getMainChainData(mainChainId, owner);
    }

    /**
     * 通过子链ID或标识所有者请求子链数据
     * @return
     */
    @GetMapping("/SubChainData")
    public SubChainDto getSubChainData(String subChainId, String owner) {
        return identityGenerationService.getSubChainData(subChainId, owner);
    }
}
