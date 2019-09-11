
package org.oasis_open.docs.ebxml_msg.ebms.v3_0.ns.core._200704;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Java class for AgreementRef complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AgreementRef">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://docs.oasis-open.org/ebxml-msg/ebms/v3.0/ns/core/200704/>max255-non-empty-string">
 *       &lt;attribute name="type" type="{http://docs.oasis-open.org/ebxml-msg/ebms/v3.0/ns/core/200704/}max255-non-empty-string" />
 *       &lt;attribute name="pmode" type="{http://docs.oasis-open.org/ebxml-msg/ebms/v3.0/ns/core/200704/}max255-non-empty-string" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AgreementRef", propOrder = {
    "value"
})
public class AgreementRef {

    @XmlValue
    protected String value;
    @XmlAttribute
    protected String type;
    @XmlAttribute
    protected String pmode;

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the pmode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPmode() {
        return pmode;
    }

    /**
     * Sets the value of the pmode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPmode(String value) {
        this.pmode = value;
    }

}