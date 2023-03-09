package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.google.gson.Gson;

@SpringBootTest
class DemoApplicationTests {


    /**
    * 1.4	主链数据模型示例
    * */
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

        Gson gson = new Gson();
        String json = gson.toJson(vehicleTraceVO);
        System.out.println(json);
    }

}
