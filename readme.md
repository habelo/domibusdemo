Demo project for the communication between a Domibus server and a SpringBootApplication.

Soap, As4, eDelivery, StandardBusinessDocumentHeader

* Config = configs what the reciever endpoints have to deal with
* ClientConfig = what the WebServiceTemplate sends to and how to marshall(convert) the xml object (which class)
* Two plugins in maven for creating objects, one for wsdl, one for xsd(sdk)
Best practice would be for these to create the objects straight into target, which in now does with the
<xjcArg>-mark-generated</xjcArg> in pom file