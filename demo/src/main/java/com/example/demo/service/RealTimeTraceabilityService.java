package com.example.demo.service;

import java.util.List;

public interface RealTimeTraceabilityService {
    /**
     * @return
     */
    List<String> generateKey(String mainKey);
}
