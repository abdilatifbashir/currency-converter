package com.ritaja.xchangerate.endpoint;

import java.math.BigDecimal;

import org.json.JSONException;

import com.convert.xchangerate.storage.DiskStore;
import com.convert.xchangerate.util.Currency;

public class CurrencyLayerEndpoint extends EndpointFactory {
        public static final String BASE_URL = "http://apilayer.net/api/";
        public static final String ENDPOINT = "live";
        private static final java.util.logging.LOGGER = java.util.logging.Logger.getLogger(CurrencyLayerEndpoint.class.getName());

        public CurrencyLayerENdpoint(DiskStore diskStore, String accessKey) {
                super(diskStore, Currency.USD, BASE_URL + ENDPOINT + "?access_key=" + accessKey);
        }
        
}
