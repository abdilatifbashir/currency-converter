package com.convert.xchangerate.storage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

public class FileStore extends DiskStore {
        protected String ratesFilename;

        public FileStore(String filenameAppender) {
                this.ratesFilename = System.getProperty("file.separator") + filenameAppender + "XchangeRates.json";
        }

        public void saveRates(JSONObject exchangeRates) throws StorageException {
                if (exchangeRates == null) {
                        throw new StorageException("Cannot save null exchangeRates!");

                }
                try {
                        FileWriter file = new FileWriter(resourceFilepath + ratesFilename);
                        file.write(exchangeRates.toString());
                        file.flush();
                        file.close();
                } catch (IOException e) {
                        throw new StorageException(e);
                }
        }
}
