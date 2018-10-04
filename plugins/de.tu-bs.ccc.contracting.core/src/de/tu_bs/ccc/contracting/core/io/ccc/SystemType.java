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
 * <p>Java-Klasse für SystemType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="SystemType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice maxOccurs="unbounded">
 *           &lt;element name="child">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                   &lt;sequence>
 *                     &lt;choice>
 *                       &lt;element name="function" type="{}NameType"/>
 *                       &lt;element name="component" type="{}NameType"/>
 *                     &lt;/choice>
 *                     &lt;element name="dependency" minOccurs="0">
 *                       &lt;complexType>
 *                         &lt;complexContent>
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                             &lt;choice maxOccurs="unbounded">
 *                               &lt;element name="child">
 *                                 &lt;complexType>
 *                                   &lt;complexContent>
 *                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;/restriction>
 *                                   &lt;/complexContent>
 *                                 &lt;/complexType>
 *                               &lt;/element>
 *                             &lt;/choice>
 *                           &lt;/restriction>
 *                         &lt;/complexContent>
 *                       &lt;/complexType>
 *                     &lt;/element>
 *                     &lt;element name="route" minOccurs="0">
 *                       &lt;complexType>
 *                         &lt;complexContent>
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                             &lt;choice maxOccurs="unbounded">
 *                               &lt;element name="service">
 *                                 &lt;complexType>
 *                                   &lt;complexContent>
 *                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                       &lt;all>
 *                                         &lt;element name="child" type="{}NameType"/>
 *                                       &lt;/all>
 *                                       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                       &lt;attribute name="label" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;/restriction>
 *                                   &lt;/complexContent>
 *                                 &lt;/complexType>
 *                               &lt;/element>
 *                             &lt;/choice>
 *                           &lt;/restriction>
 *                         &lt;/complexContent>
 *                       &lt;/complexType>
 *                     &lt;/element>
 *                     &lt;element name="config" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *                   &lt;/sequence>
 *                   &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                   &lt;attribute name="subsystem" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *         &lt;/choice>
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
@XmlType(name = "SystemType", propOrder = {
    "child"
})
public class SystemType {

    protected List<SystemType.Child> child;
    @XmlAttribute(name = "name", required = true)
    protected String name;

    /**
     * Gets the value of the child property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the child property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getChild().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SystemType.Child }
     * 
     * 
     */
    public List<SystemType.Child> getChild() {
        if (child == null) {
            child = new ArrayList<SystemType.Child>();
        }
        return this.child;
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
     *       &lt;sequence>
     *         &lt;choice>
     *           &lt;element name="function" type="{}NameType"/>
     *           &lt;element name="component" type="{}NameType"/>
     *         &lt;/choice>
     *         &lt;element name="dependency" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;choice maxOccurs="unbounded">
     *                   &lt;element name="child">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/choice>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="route" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;choice maxOccurs="unbounded">
     *                   &lt;element name="service">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;all>
     *                             &lt;element name="child" type="{}NameType"/>
     *                           &lt;/all>
     *                           &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="label" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/choice>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="config" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
     *       &lt;/sequence>
     *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="subsystem" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "function",
        "component",
        "dependency",
        "route",
        "config"
    })
    public static class Child {

        protected NameType function;
        protected NameType component;
        protected SystemType.Child.Dependency dependency;
        protected SystemType.Child.Route route;
        protected Object config;
        @XmlAttribute(name = "name")
        protected String name;
        @XmlAttribute(name = "subsystem")
        protected String subsystem;

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
         * Ruft den Wert der component-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link NameType }
         *     
         */
        public NameType getComponent() {
            return component;
        }

        /**
         * Legt den Wert der component-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link NameType }
         *     
         */
        public void setComponent(NameType value) {
            this.component = value;
        }

        /**
         * Ruft den Wert der dependency-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link SystemType.Child.Dependency }
         *     
         */
        public SystemType.Child.Dependency getDependency() {
            return dependency;
        }

        /**
         * Legt den Wert der dependency-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link SystemType.Child.Dependency }
         *     
         */
        public void setDependency(SystemType.Child.Dependency value) {
            this.dependency = value;
        }

        /**
         * Ruft den Wert der route-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link SystemType.Child.Route }
         *     
         */
        public SystemType.Child.Route getRoute() {
            return route;
        }

        /**
         * Legt den Wert der route-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link SystemType.Child.Route }
         *     
         */
        public void setRoute(SystemType.Child.Route value) {
            this.route = value;
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
         * Ruft den Wert der subsystem-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSubsystem() {
            return subsystem;
        }

        /**
         * Legt den Wert der subsystem-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSubsystem(String value) {
            this.subsystem = value;
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
         *         &lt;element name="child">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
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
            "child"
        })
        public static class Dependency {

            protected List<SystemType.Child.Dependency.Child2> child;

            /**
             * Gets the value of the child property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the child property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getChild().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link SystemType.Child.Dependency.Child }
             * 
             * 
             */
            public List<SystemType.Child.Dependency.Child2> getChild() {
                if (child == null) {
                    child = new ArrayList<SystemType.Child.Dependency.Child2>();
                }
                return this.child;
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
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            public static class Child2 {

                @XmlAttribute(name = "name", required = true)
                protected String name;

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
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;all>
         *                   &lt;element name="child" type="{}NameType"/>
         *                 &lt;/all>
         *                 &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="label" type="{http://www.w3.org/2001/XMLSchema}string" />
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
        public static class Route {

            protected List<SystemType.Child.Route.Service> service;

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
             * {@link SystemType.Child.Route.Service }
             * 
             * 
             */
            public List<SystemType.Child.Route.Service> getService() {
                if (service == null) {
                    service = new ArrayList<SystemType.Child.Route.Service>();
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
             *       &lt;all>
             *         &lt;element name="child" type="{}NameType"/>
             *       &lt;/all>
             *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="label" type="{http://www.w3.org/2001/XMLSchema}string" />
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
            public static class Service {

                @XmlElement(required = true)
                protected NameType child;
                @XmlAttribute(name = "name", required = true)
                protected String name;
                @XmlAttribute(name = "label")
                protected String label;

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
                 * Ruft den Wert der label-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getLabel() {
                    return label;
                }

                /**
                 * Legt den Wert der label-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setLabel(String value) {
                    this.label = value;
                }

            }

        }

    }

}
