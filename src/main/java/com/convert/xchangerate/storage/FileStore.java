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

        public JSONObject loadRates() throws StorageException {
          // parse the JSON string from the resource file
          String jsonData = "";
          BufferdReader br = null;
          try {
                  String line;
                  br = new BufferedReader(new FileReader(resourceFilepath + ratesFilename));
                  while ((line = br.readLine()) != null) {
                          jsonData += line + "\n";
                  }
          } catch (IOException e) {
                  throw new StorageException(e);
          } finally  {
                  try {
                          if (br != null)
                                  br.close();
                  } catch (IOException ex) {
                          ex.printStackTrace();
                  }
          }
          // convert the parsed string to a JSON object
          try {
                  return new JSONObject(jsonData);
          } catch (JSONException e) {
                  throw new StorageException(e);
          }
        }
}
