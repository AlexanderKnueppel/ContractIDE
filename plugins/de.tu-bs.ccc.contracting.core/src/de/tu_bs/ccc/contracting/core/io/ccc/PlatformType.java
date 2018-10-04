//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.10.04 um 12:30:04 PM CEST 
//


package de.tu_bs.ccc.contracting.core.io.ccc;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für PlatformType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="PlatformType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="subsystem" type="{}SubsystemType" maxOccurs="unbounded"/>
 *         &lt;element name="comm" type="{}CommType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PlatformType", propOrder = {
    "subsystem",
    "comm"
})
public class PlatformType {

    @XmlElement(required = true)
    protected List<SubsystemType> subsystem;
    protected List<CommType> comm;

    /**
     * Gets the value of the subsystem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subsystem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubsystem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SubsystemType }
     * 
     * 
     */
    public List<SubsystemType> getSubsystem() {
        if (subsystem == null) {
            subsystem = new ArrayList<SubsystemType>();
        }
        return this.subsystem;
    }

    /**
     * Gets the value of the comm property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the comm property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getComm().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CommType }
     * 
     * 
     */
    public List<CommType> getComm() {
        if (comm == null) {
            comm = new ArrayList<CommType>();
        }
        return this.comm;
    }

}
