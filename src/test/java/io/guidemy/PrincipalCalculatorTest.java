package io.guidemy;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrincipalCalculatorTest {
    @Test
    public void shouldReturnPrincipal_GivenInputs(){
        BigDecimal effectiveExchangeRate=new BigDecimal("143.655324");
        BigDecimal originalAmount=new BigDecimal("10000");
        BigDecimal expectedPrincipal =new BigDecimal("1436553.24");

        PrincipalCalculator calculator=new PrincipalCalculator();

        BigDecimal actualPrincipal=calculator.compute(originalAmount,effectiveExchangeRate);

        assertEquals(expectedPrincipal,actualPrincipal);
    }
}
