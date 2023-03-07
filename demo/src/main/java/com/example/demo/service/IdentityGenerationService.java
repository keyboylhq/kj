package com.example.demo.service;

import com.example.demo.dto.MainChainDto;
import com.example.demo.dto.SubChainDto;

import java.util.List;

public interface IdentityGenerationService {
    /**
     * @param identifier
     * @param subChainId
     * @return
     */
    List<String> GetUrl(String identifier, String subChainId);

    /**
     * @return
     */
    MainChainDto GetMainChainData(String subChainId);

    /**
     * @return
     */
    SubChainDto GetSubChainData(String subChainId);
}
