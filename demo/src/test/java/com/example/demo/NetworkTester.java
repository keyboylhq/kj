package com.example.demo;

import com.example.demo.service.PrivacyService;
import com.example.demo.vo.TreeNode;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void  findLeafNodest( ) {




    }




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
