package com.example.currencyconverter.services;

import com.example.currencyconverter.generated.*;
import com.example.currencyconverter.model.Rate;
import org.springframework.stereotype.Service;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class XMLServiceImpl implements XMLService {

    /**
     * Add currency data from xml to the list
     */
    @Override
    public List<Rate> getCurrentFxRates() {

        List<Rate> rates = new ArrayList<>();

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(FxRatesHandling.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:78.0) Gecko/20100101 Firefox/78.0";

            URL url = new URL("https://www.lb.lt/webservices/fxrates/FxRates.asmx/getCurrentFxRates?tp=eu");

            HttpURLConnection http = (HttpURLConnection) url.openConnection();

            http.setRequestProperty("User-Agent", userAgent);

            InputStream is = http.getInputStream();

            FxRatesHandling fxRatesHandling = (FxRatesHandling) jaxbUnmarshaller.unmarshal(is);

            for (FxRateHandling tmpRate1 : fxRatesHandling.getFxRate()) {
                Rate rate = new Rate();

                for (CcyAmtHandling tmpRate2 : tmpRate1.getCcyAmt()) {
                    rate.setCurrency(tmpRate2.getCcy().toString());
                    rate.setRate(tmpRate2.getAmt().doubleValue());
                }
                rates.add(rate);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return rates;
    }

    /**
     * Add currency name to the list
     */
    @Override
    public Map<String, String> getCurrencyList() {

        Map<String, String> currencyList = new HashMap<>();

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(CcyTblType.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            URL url = new URL("https://www.lb.lt//webservices/fxrates/FxRates.asmx/getCurrencyList?");

            String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:78.0) Gecko/20100101 Firefox/78.0";

            HttpURLConnection http = (HttpURLConnection) url.openConnection();

            http.setRequestProperty("User-Agent", userAgent);

            InputStream is = http.getInputStream();

            CcyTblType ccyTblType = (CcyTblType) jaxbUnmarshaller.unmarshal(is);

            String code;
            String name = null;

            for (CcyNtryType tmp1 : ccyTblType.getCcyNtry()) {

                code = tmp1.getCcy();
                for (CcyNmType tmp2 : tmp1.getCcyNm()) {

                    if (tmp2.getLang().equals("EN")) {
                        name = tmp2.getValue();
                    }
                }
                currencyList.put(code, name.toUpperCase());
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return currencyList;
    }
}
