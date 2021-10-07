package com.example.ObaProject.configuration;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "application.api")
public class ApiConfig {

    private String url ;
    private String authorization;
    private String secretKey;
    private String categorieen;
    private String sort;

    public ApiConfig() {
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getCategorieen() {
        return categorieen;
    }

    public void setCategorieen(String categorieen) {
        this.categorieen = categorieen;
    }



    public String getUrl() {
        return url;
    }
    public void setUrl(String api) {
        this.url = api;
    }
    public String getAuthorization() {
        return authorization;
    }
    public void setAuthorization(String publicKey) {
        this.authorization = publicKey;
    }
    public String getSecretKey() {
        return secretKey;
    }
    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }
}
