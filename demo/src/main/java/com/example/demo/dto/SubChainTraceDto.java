package com.example.demo.dto;

import java.sql.Time;
import java.util.List;
import java.util.Map;

public class SubChainTraceDto {
    private String childKey;
    private String tokenId;

    private Time time;

    private String index;

    private String description;

    private Map<String, List<Map<String, String>>> attributes;

    private String url;

    private String digest;

    private String owner;

    private String supervisor;

    private String superviseRule;

    private String traceRule;

    public String getChildKey() {
        return childKey;
    }

    public void setChildKey(String childKey) {
        this.childKey = childKey;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<String, List<Map<String, String>>> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, List<Map<String, String>>> attributes) {
        this.attributes = attributes;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
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
        return "SubChainTraceDto{" +
                "childKey='" + childKey + '\'' +
                ", tokenId='" + tokenId + '\'' +
                ", time=" + time +
                ", index='" + index + '\'' +
                ", description='" + description + '\'' +
                ", attributes=" + attributes +
                ", url='" + url + '\'' +
                ", digest='" + digest + '\'' +
                ", owner='" + owner + '\'' +
                ", supervisor='" + supervisor + '\'' +
                ", superviseRule='" + superviseRule + '\'' +
                ", traceRule='" + traceRule + '\'' +
                '}';
    }
}
