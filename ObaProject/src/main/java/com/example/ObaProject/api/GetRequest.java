package com.example.ObaProject.api;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.context.annotation.Configuration;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.IOException;


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

        Request request = new Request.Builder()
                .url(url)
                .build();
        OkHttpClient httpClient = new OkHttpClient();
        Document doc = null;
        try {
            Response response = httpClient.newCall(request).execute();
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
                System.out.println(response.body());
                doc = dBuilder.parse(new InputSource(new ByteArrayInputStream(response.body().bytes())));
//                return doc;
            } catch (SAXException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            doc.getDocumentElement().normalize();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return doc;
    }
}
