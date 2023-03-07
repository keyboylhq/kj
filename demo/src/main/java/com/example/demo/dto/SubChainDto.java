package com.example.demo.dto;

import java.util.List;

// 区块链子链
public class SubChainDto {
    // code对应的哈希值
    private String key;
    // code字段编码
    private String code;
    // unix时间戳
    private int time;
    // 标识记录所有者
    private String owner;
    // 数据说明
    private String description;
    // 记录对应的链下文件资源信息
    private List<Resource> resource;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Resource> getResource() {
        return resource;
    }

    public void setResource(List<Resource> resource) {
        this.resource = resource;
    }

    @Override
    public String toString() {
        return "SubChainDto{" +
                "key='" + key + '\'' +
                ", code='" + code + '\'' +
                ", time=" + time +
                ", owner='" + owner + '\'' +
                ", description='" + description + '\'' +
                ", resource=" + resource +
                '}';
    }
}
