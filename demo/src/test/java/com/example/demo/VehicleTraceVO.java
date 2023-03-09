package com.example.demo;

import java.util.List;
import java.util.Map;

/**
 * 1.4	主链数据模型示例
 * */

public class VehicleTraceVO {
    private String key;
    private String description;
    private Long time;
    private String owner;
    private Map<String, List<String>> parts;

    // 构造方法
    public VehicleTraceVO() {}

    public VehicleTraceVO(String key, String description, Long time, String owner, Map<String, List<String>> parts) {
        this.key = key;
        this.description = description;
        this.time = time;
        this.owner = owner;
        this.parts = parts;
    }

    // Getter和Setter方法
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Map<String, List<String>> getParts() {
        return parts;
    }

    public void setParts(Map<String, List<String>> parts) {
        this.parts = parts;
    }
}
