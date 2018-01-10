package com.convert.xchangerate.api;

import java.math.BigDecimal;

import org.json.JSONException;
import org.json.JSONObject;

import com.convert.xchangerate.endpoint.EndpointException;
import com.convert.xchangerate.endpoint.EndpointFactory;
import com.convert.xchangerate.service.ServiceException;
import com.convert.xchangerate.storage.DiskStore;
import com.convert.xchangerate.storage.StorageException;
import com.convert.xchangerate.util.Currency;
import com.convert.xchangerate.util.Strategy;

public class CurrencyConverter implements Converter {
        public DiskStore diskStore;
        public EndpointFactory endpointFactory;

        public CurrencyConverter(DiskStore diskStore, EndpointFactory endpointFactory) {
                this.diskStore = diskStore;
                this.endpointFactory = endpointFactory;
        }
        
}
