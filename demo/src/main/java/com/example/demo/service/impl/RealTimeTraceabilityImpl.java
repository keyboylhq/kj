package com.example.demo.service.impl;

import com.example.demo.dto.MainChainTraceDto;
import com.example.demo.dto.SubChainTraceDto;
import com.example.demo.service.RealTimeTraceabilityService;

import java.util.List;
import java.util.Map;

public class RealTimeTraceabilityImpl implements RealTimeTraceabilityService {

    @Override
    public List<String> getAllDirectChildComponentKey(String parentComponentKey) {
        MainChainTraceDto mainChainTraceData = getMainChainTraceData(parentComponentKey,null);
        List<String> allDirectSubComponentKeyList = null;
        if (mainChainTraceData.getTokenId().equals(parentComponentKey)) {
            for (int i = 0; i < mainChainTraceData.getIndex().size(); i++) {
                for (Map.Entry<String, String> entry : mainChainTraceData.getIndex().get(i).entrySet()) {
                    allDirectSubComponentKeyList.add(entry.getValue());
                }
            }
        }
        return allDirectSubComponentKeyList;
    }

    @Override
    public List<String> getDirectChildComponentKey(String parentComponentKey, String type) {
        MainChainTraceDto mainChainTraceData = getMainChainTraceData(parentComponentKey,null);
        List<String> directSubComponentKeyList = null;
        if (mainChainTraceData.getTokenId().equals(parentComponentKey)) {
            for (int i = 0; i < mainChainTraceData.getIndex().size(); i++) {
                for (Map.Entry<String, String> entry : mainChainTraceData.getIndex().get(i).entrySet()) {
                    if (entry.getKey().equals(type)) {
                        directSubComponentKeyList.add(entry.getValue());
                    }
                }
            }
        }
        return directSubComponentKeyList;
    }

    @Override
    public String getDirectParentComponentKey(String childComponentKey, String tokenId) {
        MainChainTraceDto mainChainTraceData = getMainChainTraceData(null, tokenId);
        String directParentComponentKey = null;
        for (int i = 0; i < mainChainTraceData.getIndex().size(); i++) {
            for (Map.Entry<String, String> entry : mainChainTraceData.getIndex().get(i).entrySet()) {
                if (entry.getValue().contains(childComponentKey)) {
                    directParentComponentKey = mainChainTraceData.getParentKey();
                }
            }
        }
        return directParentComponentKey;
    }

    @Override
    public MainChainTraceDto getMainChainTraceData(String parentComponentKey, String tokenId) {
        return new MainChainTraceDto();
    }

    @Override
    public SubChainTraceDto getSubChainTraceData(String childComponentKey, String tokenId) {
        return new SubChainTraceDto();
    }
}
