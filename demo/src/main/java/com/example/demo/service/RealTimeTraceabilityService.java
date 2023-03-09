package com.example.demo.service;

import com.example.demo.dto.MainChainTraceDto;
import com.example.demo.dto.SubChainTraceDto;

import java.util.List;

public interface RealTimeTraceabilityService {
    /**
     * @return
     */
    List<String> generateKey(String mainKey);

    /**
     * @return
     */
    MainChainTraceDto getMainChainTraceData(String tokenId);

    /**
     * @return
     */
    SubChainTraceDto getSubChainTraceData(String tokenId);
}
