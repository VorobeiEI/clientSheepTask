package com.paazl.rest;

import com.paazl.exception.ConnectionRefusedException;
import com.paazl.utils.ExceptionUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

//class with handling responses from server
@Component
public class ResponseHandler {
    private static final CloseableHttpClient client = HttpClients.createDefault();

    @Autowired
    private RequestHandler requestHandler;

    public String responseForBalanceRequest() throws ConnectionRefusedException {
        try {
            CloseableHttpResponse httpResponse = client.execute(requestHandler.makingRequestForBalance());
            HttpEntity httpEntity = httpResponse.getEntity();
            String response = EntityUtils.toString(httpEntity);
            return response;
        } catch (IOException e) {
            throw new ConnectionRefusedException(ExceptionUtils.textOfException());
        }
    }

    public String responseForSheepConditionsRequest() throws ConnectionRefusedException {
        try {
            HttpResponse httpResponse = client.execute(requestHandler.makingRequestForSheepCondition());
            HttpEntity httpEntity = httpResponse.getEntity();
            String response = EntityUtils.toString(httpEntity);
            return response;
        } catch (IOException e) {
            throw new ConnectionRefusedException(ExceptionUtils.textOfException());
        }
    }

    public String responseForBuyingSheepRequest(int nofSheepDesired) throws ConnectionRefusedException {
        try {
            HttpResponse httpResponse = client.execute(requestHandler.makingRequestForBuyingSheeps(nofSheepDesired));
            System.out.println(httpResponse.getStatusLine() + "here");
            HttpEntity httpEntity = httpResponse.getEntity();
            String response = EntityUtils.toString(httpEntity);
            return response;
        } catch (IOException e) {
            throw new ConnectionRefusedException(ExceptionUtils.textOfException());
        }
    }
}
