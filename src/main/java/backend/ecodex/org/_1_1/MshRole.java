
package backend.ecodex.org._1_1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for mshRole.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="mshRole">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SENDING"/>
 *     &lt;enumeration value="RECEIVING"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "mshRole")
@XmlEnum
public enum MshRole {

    SENDING,
    RECEIVING;

    public String value() {
        return name();
    }

    public static MshRole fromValue(String v) {
        return valueOf(v);
    }

}
