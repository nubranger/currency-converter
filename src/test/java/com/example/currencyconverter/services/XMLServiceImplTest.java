package com.example.currencyconverter.services;

import com.example.currencyconverter.model.Rate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class XMLServiceImplTest {

    @InjectMocks
    XMLServiceImpl xmlServiceImpl;

    @Test
    void getCurrentFxRates() {
        List<Rate> result = xmlServiceImpl.getCurrentFxRates();
        assertNotNull(result);
    }

    @Test
    void getCurrencyList() {
        Map<String, String> result = xmlServiceImpl.getCurrencyList();
        assertNotNull(result);
    }
}