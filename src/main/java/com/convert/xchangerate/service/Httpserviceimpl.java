package com.convert.xchangerate.service;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class HttpserviceImpl implements HttpService {
        // used for executing requests to the (REST) API
        private CloseableHttpClient httpClient;
        private String uri;
        private HttpRequestBase httpMethod;

        public HttpserviceImpl(String uri) {
                this.uri = uri;
        }

        
}
