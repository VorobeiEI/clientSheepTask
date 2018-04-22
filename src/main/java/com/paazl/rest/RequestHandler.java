package com.paazl.rest;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.URISyntaxException;

//class with GET requests for server resources
@Component
public class RequestHandler {

    public HttpGet makingRequestForBalance() {
        HttpGet httpGet = null;
        try {
            URI uri = new URIBuilder()
                    .setScheme("http")
                    .setHost("localhost")
                    .setPort(8080)
                    .setPath("/rest/shepherdmanager/balance")
                    .build();

            httpGet = new HttpGet(uri);

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return httpGet;
    }

    public HttpGet makingRequestForSheepCondition() {
        HttpGet httpGet = null;
        try {
            URI uri = new URIBuilder()
                    .setScheme("http")
                    .setHost("localhost")
                    .setPort(8080)
                    .setPath("/rest/shepherdmanager/sheepConditions")
                    .build();

            httpGet = new HttpGet(uri);

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return httpGet;
    }

    public HttpGet makingRequestForBuyingSheeps(int nofSheepDesired) {
        HttpGet httpGet = null;
        try {
            URI uri = new URIBuilder()
                    .setScheme("http")
                    .setHost("localhost")
                    .setPort(8080)
                    .setPath("/rest/shepherdmanager/orderNewSheeps")
                    .setParameter("nofSheepDesired", String.valueOf(nofSheepDesired))
                    .build();

            httpGet = new HttpGet(uri);

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return httpGet;
    }
}
