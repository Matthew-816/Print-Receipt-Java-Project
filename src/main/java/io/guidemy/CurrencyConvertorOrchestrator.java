package io.guidemy;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;

public class CurrencyConvertorOrchestrator {
    private ExchangeRateConvertor convertor;
    private ExchangeRateExtractor extractor;
    private PrincipalCalculator calculator;

    public CurrencyConvertorOrchestrator(ExchangeRateConvertor convertor,
                                         ExchangeRateExtractor extractor,
                                         PrincipalCalculator calculator) {
        this.convertor = convertor;
        this.extractor = extractor;
        this.calculator = calculator;
    }

    public BigDecimal process(String fromCurrency,
                              String toCurrency,
                              BigDecimal originalAmount,
                              String inputFilePath) throws ParserConfigurationException, IOException, SAXException {
        Map<String,BigDecimal>rates=extractor.extract(inputFilePath);
        BigDecimal effectiveExchangeRate=convertor.convert(
                rates,fromCurrency,toCurrency
        );
        BigDecimal principal=calculator.compute(
                originalAmount,effectiveExchangeRate
        );
        return principal;
    }
}
