package io.guidemy;

import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExchangeRateExtractorTest {
    @Test
    public void shouldReturnRates_GivenInputFilePath() throws ParserConfigurationException, IOException, SAXException {
        String inputFilePath = "src/test/resources/rates.xml ";
        Map<String, BigDecimal> expectedRate = new HashMap<>() {{
            put("USD", new BigDecimal("1.0562"));
            put("JPY", new BigDecimal("158.64"));
            put("BGN", new BigDecimal("1.9558"));
            put("CZK", new BigDecimal("25.256"));
            put("DKK", new BigDecimal("7.4579"));
            put("GBP", new BigDecimal("0.83205"));
            put("HUF", new BigDecimal("411.75"));
            put("PLN", new BigDecimal("4.2960"));
            put("RON", new BigDecimal("4.9774"));
            put("SEK", new BigDecimal("11.5180"));
            put("CHF", new BigDecimal("0.9309"));
            put("ISK", new BigDecimal("145.70"));
            put("NOK", new BigDecimal("11.6805"));
            put("TRY", new BigDecimal("36.6390"));
            put("AUD", new BigDecimal("1.6245"));
            put("BRL", new BigDecimal("6.4361"));
            put("CAD", new BigDecimal("1.4796"));
            put("CNY", new BigDecimal("7.6484"));
            put("HKD", new BigDecimal("8.2211"));
            put("IDR", new BigDecimal("16753.81"));
            put("ILS", new BigDecimal("3.8411"));
            put("INR", new BigDecimal("89.3245"));
            put("KRW", new BigDecimal("1476.11"));
            put("MXN", new BigDecimal("21.5370"));
            put("MYR", new BigDecimal("4.6948"));
            put("NZD", new BigDecimal("1.7873"));
            put("PHP", new BigDecimal("61.939"));
            put("SGD", new BigDecimal("1.4159"));
            put("THB", new BigDecimal("36.217"));
            put("ZAR", new BigDecimal("19.0777"));
        }};

        ExchangeRateExtractor extractor = new ExchangeRateExtractor();
        Map<String, BigDecimal> rates = extractor.extract(inputFilePath);

        assertEquals(expectedRate, rates);
    }

}
