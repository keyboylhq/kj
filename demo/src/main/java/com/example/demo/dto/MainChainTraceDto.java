package com.example.demo.dto;

import java.util.List;
import java.util.Map;

public class MainChainTraceDto {
    private String parentKey;
    private String tokenId;

    private String description;

    private List<Map<String, String>> index;

    private String owner;

    private List<Map<String, String>> supply;

    private List<Map<String, String>> manufacture;

    private List<Map<String, String>> transfer;

    private List<Map<String, String>> sale;

    public String getParentKey() {
        return parentKey;
    }

    public void setParentKey(String parentKey) {
        this.parentKey = parentKey;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Map<String, String>> getIndex() {
        return index;
    }

    public void setIndex(List<Map<String, String>> index) {
        this.index = index;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public List<Map<String, String>> getSupply() {
        return supply;
    }

    public void setSupply(List<Map<String, String>> supply) {
        this.supply = supply;
    }

    public List<Map<String, String>> getManufacture() {
        return manufacture;
    }

    public void setManufacture(List<Map<String, String>> manufacture) {
        this.manufacture = manufacture;
    }

    public List<Map<String, String>> getTransfer() {
        return transfer;
    }

    public void setTransfer(List<Map<String, String>> transfer) {
        this.transfer = transfer;
    }

    public List<Map<String, String>> getSale() {
        return sale;
    }

    public void setSale(List<Map<String, String>> sale) {
        this.sale = sale;
    }

    @Override
    public String toString() {
        return "MainChainTraceDto{" +
                "parentKey='" + parentKey + '\'' +
                ", tokenId='" + tokenId + '\'' +
                ", description='" + description + '\'' +
                ", index=" + index +
                ", owner='" + owner + '\'' +
                ", supply=" + supply +
                ", manufacture=" + manufacture +
                ", transfer=" + transfer +
                ", sale=" + sale +
                '}';
    }
}
