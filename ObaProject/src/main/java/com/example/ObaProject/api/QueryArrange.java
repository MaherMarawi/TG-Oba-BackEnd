package com.example.ObaProject.api;

import org.springframework.context.annotation.Configuration;

@Configuration
public class QueryArrange {

    public StringBuilder getQuery(String value) {
        String[] str =  value.split("-");
        StringBuilder query = new StringBuilder("");
        for (int i = 0; i < str.length; i++) {
            if (i < str.length - 1) {
                query.append(str[i] + "%20");
            }
            else
                query.append(str[i]);
        }
        return query;
    }
}
