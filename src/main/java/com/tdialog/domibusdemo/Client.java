package com.tdialog.domibusdemo;

import Objects.BuildSdkPayload;
import backend.ecodex.org._1_1.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.saaj.SaajSoapMessage;
import se.inera.sdk.message.MessagePayloadType;

import javax.activation.DataContentHandler;
import javax.activation.DataContentHandlerFactory;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.annotation.PostConstruct;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.soap.*;
import java.awt.datatransfer.DataFlavor;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.time.Clock;
import java.time.LocalDateTime;

@Component
public class Client {

    private String fromValue;
    private String toValue;
    private String address;

    private final WebServiceTemplate template;
    private final backend.ecodex.org._1_1.ObjectFactory factory = new backend.ecodex.org._1_1.ObjectFactory();


    @Autowired
    public Client(@Value("${server.skl-sdk.to}") String toValue,
                  @Value("${server.skl-sdk.from}") String fromValue,
                  @Value("${server.skl-sdk.organisationsid}") String address,
                  WebServiceTemplate template) {
        this.toValue = toValue;
        this.fromValue = fromValue;
        this.template = template;
        this.address = address;
    }

    @PostConstruct
    public void init() {
        System.out.println("CONFIGS:================== toValue:   " + toValue + "================== ");
        System.out.println("CONFIGS:================== fromValue: " + fromValue + "================== ");
        DataHandler.setDataContentHandlerFactory(new DomibusDataHandlerContentFactory());
    }

    public SubmitResponse submitMessage() throws JAXBException {

        SubmitRequest request = factory.createSubmitRequest();

        JAXBElement<MessagePayloadType> xml = BuildSdkPayload.build();

        JAXBContext context = JAXBContext.newInstance(MessagePayloadType.class);

        Marshaller mar= context.createMarshaller();
        mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        StringWriter sw = new StringWriter();
        mar.marshal(xml, sw);
        String xmlString = sw.toString();

        System.out.println("\nXML to send:\n" + xmlString);

        DataHandler testHandler = new DataHandler(xmlString, "text/xml");
        LargePayloadType testPayload = factory.createLargePayloadType();
        testPayload.setValue(testHandler);
        testPayload.setPayloadId("cid:message");

        request.getPayload().add(testPayload);

        template.marshalSendAndReceive(request, new CustomWebServiceMessageCallback(toValue, fromValue, address));
        return (SubmitResponse)template.marshalSendAndReceive(request, new CustomWebServiceMessageCallback(toValue, fromValue, address));
    }

    public ListPendingMessagesResponse listPendingMessages(Object request) {

        return (ListPendingMessagesResponse)template.marshalSendAndReceive(request);
    }

    public RetrieveMessageResponse retrieveMessage(RetrieveMessageRequest request) {
        return (RetrieveMessageResponse)template.marshalSendAndReceive(request);
    }





    private static class DomibusDataHandlerContentFactory implements DataContentHandlerFactory {

        @Override
        public DataContentHandler createDataContentHandler(String mimeType) {

            return new DomibusXmlDataContentHandler();
        }
    }

    public static class DomibusXmlDataContentHandler implements DataContentHandler {
        /** Creates a new instance of BinaryDataHandler */
        DomibusXmlDataContentHandler() {
            System.out.println("-----------------------------------------> Creating our handler thingie");
        }

        @Override
        public DataFlavor[] getTransferDataFlavors() {
            return new DataFlavor[] {DataFlavor.stringFlavor};
        }

        @Override
        public Object getTransferData(DataFlavor dataFlavor, DataSource dataSource) {
            return "Datajunkgrejer";
        }

        @Override
        public Object getContent(DataSource dataSource) {
            return "Datajunkgrejer";
        }

        @Override
        public void writeTo(Object o, String s, OutputStream outputStream) throws IOException {
            byte[] stringByte = ((String) o).getBytes(StandardCharsets.UTF_8);
            outputStream.write(stringByte);
        }
    }

    public static class CustomWebServiceMessageCallback implements WebServiceMessageCallback {


        private static final String FROMTYPE = "urn:oasis:names:tc:ebcore:partyid-type:unregistered";
        //        private static final String FROMVALUE = "domibus-blue";
        private static final String FROM_ROLE_VALUE = "http://docs.oasis-open.org/ebxml-msg/ebms/v3.0/ns/core/200704/initiator";
        private static final String TOTYPE = "urn:oasis:names:tc:ebcore:partyid-type:unregistered";
        //private static final String TOVALUE = "domibus-red";
        private static final String TO_ROLE_VALUE = "http://docs.oasis-open.org/ebxml-msg/ebms/v3.0/ns/core/200704/responder";

//        private static final String SERVICETYPE = "tc1";
                private static final String SERVICETYPE = "se-digg-procid";
//        private static final String SERVICEVALUE = "bdx:noprocess";
                private static final String SERVICEVALUE = "urn:riv:messaging-process";
//        private static final String ACTIONVALUE = "TC1Leg1";
        private static final String ACTIONVALUE = "busdox-docid-qns::urn:riv:infrastructure:messaging:MessageWithAttachments:1";

        private static final String ORIGINALSENDER = "urn:oasis:names:tc:ebcore:partyid-type:unregistered:C1";
        private static final String FINALRECIPIENT = "urn:oasis:names:tc:ebcore:partyid-type:unregistered:C4";
        private static final String SCHEMALOCATION = "https://org-host.se/schemas/core_components/infrastructure_messaging_MessageWithAttachments_1.0.xsd";
        private static final String SCHEMAVERSION = "1.0";

        private final String toValue;
        private final String fromValue;
        private final String address;


        public CustomWebServiceMessageCallback(String toValue, String fromValue, String address) {
            System.out.println("Set toValue to: " + toValue);
            this.toValue = toValue;
            this.fromValue = fromValue;
            this.address = address;
        }

        public void doWithMessage(WebServiceMessage message) {
            try {
                System.out.println("FROM CONFIG URL: " + toValue);
                SaajSoapMessage saajSoapMessage = (SaajSoapMessage) message;
                SOAPMessage soapMessage = saajSoapMessage.getSaajMessage();
                SOAPPart soapPart = soapMessage.getSOAPPart();
                SOAPEnvelope soapEnvelope = soapPart.getEnvelope();
                SOAPHeader soapHeader = soapEnvelope.getHeader();
                Name headerElementName = soapEnvelope.createName(
                        "Messaging",
                        "ns",
                        "http://docs.oasis-open.org/ebxml-msg/ebms/v3.0/ns/core/200704/");

                SOAPHeaderElement messagingHeader = soapHeader.addHeaderElement(headerElementName);
                SOAPElement userMessageElement = messagingHeader.addChildElement("UserMessage", "ns");
//                SOAPHeaderElement messagingHeader = header.addHeaderElement(new QName("http://docs.oasis-open.org/ebxml-msg/ebms/v3.0/ns/core/200704/", "Messaging", "ns"));
                SOAPElement messageInfoElement = userMessageElement.addChildElement("MessageInfo", "ns");
                SOAPElement timestampElement = messageInfoElement.addChildElement("Timestamp", "ns");
                timestampElement.setValue(String.valueOf(LocalDateTime.now(Clock.systemUTC())));
                SOAPElement messageIdElement = messageInfoElement.addChildElement("MessageId", "ns");
                //inte för "submitrequest"
//                messageIdElement.setValue(UUID.randomUUID().toString());


                //if not work: kolla metodanropens kronologi
                SOAPElement partyInfoElement = userMessageElement.addChildElement("PartyInfo", "ns");
                SOAPElement from = partyInfoElement.addChildElement("From", "ns");
//                SOAPElement to = partyInfoElement.addChildElement("To", "ns");

                SOAPElement fromPartyId = from.addChildElement("PartyId", "ns");
                fromPartyId.setAttribute("type", FROMTYPE);
                fromPartyId.setValue(fromValue);
                SOAPElement fromRole = from.addChildElement("Role", "ns");
                fromRole.setValue(FROM_ROLE_VALUE);
//                SOAPElement toPartyId = to.addChildElement("PartyId", "ns");
//                toPartyId.setAttribute("type", TOTYPE);
//                toPartyId.setValue(toValue);
//                SOAPElement toRole = to.addChildElement("Role", "ns");
//                toRole.setValue(TO_ROLE_VALUE);

                SOAPElement collaborationInfo = userMessageElement.addChildElement("CollaborationInfo", "ns");
//                SOAPElement agreementRef = collaborationInfo.addChildElement("AgreementRef", "ns");
                SOAPElement service = collaborationInfo.addChildElement("Service", "ns");
                service.setAttribute("type", SERVICETYPE);
                service.setValue(SERVICEVALUE);
                SOAPElement action = collaborationInfo.addChildElement("Action", "ns");
                action.setValue(ACTIONVALUE);
                SOAPElement conversationId = collaborationInfo.addChildElement("ConversationId", "ns");
                //TODO ÄNDRA när det är konversation
                conversationId.setValue("TDIALOG-");

                SOAPElement messageProperties = userMessageElement.addChildElement("MessageProperties", "ns");
                SOAPElement mProperty0 = messageProperties.addChildElement("Property", "ns");
                mProperty0.setAttribute("name", "originalSender");
                mProperty0.setAttribute("type", "riv-actorid-unregistered");
//                mProperty0.setValue(ORIGINALSENDER);
                mProperty0.setValue("sundbyberg.se");
//                mProperty0.setValue(fromValue);
                SOAPElement mProperty1 = messageProperties.addChildElement("Property", "ns");
                mProperty1.setAttribute("name", "finalRecipient");
                mProperty1.setAttribute("type", "riv-actorid-unregistered");
//                mProperty1.setValue(FINALRECIPIENT);
                mProperty1.setValue("testbed.inera.se");
//                mProperty1.setValue(toValue);

                SOAPElement payloadInfo = userMessageElement.addChildElement("PayloadInfo", "ns");
                SOAPElement partInfo = payloadInfo.addChildElement("PartInfo", "ns");
                partInfo.setAttribute("href", "cid:message");
//                SOAPElement schema = partInfo.addChildElement("Schema", "ns");
//                schema.setAttribute("location", SCHEMALOCATION);
//                schema.setAttribute("version", SCHEMAVERSION);
                SOAPElement partProperties = partInfo.addChildElement("PartProperties", "ns");
                SOAPElement pProperty0 = partProperties.addChildElement("Property", "ns");
                pProperty0.setAttribute("name", "MimeType");
                pProperty0.setValue("text/xml");

            } catch (Exception e) {

                e.printStackTrace();
            }
        }
    }
}
















