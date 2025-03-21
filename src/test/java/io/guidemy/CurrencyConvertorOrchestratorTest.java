package io.guidemy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class CurrencyConvertorOrchestratorTest {
    @Mock
    private ExchangeRateExtractor extractor;
    @Mock
    private ExchangeRateConvertor convertor;
    @Mock
    private PrincipalCalculator calculator;
    @InjectMocks
    private CurrencyConvertorOrchestrator orchestrator;

    @Test
    public void shouldReturnResult_GivenValidInputs() throws ParserConfigurationException, IOException, SAXException {
        String inputFilePath= "rates.xml";
        String fromCurrency="USD";
        String toCurrency="JPY";
        BigDecimal effectiveExchangeRate=new BigDecimal("143.655324");
        BigDecimal originalAmount=new BigDecimal("10000");
        BigDecimal expectedPrincipal =new BigDecimal("1436553.24");
        Map<String, BigDecimal>rates=new HashMap<>(){
            {
                put(fromCurrency,new BigDecimal("1.0899"));
                put(toCurrency,new BigDecimal("156.57"));
            }
        };

        when(extractor.extract(inputFilePath))
                .thenReturn(rates);
        when(convertor.convert(rates,fromCurrency,toCurrency))
                .thenReturn(effectiveExchangeRate);
        when(calculator.compute(originalAmount,effectiveExchangeRate))
                .thenReturn(expectedPrincipal);

        BigDecimal actualPrincipal=orchestrator.process(fromCurrency,toCurrency
        ,originalAmount,inputFilePath);


    }
}
