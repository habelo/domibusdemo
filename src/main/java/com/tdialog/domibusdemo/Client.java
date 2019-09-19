package com.tdialog.domibusdemo;

import backend.ecodex.org._1_1.LargePayloadType;
import backend.ecodex.org._1_1.ObjectFactory;
import backend.ecodex.org._1_1.SubmitRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.saaj.SaajSoapMessage;
import org.w3._2003._05.soap_envelope.Envelope;

import javax.activation.*;
import javax.annotation.PostConstruct;
import javax.xml.soap.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.io.OutputStream;
import java.time.Clock;
import java.time.LocalDateTime;
import java.util.*;

@Component
public class Client {

//    @Autowired
//    private Environment environment;


    private String fromValue;
    private String toValue;

    private final WebServiceTemplate template;

    @Autowired
    public Client(@Value("${server.skl-sdk.to}") String toValue,@Value("${server.skl-sdk.from}") String fromValue, WebServiceTemplate template) {
        this.toValue = toValue;
        this.fromValue = fromValue;
        this.template = template;
    }

    @PostConstruct
    public void init() {
        System.out.println("CONFIGS:================== toValue" + toValue + "================== ");
        System.out.println("CONFIGS:================== fromValue" + fromValue + "================== ");
    }

    public List<String> pingDomibus() {

        SOAPMessage message;
        ObjectFactory factory = new ObjectFactory();
        org.w3._2003._05.soap_envelope.ObjectFactory factory1 = new org.w3._2003._05.soap_envelope.ObjectFactory();
        //envelope har ingen @xmlroot men SubmitRequest har de
        Envelope envelope = factory1.createEnvelope();
        SubmitRequest request = factory.createSubmitRequest();
        //todo gör contenttype attribute

//        envelope.setBody(request);

//        request.setBodyload(new LargePayloadType());
//        request.getBodyload().setPayloadId(UUID.randomUUID().toString());

        //datahandler verkar vara det som hanterar själva Objektet
        Message localMessage = new Message();
        localMessage.setTitle("Hej");
        localMessage.setText("hejsan alla galna glada");

        //DataHandler testHandler = new DataHandler(localMessage, "mimetyp?");
        String testString = new String("Test test");

        DataHandler.setDataContentHandlerFactory(new DomibusDataHandlerContentFactory());
        //DataHandler testHandler = (new DomibusDataHandlerContentFactory()).createDataContentHandler("text/xml");
        DataHandler testHandler = new DataHandler(testString, "text/xml");
        System.out.println("Testhandler congentttype"+ testHandler.getContentType());
        LargePayloadType testPayload = factory.createLargePayloadType();
        testPayload.setValue(testHandler);

        System.out.println("Commandmap is: "+CommandMap.getDefaultCommandMap().getClass().getName());

        testPayload.setPayloadId("cid:message");

        request.getPayload().add(testPayload);

//            message = createSoap();

        //todo make response work
        System.out.println("Default urI: " + template.getDefaultUri());
//        System.out.println("Request: " + request.getBodyload().getPayloadId());
//        System.out.println("template " + template);
//        System.out.println("destination " + template.getDestinationProvider().getDestination());
//        System.out.println("marshaller " + template.getMarshaller());
//        SubmitResponse response = (SubmitResponse) template.marshalSendAndReceive(request);


        //todo doWithMessage
        template.marshalSendAndReceive(request, new CustomWebServiceMessageCallback(toValue, fromValue));

        System.out.println("Sent");

        return new ArrayList<>();

    }

    private class DomibusDataHandlerContentFactory implements DataContentHandlerFactory {

        @Override
        public DataContentHandler createDataContentHandler(String mimeType) {

            return new DomibusXmlDataContentHandler();
        }
    }

    public static class DomibusXmlDataContentHandler implements DataContentHandler {
        /** Creates a new instance of BinaryDataHandler */
        public DomibusXmlDataContentHandler() {
            System.out.println("-----------------------------------------> Creating our handler thingie");
        }

        @Override
        public DataFlavor[] getTransferDataFlavors() {
            return new DataFlavor[] {DataFlavor.stringFlavor};
        }

        @Override
        public Object getTransferData(DataFlavor dataFlavor, DataSource dataSource) throws UnsupportedFlavorException, IOException {
            return new String("Datajunkgrejer");
        }

        @Override
        public Object getContent(DataSource dataSource) throws IOException {
            return new String("Datajunkgrejer");
        }

        @Override
        public void writeTo(Object o, String s, OutputStream outputStream) throws IOException {
            byte[] stringByte = (byte[]) ((String) o).getBytes("UTF-8");
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

        private static final String SERVICETYPE = "tc1";
        private static final String SERVICEVALUE = "bdx:noprocess";
        private static final String ACTIONVALUE = "TC1Leg1";

        private static final String ORIGINALSENDER = "urn:oasis:names:tc:ebcore:partyid-type:unregistered:C1";
        private static final String FINALRECIPIENT = "urn:oasis:names:tc:ebcore:partyid-type:unregistered:C4";

        private final String toValue;
        private final String fromValue;


        public CustomWebServiceMessageCallback(String toValue, String fromValue)
        {
            System.out.println("Set toValue to: "+toValue);
            this.toValue = toValue;
            this.fromValue = fromValue;
        }

        public void doWithMessage(WebServiceMessage message) {
            try {
                //Properties holder = new Properties();
                //String TOVALUE = holder.getUrl();
                System.out.println("FROM CONFIG URL: "+toValue);
//                SOAPMessage soapMessage = ((SaajSoapMessage) message).getSaajMessage();
//                SOAPHeader header = soapMessage.getSOAPHeader();
                SaajSoapMessage saajSoapMessage = (SaajSoapMessage)message;
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


                //if not work: kolla metodanropens kronologi
                SOAPElement partyInfoElement = userMessageElement.addChildElement("PartyInfo", "ns");
                SOAPElement from = partyInfoElement.addChildElement("From", "ns");
                SOAPElement to = partyInfoElement.addChildElement("To", "ns");

                SOAPElement fromPartyId = from.addChildElement("PartyId", "ns");
                fromPartyId.setAttribute("type", FROMTYPE);
                fromPartyId.setValue(fromValue);
                SOAPElement fromRole = from.addChildElement("Role", "ns");
                fromRole.setValue(FROM_ROLE_VALUE);
                SOAPElement toPartyId = to.addChildElement("PartyId", "ns");
                toPartyId.setAttribute("type", TOTYPE);
                toPartyId.setValue(toValue);
                SOAPElement toRole = to.addChildElement("Role", "ns");
                toRole.setValue(TO_ROLE_VALUE);

                SOAPElement collaborationInfo = userMessageElement.addChildElement("CollaborationInfo", "ns");
//                SOAPElement agreementRef = collaborationInfo.addChildElement("AgreementRef", "ns");
                SOAPElement service = collaborationInfo.addChildElement("Service", "ns");
                service.setAttribute("type", SERVICETYPE);
                service.setValue(SERVICEVALUE);
                SOAPElement action = collaborationInfo.addChildElement("Action", "ns");
                action.setValue(ACTIONVALUE);
                SOAPElement conversationId = collaborationInfo.addChildElement("ConversationId", "ns");

                SOAPElement messageProperties = userMessageElement.addChildElement("MessageProperties", "ns");
                SOAPElement mProperty0 = messageProperties.addChildElement("Property", "ns");
                mProperty0.setAttribute("name", "originalSender");
                mProperty0.setValue(ORIGINALSENDER);
                SOAPElement mProperty1 = messageProperties.addChildElement("Property", "ns");
                mProperty1.setAttribute("name", "finalRecipient");
                mProperty1.setValue(FINALRECIPIENT);

                SOAPElement payloadInfo = userMessageElement.addChildElement("PayloadInfo", "ns");
                SOAPElement partInfo = payloadInfo.addChildElement("PartInfo", "ns");
                partInfo.setAttribute("href", "cid:message");
                SOAPElement partProperties = partInfo.addChildElement("PartProperties", "ns");
                SOAPElement pProperty0 = partProperties.addChildElement("Property", "ns");
                pProperty0.setAttribute("name", "MimeType");
                pProperty0.setValue("text/xml");



            } catch (Exception e) {

                e.printStackTrace();
            }


//            SoapMessage soapMessage = (SoapMessage)message;
//            SoapHeader header = soapMessage.getSoapHeader();
//            QName mainTag = new QName("http://docs.oasis-open.org/ebxml-msg/ebms/v3.0/ns/core/200704/", "CustomHeaderElement");

//            QName qName = new QName("http://docs.oasis-open.org/ebxml-msg/ebms/v3.0/ns/core/200704/", "CustomHeaderElement");
            //<CustomHeaderElement xmlns="http://docs.oasis-open.org/ebxml-msg/ebms/v3.0/ns/core/200704/"/>


//            SoapHeaderElement headerElement = header.addHeaderElement(mainTag);


            //StringSource headerSource = new StringSource("foo bar");
            //Transformer transformer = TransformerFactory.newInstance().newTransformer();
            //transformer.transform(headerSource, soapHeader.getResult());
        }
    }
//    public void createSoap() throws SOAPException {
//
//        SOAPMessage soapMessage;
//        MessageFactory messageFactory;

//        SaajSoapMessage message = new SaajSoapMessage(soapMessage, true, messageFactory);

//        MessageFactory factory = MessageFactory.newInstance();
//        SOAPMessage soapMessage = factory.createMessage();
//
//        SOAPPart soapPart = soapMessage.getSOAPPart();
//        SOAPEnvelope soapEnvelope = soapMessage.getSOAPPart().getEnvelope();
//
//        SOAPHeader soapHeader = soapMessage.getSOAPHeader();
////        soapHeader = soapMessage.getSOAPHeader();
//
//        SOAPBody soapBody = soapEnvelope.getBody();
////        soapBody = soapMessage.getSOAPBody();
//
//        SOAPFactory soapFactory = SOAPFactory.newInstance();
//        Name bodyName = soapFactory.createName("myowntag", "wut","urn:MySoapTest" );
//        SOAPBodyElement customtag = soapMessage.getSOAPBody().addDocument(soapPart);
//        Name childName = soapFactory.createName("childname");
//        SOAPElement order = customtag.addChildElement(childName);

//        order.addTextNode("15151515");
//        return soapMessage;

//    }



//    public SubmitResponse getBank(String url, Object requestPayload){
//
//
//        JAXBElement res = null;
//        try {
//            res = (JAXBElement) template.marshalSendAndReceive(url, requestPayload, new WebServiceMessageCallback() {
//
//                @Override
//                public void doWithMessage(WebServiceMessage message) {
//                    try {
//                        SoapHeader soapHeader = ((SoapMessage) message).getSoapHeader();
//                        Map mapRequest = new HashMap();
//
//                        mapRequest.put("loginuser", environment.getProperty("soap.auth.username"));
//                        mapRequest.put("loginpass", environment.getProperty("soap.auth.password"));
//                        StringSubstitutor substitutor = new StringSubstitutor(mapRequest, "%(", ")");
//                        String finalXMLRequest = substitutor.replace(environment.getProperty("soap.auth.header"));
//                        StringSource headerSource = new StringSource(finalXMLRequest);
//                        Transformer transformer = TransformerFactory.newInstance().newTransformer();
//                        transformer.transform(headerSource, soapHeader.getResult());
//                        logger.info("Marshalling of SOAP header success.");
//                    } catch (Exception e) {
//                        logger.error("error during marshalling of the SOAP headers", e);
//                    }
//                }
//            });
//        }catch (SoapFaultClientException e){
//            logger.error("Error while invoking session service : " + e.getMessage());
//            return null;
//        }
//        return res.getValue();
//    }
}
















