package com.tdialog.domibusdemo;

import backend.ecodex.org._1_1.SubmitRequest;
import backend.ecodex.org._1_1.SubmitResponse;
import com.tdialog.domibusdemo.impl.Connector;
import eu.domibus.messaging.MessageConstants;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class MessageEndpoint {

    private final String test = MessageConstants.DOMAIN;
    //namespace for the wsdl
    private static final String NAMESPACE = "http://org.ecodex.backend/1_1/";
    //envelope namespace
//    private static final String NAMESPACE = "http://www.w3.org/2003/05/soap-envelope";

    private final Connector connector = new Connector("test");

//    @PayloadRoot(namespace = NAMESPACE, localPart = "Messaging")
//    @ResponsePayload
//    public Messaging getMessage(@RequestPayload Messaging messaging){
//        System.out.println(messaging.getUserMessage());
//        return messaging;
//    }
    @PayloadRoot(namespace = NAMESPACE, localPart = "submitRequest")
    @ResponsePayload
    public SubmitResponse getMessage(@RequestPayload SubmitRequest request){
        System.out.println(request);
        return new SubmitResponse();
    }

}
