package com.example.demo.vo;

public class TraceResponse {
    private String regulatorId; // 监管者ID
    private boolean isAllowed; // 是否允许溯源
    private String traceResult; // 溯源结果
    private String message; // 响应消息

    // 构造函数、getters和setters
    public TraceResponse() {
    }

    public TraceResponse(String regulatorId, boolean isAllowed, String traceResult, String message) {
        this.regulatorId = regulatorId;
        this.isAllowed = isAllowed;
        this.traceResult = traceResult;
        this.message = message;
    }

    public String getRegulatorId() {
        return regulatorId;
    }

    public void setRegulatorId(String regulatorId) {
        this.regulatorId = regulatorId;
    }

    public boolean isAllowed() {
        return isAllowed;
    }

    public void setAllowed(boolean isAllowed) {
        this.isAllowed = isAllowed;
    }

    public String getTraceResult() {
        return traceResult;
    }

    public void setTraceResult(String traceResult) {
        this.traceResult = traceResult;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
