package com.example.demo;

import com.example.demo.dto.MainChainDto;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpExample {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://lhqpj.gcuweb.cn:5000/mainchain");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = in.readLine()) != null) {
                response.append(line);
            }
            in.close();

            String jsonResponse = response.toString();
            System.out.println(jsonResponse);

            Gson gson = new Gson();
            MainChainDto responseDTO = gson.fromJson(jsonResponse, MainChainDto.class);
            System.out.println(responseDTO.getChainId());


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
