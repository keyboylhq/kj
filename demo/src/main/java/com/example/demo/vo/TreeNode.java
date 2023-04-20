package com.example.demo.vo;

import lombok.Data;

import java.util.List;

@Data
public class TreeNode {
    private String id;
    private String parentId;
    private List<TreeNode> children;

    // getters and setters
}