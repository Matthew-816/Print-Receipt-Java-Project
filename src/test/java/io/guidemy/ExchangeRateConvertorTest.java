package io.guidemy;

import org.junit.Assert;
import org.junit.Assert.*;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExchangeRateConvertorTest {
    @Test
    public void shouldReturnEffectiveExchangeRate_GivenRatesAndFromEuro(){
        String fromCurrency="EUR";
        String toCurrency="USD";
        BigDecimal effectiveExchangeRate=new BigDecimal("1.0899");

        Map<String,BigDecimal>rates=new HashMap<>(){{
            put(toCurrency,new BigDecimal("1.0899"));

        }};

        ExchangeRateConvertor convertor=new ExchangeRateConvertor();

        BigDecimal actualEffectiveRate=convertor.convert(
                rates,fromCurrency,toCurrency
        );
        assertEquals(effectiveExchangeRate,actualEffectiveRate);
    }
    @Test
    public void shouldReturnEffectiveExchangeRate_GivenRatesAndToEuro(){
        String fromCurrency="USD";
        String toCurrency="EUR";
        BigDecimal effectiveExchangeRate=new BigDecimal("0.917515");

        Map<String,BigDecimal>rates=new HashMap<>(){{
            put(fromCurrency,new BigDecimal("1.0899"));
        }};

        ExchangeRateConvertor convertor=new ExchangeRateConvertor();

        BigDecimal actualEffectiveRate=convertor.convert(
                rates,fromCurrency,toCurrency
        );
        assertEquals(effectiveExchangeRate,actualEffectiveRate);
    }
    @Test
    public void shouldReturnEffectiveExchangeRate_GivenRatesAndOtherCurrency(){
        String fromCurrency="USD";
        String toCurrency="JPY";
        BigDecimal effectiveExchangeRate=new BigDecimal("143.655324");

        Map<String,BigDecimal>rates=new HashMap<>(){{
            put(fromCurrency,new BigDecimal("1.0899"));
            put(toCurrency,new BigDecimal("156.57"));
        }};

        ExchangeRateConvertor convertor=new ExchangeRateConvertor();

        BigDecimal actualEffectiveRate=convertor.convert(
                rates,fromCurrency,toCurrency
        );
        assertEquals(effectiveExchangeRate,actualEffectiveRate);
    }

}
