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

        public boolean checkRatesUsable(Currency currency) throws JSONException, CurrencyNotSupportedException, StorageException {
                if (!diskStore.resourceExists()) {
                        return false;
                } else if (exchangeRates == null) {
                        setExchangeRates(diskStore.loadRates());
                }
                // calculate the difference in timestamp and return false if not expired
                long old = getTimestamp(currency);
                long now = new DateTime().getMillis();
                if (Math.abs((old - now) / 1000) < (refreshRateSeconds)) {
                        return true;
                }
                // return true if the timestamp has expired
                return false;
        }

        
}
