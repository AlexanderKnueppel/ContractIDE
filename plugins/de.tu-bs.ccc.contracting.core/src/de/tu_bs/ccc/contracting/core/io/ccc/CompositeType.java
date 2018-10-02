//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.10.01 um 01:36:06 PM CEST 
//


package de.tu_bs.ccc.contracting.core.io.ccc;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für CompositeType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CompositeType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice minOccurs="0">
 *           &lt;element name="proxy" type="{}ProxyType"/>
 *           &lt;element name="filter" type="{}FilterType"/>
 *           &lt;element name="mux" type="{}MuxType"/>
 *           &lt;element name="function" type="{}NameType"/>
 *           &lt;element name="protocol" type="{}ProtocolType" maxOccurs="unbounded"/>
 *         &lt;/choice>
 *         &lt;element name="provides" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice maxOccurs="unbounded">
 *                   &lt;element name="service" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="max_clients" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="filter" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="ref" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/choice>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="requires" type="{}CompositeRequiresType" minOccurs="0"/>
 *         &lt;element name="timing" type="{}TimingType" minOccurs="0"/>
 *         &lt;element name="pattern" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice maxOccurs="unbounded">
 *                   &lt;element name="component" type="{}PatternComponentType" maxOccurs="unbounded"/>
 *                 &lt;/choice>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CompositeType", propOrder = {
    "proxy",
    "filter",
    "mux",
    "function",
    "protocol",
    "provides",
    "requires",
    "timing",
    "pattern"
})
public class CompositeType {

    protected ProxyType proxy;
    protected FilterType filter;
    protected MuxType mux;
    protected NameType function;
    protected List<ProtocolType> protocol;
    protected CompositeType.Provides provides;
    protected CompositeRequiresType requires;
    protected TimingType timing;
    @XmlElement(required = true)
    protected List<CompositeType.Pattern> pattern;
    @XmlAttribute(name = "name")
    protected String name;

    /**
     * Ruft den Wert der proxy-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ProxyType }
     *     
     */
    public ProxyType getProxy() {
        return proxy;
    }

    /**
     * Legt den Wert der proxy-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ProxyType }
     *     
     */
    public void setProxy(ProxyType value) {
        this.proxy = value;
    }

    /**
     * Ruft den Wert der filter-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link FilterType }
     *     
     */
    public FilterType getFilter() {
        return filter;
    }

    /**
     * Legt den Wert der filter-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link FilterType }
     *     
     */
    public void setFilter(FilterType value) {
        this.filter = value;
    }

    /**
     * Ruft den Wert der mux-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MuxType }
     *     
     */
    public MuxType getMux() {
        return mux;
    }

    /**
     * Legt den Wert der mux-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MuxType }
     *     
     */
    public void setMux(MuxType value) {
        this.mux = value;
    }

    /**
     * Ruft den Wert der function-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link NameType }
     *     
     */
    public NameType getFunction() {
        return function;
    }

    /**
     * Legt den Wert der function-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link NameType }
     *     
     */
    public void setFunction(NameType value) {
        this.function = value;
    }

    /**
     * Gets the value of the protocol property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the protocol property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProtocol().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProtocolType }
     * 
     * 
     */
    public List<ProtocolType> getProtocol() {
        if (protocol == null) {
            protocol = new ArrayList<ProtocolType>();
        }
        return this.protocol;
    }

    /**
     * Ruft den Wert der provides-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CompositeType.Provides }
     *     
     */
    public CompositeType.Provides getProvides() {
        return provides;
    }

    /**
     * Legt den Wert der provides-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CompositeType.Provides }
     *     
     */
    public void setProvides(CompositeType.Provides value) {
        this.provides = value;
    }

    /**
     * Ruft den Wert der requires-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CompositeRequiresType }
     *     
     */
    public CompositeRequiresType getRequires() {
        return requires;
    }

    /**
     * Legt den Wert der requires-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CompositeRequiresType }
     *     
     */
    public void setRequires(CompositeRequiresType value) {
        this.requires = value;
    }

    /**
     * Ruft den Wert der timing-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TimingType }
     *     
     */
    public TimingType getTiming() {
        return timing;
    }

    /**
     * Legt den Wert der timing-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TimingType }
     *     
     */
    public void setTiming(TimingType value) {
        this.timing = value;
    }

    /**
     * Gets the value of the pattern property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pattern property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPattern().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CompositeType.Pattern }
     * 
     * 
     */
    public List<CompositeType.Pattern> getPattern() {
        if (pattern == null) {
            pattern = new ArrayList<CompositeType.Pattern>();
        }
        return this.pattern;
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
     *       &lt;choice maxOccurs="unbounded">
     *         &lt;element name="component" type="{}PatternComponentType" maxOccurs="unbounded"/>
     *       &lt;/choice>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "component"
    })
    public static class Pattern {

        protected List<PatternComponentType> component;

        /**
         * Gets the value of the component property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the component property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getComponent().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link PatternComponentType }
         * 
         * 
         */
        public List<PatternComponentType> getComponent() {
            if (component == null) {
                component = new ArrayList<PatternComponentType>();
            }
            return this.component;
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
     *       &lt;choice maxOccurs="unbounded">
     *         &lt;element name="service" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="max_clients" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="filter" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="ref" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/choice>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "service"
    })
    public static class Provides {

        protected List<CompositeType.Provides.Service> service;

        /**
         * Gets the value of the service property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the service property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getService().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link CompositeType.Provides.Service }
         * 
         * 
         */
        public List<CompositeType.Provides.Service> getService() {
            if (service == null) {
                service = new ArrayList<CompositeType.Provides.Service>();
            }
            return this.service;
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
         *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="max_clients" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="filter" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="ref" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class Service {

            @XmlAttribute(name = "name", required = true)
            protected String name;
            @XmlAttribute(name = "max_clients")
            protected String maxClients;
            @XmlAttribute(name = "filter")
            protected String filter;
            @XmlAttribute(name = "ref")
            protected String ref;

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
             * Ruft den Wert der maxClients-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getMaxClients() {
                return maxClients;
            }

            /**
             * Legt den Wert der maxClients-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setMaxClients(String value) {
                this.maxClients = value;
            }

            /**
             * Ruft den Wert der filter-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getFilter() {
                return filter;
            }

            /**
             * Legt den Wert der filter-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setFilter(String value) {
                this.filter = value;
            }

            /**
             * Ruft den Wert der ref-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getRef() {
                return ref;
            }

            /**
             * Legt den Wert der ref-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setRef(String value) {
                this.ref = value;
            }

        }

    }

}
