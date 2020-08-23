package com.example.currencyconverter.services;

import com.example.currencyconverter.repository.UserLoggingRepository;
import com.example.currencyconverter.userlogging.UserLogging;
import org.springframework.stereotype.Service;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Service
public class UserLoggingServiceImpl implements UserLoggingService {

    private UserLoggingRepository userLoggingRepository;
    private XMLService  xmlService;

    public UserLoggingServiceImpl(UserLoggingRepository userLoggingRepository, XMLService xmlService) {
        this.userLoggingRepository = userLoggingRepository;
        this.xmlService = xmlService;
    }

    @Override
    public void saveUserActivityToDb(String amount, String selectedCurrencyCode) {
    Map<String, String> currencyMap = xmlService.getCurrencyList();
        if (amount != null && selectedCurrencyCode != null) {

            String datePattern = "yyyy-MM-dd HH:mm:ss";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(datePattern);
            String ldt = simpleDateFormat.format(new Date());

            UserLogging userLogging = new UserLogging();
            userLogging.setAmount(amount);
            userLogging.setSelectedCurrency(selectedCurrencyCode + " - " + currencyMap.get(selectedCurrencyCode));
            userLogging.setDateTime(ldt);
            userLoggingRepository.save(userLogging);
        }
    }
}
