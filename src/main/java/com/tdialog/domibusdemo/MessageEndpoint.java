package com.tdialog.domibusdemo;

import backend.ecodex.org._1_1.*;
import com.sun.istack.internal.ByteArrayDataSource;
import com.sun.xml.messaging.saaj.soap.XmlDataContentHandler;
import eu.domibus.messaging.MessageConstants;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.w3._2003._05.soap_envelope.Envelope;
import se.inera.sdk.message.MessagePayloadType;
import se.inera.sdk.message.StandardBusinessDocument;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.xml.bind.*;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;

@Endpoint
public class MessageEndpoint {

    private final WebServiceTemplate webServiceTemplate;

    @Autowired
    Client client;

    private final String test = MessageConstants.DOMAIN;
    //namespace for the wsdl
    private static final String NAMESPACE = "http://org.ecodex.backend/1_1/";


    public MessageEndpoint(WebServiceTemplate webServiceTemplate) {
        this.webServiceTemplate = webServiceTemplate;
    }

    @PayloadRoot(namespace = NAMESPACE, localPart = "submitRequest")
    @ResponsePayload
    public SubmitResponse submitMessage(@RequestPayload SubmitRequest request) throws JAXBException {
//        System.out.println("Request payload: "+ request.getPayload());

        //TODO WORKING CODE
        DataHandler value = request.getPayload().get(0).getValue();
        try {
            StreamSource source = (StreamSource) value.getContent();
            ByteArrayInputStream input = (ByteArrayInputStream) source.getInputStream();
//            ByteArrayInputStream input = (ByteArrayInputStream) value.getContent();
            String result = IOUtils.toString(input, StandardCharsets.UTF_8);
//            ByteArrayInputStream input = (ByteArrayInputStream) value.getContent();
//            String result = IOUtils.toString(input, StandardCharsets.UTF_8);


            JAXBContext jaxbContext = JAXBContext.newInstance(MessagePayloadType.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            StringReader reader = new StringReader(result);


            JAXBElement<MessagePayloadType> elemento = (JAXBElement<MessagePayloadType>)unmarshaller.unmarshal(reader);
            MessagePayloadType object = elemento.getValue();

            System.out.println(object.getMessage().getMessageHeader().getConversationId());
            //TODO END OF WORKING CODE
//            System.out.println("RESULT: "+ result);
//            System.out.println("CONTENT: " + value.getContent() + "END CONTENT");
//
//            JAXBContext context = JAXBContext.newInstance(MessagePayloadType.class);
//            Unmarshaller unmarshaller = context.createUnmarshaller();
//            MessagePayloadType object = (MessagePayloadType) unmarshaller.unmarshal(input);
//            System.out.println("OBJECT: " +object.toString());



//            MessagePayloadType payload = (MessagePayloadType) unmarshaller.unmarshal(reader);


//            XmlDataContentHandler xmlDataContentHandler = new XmlDataContentHandler();
//            DataSource source = new  ByteArrayDataSource(attachment.getData(),"application/octet-stream");
//            JAXBElement<Envelope> envelopeJAXBElement = (JAXBElement<Envelope>) xmlDataContentHandler.getContent(value.getDataSource());
//            System.out.println("ENVELOPE: "+ envelopeJAXBElement.getValue());



//        JAXBContext jc = JAXBContext.newInstance (MessagePayloadType.class);
//        Unmarshaller unmarshaller = jc.createUnmarshaller();
//        MessagePayloadType obj = (MessagePayloadType) unmarshaller.unmarshal(input);

//        System.out.println("THE OBJECT: "+ obj.toString());
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }

//        try {
////            System.out.println(value.getContent());
//            MessagePayloadType payload = (MessagePayloadType) value.getContent();
//            System.out.println("PAYLOAD: "+ payload.getStandardBusinessDocument().getSender().get(0).getIdentifier().getAuthority());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return client.submitMessage();
    }

    //just to show how you have several endpoints
    @PayloadRoot(namespace = NAMESPACE, localPart = "listPendingMessagesRequest")
    @ResponsePayload
    public ListPendingMessagesResponse listPendingMessages(@RequestPayload JAXBElement<Object> request) {
        System.out.println("PendingMessageRequest: " + request);
        return client.listPendingMessages(request);
    }

    @PayloadRoot(namespace = NAMESPACE, localPart = "retrieveMessageRequest")
    @ResponsePayload
    public RetrieveMessageResponse retrieveMessage(@RequestPayload RetrieveMessageRequest request) {
        System.out.println("RetrievingMessage: " + request);
        return client.retrieveMessage(request);
    }
}
