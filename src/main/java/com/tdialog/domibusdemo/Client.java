package com.tdialog.domibusdemo;

import backend.ecodex.org._1_1.LargePayloadType;
import backend.ecodex.org._1_1.ObjectFactory;
import backend.ecodex.org._1_1.SubmitRequest;
import backend.ecodex.org._1_1.SubmitResponse;
import org.springframework.stereotype.Component;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.SoapHeader;
import org.springframework.ws.soap.SoapHeaderElement;
import org.springframework.ws.soap.SoapMessage;
import org.w3._2003._05.soap_envelope.Envelope;

import javax.xml.namespace.QName;
import javax.xml.soap.*;
import java.util.*;

@Component
public class Client {

    private final WebServiceTemplate template;

    public Client(WebServiceTemplate template) {
        this.template = template;
    }

    public List<String> pingDomibus() {

        SOAPMessage message;
        ObjectFactory factory = new ObjectFactory();
        org.w3._2003._05.soap_envelope.ObjectFactory factory1 = new org.w3._2003._05.soap_envelope.ObjectFactory();
        //envelope har ingen @xmlroot men SubmitRequest har de
        Envelope envelope = factory1.createEnvelope();
        SubmitRequest request = factory.createSubmitRequest();
//        envelope.setBody(request);

        request.setBodyload( new LargePayloadType());
        request.getBodyload().setPayloadId(UUID.randomUUID().toString());

//            message = createSoap();

        //todo make response work
        System.out.println("Default urI: " + template.getDefaultUri());
        System.out.println("Request: "+request.getBodyload().getPayloadId());
        System.out.println("template "+ template);
        System.out.println("destination "+ template.getDestinationProvider().getDestination());
        System.out.println("marshaller "+ template.getMarshaller());
        SubmitResponse response = (SubmitResponse) template.marshalSendAndReceive(request);



        //doWithMessage
//        template.marshalSendAndReceive(request, new CustomWebServiceMessageCallback());

        System.out.println("Sent");

        return new ArrayList<>();

    }

    public void createSoap() throws SOAPException {

        SOAPMessage soapMessage;
        MessageFactory messageFactory;
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
    }




    public static class CustomWebServiceMessageCallback implements WebServiceMessageCallback
    {


        public void doWithMessage(WebServiceMessage message)
        {
            SoapMessage soapMessage = (SoapMessage)message;
            SoapHeader header = soapMessage.getSoapHeader();
            QName mainTag = new QName("http://docs.oasis-open.org/ebxml-msg/ebms/v3.0/ns/core/200704/", "CustomHeaderElement");

//            QName qName = new QName("http://docs.oasis-open.org/ebxml-msg/ebms/v3.0/ns/core/200704/", "CustomHeaderElement");
            //<CustomHeaderElement xmlns="http://docs.oasis-open.org/ebxml-msg/ebms/v3.0/ns/core/200704/"/>


            SoapHeaderElement headerElement = header.addHeaderElement(mainTag);


            //StringSource headerSource = new StringSource("foo bar");
            //Transformer transformer = TransformerFactory.newInstance().newTransformer();
            //transformer.transform(headerSource, soapHeader.getResult());
        }
    }
}
















