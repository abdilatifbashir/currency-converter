package com.convert.xchangerate.endpoint;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import org.json.JSONException;
import org.json.JSONObject;

import com.convert.xchangerate.api.CurrencyNotSupportedException;
import com.convert.xchangerate.caching.CachingXchangeRate;
import com.convert.xchangerate.service.HttpMethods;
import com.convert.xchangerate.service.HttpserviceImpl;
import com.convert.xchangerate.service.ServiceException;
import com.convert.xchangerate.storage.DiskStore;
import com.convert.xchangerate.util.Currency;

public abstract class EndpointFactory extends CachingXchangeRate implements ServiceEndpoint {
        // the intermediate Currency
        public Currency baseCurrency;
        // used for executing requests to the (REST) api
        private HttpserviceImpl httpservice;
        protected JSONObject response;

        
}
