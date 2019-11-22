package be.iso.viapass.services.implementation;

import be.iso.viapass.services.ISOValidationService;
import be.iso.viapass.util.ConstantsISO;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration
class ISOValidationServiceImplTest {

        private final String vehicleData = "<InfoExchange><infoExchangeContent><apci><messageOriginator><countryCode>1001110000</countryCode><providerIdentifier>35</providerIdentifier></messageOriginator><informationSenderID><countryCode>1001110000</countryCode><providerIdentifier>35</providerIdentifier></informationSenderID><informationrecipientID><countryCode>1001110000</countryCode><providerIdentifier>35</providerIdentifier></informationrecipientID><contextID>604</contextID><messageIdentifier>58967458652</messageIdentifier><aduType><retrieveUserDetailsADU/></aduType><numberofStructs>1</numberofStructs><messageDate>20160215141800Z</messageDate></apci><adu><retrieveUserDetailsADU><RetrieveUserDetails><userId><pan>01020304050607080901</pan><contractSerialNumber>100</contractSerialNumber><licensePlateNumber><countryCode>1001110000</countryCode><alphabetIndicator><latinAlphabetNo1/></alphabetIndicator><licensePlateNumber>0102030405060708</licensePlateNumber></licensePlateNumber><obeID><manufacturerId>25</manufacturerId><equipmentOBUId>01020304</equipmentOBUId></obeID></userId><listOfParametersRequested><UserParameterRequest>5</UserParameterRequest><UserParameterRequest>6</UserParameterRequest><UserParameterRequest>18</UserParameterRequest></listOfParametersRequested><userDetailsRequestReason>2</userDetailsRequestReason></RetrieveUserDetails></retrieveUserDetailsADU></adu></infoExchangeContent></InfoExchange>";

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
        }
}