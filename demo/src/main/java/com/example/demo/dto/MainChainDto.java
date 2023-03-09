package com.example.demo.dto;

import java.util.List;
import java.util.Map;

// 区块链主链
public class MainChainDto {
    private String key;

    private String description;

    private Integer time;

    private String owner;

    private Map<String, List<String>> parts;

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

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
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

    @Override
    public String toString() {
        return "MainChainDto{" +
                "key='" + key + '\'' +
                ", description='" + description + '\'' +
                ", time=" + time +
                ", owner='" + owner + '\'' +
                ", parts=" + parts +
                '}';
    }
}
