package com.convert.xchangerate.api;

import java.math.BigDecimal;

import org.json.JSONException;

import com.convert.xchangerate.endpoint.EndpointException;
import com.convert.xchangerate.service.ServiceException;
import com.convert.xchangerate.storage.StorageException;
import com.convert.xchangerate.util.Currency;

public interface Converter {

        public BigDecimal convertCurrency(BigDecimal moneyAmount, Currency fromCurrency, Currency toCurrency) throws CurrencyNotSupportedException, JSONException, StorageException, EndpointException, ServiceException;
}
