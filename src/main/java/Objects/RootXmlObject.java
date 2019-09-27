package Objects;


import se.inera.sdk.message.StandardBusinessDocument;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "document"
})
@XmlRootElement(name = "StandardBusinessDocument")
public class RootXmlObject {

    @XmlElement(nillable = true)
    public StandardBusinessDocument document;

    public StandardBusinessDocument getDocument() {
        return document;
    }

    public void setDocument(StandardBusinessDocument document) {
        this.document = document;
    }
}
