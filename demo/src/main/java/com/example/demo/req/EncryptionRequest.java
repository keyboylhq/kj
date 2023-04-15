package com.example.demo.req;

import java.util.List;

public class EncryptionRequest {
    private String plainData; // 隐私数据的明文
    private List<String> userAttributes; // 访问对象的属性

    // 构造函数、getters和setters
    public EncryptionRequest() {
    }

    public EncryptionRequest(String plainData, List<String> userAttributes) {
        this.plainData = plainData;
        this.userAttributes = userAttributes;
    }

    public String getPlainData() {
        return plainData;
    }

    public void setPlainData(String plainData) {
        this.plainData = plainData;
    }

    public List<String> getUserAttributes() {
        return userAttributes;
    }

    public void setUserAttributes(List<String> userAttributes) {
        this.userAttributes = userAttributes;
    }
}
