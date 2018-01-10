package com.convert.xchangerate.endpoint;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.joda.time.DateTime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.convert.xchangerate.api.CurrencyNotSupportedException;
import com.convert.xchangerate.storage.DiskStore;
import com.convert.xchangerate.util.Currency;

public class YahooEndpoint extends EndpointFactory {
        public static final String BASE_URL = "http://finance.yahoo.com/webservice/v1/symbols/allcurrencies/";
        public static final String ENDPOINT = "quote";
        private Map rate = new HashMap();

        public YahooEndpoint(DiskStore diskStore) {
                super(diskStore, Currency.USD, BASE_URL + ENDPOINT + "?format=json");
        }

        
}
