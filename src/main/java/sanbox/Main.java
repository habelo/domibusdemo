package sanbox;

import org.xml.sax.SAXException;
import se.inera.sdk.message.ObjectFactory;
import se.inera.sdk.message.Partner;
import se.inera.sdk.message.StandardBusinessDocument;
import se.inera.sdk.message.StandardBusinessDocumentHeader;

import javax.activation.DataHandler;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Base64;

//sandboxclass with no effect on application
public class Main {


    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        System.out.println("hej");
        System.out.println(new String(Base64.getDecoder().decode("PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9InllcyI/Pgo8bnMyOm1lc3NhZ2VQYXlsb2FkIHhtbG5zPSJodHRwOi8vd3d3LnVuZWNlLm9yZy9jZWZhY3QvbmFtZXNwYWNlcy9TdGFuZGFyZEJ1c2luZXNzRG9jdW1lbnRIZWFkZXIiIHhtbG5zOm5zMj0idXJuOnJpdjppbmZyYXN0cnVjdHVyZTptZXNzYWdpbmc6TWVzc2FnZVdpdGhBdHRhY2htZW50czoxIj4KICAgIDxuczI6c3RhbmRhcmRCdXNpbmVzc0RvY3VtZW50PgogICAgICAgIDxTZW5kZXI+CiAgICAgICAgICAgIDxJZGVudGlmaWVyIEF1dGhvcml0eT0icml2LWFjdG9yaWQtdW5yZWdpc3RlcmVkIj50ZXN0YmVkLmluZXJhLnNlPC9JZGVudGlmaWVyPgogICAgICAgIDwvU2VuZGVyPgogICAgICAgIDxSZWNlaXZlcj4KICAgICAgICAgICAgPElkZW50aWZpZXIgQXV0aG9yaXR5PSJyaXYtYWN0b3JpZC11bnJlZ2lzdGVyZWQiPnRlc3RiZWQuaW5lcmEuc2U8L0lkZW50aWZpZXI+CiAgICAgICAgPC9SZWNlaXZlcj4KICAgICAgICA8RG9jdW1lbnRJZGVudGlmaWNhdGlvbj4KICAgICAgICAgICAgPFN0YW5kYXJkPnVybjpyaXY6aW5mcmFzdHJ1Y3R1cmU6bWVzc2FnaW5nOk1lc3NhZ2VXaXRoQXR0YWNobWVudHM6MTwvU3RhbmRhcmQ+CiAgICAgICAgPC9Eb2N1bWVudElkZW50aWZpY2F0aW9uPgogICAgPC9uczI6c3RhbmRhcmRCdXNpbmVzc0RvY3VtZW50PgogICAgPG5zMjptZXNzYWdlPgogICAgICAgIDxuczI6bWVzc2FnZUhlYWRlcj4KICAgICAgICAgICAgPG5zMjpjcmVhdGlvbkRhdGVUaW1lPjIwMTktMDktMzBUMTI6MDc6MTguMjMyWjwvbnMyOmNyZWF0aW9uRGF0ZVRpbWU+CiAgICAgICAgICAgIDxuczI6bWVzc2FnZUlkPjlmYmFkNDBlLTY4MGUtNGIwMy1iNDY3LTFlOGFlY2Y2NTRhMjwvbnMyOm1lc3NhZ2VJZD4KICAgICAgICAgICAgPG5zMjpjb252ZXJzYXRpb25JZD40YTQyYzY2Mi1kZmFmLTRjYWMtYjM3Ny04YTJmMzJlODhiYjk8L25zMjpjb252ZXJzYXRpb25JZD4KICAgICAgICAgICAgPG5zMjpsYWJlbD50ZXN0IHV0YW4gYXR0YWNobWVudDwvbnMyOmxhYmVsPgogICAgICAgICAgICA8bnMyOmNvbmZpZGVudGlhbGl0eT5mYWxzZTwvbnMyOmNvbmZpZGVudGlhbGl0eT4KICAgICAgICAgICAgPG5zMjpyZWNpcGllbnQ+CiAgICAgICAgICAgICAgICA8bnMyOnJlY2lwaWVudElEPgogICAgICAgICAgICAgICAgICAgIDxuczI6cm9vdD5yaXYtYWN0b3JpZC11bnJlZ2lzdGVyZWQ8L25zMjpyb290PgogICAgICAgICAgICAgICAgICAgIDxuczI6ZXh0ZW5zaW9uPnRlc3RiZWQuaW5lcmEuc2U8L25zMjpleHRlbnNpb24+CiAgICAgICAgICAgICAgICA8L25zMjpyZWNpcGllbnRJRD4KICAgICAgICAgICAgICAgIDxuczI6YXR0ZW50aW9uPgogICAgICAgICAgICAgICAgICAgIDxuczI6cGVyc29uPgogICAgICAgICAgICAgICAgICAgICAgICA8bnMyOnBlcnNvbklkPgogICAgICAgICAgICAgICAgICAgICAgICAgICAgPG5zMjpyb290PjEuMi43NTIuMTI5LjIuMS40LjE8L25zMjpyb290PgogICAgICAgICAgICAgICAgICAgICAgICAgICAgPG5zMjpleHRlbnNpb24+dGVzdGJlZC5pbmVyYS5zZTwvbnMyOmV4dGVuc2lvbj4KICAgICAgICAgICAgICAgICAgICAgICAgPC9uczI6cGVyc29uSWQ+CiAgICAgICAgICAgICAgICAgICAgICAgIDxuczI6bGFiZWw+S2FyaW4gU0RLIFN2ZW5zc29uPC9uczI6bGFiZWw+CiAgICAgICAgICAgICAgICAgICAgPC9uczI6cGVyc29uPgogICAgICAgICAgICAgICAgICAgIDxuczI6c3ViT3JnYW5pemF0aW9uPgogICAgICAgICAgICAgICAgICAgICAgICA8bnMyOm9yZ2FuaXphdGlvbklkPgogICAgICAgICAgICAgICAgICAgICAgICAgICAgPG5zMjpyb290PnRlc3N0YmVkLmluZXJhLnNlPC9uczI6cm9vdD4KICAgICAgICAgICAgICAgICAgICAgICAgPC9uczI6b3JnYW5pemF0aW9uSWQ+CiAgICAgICAgICAgICAgICAgICAgICAgIDxuczI6bGFiZWw+RnVua3Rpb25zYnJldmzDpWRhIGbDtnIgeHl6IGtvbW11bmVyPC9uczI6bGFiZWw+CiAgICAgICAgICAgICAgICAgICAgPC9uczI6c3ViT3JnYW5pemF0aW9uPgogICAgICAgICAgICAgICAgPC9uczI6YXR0ZW50aW9uPgogICAgICAgICAgICA8L25zMjpyZWNpcGllbnQ+CiAgICAgICAgICAgIDxuczI6c2VuZGVyPgogICAgICAgICAgICAgICAgPG5zMjpzZW5kZXJJRD4KICAgICAgICAgICAgICAgICAgICA8bnMyOnJvb3Q+cml2LWFjdG9yaWQtdW5yZWdpc3RlcmVkPC9uczI6cm9vdD4KICAgICAgICAgICAgICAgICAgICA8bnMyOmV4dGVuc2lvbj54eXota29tbXVuLnNlPC9uczI6ZXh0ZW5zaW9uPgogICAgICAgICAgICAgICAgPC9uczI6c2VuZGVySUQ+CiAgICAgICAgICAgICAgICA8bnMyOmF0dGVudGlvbj4KICAgICAgICAgICAgICAgICAgICA8bnMyOnBlcnNvbj4KICAgICAgICAgICAgICAgICAgICAgICAgPG5zMjpwZXJzb25JZD4KICAgICAgICAgICAgICAgICAgICAgICAgICAgIDxuczI6cm9vdD5YWS1JRC1TVEFOREFSRDwvbnMyOnJvb3Q+CiAgICAgICAgICAgICAgICAgICAgICAgICAgICA8bnMyOmV4dGVuc2lvbj5YWVotSUQtNjc4OTA8L25zMjpleHRlbnNpb24+CiAgICAgICAgICAgICAgICAgICAgICAgIDwvbnMyOnBlcnNvbklkPgogICAgICAgICAgICAgICAgICAgICAgICA8bnMyOmxhYmVsPkFuZGVycyBBbmRlcnNzb248L25zMjpsYWJlbD4KICAgICAgICAgICAgICAgICAgICA8L25zMjpwZXJzb24+CiAgICAgICAgICAgICAgICAgICAgPG5zMjpzdWJPcmdhbml6YXRpb24+CiAgICAgICAgICAgICAgICAgICAgICAgIDxuczI6b3JnYW5pemF0aW9uSWQ+CiAgICAgICAgICAgICAgICAgICAgICAgICAgICA8bnMyOnJvb3Q+c3VuZGJ5YmVyZy5zZTwvbnMyOnJvb3Q+CiAgICAgICAgICAgICAgICAgICAgICAgIDwvbnMyOm9yZ2FuaXphdGlvbklkPgogICAgICAgICAgICAgICAgICAgICAgICA8bnMyOmxhYmVsPlN1bmRieWJlcmcgc3RhZDwvbnMyOmxhYmVsPgogICAgICAgICAgICAgICAgICAgIDwvbnMyOnN1Yk9yZ2FuaXphdGlvbj4KICAgICAgICAgICAgICAgIDwvbnMyOmF0dGVudGlvbj4KICAgICAgICAgICAgPC9uczI6c2VuZGVyPgogICAgICAgIDwvbnMyOm1lc3NhZ2VIZWFkZXI+CiAgICAgICAgPG5zMjptZXNzYWdlQm9keT4KICAgICAgICAgICAgPG5zMjpkb2N1bWVudHM+CiAgICAgICAgICAgICAgICA8bnMyOmRvY3VtZW50SUQ+U0RLIHRlc3RtZWRkZWxhbmRlPC9uczI6ZG9jdW1lbnRJRD4KICAgICAgICAgICAgICAgIDxuczI6ZG9jdW1lbnROYW1lPlNESyB0ZXN0YXIgbWVkZGVsYW5kZTwvbnMyOmRvY3VtZW50TmFtZT4KICAgICAgICAgICAgICAgIDxuczI6aW5kZXg+MTwvbnMyOmluZGV4PgogICAgICAgICAgICAgICAgPG5zMjpDb250ZW50VGV4dD4KICAgICAgICAgICAgICAgICAgICA8bnMyOmNoYXJhY3RlclNlcXVlbmNlPkV0dCBlbmtlbHQgbWVlZGRlbGFuZGUgdXRhbiBuw6Vnb24gYmlmb2dhZCBmaWwsIHNrcml2ZW4gYXYgSm9uYXM8L25zMjpjaGFyYWN0ZXJTZXF1ZW5jZT4KICAgICAgICAgICAgICAgIDwvbnMyOkNvbnRlbnRUZXh0PgogICAgICAgICAgICA8L25zMjpkb2N1bWVudHM+CiAgICAgICAgPC9uczI6bWVzc2FnZUJvZHk+CiAgICA8L25zMjptZXNzYWdlPgo8L25zMjptZXNzYWdlUGF5bG9hZD4K")));

        backend.ecodex.org._1_1.ObjectFactory factory = new backend.ecodex.org._1_1.ObjectFactory();

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
