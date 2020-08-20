
package com.example.currencyconverter.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for CcyNtryType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CcyNtryType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Ccy" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CcyNm" type="{http://www.lb.lt/WebServices/FxRates}CcyNmType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="CcyNbr" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CcyMnrUnts">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="0"/>
 *               &lt;enumeration value="2"/>
 *               &lt;enumeration value="3"/>
 *               &lt;enumeration value="5"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CcyNtryType", namespace = "http://www.lb.lt/WebServices/FxRates", propOrder = {
    "ccy",
    "ccyNm",
    "ccyNbr",
    "ccyMnrUnts"
})
public class CcyNtryType {

    @XmlElement(name = "Ccy", namespace = "http://www.lb.lt/WebServices/FxRates", required = true)
    protected String ccy;
    @XmlElement(name = "CcyNm", namespace = "http://www.lb.lt/WebServices/FxRates")
    protected List<CcyNmType> ccyNm;
    @XmlElement(name = "CcyNbr", namespace = "http://www.lb.lt/WebServices/FxRates", required = true)
    protected String ccyNbr;
    @XmlElement(name = "CcyMnrUnts", namespace = "http://www.lb.lt/WebServices/FxRates", required = true)
    protected String ccyMnrUnts;

    /**
     * Gets the value of the ccy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCcy() {
        return ccy;
    }

    /**
     * Sets the value of the ccy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCcy(String value) {
        this.ccy = value;
    }

    /**
     * Gets the value of the ccyNm property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ccyNm property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCcyNm().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CcyNmType }
     * 
     * 
     */
    public List<CcyNmType> getCcyNm() {
        if (ccyNm == null) {
            ccyNm = new ArrayList<CcyNmType>();
        }
        return this.ccyNm;
    }

    /**
     * Gets the value of the ccyNbr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCcyNbr() {
        return ccyNbr;
    }

    /**
     * Sets the value of the ccyNbr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCcyNbr(String value) {
        this.ccyNbr = value;
    }

    /**
     * Gets the value of the ccyMnrUnts property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCcyMnrUnts() {
        return ccyMnrUnts;
    }

    /**
     * Sets the value of the ccyMnrUnts property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCcyMnrUnts(String value) {
        this.ccyMnrUnts = value;
    }

}
