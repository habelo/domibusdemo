package com.tdialog.domibusdemo;

import backend.ecodex.org._1_1.*;
import eu.domibus.messaging.MessageConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;

@Endpoint
public class MessageEndpoint {

    private final WebServiceTemplate webServiceTemplate;

    @Autowired
    Client client;

    private final String test = MessageConstants.DOMAIN;
    //namespace for the wsdl
    private static final String NAMESPACE = "http://org.ecodex.backend/1_1/";
    //envelope namespace
//    private static final String NAMESPACE = "http://www.w3.org/2003/05/soap-envelope";


    public MessageEndpoint(WebServiceTemplate webServiceTemplate) {
        this.webServiceTemplate = webServiceTemplate;
    }

    @PayloadRoot(namespace = NAMESPACE, localPart = "submitRequest")
    @ResponsePayload
    public SubmitResponse submitMessage(@RequestPayload SubmitRequest request) throws JAXBException {
        System.out.println("Request payload: "+ request.getPayload());
//        Client client = new Client(webServiceTemplate);
//        client.submitMessage();
        return client.submitMessage();
//        return new SubmitResponse();
    }

    //just to show how you have several endpoints
    @PayloadRoot(namespace = NAMESPACE, localPart = "listPendingMessagesRequest")
    @ResponsePayload
    public ListPendingMessagesResponse listPendingMessages(@RequestPayload JAXBElement<Object> request){
//    public ListPendingMessagesResponse listPendingMessages(@RequestPayload Object request){
        System.out.println("PendingMessageRequest: "+ request);
        return client.listPendingMessages(request);
    }

    @PayloadRoot(namespace = NAMESPACE, localPart = "retrieveMessageRequest")
    @ResponsePayload
    public RetrieveMessageResponse retrieveMessage(@RequestPayload RetrieveMessageRequest request){
        System.out.println("RetrievingMessage: "+ request);
        return client.retrieveMessage(request);
    }
}
