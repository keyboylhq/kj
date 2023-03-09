package com.example.demo;

import java.net.InetAddress;

public class NetworkTester {
    public static void main(String[] args) {
        String hostName = "www.baidu.com";
        try {
            InetAddress inetAddress = InetAddress.getByName(hostName);
            System.out.println("IP address: " + inetAddress.getHostAddress());
            System.out.println("Reachable: " + inetAddress.isReachable(5000)); // 5秒超时时间
        } catch (Exception e) {
            System.out.println("Cannot reach the host: " + hostName);
            e.printStackTrace();
        }
    }
}
