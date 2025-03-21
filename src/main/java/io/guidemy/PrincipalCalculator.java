package io.guidemy;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PrincipalCalculator {
    public BigDecimal compute(BigDecimal originalAmount,
                              BigDecimal effectiveExchangeRate){
        return originalAmount.multiply(effectiveExchangeRate).setScale(2, RoundingMode.HALF_UP);

    }
}
