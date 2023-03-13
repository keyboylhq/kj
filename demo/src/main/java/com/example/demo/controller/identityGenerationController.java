package com.example.demo.controller;

import com.example.demo.dto.MainChainDto;
import com.example.demo.dto.SubChainDto;
import com.example.demo.service.IdentityGenerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
@RequestMapping("/identityGeneration")
public class identityGenerationController {

    @Autowired
    IdentityGenerationService identityGenerationService;

    /**
     * 生成数据标识 key
     * @return
     */
    @GetMapping("/generateKey")
    public String generateKey(String owner, String code) throws NoSuchAlgorithmException {
        return identityGenerationService.generateKey(owner, code);
    }

    /**
     * 在主链上查找key所在的子链ID
     * @return
     */
    @GetMapping("/getChainId")
    public String getChainId(String key) {
        return identityGenerationService.getChainId(key);
    }

    /**
     * 在子链上查找key详细信息的url
     * @return
     */
    @GetMapping("/getUrl")
    public List<String> getUrl(String key, String chainId) {
        return identityGenerationService.getUrl(key, chainId);
    }

    /**
     * 整合功能(通过owner+code查找url)
     * @return
     */
    @GetMapping("/getUrlByOwnerCode")
    public List<String> getUrlByOwnerCode(String owner, String code) {
        return identityGenerationService.getUrlByOwnerCode(owner, code);
    }

    /**
     * 通过主链ID或标识所有者请求主链数据
     * @return
     */
    @GetMapping("/getMainChainData")
    public MainChainDto getMainChainData(String key) {
        return identityGenerationService.getMainChainData(key);
    }

    /**
     * 通过子链ID或标识所有者请求子链数据
     * @return
     */
    @GetMapping("/getSubChainData")
    public SubChainDto getSubChainData(String key) {
        return identityGenerationService.getSubChainData(key);
    }
}
