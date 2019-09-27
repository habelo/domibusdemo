package sanbox;

import org.xml.sax.SAXException;
import se.inera.sdk.message.ObjectFactory;
import se.inera.sdk.message.Partner;
import se.inera.sdk.message.StandardBusinessDocument;
import se.inera.sdk.message.StandardBusinessDocumentHeader;

import javax.activation.DataHandler;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Base64;

public class Main {


    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        System.out.println("hej");
        System.out.println(new String(Base64.getDecoder().decode("PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9InllcyI/Pgo8U3RhbmRhcmRCdXNpbmVzc0RvY3VtZW50IHhtbG5zOm5zMj0iaHR0cDovL3d3dy51bmVjZS5vcmcvY2VmYWN0L25hbWVzcGFjZXMvU3RhbmRhcmRCdXNpbmVzc0RvY3VtZW50SGVhZGVyIiB4bWxuczpuczM9InVybjpyaXY6aW5mcmFzdHJ1Y3R1cmU6bWVzc2FnaW5nOk1lc3NhZ2VXaXRoQXR0YWNobWVudHM6MSI+CiAgICA8ZG9jdW1lbnQ+CiAgICAgICAgPG5zMjpTdGFuZGFyZEJ1c2luZXNzRG9jdW1lbnRIZWFkZXI+CiAgICAgICAgICAgIDxuczI6U2VuZGVyLz4KICAgICAgICA8L25zMjpTdGFuZGFyZEJ1c2luZXNzRG9jdW1lbnRIZWFkZXI+CiAgICA8L2RvY3VtZW50Pgo8L1N0YW5kYXJkQnVzaW5lc3NEb2N1bWVudD4K")));

//        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//        DocumentBuilder builder = factory.newDocumentBuilder();


//        Document document = builder.parse(new InputSource(new StringReader(get())));
        ObjectFactory factory1 = new ObjectFactory();
        StandardBusinessDocument xml = factory1.createStandardBusinessDocument();
        StandardBusinessDocumentHeader header = factory1.createStandardBusinessDocumentHeader();
        header.getSender().add(new Partner());
        xml.setStandardBusinessDocumentHeader(header);
        DataHandler dataHandler = new DataHandler(xml, "text/xml");
        System.out.println(dataHandler.getContent());
    }


    private static String get(){
        return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<StandardBusinessDocument xmlns=\"http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader\"\n" +
                "                          xmlns:ns2=\"urn:riv:infrastructure:messaging:MessageWithAttachments:1\">\n" +
                "    <StandardBusinessDocumentHeader>\n" +
                "        <Sender>\n" +
                "            <Identifier Authority=\"iso6523-actorid-upis\">testb.testbed.inera.se</Identifier><!-- Ändra Här SÄNDANDE ORGANISATION -->\n" +
                "        </Sender>\n" +
                "        <Receiver>\n" +
                "            <Identifier Authority=\"iso6523-actorid-upis\">testa.testbed.inera.se</Identifier><!-- Ändra Här MOTTAGANDE ORGANISATION -->\n" +
                "        </Receiver>\n" +
                "        <DocumentIdentification>\n" +
                "            <Standard>urn:riv:infrastructure:messaging:MessageWithAttachments:1</Standard>\n" +
                "        </DocumentIdentification>\n" +
                "    </StandardBusinessDocumentHeader>\n" +
                "    <message>\n" +
                "        <ns2:messageHeader>\n" +
                "            <ns2:messageId>9bfab169-71e6-4ca8-8de0-60545c039f9a</ns2:messageId><!-- Ändra Här UUID MEDDELANDEID - MEDDELANDELAGER -->\n" +
                "            <ns2:conversationId>9bfab169-71e6-4ca8-8de0-60545c039f9a</ns2:conversationId><!-- Ändra Här UUID CONVERSATIONID - MEDDELANDELAGER -->\n" +
                "            <ns2:label>Test utan attachment till Glenn</ns2:label>\n" +
                "            <ns2:confidentiality>false</ns2:confidentiality>\n" +
                "            <ns2:reciptient>\n" +
                "                <ns2:recipientID>\n" +
                "                    <ns2:root>iso6523-actorid-upis</ns2:root><!-- Se över -->\n" +
                "                    <ns2:extension>testa.testbed.inera.se</ns2:extension><!-- Ändra Här MOTTAGANDE ORGANISATION -->\n" +
                "                </ns2:recipientID>\n" +
                "                <ns2:attention>\n" +
                "                    <ns2:person>\n" +
                "                        <ns2:personId>\n" +
                "                            <ns2:extension>Glenn</ns2:extension>\n" +
                "                        </ns2:personId>\n" +
                "                    </ns2:person>\n" +
                "                    <ns2:subOrganization>\n" +
                "                        <ns2:organizationId>\n" +
                "                            <ns2:extension>testa.demo1.inera.se</ns2:extension><!-- Ändra Här FUNKTIONSBREVLÅDA I SDK TESTBÄDD -->\n" +
                "                        </ns2:organizationId>\n" +
                "                    </ns2:subOrganization>\n" +
                "                </ns2:attention>\n" +
                "            </ns2:reciptient>\n" +
                "            <ns2:sender>\n" +
                "                <ns2:senderID>\n" +
                "                    <ns2:root>iso6523-actorid-upis</ns2:root><!-- Se över -->\n" +
                "                    <ns2:extension>testb.testbed.inera.se</ns2:extension><!-- Ändra Här SÄNDANDE ORGANISATION -->\n" +
                "                </ns2:senderID>\n" +
                "                <ns2:attention>\n" +
                "                    <ns2:person>\n" +
                "                        <ns2:personId>\n" +
                "                            <ns2:extension>Veiron</ns2:extension>\n" +
                "                        </ns2:personId>\n" +
                "                    </ns2:person>\n" +
                "                    <ns2:subOrganization>\n" +
                "                        <ns2:organizationId>\n" +
                "                            <ns2:extension>vaktmästeriet.fejk.se</ns2:extension><!-- Ändra Här AVSÄNDARES FUNKTIONSBREVLÅDA-->\n" +
                "                        </ns2:organizationId>\n" +
                "                    </ns2:subOrganization>\n" +
                "                </ns2:attention>\n" +
                "            </ns2:sender>\n" +
                "        </ns2:messageHeader>\n" +
                "        <ns2:messageBody>\n" +
                "            <ns2:documents>\n" +
                "                <ns2:documentID>SDK Testmeddelande</ns2:documentID>\n" +
                "                <ns2:documentName>SDK Testmeddelande</ns2:documentName>\n" +
                "                <ns2:index>1</ns2:index>\n" +
                "                <ns2:ContentText>\n" +
                "                    <ns2:characterSequence>Ett enkelt testmeddelande till Glenn utan bifogad fil.</ns2:characterSequence>\n" +
                "                </ns2:ContentText>\n" +
                "            </ns2:documents>\n" +
                "            <ns2:creationDateTime>2019-04-15T16:39:45.263+02:00</ns2:creationDateTime>\n" +
                "        </ns2:messageBody>\n" +
                "    </message>\n" +
                "</StandardBusinessDocument>";
    }
}
