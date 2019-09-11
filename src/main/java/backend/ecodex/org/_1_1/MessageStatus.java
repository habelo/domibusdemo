
package backend.ecodex.org._1_1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for messageStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="messageStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="READY_TO_SEND"/>
 *     &lt;enumeration value="READY_TO_PULL"/>
 *     &lt;enumeration value="BEING_PULLED"/>
 *     &lt;enumeration value="SEND_ENQUEUED"/>
 *     &lt;enumeration value="SEND_IN_PROGRESS"/>
 *     &lt;enumeration value="WAITING_FOR_RECEIPT"/>
 *     &lt;enumeration value="ACKNOWLEDGED"/>
 *     &lt;enumeration value="ACKNOWLEDGED_WITH_WARNING"/>
 *     &lt;enumeration value="SEND_ATTEMPT_FAILED"/>
 *     &lt;enumeration value="SEND_FAILURE"/>
 *     &lt;enumeration value="NOT_FOUND"/>
 *     &lt;enumeration value="WAITING_FOR_RETRY"/>
 *     &lt;enumeration value="RECEIVED"/>
 *     &lt;enumeration value="RECEIVED_WITH_WARNINGS"/>
 *     &lt;enumeration value="DELETED"/>
 *     &lt;enumeration value="DOWNLOADED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "messageStatus")
@XmlEnum
public enum MessageStatus {

    READY_TO_SEND,
    READY_TO_PULL,
    BEING_PULLED,
    SEND_ENQUEUED,
    SEND_IN_PROGRESS,
    WAITING_FOR_RECEIPT,
    ACKNOWLEDGED,
    ACKNOWLEDGED_WITH_WARNING,
    SEND_ATTEMPT_FAILED,
    SEND_FAILURE,
    NOT_FOUND,
    WAITING_FOR_RETRY,
    RECEIVED,
    RECEIVED_WITH_WARNINGS,
    DELETED,
    DOWNLOADED;

    public String value() {
        return name();
    }

    public static MessageStatus fromValue(String v) {
        return valueOf(v);
    }

}
