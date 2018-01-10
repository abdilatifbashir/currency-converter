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

@Test
public class ConversionTest {
  private CurrencyConverter converter;

  @BeforeClass
  public void setup() {
    converter = new CurrencyConverterBuilder()
                    .strategy(Strategy.YAHOO_FINANCE_FILESTORE)
                    .accessKey("")
                    .buildConverter();
    converter.setRefreshRateSeconds(86400);
  }

  
}
