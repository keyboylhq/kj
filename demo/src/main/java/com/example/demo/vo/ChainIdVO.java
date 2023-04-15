package com.example.demo.vo;

import java.util.List;

public class ChainIdVO {
    private String chainId;
    private List<String> hashes;
    // ...其他属性和方法

    public String getChainId() {
        return chainId;
    }

    public void setChainId(String chainId) {
        this.chainId = chainId;
    }

    public List<String> getHashes() {
        return hashes;
    }

    public void setHashes(List<String> hashes) {
        this.hashes = hashes;
    }
}
