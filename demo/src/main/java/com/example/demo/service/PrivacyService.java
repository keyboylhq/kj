package com.example.demo.service;

import com.example.demo.req.AuthorizationRequest;
import com.example.demo.req.AuthorizationResponse;
import com.example.demo.req.EncryptionRequest;
import com.example.demo.req.TraceRequest;
import com.example.demo.vo.EncryptionResponse;
import com.example.demo.vo.TraceResponse;
import org.springframework.stereotype.Service;

@Service
public interface PrivacyService {
    AuthorizationResponse authorize(AuthorizationRequest request);

    EncryptionResponse encrypt(EncryptionRequest request);

    TraceResponse trace(TraceRequest request);
}
