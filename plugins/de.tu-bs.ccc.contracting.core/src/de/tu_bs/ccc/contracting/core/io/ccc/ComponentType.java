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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für ComponentType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ComponentType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice minOccurs="0">
 *           &lt;element name="proxy" type="{}ProxyType"/>
 *           &lt;element name="filter" type="{}FilterType"/>
 *           &lt;element name="function" type="{}NameType"/>
 *           &lt;element name="mux" type="{}MuxType"/>
 *           &lt;element name="protocol" type="{}ProtocolType" maxOccurs="unbounded"/>
 *         &lt;/choice>
 *         &lt;element name="provides" type="{}ProvidesType" minOccurs="0"/>
 *         &lt;element name="requires" type="{}RequiresType" minOccurs="0"/>
 *         &lt;element name="timing" type="{}TimingType" minOccurs="0"/>
 *         &lt;element name="defaults" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="singleton" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="version" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ComponentType", propOrder = {
    "proxy",
    "filter",
    "function",
    "mux",
    "protocol",
    "provides",
    "requires",
    "timing",
    "defaults"
})
public class ComponentType {

    protected ProxyType proxy;
    protected FilterType filter;
    protected NameType function;
    protected MuxType mux;
    protected List<ProtocolType> protocol;
    protected ProvidesType provides;
    protected RequiresType requires;
    protected TimingType timing;
    protected Object defaults;
    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "singleton")
    protected Boolean singleton;
    @XmlAttribute(name = "version")
    protected String version;

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
     *     {@link ProvidesType }
     *     
     */
    public ProvidesType getProvides() {
        return provides;
    }

    /**
     * Legt den Wert der provides-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ProvidesType }
     *     
     */
    public void setProvides(ProvidesType value) {
        this.provides = value;
    }

    /**
     * Ruft den Wert der requires-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link RequiresType }
     *     
     */
    public RequiresType getRequires() {
        return requires;
    }

    /**
     * Legt den Wert der requires-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link RequiresType }
     *     
     */
    public void setRequires(RequiresType value) {
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
     * Ruft den Wert der defaults-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getDefaults() {
        return defaults;
    }

    /**
     * Legt den Wert der defaults-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setDefaults(Object value) {
        this.defaults = value;
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
     * Ruft den Wert der singleton-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSingleton() {
        return singleton;
    }

    /**
     * Legt den Wert der singleton-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSingleton(Boolean value) {
        this.singleton = value;
    }

    /**
     * Ruft den Wert der version-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Legt den Wert der version-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

}
