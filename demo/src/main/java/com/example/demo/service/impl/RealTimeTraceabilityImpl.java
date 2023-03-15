package com.example.demo.service.impl;

import com.example.demo.dto.MainChainDto;
import com.example.demo.dto.MainChainTraceDto;
import com.example.demo.dto.SubChainTraceDto;
import com.example.demo.service.RealTimeTraceabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;


@Service
public class RealTimeTraceabilityImpl implements RealTimeTraceabilityService {

    @Autowired
    IdentityGenerationImpl identityGeneration;

    @Override
    public List<String> getAllDirectChildComponentKey(String parentComponentKey) {
        MainChainDto mainChainData = identityGeneration.getMainChainData(parentComponentKey);
        List<String> allDirectSubComponentKeyList = new ArrayList<>();
            for (int i = 0; i < mainChainData.getParts().size(); i++) {
                for (Map.Entry<String, List<String>> entry : mainChainData.getParts().entrySet()) {
                    Objects.requireNonNull(allDirectSubComponentKeyList).addAll(entry.getValue());
                }
            }
        return allDirectSubComponentKeyList;
    }

    @Override
    public List<String> getDirectChildComponentKey(String parentComponentKey, String childComponentType) {
        MainChainDto mainChainData = identityGeneration.getMainChainData(parentComponentKey);
        List<String> DirectSubComponentKeyList = new ArrayList<>();
            for (int i = 0; i < mainChainData.getParts().size(); i++) {
                for (Map.Entry<String, List<String>> entry : mainChainData.getParts().entrySet()) {
                    for (String value : entry.getValue()) {
                        if (value.equals(childComponentType)) {
                            DirectSubComponentKeyList.add(value);
                        }
                    }
                }
            }
        return DirectSubComponentKeyList;
    }

    @Override
    public String getDirectParentComponentKey(String childComponentKey) {
        MainChainTraceDto mainChainTraceData = getMainChainTraceData(null,null);
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
    public List<String> getIndirectChildComponentKey(String parentComponentKey, String childComponentType) {
        MainChainDto mainChainData = identityGeneration.getMainChainData(parentComponentKey);
        List<String> DirectSubComponentKeyList = new ArrayList<>();
        List<String> IndirectSubComponentKeyList = new ArrayList<>();
        for (int i = 0; i < mainChainData.getParts().size(); i++) {
            for (Map.Entry<String, List<String>> entry : mainChainData.getParts().entrySet()) {
                for (String value : entry.getValue()) {
                    if (value.equals(childComponentType)) {
                        DirectSubComponentKeyList.add(value);
                    }
                }
            }
        }
        for (String key : DirectSubComponentKeyList) {
            MainChainDto subComponentMainChainData = identityGeneration.getMainChainData(key);
            for (int i = 0; i < subComponentMainChainData.getParts().size(); i++) {
                for (Map.Entry<String, List<String>> entry : subComponentMainChainData.getParts().entrySet()) {
                    for (String value : entry.getValue()) {
                        if (value.equals(childComponentType)) {
                            IndirectSubComponentKeyList.add(value);
                        }
                    }
                }
            }
        }
        return IndirectSubComponentKeyList;
    }

    @Override
    public Map<String, String> getIndirectParentComponentKey(String childComponentKey, String parentComponentType) {
        return null;
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
