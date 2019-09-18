package com.tdialog.domibusdemo;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.soap.SoapVersion;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.ws.wsdl.wsdl11.SimpleWsdl11Definition;
import org.springframework.ws.wsdl.wsdl11.Wsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;


@EnableWs
@Configuration
public class Config extends WsConfigurerAdapter {

    //better config
    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext context){

        MessageDispatcherServlet dispatcherServlet = new MessageDispatcherServlet();
        dispatcherServlet.setApplicationContext(context);
        dispatcherServlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(dispatcherServlet, "/ws");
    }

    @Bean(name = "backendservice_1_1")
    public Wsdl11Definition defaultWsdl11Definition() {
        SimpleWsdl11Definition wsdl11Definition =
                new SimpleWsdl11Definition();
        wsdl11Definition
                .setWsdl(new ClassPathResource("META-INF/wsdl/BackendService_1_1.wsdl"));

        return wsdl11Definition;
    }



    //first working config
//    @Bean(name = "backendservice_1_1")
//    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema domibusBackend){
//
//        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
//        definition.setTargetNamespace("http://org.ecodex.backend/1_1/");
//        definition.setPortTypeName("BackendInterface");
//        definition.setLocationUri("/ws");
//        definition.setSchema(domibusBackend);
//        return definition;
//    }
//
//    @Bean
//    public XsdSchema domibusBackend(){
//        return new SimpleXsdSchema(new ClassPathResource("domibus-backend.xsd"));
//    }



    //non-working config
//    @Bean
//    public Jaxb2Marshaller marshaller(){
//        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
//        marshaller.setContextPath("META-INF/wsdl");
//        return marshaller;
//    }
//
//    @Bean
//    public Client client(Jaxb2Marshaller marshaller){
//        Client client = new Client();
//        client.setDefaultUri("http://localhost:8080/test");
//        client.setMarshaller(marshaller);
//        client.setUnmarshaller(marshaller);
//        return client;
//    }




//    @Bean
//    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext){
//
//        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
//        servlet.setApplicationContext(applicationContext);
//        servlet.setTransformWsdlLocations(true);
//        return new ServletRegistrationBean(servlet, "/test/*");
//    }
//
//    @Bean(name = "submissions")
//    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema submissionsSchema){
//        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
//        definition.setPortTypeName("SubmissionsPort");
//        definition.setLocationUri("/test");
//        definition.setTargetNamespace("http://docs.oasis-open.org/ebxml-msg/ebms/v3.0/ns/core/200704/");
//        definition.setSchema(submissionsSchema);
//        return definition;
//    }
//
//    @Bean
//    public XsdSchema submissionsSchema(){
//        return new SimpleXsdSchema(new ClassPathResource("domibus-submission.xsd"));
//    }




    @Bean
    public SaajSoapMessageFactory messageFactory() {
        SaajSoapMessageFactory messageFactory = new SaajSoapMessageFactory();
        messageFactory.setSoapVersion(SoapVersion.SOAP_12);
        return messageFactory;
    }

}
