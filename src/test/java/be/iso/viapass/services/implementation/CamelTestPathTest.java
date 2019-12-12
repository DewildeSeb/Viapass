package be.iso.viapass.services.implementation;

import be.iso.viapass.util.ConstantsISO;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class CamelTestPathTest {

        private static String XML_PATH = ConstantsISO.RESPONSE_ANORMAL_OBE_XML_PATH;
        private static final String XML_STRING = "<InfoExchange><infoExchangeContent><apci><messageOriginator><countryCode>1001110000</countryCode><providerIdentifier>0</providerIdentifier></messageOriginator><informationSenderID><countryCode>1001110000</countryCode><providerIdentifier>35</providerIdentifier></informationSenderID><informationrecipientID><countryCode>1001110000</countryCode><providerIdentifier>49</providerIdentifier></informationrecipientID><contextID>604</contextID><messageIdentifier>5896745</messageIdentifier><aduType><ackADU/></aduType><numberofStructs>1</numberofStructs><messageDate>20160215141800Z</messageDate></apci><adu><ackADU><aDUIdentifier>124586</aDUIdentifier><numberOfADUStructs>1</numberOfADUStructs><ackCode><obsoleteADU/></ackCode><aduCode><SEQUENCE><numberOfADUStruct>1</numberOfADUStruct><aDUReasonCode>trustObjectExpired</aDUReasonCode></SEQUENCE></aduCode></ackADU></adu></infoExchangeContent></InfoExchange>";

        private static final String FINDING_PATH = "//InfoExchange/infoExchangeContent/apci/messageOriginator/countryCode/@Value";


        //fromF("file://%s?include=%s", path, pattern).toF("mock:%s", result);
        //from("direct:start").toF("file://%s?fileName=%s", path, name);

        @Test
        void findPathWithCamel() throws Exception {

//                RouteBuilder builder = new RouteBuilder() {
//                        public void configure() {
//                                errorHandler(deadLetterChannel("mock:error"));
//
//                                from("direct:start").to("stream:out");
//
//                        }
//                };
//
//                System.out.println(builder.toString());

//                        CamelContext camelContext = new DefaultCamelContext();
//                        try {
//                                camelContext.addRoutes(new RouteBuilder() {
//                                        @Override
//                                        public void configure() throws Exception {
//                                                from("direct:start")
//                                                        .split(xpath(FINDING_PATH))
//                                                        .to("stream:out")
//                                                        .end();
//                                        }
//                                });
//                                InputStream is = new FileInputStream(XML_PATH);
//                                camelContext.start();
//                                ProducerTemplate template = camelContext.createProducerTemplate();
//                                template.sendBody("direct:start", is);
//                        } finally {
//                                camelContext.stop();
//                        }

        }
}