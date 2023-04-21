package com.example.demo.controller;

import com.example.demo.dto.MainChainDto;
import com.example.demo.dto.SubChainDto;
import com.example.demo.service.IdentityGenerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

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
     *
     * @return
     */
    @GetMapping("/getChainId")
    public Map<String, Object> getChainId(String key) throws UnsupportedEncodingException, MalformedURLException {
        return identityGenerationService.getChainId(key);
    }

    @GetMapping("/getChainIdall")
    public Map<String, Object> getChainIdall(String key) throws UnsupportedEncodingException, MalformedURLException {
        return identityGenerationService.getChainIdall(key);
    }

    /**
     * 在子链上查找key详细信息的url
     *
     * @return
     */
    @GetMapping("/getUrl")
    public Map<String, String> getUrl(String key, String chainId) throws IOException {
//        return identityGenerationService.getUrl(key, chainId);
        return identityGenerationService.getUrl(key, chainId);
    }

    /**
     * 整合功能(通过owner+code查找url)
     *
     * @return
     */
    @GetMapping("/getUrlByOwnerCode")
    public Map<String, String> getUrlByOwnerCode(String owner, String code) throws UnsupportedEncodingException, NoSuchAlgorithmException, MalformedURLException {
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
