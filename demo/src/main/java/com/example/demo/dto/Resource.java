package com.example.demo.dto;

import java.util.Collections;
import java.util.List;

// 区块链子链下的Resource
public class Resource {
    // 单条链下的资源记录的类别
    private String type;

    // 单条链下记录对应的资源存储地址
    private String url;

    // 数据说明
    private String description;

    // 单条链下资源的哈希值
    private String digest;

    // 监管者字段，用于标识拥有操作权限的监管者
    private String supervisor;

    // 监管规则信息
    private String superviseRule;

    // 追溯规则信息
    private String traceRule;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getUrl() {
        return Collections.singletonList(url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public String getSuperviseRule() {
        return superviseRule;
    }

    public void setSuperviseRule(String superviseRule) {
        this.superviseRule = superviseRule;
    }

    public String getTraceRule() {
        return traceRule;
    }

    public void setTraceRule(String traceRule) {
        this.traceRule = traceRule;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "type='" + type + '\'' +
                ", url='" + url + '\'' +
                ", description='" + description + '\'' +
                ", digest='" + digest + '\'' +
                ", supervisor='" + supervisor + '\'' +
                ", superviseRule='" + superviseRule + '\'' +
                ", traceRule='" + traceRule + '\'' +
                '}';
    }
}
