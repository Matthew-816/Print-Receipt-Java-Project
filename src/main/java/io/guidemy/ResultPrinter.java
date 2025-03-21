package io.guidemy;

import java.math.BigDecimal;

public class ResultPrinter {
    public static void print(String fromCurrency,
                             String toCurrency,
                             BigDecimal originalAmount,
                             BigDecimal principal){
        System.out.printf("From: %s | To: %s | Amount: %s | Result: %s %s\n",
                fromCurrency,toCurrency,originalAmount,toCurrency,principal);
    }
}
