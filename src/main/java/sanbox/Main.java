package sanbox;

import com.tdialog.domibusdemo.Client;
import com.tdialog.domibusdemo.Message;
import org.xml.sax.SAXException;
import se.inera.sdk.message.ObjectFactory;
import se.inera.sdk.message.Partner;
import se.inera.sdk.message.StandardBusinessDocument;
import se.inera.sdk.message.StandardBusinessDocumentHeader;

import javax.activation.DataHandler;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Base64;
import java.util.UUID;

//sandboxclass with no effect on application
public class Main {


    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
//        System.out.println("hej");
//        System.out.println(new String(Base64.getDecoder().decode("PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiI" +
//                "HN0YW5kYWxvbmU9InllcyI/Pgo8bnMyOm1lc3NhZ2VQYXlsb2FkIHhtbG5zPSJodHRwOi8vd3d3LnVuZWNlLm9yZy9jZWZhY3QvbmFt" +
//                "ZXNwYWNlcy9TdGFuZGFyZEJ1c2luZXNzRG9jdW1lbnRIZWFkZXIiIHhtbG5zOm5zMj0idXJuOnJpdjppbmZyYXN0cnVjdHVyZTptZXN" +
//                "zYWdpbmc6TWVzc2FnZVdpdGhBdHRhY2htZW50czoxIj4KICAgIDxuczI6c3RhbmRhcmRCdXNpbmVzc0RvY3VtZW50PgogICAgICAgID" +
//                "xTZW5kZXI+CiAgICAgICAgICAgIDxJZGVudGlmaWVyIEF1dGhvcml0eT0icml2LWFjdG9yaWQtdW5yZWdpc3RlcmVkIj48L0lkZW50a" +
//                "WZpZXI+CiAgICAgICAgPC9TZW5kZXI+CiAgICAgICAgPFJlY2VpdmVyPgogICAgICAgICAgICA8SWRlbnRpZmllciBBdXRob3JpdHk9" +
//                "InJpdi1hY3RvcmlkLXVucmVnaXN0ZXJlZCI+PC9JZGVudGlmaWVyPgogICAgICAgIDwvUmVjZWl2ZXI+CiAgICAgICAgPERvY3VtZW5" +
//                "0SWRlbnRpZmljYXRpb24+CiAgICAgICAgICAgIDxTdGFuZGFyZD51cm46cml2OmluZnJhc3RydWN0dXJlOm1lc3NhZ2luZzpNZXNzYW" +
//                "dlV2l0aEF0dGFjaG1lbnRzOjE8L1N0YW5kYXJkPgogICAgICAgIDwvRG9jdW1lbnRJZGVudGlmaWNhdGlvbj4KICAgIDwvbnMyOnN0Y" +
//                "W5kYXJkQnVzaW5lc3NEb2N1bWVudD4KICAgIDxuczI6bWVzc2FnZT4KICAgICAgICA8bnMyOm1lc3NhZ2VIZWFkZXI+CiAgICAgICAg" +
//                "ICAgIDxuczI6Y3JlYXRpb25EYXRlVGltZT4yMDE5LTEwLTAyVDEzOjIwOjExLjUzNFo8L25zMjpjcmVhdGlvbkRhdGVUaW1lPgogICA" +
//                "gICAgICAgICA8bnMyOmxhYmVsPjwvbnMyOmxhYmVsPgogICAgICAgICAgICA8bnMyOmNvbmZpZGVudGlhbGl0eT5mYWxzZTwvbnMyOm" +
//                "NvbmZpZGVudGlhbGl0eT4KICAgICAgICAgICAgPG5zMjpyZWNpcGllbnQ+CiAgICAgICAgICAgICAgICA8bnMyOnJlY2lwaWVudElEP" +
//                "gogICAgICAgICAgICAgICAgICAgIDxuczI6cm9vdD5yaXYtYWN0b3JpZC11bnJlZ2lzdGVyZWQ8L25zMjpyb290PgogICAgICAgICAg" +
//                "ICAgICAgICAgIDxuczI6ZXh0ZW5zaW9uPjwvbnMyOmV4dGVuc2lvbj4KICAgICAgICAgICAgICAgIDwvbnMyOnJlY2lwaWVudElEPgo" +
//                "gICAgICAgICAgICAgICAgPG5zMjphdHRlbnRpb24+CiAgICAgICAgICAgICAgICAgICAgPG5zMjpwZXJzb24+CiAgICAgICAgICAgIC" +
//                "AgICAgICAgICAgIDxuczI6cGVyc29uSWQ+CiAgICAgICAgICAgICAgICAgICAgICAgICAgICA8bnMyOnJvb3Q+PC9uczI6cm9vdD4KI" +
//                "CAgICAgICAgICAgICAgICAgICAgICAgICAgIDxuczI6ZXh0ZW5zaW9uPjwvbnMyOmV4dGVuc2lvbj4KICAgICAgICAgICAgICAgICAgI" +
//                "CAgICAgPC9uczI6cGVyc29uSWQ+CiAgICAgICAgICAgICAgICAgICAgICAgIDxuczI6bGFiZWw+PC9uczI6bGFiZWw+CiAgICAgICAgI" +
//                "CAgICAgICAgICAgPC9uczI6cGVyc29uPgogICAgICAgICAgICAgICAgICAgIDxuczI6c3ViT3JnYW5pemF0aW9uPgogICAgICAgICAgI" +
//                "CAgICAgICAgICAgICA8bnMyOm9yZ2FuaXphdGlvbklkPgogICAgICAgICAgICAgICAgICAgICAgICAgICAgPG5zMjpleHRlbnNpb24+P" +
//                "C9uczI6ZXh0ZW5zaW9uPgogICAgICAgICAgICAgICAgICAgICAgICA8L25zMjpvcmdhbml6YXRpb25JZD4KICAgICAgICAgICAgICAgI" +
//                "CAgICAgICAgPG5zMjpsYWJlbD48L25zMjpsYWJlbD4KICAgICAgICAgICAgICAgICAgICA8L25zMjpzdWJPcmdhbml6YXRpb24+CiAgI" +
//                "CAgICAgICAgICAgICA8L25zMjphdHRlbnRpb24+CiAgICAgICAgICAgIDwvbnMyOnJlY2lwaWVudD4KICAgICAgICAgICAgPG5zMjpz" +
//                "ZW5kZXI+CiAgICAgICAgICAgICAgICA8bnMyOnNlbmRlcklEPgogICAgICAgICAgICAgICAgICAgIDxuczI6cm9vdD5yaXYtYWN0b3Jp" +
//                "ZC11bnJlZ2lzdGVyZWQ8L25zMjpyb290PgogICAgICAgICAgICAgICAgICAgIDxuczI6ZXh0ZW5zaW9uPnh5ei1rb21tdW4uc2U8L25z" +
//                "MjpleHRlbnNpb24+CiAgICAgICAgICAgICAgICA8L25zMjpzZW5kZXJJRD4KICAgICAgICAgICAgICAgIDxuczI6YXR0ZW50aW9uPgog" +
//                "ICAgICAgICAgICAgICAgICAgIDxuczI6cGVyc29uPgogICAgICAgICAgICAgICAgICAgICAgICA8bnMyOnBlcnNvbklkPgogICAgICAg" +
//                "ICAgICAgICAgICAgICAgICAgICAgPG5zMjpyb290PjwvbnMyOnJvb3Q+CiAgICAgICAgICAgICAgICAgICAgICAgICAgICA8bnMyOmV4" +
//                "dGVuc2lvbj48L25zMjpleHRlbnNpb24+CiAgICAgICAgICAgICAgICAgICAgICAgIDwvbnMyOnBlcnNvbklkPgogICAgICAgICAgICAg" +
//                "ICAgICAgICAgICA8bnMyOmxhYmVsPjwvbnMyOmxhYmVsPgogICAgICAgICAgICAgICAgICAgIDwvbnMyOnBlcnNvbj4KICAgICAgICAg" +
//                "ICAgICAgICAgICA8bnMyOnN1Yk9yZ2FuaXphdGlvbj4KICAgICAgICAgICAgICAgICAgICAgICAgPG5zMjpvcmdhbml6YXRpb25JZD4K" +
//                "ICAgICAgICAgICAgICAgICAgICAgICAgICAgIDxuczI6cm9vdD5zdW5kYnliZXJnLnNlPC9uczI6cm9vdD4KICAgICAgICAgICAgICAg" +
//                "ICAgICAgICAgPC9uczI6b3JnYW5pemF0aW9uSWQ+CiAgICAgICAgICAgICAgICAgICAgICAgIDxuczI6bGFiZWw+U29jaWFsdGrDpG5z" +
//                "dGVuIFN1bmRieWJlcmcgc3RhZDwvbnMyOmxhYmVsPgogICAgICAgICAgICAgICAgICAgIDwvbnMyOnN1Yk9yZ2FuaXphdGlvbj4KICAg" +
//                "ICAgICAgICAgICAgIDwvbnMyOmF0dGVudGlvbj4KICAgICAgICAgICAgPC9uczI6c2VuZGVyPgogICAgICAgIDwvbnMyOm1lc3NhZ2VI" +
//                "ZWFkZXI+CiAgICAgICAgPG5zMjptZXNzYWdlQm9keT4KICAgICAgICAgICAgPG5zMjpkb2N1bWVudHM+CiAgICAgICAgICAgICAgICA8" +
//                "bnMyOmRvY3VtZW50SUQ+PC9uczI6ZG9jdW1lbnRJRD4KICAgICAgICAgICAgICAgIDxuczI6ZG9jdW1lbnROYW1lPjwvbnMyOmRvY3Vt" +
//                "ZW50TmFtZT4KICAgICAgICAgICAgICAgIDxuczI6aW5kZXg+MTwvbnMyOmluZGV4PgogICAgICAgICAgICAgICAgPG5zMjpDb250ZW50" +
//                "VGV4dD4KICAgICAgICAgICAgICAgICAgICA8bnMyOmNoYXJhY3RlclNlcXVlbmNlPjwvbnMyOmNoYXJhY3RlclNlcXVlbmNlPgogICAg" +
//                "ICAgICAgICAgICAgPC9uczI6Q29udGVudFRleHQ+CiAgICAgICAgICAgIDwvbnMyOmRvY3VtZW50cz4KICAgICAgICA8L25zMjptZXNz" +
//                "YWdlQm9keT4KICAgIDwvbnMyOm1lc3NhZ2U+CjwvbnMyOm1lc3NhZ2VQYXlsb2FkPgo=")));
//
//        backend.ecodex.org._1_1.ObjectFactory factory = new backend.ecodex.org._1_1.ObjectFactory();
//
//        ObjectFactory factory1 = new ObjectFactory();
//        StandardBusinessDocument xml = factory1.createStandardBusinessDocument();
//        StandardBusinessDocumentHeader header = factory1.createStandardBusinessDocumentHeader();
//        header.getSender().add(new Partner());
//        xml.setStandardBusinessDocumentHeader(header);
//        DataHandler dataHandler = new DataHandler(xml, "text/xml");
//        System.out.println(dataHandler.getContent());

        DataHandler testHandler = new DataHandler(get(), "text/xml");
        System.out.println(testHandler.getContent().toString());

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
