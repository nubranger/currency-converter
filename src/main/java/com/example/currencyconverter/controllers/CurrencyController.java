package com.example.currencyconverter.controllers;

import com.example.currencyconverter.model.Rate;
import com.example.currencyconverter.repository.RateRepository;
import com.example.currencyconverter.repository.UserLoggingRepository;
import com.example.currencyconverter.services.XMLService;
import com.example.currencyconverter.userlogging.UserLogging;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class CurrencyController {

    RateRepository rateRepository;
    UserLoggingRepository userLoggingRepository;

    public CurrencyController(RateRepository rateRepository, UserLoggingRepository userLoggingRepository) {
        this.rateRepository = rateRepository;
        this.userLoggingRepository = userLoggingRepository;
    }

    @GetMapping("/")
    public String getIndex(Model model,
                           @RequestParam(value = "selectedCurrencyCode", required = false) String selectedCurrencyCode,
                           @RequestParam(value = "amount", required = false) String amount) {

        XMLService xmlService = new XMLService();
        Map<String, String> currencyMap = xmlService.getCurrencyList();
        List<Rate> currentFxRates = (List<Rate>) rateRepository.findAll();

        model.addAttribute("currentFxRates", currentFxRates);
        model.addAttribute("currencyMap", currencyMap);

        /**
         * Save to DB amount, currency, date and time entered and selected by user
         */
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

        /**
         * If amount is null or empty, default value will be 1
         */
        if (amount == null || amount.equals("")) {
            model.addAttribute("amount", amount = "1");
        } else {
            model.addAttribute("amount", amount);
        }

        /**
         * Check pattern (only numbers)
         */
        String regex = "^[0-9]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(amount);

        if (matcher.matches()) {
            model.addAttribute("amount", amount);
        } else {
            model.addAttribute("amount", amount = "1");
        }

        /**
         * If selected currency is null or empty, default currency will be USD
         */
        if (selectedCurrencyCode == null || selectedCurrencyCode.equals("")) {
            model.addAttribute("selectedCurrencyCode", selectedCurrencyCode = "USD");
            model.addAttribute("selectedCurrencyName", currencyMap.get(selectedCurrencyCode));
        } else {
            model.addAttribute("selectedCurrencyCode", selectedCurrencyCode);
            model.addAttribute("selectedCurrencyName", currencyMap.get(selectedCurrencyCode));
        }

        /**
         * Get selected currency rate from DB
         */
        Double currencyRate = null;
        for (Rate tmp : currentFxRates) {
            if (tmp.getCurrency().equals(selectedCurrencyCode)) {
                currencyRate = tmp.getRate();
            }
        }
        /**
         * Convert currency amount with BigDecimal class and convert to string
         */
        if (currencyRate != null) {
            BigDecimal bd1 = new BigDecimal(amount);
            BigDecimal bd2 = new BigDecimal(currencyRate);
            BigDecimal bd3 = bd1.multiply(bd2);
            DecimalFormat df = new DecimalFormat();
            df.setMaximumFractionDigits(3);
            df.setMinimumFractionDigits(3);

            String currencyResult = df.format(bd3);
            model.addAttribute("currencyResult", currencyResult);
            model.addAttribute("currencyRate", currencyRate);
        }

        return "index";
    }
}