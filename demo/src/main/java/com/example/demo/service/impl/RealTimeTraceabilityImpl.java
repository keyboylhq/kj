package com.example.demo.service.impl;

import com.example.demo.dto.IndexDto;
import com.example.demo.dto.MainChainDto;
import com.example.demo.service.RealTimeTraceabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service
public class RealTimeTraceabilityImpl implements RealTimeTraceabilityService {

    @Autowired
    IdentityGenerationImpl identityGeneration;

    // 功能1:获取所有直接子件key
    @Override
    public Map<String, Object> getAllDirectChildComponentKey(String parentComponentKey) throws MalformedURLException, UnsupportedEncodingException {

        CouchDBExample couchDBExampl = new CouchDBExample();
        Map<String, Object> allurl = couchDBExampl.geturlfun(parentComponentKey);
        return  allurl;
//        MainChainDto mainChainData = identityGeneration.getMainChainData(parentComponentKey);
//        List<String> allDirectSubComponentKeyList = new ArrayList<>();
//        for (int i = 0; i < mainChainData.getParts().size(); i++) {
//            for (Map.Entry<String, List<String>> entry : mainChainData.getParts().entrySet()) {
//                Objects.requireNonNull(allDirectSubComponentKeyList).addAll(entry.getValue());
//            }
//        }
//        return allDirectSubComponentKeyList;
    }

    // 功能2:获取直接子件key(带子件品类筛选)
    @Override
    public List<String> getDirectChildComponentKey(String parentComponentKey, String childComponentType) {
        MainChainDto mainChainData = identityGeneration.getMainChainData(parentComponentKey);
        List<String> DirectSubComponentKeyList = new ArrayList<>();
        for (int i = 0; i < mainChainData.getParts().size(); i++) {
            for (Map.Entry<String, List<String>> entry : mainChainData.getParts().entrySet()) {
                if (entry.getKey().equals(childComponentType)) {
                    DirectSubComponentKeyList.addAll(entry.getValue());
                }
            }
        }
        return DirectSubComponentKeyList;
    }

    // 功能3:获得直接母件key
    @Override
    public List<String> getDirectParentComponentKey(String childComponentKey) {
        IndexDto indexData = identityGeneration.getIndexData(childComponentKey);
        return indexData.getRelatedKey();
    }

    // 功能4:获得间接子件key(带子件品类筛选)
    @Override
    public List<String> getIndirectChildComponentKey(String parentComponentKey, String childComponentType) {
        List<String> directChildComponentKey = getDirectChildComponentKey(parentComponentKey, childComponentType);
        List<String> indirectChildComponentKey = new ArrayList<>();
        while (directChildComponentKey != null) {
            List<String> list = new ArrayList<>();
            for (String str : directChildComponentKey) {
                List<String> directChildComponentKey1 = getDirectChildComponentKey(str, childComponentType);
                indirectChildComponentKey.addAll(directChildComponentKey1);
                list.addAll(directChildComponentKey1);
            }
            directChildComponentKey = list;
        }
        return indirectChildComponentKey;
    }

    // 功能5:获取间接母件key(带母件品类筛选) 未完
    @Override
    public List<String> getIndirectParentComponentKey(String childComponentKey, String parentComponentType) {
        IndexDto indexData = identityGeneration.getIndexData(childComponentKey);
        List<String> indirectParentComponentKey = new ArrayList<>();
        while (indexData.getRelatedKey() != null) {
            for (String key : indexData.getRelatedKey()) {
                MainChainDto mainChainData = identityGeneration.getMainChainData(key);
            }
        }
        return null;
    }

    // 获取Owner某时间段同种产品品类的Key集合
    @Override
    public List<String> getKeyList(String owner, String parentComponentType, String startTime, String endTime) {
        return null;
    }
}
