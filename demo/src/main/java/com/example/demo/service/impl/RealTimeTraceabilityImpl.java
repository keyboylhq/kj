package com.example.demo.service.impl;

import com.example.demo.dto.MainChainDto;
import com.example.demo.dto.MainChainTraceDto;
import com.example.demo.dto.SubChainTraceDto;
import com.example.demo.service.IdentityGenerationService;
import com.example.demo.service.RealTimeTraceabilityService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class RealTimeTraceabilityImpl implements RealTimeTraceabilityService {
    
    @Autowired
    IdentityGenerationService identityGenerationService;

    @Override
    public List<String> generateKey(String mainKey) {
        MainChainTraceDto mainChainTraceData = getMainChainTraceData(mainKey);
        List<String> directSubKeyList = null;
        if (mainChainTraceData.getTokenId().equals(mainKey)) {
            for (int i = 0; i < mainChainTraceData.getIndex().size(); i++) {
                for (Map.Entry<String, String> entry : mainChainTraceData.getIndex().get(i).entrySet()) {
                        directSubKeyList.add(entry.getValue());
                }
            }
        }
        return directSubKeyList;
    }

    @Override
    public MainChainTraceDto getMainChainTraceData(String tokenId) {
        return new MainChainTraceDto();
    }

    @Override
    public SubChainTraceDto getSubChainTraceData(String tokenId) {
        return new SubChainTraceDto();
    }
}
