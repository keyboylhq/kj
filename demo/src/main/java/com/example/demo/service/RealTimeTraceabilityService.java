package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Map;

@Service
public interface RealTimeTraceabilityService {
    /**
     * @return
     */
    Map<String, Object> getAllDirectChildComponentKey(String parentComponentKey) throws UnsupportedEncodingException, MalformedURLException;

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
