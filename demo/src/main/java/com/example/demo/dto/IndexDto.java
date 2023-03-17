package com.example.demo.dto;

import java.util.List;

public class IndexDto {
    String  key;

    List<String> relatedKey;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<String> getRelatedKey() {
        return relatedKey;
    }

    public void setRelatedKey(List<String> relatedKey) {
        this.relatedKey = relatedKey;
    }

    @Override
    public String toString() {
        return "IndexDto{" +
                "key='" + key + '\'' +
                ", relatedKey=" + relatedKey +
                '}';
    }
}
