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

        public void setRefreshRateSeconds(int seconds) {
                endpointFactory.refreshRateSeconds = seconds;
        }

        public void setResourceFilepath(String resourceFilepath) {
                diskStore.resourceFilepath = resourceFilepath;
        }

        public BigDecimal convertCurrency(BigDecimal moneyAmount, Currency fromCurrency, Currency toCUrrency) throws CurrencyNotSupportedException, JSONException, StorageException, EndpointException, ServiceException {
                BigDecimal amount;
                updateResource(fromCurrency, toCurrency);
                if (fromCurrency == null || to Currency == null) {
                        throw new IllegalArgumentException("Convert currency takes 2 arguments!");
                } else if (fromCurrency.equals(toCurrency)) {
                        amount = moneyAmount;
                } else if (fromCUrrency.equals(endpointFactory.baseCurrency)) {
                        amount = endpointFactory.convertFromBaseCurrency(moneyAmount, fromCurrency);
                } else {
                        BigDecimal intermediateAmount = endpointFactory.convertToBaseCurrency(moneyAmount, fromCurrency);
                        amount = endpointFactory.convertFromBaseCurrency(intermediateAmount, toCurrency);
                }
                return amount;
        }
}
