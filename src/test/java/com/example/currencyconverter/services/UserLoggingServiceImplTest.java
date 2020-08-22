package com.example.currencyconverter.services;

import com.example.currencyconverter.repository.UserLoggingRepository;
import com.example.currencyconverter.userlogging.UserLogging;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UserLoggingServiceImplTest {

    @Mock
    UserLoggingRepository userLoggingRepository;

    @Mock
    Map<String, String> currencyMap;

    @Mock
    XMLService  xmlService;

    @InjectMocks
    UserLoggingServiceImpl userLoggingServiceImpl;

    @Test
    void saveUserActivityToDb() {
        String datePattern = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(datePattern);
        String ldt = simpleDateFormat.format(new Date());
        UserLogging userLogging = new UserLogging();
        userLogging.setDateTime(ldt);
        userLogging.setAmount("100");
        userLogging.setSelectedCurrency("USD - null");
        userLoggingServiceImpl.saveUserActivityToDb("100", "USD");
        verify(userLoggingRepository).save(userLogging);

    }
}