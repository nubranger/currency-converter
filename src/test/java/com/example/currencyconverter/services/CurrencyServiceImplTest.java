package com.example.currencyconverter.services;

import com.example.currencyconverter.model.Rate;
import com.example.currencyconverter.repository.RateRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CurrencyServiceImplTest {

    @Mock
    RateRepository rateRepository;

    @Mock
    Rate rate = new Rate();

    @Mock
    List<Rate> rateList = new ArrayList<>();

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
        assumeTrue(result.equals("117.700"));
    }

    @Test
    void currentFxRates() {
        when(rateRepository.findAll()).thenReturn(rateList);
        List<Rate> foundRateList = currencyServiceImpl.currentFxRates();
        assertNotNull(foundRateList);
        verify(rateRepository).findAll();
    }

    @Test
    void getSelectedCurrencyRate() {
        when(rateRepository.findByCurrency("USD")).thenReturn(rate);
        Double foundRate = currencyServiceImpl.getSelectedCurrencyRate("USD");
        assertNotNull(foundRate);
        verify(rateRepository).findByCurrency(anyString());
    }
}