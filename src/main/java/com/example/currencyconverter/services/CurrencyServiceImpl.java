package com.example.currencyconverter.services;

import com.example.currencyconverter.model.Rate;
import com.example.currencyconverter.repository.RateRepository;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    private RateRepository rateRepository;

    public CurrencyServiceImpl(RateRepository rateRepository) {
        this.rateRepository = rateRepository;
    }

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
    public Double getSelectedCurrencyRate(String selectedCurrencyCode) {

        Rate currencyRate = rateRepository.findByCurrency(selectedCurrencyCode);
        return currencyRate.getRate();
    }

    @Override
    public Boolean isNumber(String amount) {

        String regex = "^[0-9]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(amount);
        boolean result = matcher.matches();
        return result;
    }

    @Override
    public List<Rate> currentFxRates() {

        return (List<Rate>) rateRepository.findAll();
    }
}
