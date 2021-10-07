package com.example.ObaProject.configuration;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "application.api")
public class ApiConfig {

    private String url ;
    private String authorization;
    private String secretKey;
    private String sort;

    public String getSort() {
        return sort;
    }
    public String getUrl() {
        return url;
    }
    public String getAuthorization() {
        return authorization;
    }
    public String getSecretKey() {
        return secretKey;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }
    public void setUrl(String api) {
        this.url = api;
    }
    public void setAuthorization(String publicKey) {
        this.authorization = publicKey;
    }
    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }
}
