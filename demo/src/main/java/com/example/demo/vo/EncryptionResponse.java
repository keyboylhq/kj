package com.example.demo.vo;

public class EncryptionResponse {
    private String encryptedData; // 隐私数据的密文

    // 构造函数、getters和setters
    public EncryptionResponse() {
    }

    public EncryptionResponse(String encryptedData) {
        this.encryptedData = encryptedData;
    }

    public String getEncryptedData() {
        return encryptedData;
    }

    public void setEncryptedData(String encryptedData) {
        this.encryptedData = encryptedData;
    }
}
