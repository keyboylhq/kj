package com.example.demo.service.impl;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class CouchDBExample {


    public Map<String, Object> geturlfun(String key) throws UnsupportedEncodingException {
//        String key = "ac4b5131f73b2bbe42df9f9a56c3a3c88b9f68df14b97541354c306f466f93d6";
//        String encodedKey = URLEncoder.encode(key, StandardCharsets.UTF_8);
//        String encodedKey = URLEncoder.encode(key, StandardCharsets.UTF_8.toString());
        String url = "http://106.12.107.132:5984/mydatabase/_design/myDesignDocument/_view/new-view?key=" + "\"" + key + "\"";

        String username = "admin";
        String password = "password";

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add(new BasicAuthenticationInterceptor(username, password));

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");
        HttpEntity<String> entity = new HttpEntity<>(headers);

        String geturl = null;
        List<String> hashes = null;
        JSONObject partsjson = null;
        Map<String, Object> parts = null;
        try {
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
            JSONObject jsonObject = new JSONObject(response.getBody());
            String id = jsonObject.getJSONArray("rows").getJSONObject(0).getString("id");

            String docUrl = "http://106.12.107.132:5984/mydatabase/" + id;
            ResponseEntity<String> docResponse = restTemplate.exchange(docUrl, HttpMethod.GET, entity, String.class);
            JSONObject docJsonObject = new JSONObject(docResponse.getBody());

            System.out.println("Retrieved document:");
            System.out.println(docJsonObject.toString());


            partsjson = docJsonObject.getJSONObject("parts");
            parts = partsjson.toMap();

//            parts = objectMapper.readValue(partsjson, PartsVo.class);

//            hashes = new ArrayList<>();
//            for (Iterator<String> it = parts.keys(); it.hasNext(); ) {
//                String  partskey  = it.next();
//                JSONArray arr = parts.getJSONArray(partskey);
//                for (int i = 0; i < arr.length(); i++) {
//                    hashes.add(arr.getString(i));
//                }
//            }

            System.out.println("parts:");
            System.out.println(parts);
//            for (String partskey : parts.keySet()) {
//                JSONArray values = parts.getJSONArray(partskey);
//                System.out.println(partskey + ": " + values.toString());
//            }
//            System.out.println("Hashes:");
//            System.out.println(hashes.toString());
//            geturl = docJsonObject.getJSONArray("resource").getJSONObject(1).getString("URL");
//            System.out.println("geturl");
//            System.out.println(geturl);

            return parts;
        } catch (HttpClientErrorException ex) {
            System.out.println("Error: " + ex.getMessage());
        } catch (JSONException ex) {
            System.out.println("Error parsing JSON: " + ex.getMessage());
        }

        return parts;
    }


    public List<String> geturlsonfun(String key) throws UnsupportedEncodingException {
//        String key = "ac4b5131f73b2bbe42df9f9a56c3a3c88b9f68df14b97541354c306f466f93d6";
//        String encodedKey = URLEncoder.encode(key, StandardCharsets.UTF_8);
//        String encodedKey = URLEncoder.encode(key, StandardCharsets.UTF_8.toString());
        String url = "http://106.12.107.132:5984/mydatabase/_design/myDesignDocument/_view/new-view?key=" + "\"" + key + "\"";

        String username = "admin";
        String password = "password";

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add(new BasicAuthenticationInterceptor(username, password));

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");
        HttpEntity<String> entity = new HttpEntity<>(headers);

        String geturl = null;
        List<String> geturls = new ArrayList<>();
        List<String> hashes = null;
        try {
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
            JSONObject jsonObject = new JSONObject(response.getBody());
            String id = jsonObject.getJSONArray("rows").getJSONObject(0).getString("id");

            String docUrl = "http://106.12.107.132:5984/mydatabase/" + id;
            ResponseEntity<String> docResponse = restTemplate.exchange(docUrl, HttpMethod.GET, entity, String.class);
            JSONObject docJsonObject = new JSONObject(docResponse.getBody());
//
//            System.out.println("Retrieved document:");
//            System.out.println(docJsonObject.toString());


//            JSONObject parts = docJsonObject.getJSONObject("parts");
//            hashes = new ArrayList<>();
//            for (Iterator<String> it = parts.keys(); it.hasNext(); ) {
//                String  partskey  = it.next();
//                JSONArray arr = parts.getJSONArray(partskey);
//                for (int i = 0; i < arr.length(); i++) {
//                    hashes.add(arr.getString(i));
//                }
//            }

//            System.out.println("Hashes:");
//            System.out.println(hashes.toString());
            JSONArray resources = docJsonObject.getJSONArray("resource");
            for (int i = 0; i < resources.length(); i++) {
                geturl = resources.getJSONObject(i).getString("URL");
                System.out.println(url);
                geturls.add(geturl);

            }

//            geturl = docJsonObject.getJSONArray("resource").getJSONObject(1).getString("URL");
//            System.out.println("geturl");
//            System.out.println(geturl);
            return geturls;
        } catch (HttpClientErrorException ex) {
            System.out.println("Error: " + ex.getMessage());
        } catch (JSONException ex) {
            System.out.println("Error parsing JSON: " + ex.getMessage());
        }

        return geturls;
    }
}
