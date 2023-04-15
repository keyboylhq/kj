package com.example.demo.controller;

import com.example.demo.req.AuthorizationRequest;
import com.example.demo.req.EncryptionRequest;
import com.example.demo.req.TraceRequest;
import com.example.demo.service.PrivacyService;
import com.example.demo.req.AuthorizationResponse;
import com.example.demo.vo.EncryptionResponse;
import com.example.demo.vo.TraceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/privacyController")
public class PrivacyController {
  @Autowired
  private PrivacyService privacyService;
  
  // 多监管者授权
  @PostMapping("/authorize")
  public ResponseEntity<?> authorize(@RequestBody AuthorizationRequest request) {
    AuthorizationResponse response = privacyService.authorize(request);
    return ResponseEntity.ok(response);
  }
  
  // 数据属性加密
  @PostMapping("/encrypt")
  public ResponseEntity<?> encrypt(@RequestBody EncryptionRequest request) {
    EncryptionResponse response = privacyService.encrypt(request);
    return ResponseEntity.ok(response);
  }
  
  // 监管溯源请求
  @PostMapping("/trace")
  public ResponseEntity<?> trace(@RequestBody TraceRequest request) {
    TraceResponse response = privacyService.trace(request);
    return ResponseEntity.ok(response);
  }
}
