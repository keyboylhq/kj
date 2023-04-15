package com.example.demo.req;

public class AuthorizationResponse {
    private String regulatorId; // 监管者ID
    private boolean authorized; // 是否获得足够的授权凭证
    private String authorizationProof; // 监管授权证明
    private String message; // 响应消息

    // 构造函数、getters和setters
    public AuthorizationResponse() {
    }

    public AuthorizationResponse(String regulatorId, boolean authorized, String authorizationProof, String message) {
        this.regulatorId = regulatorId;
        this.authorized = authorized;
        this.authorizationProof = authorizationProof;
        this.message = message;
    }

    public String getRegulatorId() {
        return regulatorId;
    }

    public void setRegulatorId(String regulatorId) {
        this.regulatorId = regulatorId;
    }

    public boolean isAuthorized() {
        return authorized;
    }

    public void setAuthorized(boolean authorized) {
        this.authorized = authorized;
    }

    public String getAuthorizationProof() {
        return authorizationProof;
    }

    public void setAuthorizationProof(String authorizationProof) {
        this.authorizationProof = authorizationProof;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
