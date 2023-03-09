package com.example.demo.service.impl;

import com.example.demo.dto.MainChainDto;
import com.example.demo.dto.SubChainDto;
import com.example.demo.service.IdentityGenerationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

public class IdentityGenerationImpl implements IdentityGenerationService {

    @Override
    public String generateKey(String owner, String code) throws NoSuchAlgorithmException {
        String key = owner + code;
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = digest.digest(key.getBytes(StandardCharsets.UTF_8));
        StringBuilder hexString = new StringBuilder();
        for (byte b : hashBytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }

    @Override
    public String getChainId(String mainChain, String key) {
        MainChainDto mainChainData = getMainChainData(mainChain, null);
        String chainId = null;
        for (Map.Entry<String, List<String>> entry : mainChainData.getParts().entrySet()) {
            if (entry.getValue().contains(key)) {
                chainId = entry.getKey();
            }
        }
        return chainId;
    }

    @Override
    public List<String> getUrl(String key, String chainId) {
        // 获取子链数据
        SubChainDto subChainDto = getSubChainData(chainId, null);
        // 查找url
        List<String> url = null;
        if (subChainDto.getKey().equals(key)) {
            for (int i = 0; i < subChainDto.getResource().size(); i++) {
                url = subChainDto.getResource().get(i).getUrl();
            }
        }
        return url;
    }

    @Override
    public String getIdentifier(String owner, String code) {
        // 获取子链数据
        SubChainDto subChainDto = getSubChainData(null, owner);
        if (!subChainDto.getCode().equals(code)) {
            return null;
        }
        return subChainDto.getKey();
    }

    @Override
    public MainChainDto getMainChainData(String mainChainId, String owner) {
        return new MainChainDto();
    }

    @Override
    public SubChainDto getSubChainData(String subChainId, String owner) {
        return new SubChainDto();
    }
}
