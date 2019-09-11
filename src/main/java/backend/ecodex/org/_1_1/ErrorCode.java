
package backend.ecodex.org._1_1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for errorCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="errorCode">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="EBMS_0001"/>
 *     &lt;enumeration value="EBMS_0002"/>
 *     &lt;enumeration value="EBMS_0003"/>
 *     &lt;enumeration value="EBMS_0004"/>
 *     &lt;enumeration value="EBMS_0005"/>
 *     &lt;enumeration value="EBMS_0006"/>
 *     &lt;enumeration value="EBMS_0007"/>
 *     &lt;enumeration value="EBMS_0008"/>
 *     &lt;enumeration value="EBMS_0009"/>
 *     &lt;enumeration value="EBMS_0010"/>
 *     &lt;enumeration value="EBMS_0011"/>
 *     &lt;enumeration value="EBMS_0101"/>
 *     &lt;enumeration value="EBMS_0102"/>
 *     &lt;enumeration value="EBMS_0103"/>
 *     &lt;enumeration value="EBMS_0201"/>
 *     &lt;enumeration value="EBMS_0202"/>
 *     &lt;enumeration value="EBMS_0301"/>
 *     &lt;enumeration value="EBMS_0302"/>
 *     &lt;enumeration value="EBMS_0303"/>
 *     &lt;enumeration value="EBMS_0020"/>
 *     &lt;enumeration value="EBMS_0021"/>
 *     &lt;enumeration value="EBMS_0022"/>
 *     &lt;enumeration value="EBMS_0023"/>
 *     &lt;enumeration value="EBMS_0030"/>
 *     &lt;enumeration value="EBMS_0031"/>
 *     &lt;enumeration value="EBMS_0040"/>
 *     &lt;enumeration value="EBMS_0041"/>
 *     &lt;enumeration value="EBMS_0042"/>
 *     &lt;enumeration value="EBMS_0043"/>
 *     &lt;enumeration value="EBMS_0044"/>
 *     &lt;enumeration value="EBMS_0045"/>
 *     &lt;enumeration value="EBMS_0046"/>
 *     &lt;enumeration value="EBMS_0047"/>
 *     &lt;enumeration value="EBMS_0048"/>
 *     &lt;enumeration value="EBMS_0049"/>
 *     &lt;enumeration value="EBMS_0050"/>
 *     &lt;enumeration value="EBMS_0051"/>
 *     &lt;enumeration value="EBMS_0052"/>
 *     &lt;enumeration value="EBMS_0053"/>
 *     &lt;enumeration value="EBMS_0054"/>
 *     &lt;enumeration value="EBMS_0055"/>
 *     &lt;enumeration value="EBMS_0060"/>
 *     &lt;enumeration value="EBMS_0065"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "errorCode")
@XmlEnum
public enum ErrorCode {

    EBMS_0001,
    EBMS_0002,
    EBMS_0003,
    EBMS_0004,
    EBMS_0005,
    EBMS_0006,
    EBMS_0007,
    EBMS_0008,
    EBMS_0009,
    EBMS_0010,
    EBMS_0011,
    EBMS_0101,
    EBMS_0102,
    EBMS_0103,
    EBMS_0201,
    EBMS_0202,
    EBMS_0301,
    EBMS_0302,
    EBMS_0303,
    EBMS_0020,
    EBMS_0021,
    EBMS_0022,
    EBMS_0023,
    EBMS_0030,
    EBMS_0031,
    EBMS_0040,
    EBMS_0041,
    EBMS_0042,
    EBMS_0043,
    EBMS_0044,
    EBMS_0045,
    EBMS_0046,
    EBMS_0047,
    EBMS_0048,
    EBMS_0049,
    EBMS_0050,
    EBMS_0051,
    EBMS_0052,
    EBMS_0053,
    EBMS_0054,
    EBMS_0055,
    EBMS_0060,
    EBMS_0065;

    public String value() {
        return name();
    }

    public static ErrorCode fromValue(String v) {
        return valueOf(v);
    }

}
