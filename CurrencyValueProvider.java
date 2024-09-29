package com.striim.ec;

import java.time.LocalDate;

public class CurrencyValueProvider {
    public static Double fxRate(String baseCurrency, String fxCurrency, LocalDate date) {

        return Double.valueOf((FxDB.getInstance().getCurrencyRateDB().get(fxCurrency.strip())).toString());
    }
}
