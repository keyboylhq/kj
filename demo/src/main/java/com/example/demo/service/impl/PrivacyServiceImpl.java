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
    if (request.getCompanyId().equals("1") ) {
      authorizationResponse.setAuthorized(true);
      authorizationResponse.setAuthorizationProof("12321321aerqwrqwe");
    }
    else {
      authorizationResponse.setAuthorized(false);

    }

    // 实现多监管者授权功能
    return authorizationResponse ;
  }
  
  @Override
  public EncryptionResponse encrypt(EncryptionRequest request) {
    // 实现数据属性加密功能
    EncryptionResponse encryptionResponse = new EncryptionResponse();
    encryptionResponse.setEncryptedData("11111111");
    return encryptionResponse ;
  }
  
  @Override
  public TraceResponse trace(TraceRequest request) {
    TraceResponse traceResponse = new TraceResponse();
    traceResponse.setRegulatorId(request.getRegulatorId());
    if (request.getRegulatorId().equals("regulatorId") & request.getAttributeCertificate().equals("attributeCertificate")) {
      traceResponse.setAllowed(true);
    }else {
      traceResponse.setAllowed(false);

    }
    // 实现监管溯源请求功能


    return traceResponse;
  }
}
