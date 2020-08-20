
package com.example.currencyconverter.generated;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for FxRateHandling complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FxRateHandling">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Tp" type="{http://www.lb.lt/WebServices/FxRates}FxRateTypeHandling"/>
 *         &lt;element name="Dt" type="{http://www.lb.lt/WebServices/FxRates}ISODate"/>
 *         &lt;element name="CcyAmt" type="{http://www.lb.lt/WebServices/FxRates}CcyAmtHandling" maxOccurs="2" minOccurs="2"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FxRateHandling", propOrder = {
    "tp",
    "dt",
    "ccyAmt"
})
public class FxRateHandling {

    @XmlElement(name = "Tp", required = true)
    @XmlSchemaType(name = "string")
    protected FxRateTypeHandling tp;
    @XmlElement(name = "Dt", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dt;
    @XmlElement(name = "CcyAmt", required = true)
    protected List<CcyAmtHandling> ccyAmt;

    /**
     * Gets the value of the tp property.
     * 
     * @return
     *     possible object is
     *     {@link FxRateTypeHandling }
     *     
     */
    public FxRateTypeHandling getTp() {
        return tp;
    }

    /**
     * Sets the value of the tp property.
     * 
     * @param value
     *     allowed object is
     *     {@link FxRateTypeHandling }
     *     
     */
    public void setTp(FxRateTypeHandling value) {
        this.tp = value;
    }

    /**
     * Gets the value of the dt property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDt() {
        return dt;
    }

    /**
     * Sets the value of the dt property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDt(XMLGregorianCalendar value) {
        this.dt = value;
    }

    /**
     * Gets the value of the ccyAmt property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ccyAmt property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCcyAmt().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CcyAmtHandling }
     * 
     * 
     */
    public List<CcyAmtHandling> getCcyAmt() {
        if (ccyAmt == null) {
            ccyAmt = new ArrayList<CcyAmtHandling>();
        }
        return this.ccyAmt;
    }

}
