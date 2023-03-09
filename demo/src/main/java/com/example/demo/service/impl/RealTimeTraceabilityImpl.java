package com.example.demo.service.impl;

import com.example.demo.dto.MainChainTraceDto;
import com.example.demo.dto.SubChainTraceDto;
import com.example.demo.service.RealTimeTraceabilityService;

import java.util.List;
import java.util.Map;

public class RealTimeTraceabilityImpl implements RealTimeTraceabilityService {

    @Override
    public List<String> getAllDirectChildComponentKey(String parentKey) {
        MainChainTraceDto mainChainTraceData = getMainChainTraceData(parentKey,null);
        List<String> allDirectSubKeyList = null;
        if (mainChainTraceData.getTokenId().equals(parentKey)) {
            for (int i = 0; i < mainChainTraceData.getIndex().size(); i++) {
                for (Map.Entry<String, String> entry : mainChainTraceData.getIndex().get(i).entrySet()) {
                    allDirectSubKeyList.add(entry.getValue());
                }
            }
        }
        return allDirectSubKeyList;
    }

    @Override
    public List<String> getDirectChildComponentKey(String parentKey, String type) {
        MainChainTraceDto mainChainTraceData = getMainChainTraceData(parentKey,null);
        List<String> directSubKeyList = null;
        if (mainChainTraceData.getTokenId().equals(parentKey)) {
            for (int i = 0; i < mainChainTraceData.getIndex().size(); i++) {
                for (Map.Entry<String, String> entry : mainChainTraceData.getIndex().get(i).entrySet()) {
                    if (entry.getKey().equals(type)) {
                        directSubKeyList.add(entry.getValue());
                    }
                }
            }
        }
        return directSubKeyList;
    }

    @Override
    public String getDirectParentComponentKey(String childKey, String tokenId) {
        MainChainTraceDto mainChainTraceData = getMainChainTraceData(null, tokenId);
        String parentComponentKey = null;
        for (int i = 0; i < mainChainTraceData.getIndex().size(); i++) {
            for (Map.Entry<String, String> entry : mainChainTraceData.getIndex().get(i).entrySet()) {
                if (entry.getValue().contains(childKey)) {
                    parentComponentKey = mainChainTraceData.getParentKey();
                }
            }
        }
        return parentComponentKey;
    }

    @Override
    public MainChainTraceDto getMainChainTraceData(String parentKey, String tokenId) {
        return new MainChainTraceDto();
    }

    @Override
    public SubChainTraceDto getSubChainTraceData(String childKey, String tokenId) {
        return new SubChainTraceDto();
    }
}
