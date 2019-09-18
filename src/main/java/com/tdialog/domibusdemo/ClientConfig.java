package com.tdialog.domibusdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;

@Configuration
public class ClientConfig {

    @Bean
    Jaxb2Marshaller jaxb2Marshaller() {
        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        jaxb2Marshaller
//                .setContextPath("org.w3._2005._05.xmlmime");
//                .setContextPath("org.w3._2005._05.xmlmime:org.w3._2003._05.soap_envelope:org.oasis_open.docs.ebxml_msg.ebms.v3_0.ns.core._200704:backend.ecodex.org._1_1");
                .setContextPath("backend.ecodex.org._1_1");

        return jaxb2Marshaller;
    }

    @Bean
    public WebServiceTemplate webServiceTemplate() {
        WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
        webServiceTemplate.setMarshaller(jaxb2Marshaller());
        webServiceTemplate.setUnmarshaller(jaxb2Marshaller());
        webServiceTemplate.setDefaultUri(
                "http://localhost:8080/domibus/services/backend");
//                "http://127.0.0.1:8080/domibus/services/backend");

        return webServiceTemplate;
    }
}
