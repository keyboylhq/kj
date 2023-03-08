package com.example.demo.service.impl;

import com.example.demo.dto.MainChainDto;
import com.example.demo.dto.SubChainDto;
import com.example.demo.service.IdentityGenerationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class IdentityGenerationImpl implements IdentityGenerationService {
    @Override
    public List<String> getUrl(String identifier, String subChainId) {
        // 获取主链子链数据
        MainChainDto mainChainDto = getMainChainData(identifier, null);
        SubChainDto subChainDto = getSubChainData(subChainId, null);
        // 查找url
        List<String> url = null;
        if (mainChainDto.getParts().containsValue(subChainId) && subChainDto.getKey().equals(subChainId)) {
            for (int i = 0; i < subChainDto.getResource().size(); i++) {
                url = subChainDto.getResource().get(i).getUrl();
            }
        }
        return url;
    }

    @Override
    public String getIdentifier(String owner, String code) {
        // 获取主链数据
        SubChainDto subChainDto = getSubChainData(null, owner);
        if (!subChainDto.getCode().equals(code)) {
            return null;
        }
        return subChainDto.getKey();
    }

    @Override
    public MainChainDto getMainChainData(String mainChainId, String owner) {
        return new MainChainDto();
    }

    @Override
    public SubChainDto getSubChainData(String subChainId, String owner) {
        return new SubChainDto();
    }
}
