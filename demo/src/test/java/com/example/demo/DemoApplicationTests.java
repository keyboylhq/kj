package com.example.demo;

import com.example.demo.dto.MainChainDto;
import com.example.demo.service.impl.CouchDBExample;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    CouchDBExample CouchDBExample;
    /**
     * 1.4	主链数据模型示例
     */
    @Test
    void contextLoads() {

        // 创建一个VehicleTraceVO对象
        VehicleTraceVO vehicleTraceVO = new VehicleTraceVO();

// 设置对象的属性值
        vehicleTraceVO.setKey("f0ff3b8ad283922e86693a68164c966a183e370a0cbaac922107c5fcf6c0d013");
        vehicleTraceVO.setDescription("这是一条整车追溯示例");
        vehicleTraceVO.setTime(1655438693L);
        vehicleTraceVO.setOwner("制造商A");

// 设置对象的parts属性值
        Map<String, List<String>> parts = new HashMap<>();
        List<String> engineList = new ArrayList<>();
        engineList.add("ac4b5131f73b2bbe42df9f9a56c3a3c88b9f68df14b97541354c306f466f93d6");
        parts.put("发动机总成", engineList);

        List<String> steeringWheelList = new ArrayList<>();
        steeringWheelList.add("1632ae6ddd4a45aee5efc0a16d82aef3d2bd5201505dcf36f4b5333fa0b50221");
        parts.put("方向盘", steeringWheelList);

        List<String> tireList = new ArrayList<>();
        tireList.add("cccf2d6674ce96a3d8dcfe3f0b1aab07e2011de1b7bab151be6e7b07a915d438");
        parts.put("轮胎", tireList);

        vehicleTraceVO.setParts(parts);

//        Gson gson = new Gson();
//        String json = gson.toJson(vehicleTraceVO);
//        System.out.println(json);
    }

    @Test
    void qqq() {
        try {
            String key = "4564321234";
            String path = "http://lhqpj.gcuweb.cn:5000/mainchain?key=" + key;
            URL url = new URL(path);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

//            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
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
            MainChainDto responseDTO = gson.fromJson(responseString, MainChainDto.class);
            System.out.println(responseDTO);
            System.out.println(responseDTO.getChainId());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    void dd() throws UnsupportedEncodingException {

//        Map<String, Object> stringObjectMap = CouchDBExample.binaryTreealgorithm("83a86d7ea0295798b4ad57765a35d36b5e1bc301295f208974d7886da079209b");
//        System.out.println(stringObjectMap);
    }
}
