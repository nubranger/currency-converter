package com.example.currencyconverter.controllers;

import com.example.currencyconverter.model.Rate;
import com.example.currencyconverter.repository.RateRepository;
import com.example.currencyconverter.repository.UserLoggingRepository;
import com.example.currencyconverter.services.CurrencyService;
import com.example.currencyconverter.services.XMLService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import java.util.Map;

@Controller
public class CurrencyController {

    RateRepository rateRepository;
    UserLoggingRepository userLoggingRepository;
    XMLService xmlService;
    CurrencyService currencyService;

    public CurrencyController(RateRepository rateRepository, UserLoggingRepository userLoggingRepository, XMLService xmlService, CurrencyService currencyService) {
        this.rateRepository = rateRepository;
        this.userLoggingRepository = userLoggingRepository;
        this.xmlService = xmlService;
        this.currencyService = currencyService;
    }

    @GetMapping({"/", ""})
    public String getIndex(Model model,
                           @RequestParam(value = "selectedCurrencyCode", required = false) String selectedCurrencyCode,
                           @RequestParam(value = "amount", required = false) String amount) {

        Map<String, String> currencyMap = xmlService.getCurrencyList();
        List<Rate> currentFxRates = (List<Rate>) rateRepository.findAll();

        model.addAttribute("currentFxRates", currentFxRates);
        model.addAttribute("currencyMap", currencyMap);

        /**
         * Save to DB amount, currency, date and time entered and selected by user
         */
        currencyService.saveUserActivityToDb(amount, selectedCurrencyCode, currencyMap, userLoggingRepository);

        /**
         * If amount is null, empty not a number, default value will be 1
         */
        if (amount == null || amount.equals("") || !currencyService.isNumber(amount)) {
            model.addAttribute("amount", amount = "1");
        } else {
            model.addAttribute("amount", amount);
        }

        /**
         * If selected currency is null or empty, default currency will be USD
         */
        if (selectedCurrencyCode == null || selectedCurrencyCode.equals("")) {
            model.addAttribute("selectedCurrencyCode", selectedCurrencyCode = "USD");
        } else {
            model.addAttribute("selectedCurrencyCode", selectedCurrencyCode);
        }
        model.addAttribute("selectedCurrencyName", currencyMap.get(selectedCurrencyCode));

        /**
         * Get selected currency rate from DB
         */
        Double currencyRate = currencyService.getSelectedCurrencyRate(selectedCurrencyCode, currentFxRates);
        model.addAttribute("currencyRate", currencyRate);

        /**
         * Convert currency amount with BigDecimal class and convert to string
         */
        String currencyResult = currencyService.convertCurrency(amount, currencyRate);
        model.addAttribute("currencyResult", currencyResult);

        return "index";
    }
}