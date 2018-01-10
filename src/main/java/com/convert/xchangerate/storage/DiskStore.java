package com.convert.xchangerate.storage;

import org.json.JSONObject;

public abstract class DiskStore {
        public String resourceFilepath = System.getProperty("java.io.tmpdir");

        public abstract void saveRates(JSONObject exchangeRates) throws StorageException;

        public abstract JSONObject loadRates() throws StorageException;

        public abstract boolean resourceExists();
}
