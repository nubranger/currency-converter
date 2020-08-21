package com.example.currencyconverter.services;

import com.example.currencyconverter.model.Rate;
import com.example.currencyconverter.repository.UserLoggingRepository;
import com.example.currencyconverter.userlogging.UserLogging;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class CurrencyServiceImpl implements CurrencyService {
    @Override
    public String convertCurrency(String amount, Double currencyRate) {
        String currencyResult = "";

        if (currencyRate != null) {
            BigDecimal bd1 = new BigDecimal(amount);
            BigDecimal bd2 = new BigDecimal(currencyRate);
            BigDecimal bd3 = bd1.multiply(bd2);
            DecimalFormat df = new DecimalFormat();
            df.setMaximumFractionDigits(3);
            df.setMinimumFractionDigits(3);

            currencyResult = df.format(bd3);
        }
        return currencyResult;
    }

    @Override
    public Double getSelectedCurrencyRate(String selectedCurrencyCode, List<Rate> currentFxRates) {
        Double currencyRate = null;
        for (Rate tmp : currentFxRates) {
            if (tmp.getCurrency().equals(selectedCurrencyCode)) {
                currencyRate = tmp.getRate();
            }
        }
        return currencyRate;
    }

    @Override
    public void saveUserActivityToDb(String amount, String selectedCurrencyCode, Map<String, String> currencyMap, UserLoggingRepository userLoggingRepository) {
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

    @Override
    public Boolean isNumber(String amount) {
        String regex = "^[0-9]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(amount);
        boolean result = matcher.matches();

        return result;
    }
}
