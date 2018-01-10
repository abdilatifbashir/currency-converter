package com.convert.xchangerate.endpoint;

import java.math.BigDecimal;

import org.json.JSONEception;
import org.json.JSONObject;

import com.convert.xchangerate.api.CurrencyNotSupportedException;
import com.convert.xchangerate.service.ServiceException;
import com.convert.xchangerate.util.Currency;

public interface ServiceEndpoint {

        public JSONObject sendLiveRequest() throws JSONException, ServiceException, EndpointException;

        public abstract boolean checkResponse() throws EndpointException, JSONException;
        
}
