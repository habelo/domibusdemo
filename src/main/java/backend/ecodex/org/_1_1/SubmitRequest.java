
package backend.ecodex.org._1_1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bodyload" type="{http://org.ecodex.backend/1_1/}LargePayloadType" minOccurs="0"/>
 *         &lt;element name="payload" type="{http://org.ecodex.backend/1_1/}LargePayloadType" maxOccurs="unbounded" minOccurs="0"/>
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
    "bodyload",
    "payload"
})
@XmlRootElement(name = "submitRequest")
public class SubmitRequest {

    protected LargePayloadType bodyload;
    @XmlElement(nillable = true)
    protected List<LargePayloadType> payload;

    /**
     * Gets the value of the bodyload property.
     * 
     * @return
     *     possible object is
     *     {@link LargePayloadType }
     *     
     */
    public LargePayloadType getBodyload() {
        return bodyload;
    }

    /**
     * Sets the value of the bodyload property.
     * 
     * @param value
     *     allowed object is
     *     {@link LargePayloadType }
     *     
     */
    public void setBodyload(LargePayloadType value) {
        this.bodyload = value;
    }

    /**
     * Gets the value of the payload property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the payload property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPayload().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LargePayloadType }
     * 
     * 
     */
    public List<LargePayloadType> getPayload() {
        if (payload == null) {
            payload = new ArrayList<LargePayloadType>();
        }
        return this.payload;
    }

}
