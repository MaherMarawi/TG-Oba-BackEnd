package com.example.ObaProject.api;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "application.api")
public class ApiConfig {

    private String url ;
    private String publicKey;
    private String secretKey;
    private String categorieen;

    public ApiConfig() {
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
    public String getPublicKey() {
        return publicKey;
    }
    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }
    public String getSecretKey() {
        return secretKey;
    }
    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }
}
