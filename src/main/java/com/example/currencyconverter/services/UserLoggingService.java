package com.example.currencyconverter.services;

public interface UserLoggingService {

    void saveUserActivityToDb(String amount, String selectedCurrencyCode);
}
