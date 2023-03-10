package com.example.demo.service;

import com.example.demo.dto.MainChainTraceDto;
import com.example.demo.dto.SubChainTraceDto;

import java.util.List;
import java.util.Map;

public interface RealTimeTraceabilityService {
    /**
     * @return
     */
    List<String> getAllDirectChildComponentKey(String parentComponentKey);

    /**
     * @return
     */
    List<String> getDirectChildComponentKey(String parentComponentKey, String type);

    /**
     * @return
     */
    String getDirectParentComponentKey(String childComponentKey, String tokenId);

    /**
     * @return
     */
    Map<String, String> getIndirectChildComponentKey(String parentComponentKey, String type);

    /**
     * @return
     */
    MainChainTraceDto getMainChainTraceData(String parentComponentKey, String tokenId);

    /**
     * @return
     */
    SubChainTraceDto getSubChainTraceData(String childComponentKey, String tokenId);

}
