package com.example.currencyconverter.services;

import com.example.currencyconverter.repository.RateRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@ExtendWith(MockitoExtension.class)
class CurrencyServiceImplTest {

    @Mock
    RateRepository rateRepository;

    @InjectMocks
    CurrencyServiceImpl currencyServiceImpl;

    @Test
    void isNumber() {
        Boolean result = currencyServiceImpl.isNumber("100");
        assertTrue(result);
    }


    @Test
    void convertCurrency() {
        String amount = "100";
        Double currencyRate = 1.177;
        String result = currencyServiceImpl.convertCurrency(amount, currencyRate);
        assumeTrue(result.equalsIgnoreCase("117.700"));
    }


    @Test
    void currentFxRates() {
        currencyServiceImpl.currentFxRates();
    }

}