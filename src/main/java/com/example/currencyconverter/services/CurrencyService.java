package com.example.currencyconverter.services;

import com.example.currencyconverter.model.Rate;
import java.util.List;

public interface CurrencyService {

    String convertCurrency(String amount, Double currencyRate);

    Double getSelectedCurrencyRate(String selectedCurrencyCode);

    Boolean isNumber(String amount);

    List<Rate>currentFxRates();

}
