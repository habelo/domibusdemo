package Objects;

import se.inera.sdk.message.*;

import javax.xml.bind.JAXBElement;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.Instant;
import java.util.UUID;

public class BuildSdkPayload {

    private static String SENDERAUTH = "riv-actorid-unregistered";
    private static String RECIEVERAUTH = "riv-actorid-unregistered";
    private static String SENDERID = "sundbyberg.se";
    private static String RECIEVERID = "testbed.inera.se";
    private static String DOCUMENTIDSTANDARD =  "urn:riv:infrastructure:messaging:MessageWithAttachments:1";
    private static String MESSAGEHEADERLABEL = "test utan attachment";
    private static String CONFIDENTIALITY = "false";
    private static String RECIPIENTROOT = "riv-actorid-unregistered";
    private static String RECIPIENTEXT = "testbed.inera.se";
    private static String PERSONIDROOT = "1.2.752.129.2.1.4.1";
    private static String PERSONIDEXT = "testbed.inera.se";
    private static String PERSONLABEL = "Karin SDK Svensson";
    private static String ORGIDEXT = "tesstbed.inera.se";
    private static String ORGLABEL = "Funktionsbrevlåda för xyz kommuner";
    private static String ORGSENDERROOT = "riv-actorid-unregistered";
    private static String ORGSENDEXT = "xyz-kommun.se";
    private static String SENDERPERSONID = "XY-ID-STANDARD";
    private static String SENDERPERSONLABEL = "Anders Andersson";
    private static String SENDERORGROOT = "sundbyberg.se";
    private static String SENDORGLABEL = "Sundbyberg stad";
    private static String DOCUMENTID = "SDK testmeddelande";
    private static String DOCUMENTNAME = "SDK testar meddelande";
    private static String CONTENTTEXT = "Ett enkelt meeddelande utan någon bifogad fil, skriven av Jonas";

    private static se.inera.sdk.message.ObjectFactory factory1 = new se.inera.sdk.message.ObjectFactory();



    public static JAXBElement<MessagePayloadType> build() {
//        RootXmlObject xml = new RootXmlObject();
//        document.setStandardBusinessDocumentHeader(header);
//        xml.setStandardBusinessDocument(document);

        MessagePayloadType messagePayloadType = factory1.createMessagePayloadType();
        messagePayloadType.setStandardBusinessDocument(buildSBD());
        messagePayloadType.setMessage(buildMessage());


        return factory1.createMessagePayload(messagePayloadType);
    }

    private static MessageType buildMessage()  {

        MessageType message = factory1.createMessageType();
        MessageHeaderType header = factory1.createMessageHeaderType();
        MessageBodyType body = factory1.createMessageBodyType();

        header.setCreationDateTime(getXMLNow());
        header.setMessageId(UUID.randomUUID().toString());
        header.setConversationId(UUID.randomUUID().toString());
        header.setLabel(MESSAGEHEADERLABEL);
        header.setConfidentiality(false);
        header.setRecipient(buildRecipient());
        header.setSender(buildSender());

        body.getDocuments().add(buildDocument());

        message.setMessageHeader(header);
        message.setMessageBody(body);
        return message;
    }

    private static DigitalDocumentType buildDocument() {
        DigitalDocumentType document = factory1.createDigitalDocumentType();
        ContentAsText text = factory1.createContentAsText();
        document.setDocumentID(DOCUMENTID);
        document.setDocumentName(DOCUMENTNAME);
        document.setIndex("1");
        text.setCharacterSequence(CONTENTTEXT);
        document.getContentText().add(text);

        return document;
    }

    private static SenderType buildSender() {
        SenderType senderType = factory1.createSenderType();
        IIType id = factory1.createIIType();
        id.setRoot(ORGSENDERROOT);
        id.setExtension(ORGSENDEXT);
        senderType.setSenderID(id);
        senderType.setAttention(buildAttention(true));

        return senderType;
    }

    private static RecipientType buildRecipient() {
        RecipientType recipient = factory1.createRecipientType();
        IIType id = factory1.createIIType();
        id.setRoot(RECIPIENTROOT);
        id.setExtension(RECIPIENTEXT);
        recipient.setRecipientID(id);
        recipient.setAttention(buildAttention(false));


        return  recipient;
    }

    private static AttentionDataType buildAttention(boolean sender) {

        AttentionDataType attention = factory1.createAttentionDataType();
        if(sender){
            attention.getPerson().add(buildPerson(true));
            attention.setSubOrganization(buildSubOrg(true));
        }else {
            attention.getPerson().add(buildPerson(false));
            attention.setSubOrganization(buildSubOrg(false));
        }

        return attention;
    }

    private static SubOrganizationType buildSubOrg(boolean sender) {
        SubOrganizationType organizationType = factory1.createSubOrganizationType();
        IIType id = factory1.createIIType();
        if(sender){
            id.setRoot(SENDERORGROOT);
            organizationType.setOrganizationId(id);
            organizationType.setLabel(SENDORGLABEL);
        }else {
        id.setRoot(ORGIDEXT);
        organizationType.setOrganizationId(id);
        organizationType.setLabel(ORGLABEL);
        }
        return organizationType;
    }

    private static AttentionPersonType buildPerson(boolean sender) {
        AttentionPersonType personType = factory1.createAttentionPersonType();
        IIType id = factory1.createIIType();
        if(sender){
            id.setRoot(SENDERPERSONID);
            id.setExtension("XYZ-ID-67890");
            personType.setPersonId(id);
            personType.setLabel(SENDERPERSONLABEL);
        }else {
            id.setRoot(PERSONIDROOT);
            id.setExtension(PERSONIDEXT);
            personType.setPersonId(id);
            personType.setLabel(PERSONLABEL);
        }

        return personType;
    }

    private static XMLGregorianCalendar getXMLNow() {
        String dateTimeString = Instant.now().toString();
        XMLGregorianCalendar date = null;
        try {
         date = DatatypeFactory.newInstance().newXMLGregorianCalendar(dateTimeString);
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }
        return date;
    }

    private static StandardBusinessDocumentHeader buildSBD(){

        StandardBusinessDocumentHeader header = factory1.createStandardBusinessDocumentHeader();

        //sender
        Partner partner = new Partner();
        PartnerIdentification id = new PartnerIdentification();
        id.setValue(SENDERID);
        id.setAuthority(SENDERAUTH);
        partner.setIdentifier(id);
        header.getSender().add(partner);

        //reciever
        id.setValue(RECIEVERID);
        partner.setIdentifier(id);
        header.getReceiver().add(partner);

        //documentID
        DocumentIdentification documentIdentification = new DocumentIdentification();
        documentIdentification.setStandard(DOCUMENTIDSTANDARD);
        header.setDocumentIdentification(documentIdentification);

        return header;
    }
}
