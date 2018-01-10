package com.convert.xchangerate.util;

import com.convert.xchangerate.endpoint.YahooEndpoint;
import com.convert.xchangerate.storage.FileStore;

public enum Strategy {
        YAHOO_FINANCE_FILESTORE("YAHOO_FINANCE_FILESTORE"),

        CURRENCY_LAYER_FILESTORE("CURRENCY_LAYER_FILESTORE");

        private final String strategy;

        private Strategy(String strategy) {
                this.strategy = strategy;
        }

        public String toString() {
                return this.strategy;
        }
}
