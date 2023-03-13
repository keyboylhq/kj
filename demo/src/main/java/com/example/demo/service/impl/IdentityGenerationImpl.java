package com.example.demo.service.impl;

import com.example.demo.dto.MainChainDto;
import com.example.demo.dto.SubChainDto;
import com.example.demo.service.IdentityGenerationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
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
    public String getChainId(String key) {
        return null;
    }

    /*@Override
    public String getChainId(String key) {
        MainChainDto mainChainData = getMainChainData(key);
        return mainChainData.getChainId();
    }*/

    @Override
    public List<String> getUrl(String key, String chainId) {
        // 获取子链数据
        SubChainDto subChainDto = getSubChainData(key);
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
    public MainChainDto getMainChainData(String key) {
        MainChainDto dto = new MainChainDto();
        try {
            String path = "http://lhqpj.gcuweb.cn:5000/mainchain?key=" + key;
            URL url = new URL(path);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            String responseString = response.toString();
            String decodedString = java.net.URLDecoder.decode(responseString, StandardCharsets.UTF_8.name());
            System.out.println(decodedString);
            Gson gson = new Gson();
            dto = gson.fromJson(responseString, MainChainDto.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dto;
    }

    @Override
    public SubChainDto getSubChainData(String key) {
        SubChainDto dto = new SubChainDto();
        try {
            String path = "http://lhqpj.gcuweb.cn:5000/subchain?key=" + key;
            URL url = new URL(path);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            String responseString = response.toString();
            String decodedString = java.net.URLDecoder.decode(responseString, StandardCharsets.UTF_8.name());
            System.out.println(decodedString);
            Gson gson = new Gson();
            dto = gson.fromJson(responseString, SubChainDto.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dto;
    }
}
