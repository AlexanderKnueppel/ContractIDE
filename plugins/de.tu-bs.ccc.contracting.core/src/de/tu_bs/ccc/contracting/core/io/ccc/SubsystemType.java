//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.02.11 um 10:27:32 AM CET 
//


package de.tu_bs.ccc.contracting.core.io.ccc;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für SubsystemType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="SubsystemType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="provides" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence maxOccurs="unbounded">
 *                   &lt;element name="rte" type="{}NameType" minOccurs="0"/>
 *                   &lt;element name="spec" type="{}NameType" minOccurs="0"/>
 *                   &lt;element name="ram" type="{}QuantumType" minOccurs="0"/>
 *                   &lt;element name="caps" type="{}QuantumType" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="requires" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence maxOccurs="unbounded">
 *                   &lt;element name="comm" type="{}NameType" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="config" type="{}NameType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SubsystemType", propOrder = {
    "provides",
    "requires",
    "config"
})
public class SubsystemType {

    protected SubsystemType.Provides provides;
    protected SubsystemType.Requires requires;
    protected NameType config;
    @XmlAttribute(name = "name", required = true)
    protected String name;

    /**
     * Ruft den Wert der provides-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SubsystemType.Provides }
     *     
     */
    public SubsystemType.Provides getProvides() {
        return provides;
    }

    /**
     * Legt den Wert der provides-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SubsystemType.Provides }
     *     
     */
    public void setProvides(SubsystemType.Provides value) {
        this.provides = value;
    }

    /**
     * Ruft den Wert der requires-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SubsystemType.Requires }
     *     
     */
    public SubsystemType.Requires getRequires() {
        return requires;
    }

    /**
     * Legt den Wert der requires-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SubsystemType.Requires }
     *     
     */
    public void setRequires(SubsystemType.Requires value) {
        this.requires = value;
    }

    /**
     * Ruft den Wert der config-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link NameType }
     *     
     */
    public NameType getConfig() {
        return config;
    }

    /**
     * Legt den Wert der config-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link NameType }
     *     
     */
    public void setConfig(NameType value) {
        this.config = value;
    }

    /**
     * Ruft den Wert der name-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Legt den Wert der name-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }


    /**
     * <p>Java-Klasse für anonymous complex type.
     * 
     * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence maxOccurs="unbounded">
     *         &lt;element name="rte" type="{}NameType" minOccurs="0"/>
     *         &lt;element name="spec" type="{}NameType" minOccurs="0"/>
     *         &lt;element name="ram" type="{}QuantumType" minOccurs="0"/>
     *         &lt;element name="caps" type="{}QuantumType" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "rteAndSpecAndRam"
    })
    public static class Provides {

        @XmlElementRefs({
            @XmlElementRef(name = "caps", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "ram", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "spec", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "rte", type = JAXBElement.class, required = false)
        })
        protected List<JAXBElement<?>> rteAndSpecAndRam;

        /**
         * Gets the value of the rteAndSpecAndRam property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the rteAndSpecAndRam property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getRteAndSpecAndRam().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link JAXBElement }{@code <}{@link QuantumType }{@code >}
         * {@link JAXBElement }{@code <}{@link NameType }{@code >}
         * {@link JAXBElement }{@code <}{@link QuantumType }{@code >}
         * {@link JAXBElement }{@code <}{@link NameType }{@code >}
         * 
         * 
         */
        public List<JAXBElement<?>> getRteAndSpecAndRam() {
            if (rteAndSpecAndRam == null) {
                rteAndSpecAndRam = new ArrayList<JAXBElement<?>>();
            }
            return this.rteAndSpecAndRam;
        }

    }


    /**
     * <p>Java-Klasse für anonymous complex type.
     * 
     * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence maxOccurs="unbounded">
     *         &lt;element name="comm" type="{}NameType" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "comm"
    })
    public static class Requires {

        protected List<NameType> comm;

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
         * {@link NameType }
         * 
         * 
         */
        public List<NameType> getComm() {
            if (comm == null) {
                comm = new ArrayList<NameType>();
            }
            return this.comm;
        }

    }

}
