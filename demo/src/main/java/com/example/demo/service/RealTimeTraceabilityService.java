package com.example.demo.service;

import com.example.demo.dto.MainChainTraceDto;
import com.example.demo.dto.SubChainTraceDto;

import java.util.List;

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
    MainChainTraceDto getMainChainTraceData(String parentComponentKey, String tokenId);

    /**
     * @return
     */
    SubChainTraceDto getSubChainTraceData(String childComponentKey, String tokenId);


}
