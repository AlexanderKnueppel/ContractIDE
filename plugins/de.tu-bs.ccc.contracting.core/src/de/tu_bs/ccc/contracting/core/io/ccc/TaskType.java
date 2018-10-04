//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.10.04 um 12:30:04 PM CEST 
//


package de.tu_bs.ccc.contracting.core.io.ccc;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für TaskType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="TaskType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded">
 *         &lt;element name="task" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="wcet" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *                 &lt;attribute name="bcet" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *                 &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="signal" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="to_ref" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="junction" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="call" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="to_ref" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="method" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
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
@XmlType(name = "TaskType", propOrder = {
    "taskOrSignalOrCall"
})
@XmlSeeAlso({
    de.tu_bs.ccc.contracting.core.io.ccc.TimingType.OnTime.class,
    de.tu_bs.ccc.contracting.core.io.ccc.TimingType.OnSignal.class,
    de.tu_bs.ccc.contracting.core.io.ccc.TimingType.OnRpc.class,
    de.tu_bs.ccc.contracting.core.io.ccc.TimingType.Junction.class
})
public class TaskType {

    @XmlElements({
        @XmlElement(name = "task", type = TaskType.Task.class),
        @XmlElement(name = "signal", type = TaskType.Signal.class),
        @XmlElement(name = "call", type = TaskType.Call.class)
    })
    protected List<Object> taskOrSignalOrCall;

    /**
     * Gets the value of the taskOrSignalOrCall property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the taskOrSignalOrCall property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTaskOrSignalOrCall().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TaskType.Task }
     * {@link TaskType.Signal }
     * {@link TaskType.Call }
     * 
     * 
     */
    public List<Object> getTaskOrSignalOrCall() {
        if (taskOrSignalOrCall == null) {
            taskOrSignalOrCall = new ArrayList<Object>();
        }
        return this.taskOrSignalOrCall;
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
     *       &lt;attribute name="to_ref" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="method" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Call {

        @XmlAttribute(name = "to_ref", required = true)
        protected String toRef;
        @XmlAttribute(name = "method", required = true)
        protected String method;

        /**
         * Ruft den Wert der toRef-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getToRef() {
            return toRef;
        }

        /**
         * Legt den Wert der toRef-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setToRef(String value) {
            this.toRef = value;
        }

        /**
         * Ruft den Wert der method-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMethod() {
            return method;
        }

        /**
         * Legt den Wert der method-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMethod(String value) {
            this.method = value;
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
     *       &lt;attribute name="to_ref" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="junction" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Signal {

        @XmlAttribute(name = "to_ref")
        protected String toRef;
        @XmlAttribute(name = "junction")
        protected String junction;

        /**
         * Ruft den Wert der toRef-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getToRef() {
            return toRef;
        }

        /**
         * Legt den Wert der toRef-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setToRef(String value) {
            this.toRef = value;
        }

        /**
         * Ruft den Wert der junction-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getJunction() {
            return junction;
        }

        /**
         * Legt den Wert der junction-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setJunction(String value) {
            this.junction = value;
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
     *       &lt;attribute name="wcet" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
     *       &lt;attribute name="bcet" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
     *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Task {

        @XmlAttribute(name = "wcet", required = true)
        protected BigInteger wcet;
        @XmlAttribute(name = "bcet", required = true)
        protected BigInteger bcet;
        @XmlAttribute(name = "name")
        protected String name;

        /**
         * Ruft den Wert der wcet-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getWcet() {
            return wcet;
        }

        /**
         * Legt den Wert der wcet-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setWcet(BigInteger value) {
            this.wcet = value;
        }

        /**
         * Ruft den Wert der bcet-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getBcet() {
            return bcet;
        }

        /**
         * Legt den Wert der bcet-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setBcet(BigInteger value) {
            this.bcet = value;
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

    }

}
