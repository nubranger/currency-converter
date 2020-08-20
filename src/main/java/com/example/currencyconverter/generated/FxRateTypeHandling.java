
package com.example.currencyconverter.generated;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FxRateTypeHandling.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="FxRateTypeHandling">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="LT"/>
 *     &lt;enumeration value="EU"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "FxRateTypeHandling")
@XmlEnum
public enum FxRateTypeHandling {


    /**
     * Foreign exchange rate in accordance to the Law on Accounting
     * 
     */
    LT,

    /**
     * Foreign exchange rate by date of publication
     * 
     */
    EU;

    public String value() {
        return name();
    }

    public static FxRateTypeHandling fromValue(String v) {
        return valueOf(v);
    }

}
