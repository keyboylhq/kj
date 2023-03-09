package com.example.demo.service;

import com.example.demo.dto.MainChainTraceDto;
import com.example.demo.dto.SubChainTraceDto;

import java.util.List;

public interface RealTimeTraceabilityService {
    /**
     * @return
     */
    List<String> getAllDirectChildComponentKey(String parentKey);

    /**
     * @return
     */
    List<String> getDirectChildComponentKey(String parentKey, String type);

    /**
     * @return
     */
    String getDirectParentComponentKey(String childKey);

    /**
     * @return
     */
    MainChainTraceDto getMainChainTraceData(String tokenId);

    /**
     * @return
     */
    SubChainTraceDto getSubChainTraceData(String tokenId);


}
