package com.example.demo.service;

import com.example.demo.dto.IndexDto;
import com.example.demo.dto.MainChainDto;
import com.example.demo.dto.SubChainDto;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
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
    List<String> getUrlByOwnerCode(String owner, String code);

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
