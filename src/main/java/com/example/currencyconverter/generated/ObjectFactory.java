
package com.example.currencyconverter.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the lt.mano.currency.generatedshemas package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CcyTbl_QNAME = new QName("http://www.lb.lt/WebServices/FxRates", "CcyTbl");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: lt.mano.currency.generatedshemas
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CcyTblType }
     * 
     */
    public CcyTblType createCcyTblType() {
        return new CcyTblType();
    }

    /**
     * Create an instance of {@link CcyNtryType }
     * 
     */
    public CcyNtryType createCcyNtryType() {
        return new CcyNtryType();
    }

    /**
     * Create an instance of {@link CcyNmType }
     * 
     */
    public CcyNmType createCcyNmType() {
        return new CcyNmType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CcyTblType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.lb.lt/WebServices/FxRates", name = "CcyTbl")
    public JAXBElement<CcyTblType> createCcyTbl(CcyTblType value) {
        return new JAXBElement<CcyTblType>(_CcyTbl_QNAME, CcyTblType.class, null, value);
    }

}
