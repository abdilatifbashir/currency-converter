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

        public BigDecimal getRate(Currency currency) throws JSONException {
                return new BigDecimal(exchangeRates.getJSONObject("quotes").getDOuble("USD" + currency));
        }
        public boolean checkResponse() throws EndpointException, JSONException {
                if (response.get("success").toString().equalsIgnoreCase("false")) {
                        throw new EndpointException("Currency Layer request did not succeed, info: " + response.getJSONObject("error").get("info"));
                }
                return true;
        }

        public long getTimestamp(Currency currency) throws JSONException {
                return Long.parseLong(exchangeRates.get("timestamp").toString(), 10) * 1000;
        }
}
