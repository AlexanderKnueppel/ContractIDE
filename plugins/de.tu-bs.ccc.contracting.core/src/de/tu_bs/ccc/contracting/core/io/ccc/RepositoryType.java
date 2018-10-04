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
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für RepositoryType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="RepositoryType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded">
 *         &lt;element name="binary" type="{}BinaryType"/>
 *         &lt;element name="component" type="{}ComponentType"/>
 *         &lt;element name="composite" type="{}CompositeType"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RepositoryType", propOrder = {
    "binaryOrComponentOrComposite"
})
public class RepositoryType {

    @XmlElements({
        @XmlElement(name = "binary", type = BinaryType.class),
        @XmlElement(name = "component", type = ComponentType.class),
        @XmlElement(name = "composite", type = CompositeType.class)
    })
    protected List<Object> binaryOrComponentOrComposite;

    /**
     * Gets the value of the binaryOrComponentOrComposite property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the binaryOrComponentOrComposite property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBinaryOrComponentOrComposite().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BinaryType }
     * {@link ComponentType }
     * {@link CompositeType }
     * 
     * 
     */
    public List<Object> getBinaryOrComponentOrComposite() {
        if (binaryOrComponentOrComposite == null) {
            binaryOrComponentOrComposite = new ArrayList<Object>();
        }
        return this.binaryOrComponentOrComposite;
    }

}
