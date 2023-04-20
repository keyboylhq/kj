package com.example.demo.service.impl;

import com.example.demo.dto.IndexDto;
import com.example.demo.dto.MainChainDto;
import com.example.demo.dto.SubChainDto;
import com.example.demo.service.IdentityGenerationService;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class IdentityGenerationImpl implements IdentityGenerationService {

    // 功能1:通过Owner+Code生成对应的key
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

    // 功能2:在主链上查找key所在的子链ID
    @Override
    public Map<String, Object> getChainId(String key) throws UnsupportedEncodingException, MalformedURLException {
        CouchDBExample couchDBExampl = new CouchDBExample();
//      直接子件
//        Map<String, Object> allurl = couchDBExampl.geturlfun(key);
//        间接子件
        Map<String, Object> allurl = couchDBExampl.binaryTreealgorithm(key);
        return  allurl;
//        MainChainDto mainChainData = getMainChainData(key);
//        return mainChainData.getChainId();
    }

    // 功能3:在子链上查找key详细信息的URL
    @Override
    public Map<String, String> getUrl(String key, String chainId) throws UnsupportedEncodingException, MalformedURLException {

        CouchDBExample couchDBExampl = new CouchDBExample();
        Map<String, Object> allurl = couchDBExampl.geturlfun(key);
//        jsonObject.put("name", "John");
        Map<String, String> urlMap = new HashMap<>();
        for (Map.Entry<String, Object> entry : allurl.entrySet()) {
            String name = entry.getKey();
            List<String> values = (List<String>) entry.getValue();
            List<String> hashes = new ArrayList<>();
            for (int i = 0; i < values.size(); i++) {
//                hashes.add(values.getString(i));
                List<String> sonUrl = couchDBExampl.geturlsonfun(values.get(i));
                urlMap.put(name, sonUrl.toString());
            }

        }




//        JSONObject allurl = couchDBExampl.geturlsonfun(key);

        return urlMap;
        // 获取子链数据
//        SubChainDto subChainDto = getSubChainData(key);
//        // 查找url
//        List<String> url = null;
//        if (subChainDto.getKey().equals(key)) {
//            for (int i = 0; i < subChainDto.getResource().size(); i++) {
//                url = subChainDto.getResource().get(i).getUrl();
//            }
//        }
//        return url;
    }

    // 携带key发送http请求获取主链数据
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

    // 携带key发送http请求获取子链数据
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

    // 携带子链key发送http请求获取索引信息数据
    @Override
    public IndexDto getIndexData(String key) {
        IndexDto dto = new IndexDto();
        try {
            String path = "http://lhqpj.gcuweb.cn:5000/index?key=" + key;
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
            dto = gson.fromJson(responseString, IndexDto.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dto;
    }

    // 构件一功能总成

    @Override
    public Map<String, String> getUrlByOwnerCode(String owner, String code) throws NoSuchAlgorithmException, UnsupportedEncodingException, MalformedURLException {
        String key = this.generateKey(owner, code);
        Map<String, String> urlMap = this.getUrl(key, key);
        return urlMap;

    }
//    @Override
//    public List<String> getUrlByOwnerCode(String owner, String code) {
//        String key = owner + code;
//        MessageDigest digest;
//        List<String> url = null;
//        try {
//            digest = MessageDigest.getInstance("SHA-256");
//        } catch (NoSuchAlgorithmException e) {
//            throw new RuntimeException(e);
//        }
//        byte[] hashBytes = digest.digest(key.getBytes(StandardCharsets.UTF_8));
//        StringBuilder hexString = new StringBuilder();
//        for (byte b : hashBytes) {
//            String hex = Integer.toHexString(0xff & b);
//            if (hex.length() == 1) hexString.append('0');
//            hexString.append(hex);
//        }
//        MainChainDto mainChainData = getMainChainData(String.valueOf(hexString));
//        List<String> urlList = null;
//        for (int i = 0; i < mainChainData.getParts().size(); i++) {
//            for (Map.Entry<String, List<String>> entry : mainChainData.getParts().entrySet()) {
//                for (int j = 0; j < mainChainData.getParts().values().size(); j++) {
//                    urlList.add(entry.getValue().get(j));
//                }
//            }
//        }
//        for (String str : urlList) {
//            SubChainDto subChainData = getSubChainData(str);
//            for (int i = 0; i < subChainData.getResource().size(); i++) {
//                url = subChainData.getResource().get(i).getUrl();
//            }
//        }
//        return url;
//    }
}
