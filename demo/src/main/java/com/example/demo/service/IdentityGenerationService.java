package com.example.demo.service;

import com.example.demo.dto.MainChainDto;
import com.example.demo.dto.SubChainDto;

import java.util.List;

public interface IdentityGenerationService {
    /**
     * @return
     */
    List<String> getUrl(String identifier, String subChainId);

    /**
     * @return
     */
    String getIdentifier(String owner, String code);

    /**
     * @return
     */
    MainChainDto getMainChainData(String mainChainId, String owner);

    /**
     * @return
     */
    SubChainDto getSubChainData(String subChainId, String owner);


}
