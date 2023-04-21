package com.example.demo.service.impl;

import com.example.demo.vo.TreeNode;
import org.ektorp.http.StdHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;


import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.*;
import java.net.URI;
import java.util.Map;
import org.ektorp.CouchDbConnector;
import org.ektorp.CouchDbInstance;
import org.ektorp.ViewQuery;
import org.ektorp.ViewResult;
import org.ektorp.impl.StdCouchDbConnector;
import org.ektorp.impl.StdCouchDbInstance;

public class CouchDBExample {

/*
*
* */

    /**
     * 主链上查找key所在的子链ID（直接）直接
     *
     *
    * */


//    直接子件 key
//    public Map<String, Object> geturlfun(String key) throws UnsupportedEncodingException {
////        String key = "ac4b5131f73b2bbe42df9f9a56c3a3c88b9f68df14b97541354c306f466f93d6";
////        String encodedKey = URLEncoder.encode(key, StandardCharsets.UTF_8);
////        String encodedKey = URLEncoder.encode(key, StandardCharsets.UTF_8.toString());
//        String url = "http://106.12.107.132:5984/parent_chain/_design/my/_view/new-view?key=" + "\"" + key + "\"";
//
//        String username = "admin";
//        String password = "password";
//
//        RestTemplate restTemplate = new RestTemplate();
//        restTemplate.getInterceptors().add(new BasicAuthenticationInterceptor(username, password));
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("Accept", "application/json");
//        HttpEntity<String> entity = new HttpEntity<>(headers);
////
////        String geturl = null;
////        List<String> hashes = null;
//        JSONObject partsjson = null;
//        Map<String, Object> parts = null;
//        try {
//            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
//            JSONObject jsonObject = new JSONObject(response.getBody());
//            String id = jsonObject.getJSONArray("rows").getJSONObject(0).getString("id");
//
//            String docUrl = "http://106.12.107.132:5984/parent_chain/" + id;
//            ResponseEntity<String> docResponse = restTemplate.exchange(docUrl, HttpMethod.GET, entity, String.class);
//            JSONObject docJsonObject = new JSONObject(docResponse.getBody());
//
//            System.out.println("Retrieved document:");
//            System.out.println(docJsonObject.toString());
//
//
//            partsjson = docJsonObject.getJSONObject("parts");
//            parts = partsjson.toMap();
//
////            parts = objectMapper.readValue(partsjson, PartsVo.class);
//
////            hashes = new ArrayList<>();
////            for (Iterator<String> it = parts.keys(); it.hasNext(); ) {
////                String  partskey  = it.next();
////                JSONArray arr = parts.getJSONArray(partskey);
////                for (int i = 0; i < arr.length(); i++) {
////                    hashes.add(arr.getString(i));
////                }
////            }
//            System.out.println("parts:");
//            System.out.println(parts);
////            for (String partskey : parts.keySet()) {
////                JSONArray values = parts.getJSONArray(partskey);
////                System.out.println(partskey + ": " + values.toString());
////            }
////            System.out.println("Hashes:");
////            System.out.println(hashes.toString());
////            geturl = docJsonObject.getJSONArray("resource").getJSONObject(1).getString("URL");
////            System.out.println("geturl");
////            System.out.println(geturl);
//            return parts;
//        } catch (HttpClientErrorException ex) {
//            System.out.println("Error: " + ex.getMessage());
//        } catch (JSONException ex) {
//            System.out.println("Error parsing JSON: " + ex.getMessage());
//            return null;
//        }
//
//        return parts;
//    }


//不如上面

    public Map<String, Object> geturlfun(String key) throws MalformedURLException {
            String url = "http://admin:password@106.12.107.132:5984/";
            String dbName = "parent_chain";
            String viewName = "my/new-view";
//            String key = "your_key_here";

            // Connect to the CouchDB server
            CouchDbInstance dbInstance = new StdCouchDbInstance(new StdHttpClient.Builder()
                    .url(url)
                    .build());
            CouchDbConnector db = new StdCouchDbConnector(dbName, dbInstance);

            // Build the query parameters and options
            ViewQuery query = new ViewQuery().designDocId("_design/" + viewName.split("/")[0])
                    .viewName(viewName.split("/")[1])
                    .key(key)
                    .includeDocs(true);

            // Query the view and retrieve the document ID
            ViewResult result = db.queryView(query);
            try {
                String id = result.getRows().get(0).getId();
                // Retrieve the full document and extract the parts object
                Map<String, Object> doc = db.get(Map.class, id);
                Map<String, Object> parts = (Map<String, Object>) doc.get("parts");

                // Print parts data to console
//                System.out.println("Retrieved parts:");
//                System.out.println(parts);
                return parts;
            } catch (IndexOutOfBoundsException e) {
//                System.out.println("Error: " + e.getMessage());
                return null;
            }

    }


    /**
*  间接子件key
 *  用直接子件获得key在查
 *  */

public Map<String, Object> binaryTreealgorithm(String key) throws MalformedURLException, UnsupportedEncodingException {
    Map<String, Object> allsonparts = new HashMap<String, Object>(); // This map will contain results for each sub-key
//    long startTime = System.currentTimeMillis();

// Code to be measured goes here
    Map<String, Object> geturlfun = geturlfun(key); // Get URLs for the main key
//    long endTime = System.currentTimeMillis();
//    long elapsedTime = endTime - startTime;

//    System.out.println("Elapsed time: " + elapsedTime + " milliseconds");


    // If there are no URLs for the main key, return null
    if (geturlfun == null) {
        return null;
    }

    processSubkeys(geturlfun, allsonparts);

    // Return the map of all sub-key results
    return allsonparts;
}

    private void processSubkeys(Map<String, Object> allsonurl, Map<String, Object> allsonparts) throws UnsupportedEncodingException, MalformedURLException {
        Iterator<Map.Entry<String, Object>> iterator = new HashMap<>(allsonurl).entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Object> entry = iterator.next();
            String subkey = entry.getKey();
            Object value = entry.getValue();

            // Perform some operation with the key and value here

            // Remove the current key-value pair from the map using iterator.remove()
            iterator.remove();

            // Get URLs for the current subkey
            ArrayList<String> urls = (ArrayList<String>) value;
            for (String url : urls) {
                Map<String, Object> subkeyUrls = geturlfun(url);

                // If there are no URLs for the current subkey, add the current subkey and URLs to the allsonparts map
                if (subkeyUrls == null) {
                    allsonparts.put(subkey, urls);
                }
                // Otherwise, process the URLs for the current subkey using the processSubkeys() method
                else {
                    allsonparts.put(subkey, urls); // Add the current subkey and URLs to the allsonparts map
                    processSubkeys(subkeyUrls, allsonparts);
                }
            }
        }
    }



    /**
     * 主链上查找key所在的子链ID（直接）
     *
     * 在子链上查找key详细信息的URL
     * */
    public List<String> geturlsonfun(String key) throws UnsupportedEncodingException {
//        String key = "ac4b5131f73b2bbe42df9f9a56c3a3c88b9f68df14b97541354c306f466f93d6";
//        String encodedKey = URLEncoder.encode(key, StandardCharsets.UTF_8);
//        String encodedKey = URLEncoder.encode(key, StandardCharsets.UTF_8.toString());
        String url = "http://106.12.107.132:5984/mydatabase/_design/my/_view/new-view?key=" + "\"" + key + "\"";

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
//    Multi-fork tree to find non-leaf nodes
    public List<TreeNode> findLeafNodes(TreeNode node) {
        List<TreeNode> leafNodes = new ArrayList<>();
        if (node.getChildren() == null || node.getChildren().isEmpty()) {
            // 如果当前节点没有子节点，那么它是一个子叶节点，将其加入结果列表
            leafNodes.add(node);
        } else {
            // 如果当前节点有子节点，遍历每个子节点并递归调用该函数
            for (TreeNode child : node.getChildren()) {
                leafNodes.addAll(findLeafNodes(child));
            }
        }
        return leafNodes;
    }

}
