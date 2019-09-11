
package backend.ecodex.org._1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for errorResultImpl complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="errorResultImpl">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="errorCode" type="{http://org.ecodex.backend/1_1/}errorCode" minOccurs="0"/>
 *         &lt;element name="errorDetail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="messageInErrorId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mshRole" type="{http://org.ecodex.backend/1_1/}mshRole" minOccurs="0"/>
 *         &lt;element name="notified" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="timestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "errorResultImpl", propOrder = {
    "errorCode",
    "errorDetail",
    "messageInErrorId",
    "mshRole",
    "notified",
    "timestamp"
})
public class ErrorResultImpl {

    protected ErrorCode errorCode;
    protected String errorDetail;
    protected String messageInErrorId;
    protected MshRole mshRole;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar notified;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar timestamp;

    /**
     * Gets the value of the errorCode property.
     * 
     * @return
     *     possible object is
     *     {@link ErrorCode }
     *     
     */
    public ErrorCode getErrorCode() {
        return errorCode;
    }

    /**
     * Sets the value of the errorCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ErrorCode }
     *     
     */
    public void setErrorCode(ErrorCode value) {
        this.errorCode = value;
    }

    /**
     * Gets the value of the errorDetail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorDetail() {
        return errorDetail;
    }

    /**
     * Sets the value of the errorDetail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorDetail(String value) {
        this.errorDetail = value;
    }

    /**
     * Gets the value of the messageInErrorId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessageInErrorId() {
        return messageInErrorId;
    }

    /**
     * Sets the value of the messageInErrorId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessageInErrorId(String value) {
        this.messageInErrorId = value;
    }

    /**
     * Gets the value of the mshRole property.
     * 
     * @return
     *     possible object is
     *     {@link MshRole }
     *     
     */
    public MshRole getMshRole() {
        return mshRole;
    }

    /**
     * Sets the value of the mshRole property.
     * 
     * @param value
     *     allowed object is
     *     {@link MshRole }
     *     
     */
    public void setMshRole(MshRole value) {
        this.mshRole = value;
    }

    /**
     * Gets the value of the notified property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getNotified() {
        return notified;
    }

    /**
     * Sets the value of the notified property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setNotified(XMLGregorianCalendar value) {
        this.notified = value;
    }

    /**
     * Gets the value of the timestamp property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTimestamp() {
        return timestamp;
    }

    /**
     * Sets the value of the timestamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTimestamp(XMLGregorianCalendar value) {
        this.timestamp = value;
    }

}
