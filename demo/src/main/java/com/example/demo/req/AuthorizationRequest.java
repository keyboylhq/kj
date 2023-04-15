package com.example.demo.req;
public class AuthorizationRequest {
    private String regulatorId; // 监管者ID
    private String companyId; // 企业ID
    private String targetData; // 监管的目标数据

    // 构造函数、getters和setters
    public AuthorizationRequest() {
    }

    public AuthorizationRequest(String regulatorId, String companyId, String targetData) {
        this.regulatorId = regulatorId;
        this.companyId = companyId;
        this.targetData = targetData;
    }

    public String getRegulatorId() {
        return regulatorId;
    }

    public void setRegulatorId(String regulatorId) {
        this.regulatorId = regulatorId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getTargetData() {
        return targetData;
    }

    public void setTargetData(String targetData) {
        this.targetData = targetData;
    }
}
