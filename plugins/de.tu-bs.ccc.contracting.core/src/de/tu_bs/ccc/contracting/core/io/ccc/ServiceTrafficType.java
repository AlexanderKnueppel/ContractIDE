//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.02.11 um 10:27:32 AM CET 
//


package de.tu_bs.ccc.contracting.core.io.ccc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für ServiceTrafficType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ServiceTrafficType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="in-traffic" type="{}TrafficType" minOccurs="0"/>
 *         &lt;element name="out-traffic" type="{}TrafficType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceTrafficType", propOrder = {
    "inTraffic",
    "outTraffic"
})
@XmlSeeAlso({
    de.tu_bs.ccc.contracting.core.io.ccc.RequiresType.Service.class,
    de.tu_bs.ccc.contracting.core.io.ccc.ProvidesType.Service.class,
    de.tu_bs.ccc.contracting.core.io.ccc.CompositeRequiresType.Service.class,
    de.tu_bs.ccc.contracting.core.io.ccc.CompositeType.Provides.Service.class
})
public class ServiceTrafficType {

    @XmlElement(name = "in-traffic")
    protected TrafficType inTraffic;
    @XmlElement(name = "out-traffic")
    protected TrafficType outTraffic;

    /**
     * Ruft den Wert der inTraffic-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TrafficType }
     *     
     */
    public TrafficType getInTraffic() {
        return inTraffic;
    }

    /**
     * Legt den Wert der inTraffic-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TrafficType }
     *     
     */
    public void setInTraffic(TrafficType value) {
        this.inTraffic = value;
    }

    /**
     * Ruft den Wert der outTraffic-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TrafficType }
     *     
     */
    public TrafficType getOutTraffic() {
        return outTraffic;
    }

    /**
     * Legt den Wert der outTraffic-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TrafficType }
     *     
     */
    public void setOutTraffic(TrafficType value) {
        this.outTraffic = value;
    }

}
