package com.example.demo.service;

import com.example.demo.dto.MainChainTraceDto;
import com.example.demo.dto.SubChainTraceDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface RealTimeTraceabilityService {
    /**
     * @return
     */
    List<String> getAllDirectChildComponentKey(String parentComponentKey);

    /**
     * @return
     */
    List<String> getDirectChildComponentKey(String parentComponentKey, String childComponentType);

    /**
     * @return
     */
    String getDirectParentComponentKey(String childComponentKey);

    /**
     * @return
     */
    Map<String, String> getIndirectChildComponentKey(String parentComponentKey, String childComponentType);

    /**
     * @return
     */
    Map<String, String> getIndirectParentComponentKey(String childComponentKey, String parentComponentType);

    /**
     * @return
     */
    MainChainTraceDto getMainChainTraceData(String parentComponentKey, String tokenId);

    /**
     * @return
     */
    SubChainTraceDto getSubChainTraceData(String childComponentKey, String tokenId);

}
