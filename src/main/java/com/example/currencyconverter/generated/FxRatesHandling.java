
package com.example.currencyconverter.generated;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * List of foreign exchange rates or technical error report
 * 
 * <p>Java class for FxRatesHandling complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FxRatesHandling">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="FxRate" type="{http://www.lb.lt/WebServices/FxRates}FxRateHandling" maxOccurs="unbounded"/>
 *           &lt;element name="OprlErr" type="{http://www.lb.lt/WebServices/FxRates}OprlErrHandling"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FxRatesHandling", propOrder = {
    "fxRate",
    "oprlErr"
})

@XmlRootElement(name="FxRates")
public class FxRatesHandling {

    @XmlElement(name = "FxRate")
    protected List<FxRateHandling> fxRate;
    @XmlElement(name = "OprlErr")
    protected OprlErrHandling oprlErr;

    /**
     * Gets the value of the fxRate property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fxRate property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFxRate().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FxRateHandling }
     * 
     * 
     */
    public List<FxRateHandling> getFxRate() {
        if (fxRate == null) {
            fxRate = new ArrayList<FxRateHandling>();
        }
        return this.fxRate;
    }

    /**
     * Gets the value of the oprlErr property.
     * 
     * @return
     *     possible object is
     *     {@link OprlErrHandling }
     *     
     */
    public OprlErrHandling getOprlErr() {
        return oprlErr;
    }

    /**
     * Sets the value of the oprlErr property.
     * 
     * @param value
     *     allowed object is
     *     {@link OprlErrHandling }
     *     
     */
    public void setOprlErr(OprlErrHandling value) {
        this.oprlErr = value;
    }

}
