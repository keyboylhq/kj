package com.example.demo.service.impl;

import com.example.demo.dto.MainChainDto;
import com.example.demo.dto.SubChainDto;
import com.example.demo.service.IdentityGenerationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class IdentityGenerationImpl implements IdentityGenerationService {
    @Autowired
    IdentityGenerationService identityGenerationService;

    @Override
    public List<String> GetUrl(String identifier, String subChainId) {
        // 获取主链子链数据
        MainChainDto mainChainDto = identityGenerationService.GetMainChainData(subChainId);
        SubChainDto subChainDto = identityGenerationService.GetSubChainData(subChainId);
        // 查找url
        List<String> url = null;
        if (mainChainDto.getKey().equals(identifier) && subChainDto.getKey().equals(subChainId)) {
            for (int i = 0; i < subChainDto.getResource().size(); i++) {
                url = subChainDto.getResource().get(i).getUrl();
            }
        }
        return url;
    }

    @Override
    public MainChainDto GetMainChainData(String subChainId) {
        MainChainDto mainChainDto = new MainChainDto();
        return mainChainDto;
    }

    @Override
    public SubChainDto GetSubChainData(String subChainId) {
        SubChainDto subChainDto = new SubChainDto();
        return subChainDto;
    }
}
