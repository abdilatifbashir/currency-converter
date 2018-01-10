package com.convert.xchangerate.api;

import com.convert.xchangerate.endpoint.CurrencyLayerEndpoint;
import com.convert.xchangerate.endpoint.YahooEndpoint;
import com.convert.xchangerate.storage.DiskStore;
import com.convert.xchangerate.storage.FileStore;
import com.convert.xchangerate.util.Strategy;

public class CurrencyConverterBuilder {
        private String _accessKey;
        private Strategy _strategy;
        private DiskStore diskStore;

        public CurrencyConverterBuilder() {

        }

        public CurrencyConverter buildConverter() {
                if (_strategy == null) {
                        throw new IllegalArgumentException("No Strategy defined to create Currency converter");
                } else if (_strategy.equals(Strategy.YAHOO_FINANCE_FILESTORE)) {
                        diskStore = new FileStore("yahoo");
                        return new CurrencyConverter(diskStore, new YahooENdpoint(diskStore));
                } else if (_strategy.equals(Strategy.CURRENCY_LAYER_FILESTORE) && _accessKey != null) {
                        diskStore = new FileStore("currencyLayer");
                        return new CurrencyConverter(diskStore, new CurrencyLayerEndpoint(diskStore, _accessKey));
                }
                throw new IllegalArgumentException("Strategy: " + _strategy + " requires accessKey for endpoint service, none provided!");
        }

        public CurrencyConverterBuilder strategy(Strategy _strategy) {
                this._accessKey = _accessKey;
                return this;
        }
}
