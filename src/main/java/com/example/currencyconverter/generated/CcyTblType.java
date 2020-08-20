
package com.example.currencyconverter.generated;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for CcyTblType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CcyTblType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CcyNtry" type="{http://www.lb.lt/WebServices/FxRates}CcyNtryType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CcyTblType", namespace = "http://www.lb.lt/WebServices/FxRates", propOrder = {
    "ccyNtry"
})

@XmlRootElement(name="CcyTbl")
public class CcyTblType {

    @XmlElement(name = "CcyNtry", namespace = "http://www.lb.lt/WebServices/FxRates")
    protected List<CcyNtryType> ccyNtry;

    /**
     * Gets the value of the ccyNtry property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ccyNtry property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCcyNtry().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CcyNtryType }
     * 
     * 
     */
    public List<CcyNtryType> getCcyNtry() {
        if (ccyNtry == null) {
            ccyNtry = new ArrayList<CcyNtryType>();
        }
        return this.ccyNtry;
    }

}
