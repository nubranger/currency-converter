package com.example.currencyconverter.services;

import com.example.currencyconverter.model.Rate;
import com.example.currencyconverter.repository.UserLoggingRepository;
import java.util.List;
import java.util.Map;

public interface CurrencyService {

    String convertCurrency(String amount, Double currencyRate);

    Double getSelectedCurrencyRate(String selectedCurrencyCode, List<Rate> currentFxRates);

    void saveUserActivityToDb(String amount, String selectedCurrencyCode, Map<String, String> currencyMap, UserLoggingRepository userLoggingRepository);

    Boolean isNumber(String amount);

}
