package com.example.demo.service;

import com.example.demo.dto.IndexDto;
import com.example.demo.dto.MainChainDto;
import com.example.demo.dto.SubChainDto;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

@Service
public interface IdentityGenerationService {
    /**
     * @return
     */
    String generateKey(String owner, String code) throws NoSuchAlgorithmException;

    /**
     * @return
     */
    Map<String, Object> getChainId(String key) throws UnsupportedEncodingException;

    /**
     * @return
     */
    Map<String, String> getUrl(String key, String chainId) throws UnsupportedEncodingException;

    /**
     * @return
     */
    Map<String, String> getUrlByOwnerCode(String owner, String code) throws NoSuchAlgorithmException, UnsupportedEncodingException;

    /**
     * @return
     */
    MainChainDto getMainChainData(String key);

    /**
     * @return
     */
    SubChainDto getSubChainData(String key);

    /**
     * @return
     */
    IndexDto getIndexData(String key);
}
