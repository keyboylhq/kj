package com.example.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "couchdb")
public class CouchDbConfig {
    private String url;
    private String dbName;
    private String viewName;

    // Getters and setters
}
