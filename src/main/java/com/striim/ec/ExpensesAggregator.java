package com.striim.ec;

import java.util.List;

public class ExpensesAggregator {
    public void showAggregatedExpense(List<ExpensesModel> expensesModelList) {
        String baseCurrency = (String) FxDB.getCurrencyRateDB().get("BASE_CURRENCY");
        double total = expensesModelList.stream().mapToDouble(x -> {
            return x.getAmount() * CurrencyValueProvider.fxRate(baseCurrency, x.getCurrencyType(), x.getDate());
        }).sum();
        System.out.println("Total Expense: " + total + " " + baseCurrency);
    }
}