package be.iso.viapass.services.implementation;

import be.iso.viapass.services.ISOValidationService;
import be.iso.viapass.util.ConstantsISO;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;

@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration
class ISOValidationServiceImplTest {

        private final String vehicleData = "<InfoExchange><infoExchangeContent><apci><messageOriginator><countryCode>1001110000</countryCode><providerIdentifier>35</providerIdentifier></messageOriginator><informationSenderID><countryCode>1001110000</countryCode><providerIdentifier>35</providerIdentifier></informationSenderID><informationrecipientID><countryCode>1001110000</countryCode><providerIdentifier>35</providerIdentifier></informationrecipientID><contextID>604</contextID><messageIdentifier>58967458652</messageIdentifier><aduType><retrieveUserDetailsADU/></aduType><numberofStructs>1</numberofStructs><messageDate>20160215141800Z</messageDate></apci><adu><retrieveUserDetailsADU><RetrieveUserDetails><userId><pan>01020304050607080901</pan><contractSerialNumber>100</contractSerialNumber><licensePlateNumber><countryCode>1001110000</countryCode><alphabetIndicator><latinAlphabetNo1/></alphabetIndicator><licensePlateNumber>0102030405060708</licensePlateNumber></licensePlateNumber><obeID><manufacturerId>25</manufacturerId><equipmentOBUId>01020304</equipmentOBUId></obeID></userId><listOfParametersRequested><UserParameterRequest>5</UserParameterRequest><UserParameterRequest>6</UserParameterRequest><UserParameterRequest>18</UserParameterRequest></listOfParametersRequested><userDetailsRequestReason>2</userDetailsRequestReason></RetrieveUserDetails></retrieveUserDetailsADU></adu></infoExchangeContent></InfoExchange>";
        private final String OBUCompliance1 = "src/test/resources/getobucompliance_00027E5A_response.xml";
        private final String OBUCompliance2 = "src/test/resources/getobucompliancedata_0000BEE6_response.xml";
        private final String OBUCompliance3 = "src/test/resources/getobucompliancedata_0001E55A_response.xml";
        private final String OBUCompliance4 = "src/test/resources/getobucompliancedata_00027E5A_response.xml";
        private final String OBUCompliance5 = "src/test/resources/getobucompliancedata_00027E5A_response_nogo.xml";
        private final String OBUCompliance6 = "src/test/resources/getobucompliancedata_00027E67_response.xml";

        private static final String BLACK_LIST = "src/test/resources/blacklist.xml";
        private static final String BLACK_LIST_BACK = "src/test/resources/blacklist_back.xml";
        private static final String WHITE_LIST = "src/test/resources/whitelist.xml";

        private ISOValidationService isoValidationService = new ISOValidationServiceImpl();

        @Test
        void createSchemaISOValidation() {
        }

        @Test
        void validateRequestISO() {
                System.out.println(isoValidationService.validateRequestISO(vehicleData));
        }


        @Test
        void validateRequestISO2Param() {
                System.out.println(isoValidationService.validateRequestISO(ConstantsISO.RESPONSE_ANORMAL_OBE_XML_PATH, ConstantsISO.RESPONSE_ANORMAL_OBE_XSD_PATH));
                System.out.println(isoValidationService.validateRequestISO(OBUCompliance1, ConstantsISO.RESPONSE_OBU_COMPLIANCE_DATA_PATH));
        }

        @Test
        void findADUTypeInRequestISOStringTest() throws SAXException, ParserConfigurationException, XPathExpressionException, IOException {
                System.out.println(isoValidationService.findADUTypeInRequestISOString(vehicleData));
        }

        @Test
        void findADUTypeInRequestISOPathTest() throws SAXException, ParserConfigurationException, XPathExpressionException, IOException {
//                System.out.println(isoValidationService.findADUTypeInRequestISOPath(OBUCompliance1));
//                System.out.println(isoValidationService.findADUTypeInRequestISOPath(OBUCompliance2));
//                System.out.println(isoValidationService.findADUTypeInRequestISOPath(OBUCompliance3));
//                System.out.println(isoValidationService.findADUTypeInRequestISOPath(OBUCompliance4));
//                System.out.println(isoValidationService.findADUTypeInRequestISOPath(OBUCompliance5));
//                System.out.println(isoValidationService.findADUTypeInRequestISOPath(OBUCompliance6));

                System.out.println(isoValidationService.findADUTypeInRequestISOPath(BLACK_LIST));
                System.out.println(isoValidationService.findADUTypeInRequestISOPath(BLACK_LIST_BACK));
                System.out.println(isoValidationService.findADUTypeInRequestISOPath(WHITE_LIST));
        }
}