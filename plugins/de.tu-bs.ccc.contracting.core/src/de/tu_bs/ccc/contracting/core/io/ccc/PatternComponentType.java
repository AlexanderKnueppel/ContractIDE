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
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für PatternComponentType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="PatternComponentType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="requires" type="{}CompositeRequiresType" minOccurs="0"/>
 *         &lt;element name="route" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice maxOccurs="unbounded">
 *                   &lt;element name="service">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;extension base="{}ServiceType">
 *                           &lt;choice>
 *                             &lt;element name="external" type="{}RefType"/>
 *                             &lt;element name="child" type="{}NameType"/>
 *                           &lt;/choice>
 *                         &lt;/extension>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/choice>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="expose" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;all>
 *                   &lt;element name="service" type="{}ServiceType"/>
 *                 &lt;/all>
 *                 &lt;attribute name="ref" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="config" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
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
@XmlType(name = "PatternComponentType", propOrder = {
    "requires",
    "route",
    "expose",
    "config"
})
public class PatternComponentType {

    protected CompositeRequiresType requires;
    protected PatternComponentType.Route route;
    protected List<PatternComponentType.Expose> expose;
    protected Object config;
    @XmlAttribute(name = "name", required = true)
    protected String name;

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
     * Ruft den Wert der route-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PatternComponentType.Route }
     *     
     */
    public PatternComponentType.Route getRoute() {
        return route;
    }

    /**
     * Legt den Wert der route-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PatternComponentType.Route }
     *     
     */
    public void setRoute(PatternComponentType.Route value) {
        this.route = value;
    }

    /**
     * Gets the value of the expose property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the expose property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExpose().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PatternComponentType.Expose }
     * 
     * 
     */
    public List<PatternComponentType.Expose> getExpose() {
        if (expose == null) {
            expose = new ArrayList<PatternComponentType.Expose>();
        }
        return this.expose;
    }

    /**
     * Ruft den Wert der config-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getConfig() {
        return config;
    }

    /**
     * Legt den Wert der config-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setConfig(Object value) {
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
     *       &lt;all>
     *         &lt;element name="service" type="{}ServiceType"/>
     *       &lt;/all>
     *       &lt;attribute name="ref" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {

    })
    public static class Expose {

        @XmlElement(required = true)
        protected ServiceType service;
        @XmlAttribute(name = "ref")
        protected String ref;

        /**
         * Ruft den Wert der service-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link ServiceType }
         *     
         */
        public ServiceType getService() {
            return service;
        }

        /**
         * Legt den Wert der service-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link ServiceType }
         *     
         */
        public void setService(ServiceType value) {
            this.service = value;
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
     *         &lt;element name="service">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;extension base="{}ServiceType">
     *                 &lt;choice>
     *                   &lt;element name="external" type="{}RefType"/>
     *                   &lt;element name="child" type="{}NameType"/>
     *                 &lt;/choice>
     *               &lt;/extension>
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
    public static class Route {

        protected List<PatternComponentType.Route.Service> service;

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
         * {@link PatternComponentType.Route.Service }
         * 
         * 
         */
        public List<PatternComponentType.Route.Service> getService() {
            if (service == null) {
                service = new ArrayList<PatternComponentType.Route.Service>();
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
         *     &lt;extension base="{}ServiceType">
         *       &lt;choice>
         *         &lt;element name="external" type="{}RefType"/>
         *         &lt;element name="child" type="{}NameType"/>
         *       &lt;/choice>
         *     &lt;/extension>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "external",
            "child"
        })
        public static class Service
            extends ServiceType
        {

            protected RefType external;
            protected NameType child;

            /**
             * Ruft den Wert der external-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link RefType }
             *     
             */
            public RefType getExternal() {
                return external;
            }

            /**
             * Legt den Wert der external-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link RefType }
             *     
             */
            public void setExternal(RefType value) {
                this.external = value;
            }

            /**
             * Ruft den Wert der child-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link NameType }
             *     
             */
            public NameType getChild() {
                return child;
            }

            /**
             * Legt den Wert der child-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link NameType }
             *     
             */
            public void setChild(NameType value) {
                this.child = value;
            }

        }

    }

}
