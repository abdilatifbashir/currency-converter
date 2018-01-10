package convert.xchangerate;

import java.math.BigDecimal;

import org.json.JSONException;
import org.junit.BeforeClass;
import org.testing.Assert;
import org.testing.annotations.Test;

import com.convert.xchangerate.api.CurrencyConverter;
import com.convert.xchangerate.api.CurrencyConverterBuilder;
import com.convert.xchangerate.api.CurrencyNotSupportedException;
import com.convert.xchangerate.endpoint.EndpointException;
import com.convert.xchangerate.service.ServiceException;
import com.convert.xchangerate.storage.StorageException;
import com.convert.xchangerate.util.Currency;
import com.convert.xchangerate.util.Strategy;
