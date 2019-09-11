package com.tdialog.domibusdemo;

import backend.ecodex.org._1_1.SubmitResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class Client extends WebServiceGatewaySupport {

    public Object getMessage(String url, Object request){

        return getWebServiceTemplate().marshalSendAndReceive(url, request);
    }
}
