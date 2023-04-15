package com.example.demo.service.impl;

import com.example.demo.req.AuthorizationRequest;
import com.example.demo.req.EncryptionRequest;
import com.example.demo.req.TraceRequest;
import com.example.demo.service.PrivacyService;
import com.example.demo.req.AuthorizationResponse;
import com.example.demo.vo.EncryptionResponse;
import com.example.demo.vo.TraceResponse;
import org.springframework.stereotype.Service;

@Service
public class PrivacyServiceImpl implements PrivacyService {
  @Override
  public AuthorizationResponse authorize(AuthorizationRequest request) {
    AuthorizationResponse authorizationResponse = new AuthorizationResponse();
    authorizationResponse.setAuthorizationProof("111");
    // 实现多监管者授权功能
    return authorizationResponse ;
  }
  
  @Override
  public EncryptionResponse encrypt(EncryptionRequest request) {
    // 实现数据属性加密功能
    EncryptionResponse encryptionResponse = new EncryptionResponse();
    encryptionResponse.setEncryptedData("111");
    return encryptionResponse ;
  }
  
  @Override
  public TraceResponse trace(TraceRequest request) {
    // 实现监管溯源请求功能
    TraceResponse traceResponse = new TraceResponse();
    traceResponse.setTraceResult("111");
    return traceResponse;
  }
}
