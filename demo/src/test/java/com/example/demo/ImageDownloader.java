package com.example.demo;

import java.io.*;
import java.net.*;

public class ImageDownloader {
    public static void main(String[] args) {
        String imageUrl = "https://tenfei03.cfp.cn/creative/vcg/800/version23/VCG41175510742.jpg";
        String destinationFile = "src/main/resources/dow/mountains.jpg";
        
        try {
            URL url = new URL(imageUrl);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            InputStream inputStream = httpURLConnection.getInputStream();
            byte[] buffer = new byte[4096];
            int bytesRead = -1;
            OutputStream outputStream = new FileOutputStream(destinationFile);
            
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            
            outputStream.close();
            inputStream.close();
            
            System.out.println("Image downloaded successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
