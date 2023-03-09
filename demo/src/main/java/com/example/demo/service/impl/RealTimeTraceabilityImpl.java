package com.example.demo.service.impl;

import com.example.demo.service.RealTimeTraceabilityService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RealTimeTraceabilityImpl implements RealTimeTraceabilityService {

    @Override
    public List<String> generateKey(String mainKey) {
        return null;
    }
}
