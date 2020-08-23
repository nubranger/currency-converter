package com.example.currencyconverter.services;

import com.example.currencyconverter.model.Rate;
import java.util.List;
import java.util.Map;

public interface XMLService {

    List<Rate> getCurrentFxRates();

    Map<String, String> getCurrencyList();
}
