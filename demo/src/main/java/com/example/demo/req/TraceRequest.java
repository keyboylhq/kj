package com.example.demo.req;

public class TraceRequest {
    private String regulatorId; // 监管者ID
    private String authorizationProof; // 监管授权凭证
    private String attributeCertificate; // 监管者属性证书

    // 构造函数、getters和setters
    public TraceRequest() {
    }

    public TraceRequest(String regulatorId, String authorizationProof, String attributeCertificate) {
        this.regulatorId = regulatorId;
        this.authorizationProof = authorizationProof;
        this.attributeCertificate = attributeCertificate;
    }

    public String getRegulatorId() {
        return regulatorId;
    }

    public void setRegulatorId(String regulatorId) {
        this.regulatorId = regulatorId;
    }

    public String getAuthorizationProof() {
        return authorizationProof;
    }

    public void setAuthorizationProof(String authorizationProof) {
        this.authorizationProof = authorizationProof;
    }

    public String getAttributeCertificate() {
        return attributeCertificate;
    }

    public void setAttributeCertificate(String attributeCertificate) {
        this.attributeCertificate = attributeCertificate;
    }
}
