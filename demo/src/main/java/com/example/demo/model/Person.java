package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private String id;
    private String key;
    private String description;
    private Long time;
    private String owner;
    private String chainId;
    private String parentKey;
    private Map<String, List<Part>> parts;
}