package Objects;


import se.inera.sdk.message.StandardBusinessDocument;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "standardBusinessDocument"
})
@XmlRootElement(name = "messagePayload")
public class RootXmlObject {

    @XmlElement(nillable = true)
    public StandardBusinessDocument standardBusinessDocument;

    public StandardBusinessDocument getStandardBusinessDocument() {
        return standardBusinessDocument;
    }

    public void setStandardBusinessDocument(StandardBusinessDocument standardBusinessDocument) {
        this.standardBusinessDocument = standardBusinessDocument;
    }
}
