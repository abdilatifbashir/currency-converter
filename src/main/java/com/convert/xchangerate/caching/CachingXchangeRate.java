package com.convert.xchangerate.caching;

import org.joda.time.DateTime;
import org.json.JSONException;
import org.json.JSONObject;

import com.convert.xchangerate.api.CurrencyNotSupportedException;
import com.convert.xchangerate.endpoint.EndpointException;
import com.convert.xchangerate.storage.DiskStore;
import com.convert.xchangerate.storage.StorageException;
import com.convert.xchangerate.util.Currency;

public abstract class CachingXchangeRate {

        public int refreshRateSeconds = 86400;
        public JSONObject exchangeRates = null;
        private DiskStore diskStore;

        public CachingXchangeRate(DiskStore diskStore) {
                this.diskStore = diskStore;
        }

        public void setExchangeRates(JSONObject exchangeRates) {
                this.exchangeRates=exchangeRates;
        }
}
