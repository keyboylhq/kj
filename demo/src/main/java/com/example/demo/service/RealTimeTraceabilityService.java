package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.List;

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
    List<String> getDirectParentComponentKey(String childComponentKey);

    /**
     * @return
     */
    List<String> getIndirectChildComponentKey(String parentComponentKey, String childComponentType);

    /**
     * @return
     */
    List<String> getIndirectParentComponentKey(String childComponentKey, String parentComponentType);

    /**
     * @return
     */
    List<String> getKeyList(String owner, String parentComponentType, String startTime, String endTime);
}
