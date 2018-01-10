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
}
