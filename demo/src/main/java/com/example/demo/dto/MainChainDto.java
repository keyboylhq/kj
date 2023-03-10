package com.example.demo.dto;

import java.util.List;
import java.util.Map;

// 区块链主链
public class MainChainDto {
    // 子链上Owner+Code字段对应的哈希
    private String key;

    // 数据说明
    private String description;

    // unix时间戳
    private Integer time;

    // 该条记录的所有者
    private String owner;

    // 该条数据存储在哪条子链上
    private String chainId;

    // 该记录的组成信息
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

    public String getChainId() {
        return chainId;
    }

    public void setChainId(String chainId) {
        this.chainId = chainId;
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
                ", chainId='" + chainId + '\'' +
                ", parts=" + parts +
                '}';
    }
}
