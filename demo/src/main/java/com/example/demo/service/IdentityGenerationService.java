package com.example.demo.service;

import com.example.demo.dto.MainChainDto;
import com.example.demo.dto.SubChainDto;

import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface IdentityGenerationService {
    /**
     * @return
     */
    String generateKey(String owner, String code) throws NoSuchAlgorithmException;

    /**
     * @return
     */
    String getChainId(String key);

    /**
     * @return
     */
    List<String> getUrl(String key, String chainId);

    /**
     * @return
     */
    MainChainDto getMainChainData(String key);

    /**
     * @return
     */
    SubChainDto getSubChainData(String key);


    List<String> getUrlByOwnerCode(String owner, String code);
}
