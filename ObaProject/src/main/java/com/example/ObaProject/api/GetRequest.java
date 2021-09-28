package com.example.ObaProject.api;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;
import org.springframework.context.annotation.Configuration;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Date;

import org.json.*;



@Configuration
public class GetRequest {

    public Document sendRequest(String url) {



//        HttpClient client = HttpClient.newHttpClient();
//        HttpRequest request = HttpRequest.newBuilder()
//                .GET()
////                .header("authorization", "Bearer eyJ0eXAiOi")
////                .header("accept", "Content-Type: application/json;charset=utf-8")
//                .uri(URI.create(url))
//                .build();
//        HttpResponse<String> response = null;
//        try {
//            response = client.send(request, HttpResponse.BodyHandlers.ofString());
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        DocumentBuilderFactory factory =
//                DocumentBuilderFactory.newInstance();
//        DocumentBuilder dBuilder = null;
//        try {
//            dBuilder = factory.newDocumentBuilder();
//        } catch (ParserConfigurationException e) {
//            e.printStackTrace();
//        }
//        Document doc = null;
//        try {
//            doc = dBuilder.parse(new InputSource(new ByteArrayInputStream(response.body().getBytes("UTF-8"))));
//        } catch (SAXException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        doc.getDocumentElement().normalize();
//
//        return doc;

//        Request request = new Request.Builder()
//                .url(url)
//                .build();
//        OkHttpClient httpClient = new OkHttpClient();

        Document doc = null;
        Response response = send(url);
        DocumentBuilderFactory factory =
                DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = null;
        try {
            dBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        doc = null;
        try {
            doc = dBuilder.parse(new InputSource(new ByteArrayInputStream(response.body().bytes())));
//                return doc;
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        doc.getDocumentElement().normalize();
        return doc;
    }



    private static Response send(String url) {
        String g = "https://zoeken.oba.nl/api/v1/?i_public=1e19898c87464e239192c8bfe422f280&i_secret=4289fec4e962a33118340c888699438d#jwt";
            Request request = new Request.Builder()
                    .url(url)
                    .build();
            OkHttpClient httpClient = new OkHttpClient();
        Response response = null;
        try {
            response = httpClient.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;

    }



}
