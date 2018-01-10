package com.convert.xchangerate.service;

import org.json.JSONException;
import org.json.JSONObject;

public interface HttpService {
        public JSONObject getResponse(HttpMethods method) throws JSONException, ServiceException;
}
