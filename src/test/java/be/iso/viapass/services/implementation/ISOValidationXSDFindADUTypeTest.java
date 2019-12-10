package be.iso.viapass.services.implementation;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;


@RunWith(JUnitParamsRunner.class)
public class ISOValidationXSDFindADUTypeTest {

        public static final String XPATH_TREE_ADUTYPE_IN_XML = "/InfoExchange/infoExchangeContent/apci/aduType/*";

        @BeforeClass
        public static void setup() {
                xPath = XPathFactory.newInstance().newXPath();
        }

        private static XPath xPath;
        private static Document doc;
        private static NodeList nodeList;

        private static final String RESPONSE_PROVIDE_DAILY_STATEMENT_PATH = "src/test/resources/provide_daily_statement_response.xml";
        private static final String RESPONSE_PROVIDE_DAILY_STATEMENT_WRONG_GENERALIZED_TIME_PATH = "src/test/resources/provide_daily_statement_response_wrong_generalized_time.xml";


        private static final String REQUEST_PROVIDE_DAILY_STATEMENT = "<InfoExchange><infoExchangeContent><apci><messageOriginator><countryCode>1001110000</countryCode><providerIdentifier>35</providerIdentifier></messageOriginator><informationSenderID><countryCode>1001110000</countryCode><providerIdentifier>35</providerIdentifier></informationSenderID><informationrecipientID><countryCode>1001110000</countryCode><providerIdentifier>49</providerIdentifier></informationrecipientID><contextID>604</contextID><messageIdentifier>5896745</messageIdentifier><aduType><tollDeclarationADU/></aduType><numberofStructs>1</numberofStructs><messageDate>20160215141800Z</messageDate></apci><adu><tollDeclarationADU><tollDeclarationId><issuerId><countryCode>1001110000</countryCode><providerIdentifier>35</providerIdentifier></issuerId><declarationId>6584654654564</declarationId></tollDeclarationId><gnssTollDeclaration><ChargeReport><obeId><manufacturerId>25</manufacturerId><equipmentOBUId>1325E34F</equipmentOBUId></obeId><vehicleLPNr><countryCode>1001110000</countryCode><alphabetIndicator><latinAlphabetNo1/></alphabetIndicator><licensePlateNumber>0102030405060708</licensePlateNumber></vehicleLPNr><serviceProviderContract><contractProvider><countryCode>1001110000</countryCode><providerIdentifier>12587</providerIdentifier></contractProvider><typeOfContract>0102</typeOfContract><contextVersion>25</contextVersion></serviceProviderContract><timeOfReport><timeDate><year>2018</year><month>5</month><day>1</day></timeDate><timeCompact><hours>4</hours><mins>59</mins><double-secs>15</double-secs></timeCompact></timeOfReport><reportPeriod><beginOfPeriod><timeDate><year>2018</year><month>7</month><day>2</day></timeDate><timeCompact><hours>3</hours><mins>29</mins><double-secs>12</double-secs></timeCompact></beginOfPeriod><endOfPeriod><timeDate><year>2018</year><month>7</month><day>2</day></timeDate><timeCompact><hours>3</hours><mins>29</mins><double-secs>12</double-secs></timeCompact></endOfPeriod></reportPeriod><usageStatementList><UsageStatement><usageStatementID>458</usageStatementID><regimeID>15</regimeID><aggregatedSingleTariffClassSession><timePeriodCovered><beginOfPeriod><timeDate><year>2018</year><month>7</month><day>2</day></timeDate><timeCompact><hours>3</hours><mins>29</mins><double-secs>12</double-secs></timeCompact></beginOfPeriod><endOfPeriod><timeDate><year>2018</year><month>7</month><day>2</day></timeDate><timeCompact><hours>3</hours><mins>29</mins><double-secs>12</double-secs></timeCompact></endOfPeriod></timePeriodCovered><vehicleDescription><specificCharacteristics><environmentalCharacteristics><euroValue><euro-1/></euroValue><copValue><co2class1/></copValue></environmentalCharacteristics><engineCharacteristics>0</engineCharacteristics><descriptiveCharacteristics>0</descriptiveCharacteristics><futureCharacteristics>0</futureCharacteristics></specificCharacteristics><ladenWeight>23548</ladenWeight><weightLimits><vehicleMaxLadenWeight>500</vehicleMaxLadenWeight><vehicleTrainMaximumWeight>5006</vehicleTrainMaximumWeight><vehicleWeightUnladen>140</vehicleWeightUnladen></weightLimits></vehicleDescription><totalDistanceCovered><dist>4589</dist><disUnit><metres/></disUnit></totalDistanceCovered><feeExclVat><paymentFeeAmount>500</paymentFeeAmount><paymentFeeUnit>0978</paymentFeeUnit></feeExclVat><vat><paymentFeeAmount>500</paymentFeeAmount><paymentFeeUnit>0978</paymentFeeUnit></vat></aggregatedSingleTariffClassSession></UsageStatement></usageStatementList></ChargeReport></gnssTollDeclaration></tollDeclarationADU></adu></infoExchangeContent></InfoExchange>";
        private static final String REQUEST_GET_VEHICLE_DATA = "<InfoExchange><infoExchangeContent><apci><messageOriginator><countryCode>1001110000</countryCode><providerIdentifier>35</providerIdentifier></messageOriginator><informationSenderID><countryCode>1001110000</countryCode><providerIdentifier>35</providerIdentifier></informationSenderID><informationrecipientID><countryCode>1001110000</countryCode><providerIdentifier>49</providerIdentifier></informationrecipientID><contextID>604</contextID><messageIdentifier>5896745</messageIdentifier><aduType><retrieveUserDetailsADU/></aduType><numberofStructs>1</numberofStructs><messageDate>20160215141800Z</messageDate></apci><adu><retrieveUserDetailsADU><RetrieveUserDetails><userId><pan>3156495000817002131F</pan><contractSerialNumber>100</contractSerialNumber><licensePlateNumber><countryCode>1001110000</countryCode><alphabetIndicator><latinAlphabetNo1/></alphabetIndicator><licensePlateNumber>41583034365845</licensePlateNumber></licensePlateNumber><obeID><manufacturerId>25</manufacturerId><equipmentOBUId>1325E34F</equipmentOBUId></obeID></userId><listOfParametersRequested><UserParameterRequest>5</UserParameterRequest></listOfParametersRequested><userDetailsRequestReason>3</userDetailsRequestReason></RetrieveUserDetails></retrieveUserDetailsADU></adu></infoExchangeContent></InfoExchange>";
        private static final String REQUEST_GET_ADDRESS_DATA = "<InfoExchange><infoExchangeContent><apci><messageOriginator><countryCode>1001110000</countryCode><providerIdentifier>35</providerIdentifier></messageOriginator><informationSenderID><countryCode>1001110000</countryCode><providerIdentifier>35</providerIdentifier></informationSenderID><informationrecipientID><countryCode>1001110000</countryCode><providerIdentifier>49</providerIdentifier></informationrecipientID><contextID>604</contextID><messageIdentifier>5896745</messageIdentifier><aduType><retrieveUserDetailsADU/></aduType><numberofStructs>1</numberofStructs><messageDate>20160215141800Z</messageDate></apci><adu><retrieveUserDetailsADU><RetrieveUserDetails><userId><pan>3156495000817002131F</pan><contractSerialNumber>100</contractSerialNumber><licensePlateNumber><countryCode>1001110000</countryCode><alphabetIndicator><latinAlphabetNo1/></alphabetIndicator><licensePlateNumber>0041583034365845</licensePlateNumber></licensePlateNumber><obeID><manufacturerId>25</manufacturerId><equipmentOBUId>1325E34F</equipmentOBUId></obeID></userId><listOfParametersRequested><UserParameterRequest>0</UserParameterRequest></listOfParametersRequested><userDetailsRequestReason>3</userDetailsRequestReason></RetrieveUserDetails></retrieveUserDetailsADU></adu></infoExchangeContent></InfoExchange>";
        private static final String REQUEST_GET_OBU_COMPLIANCE_DATA = "<InfoExchange><infoExchangeContent><apci><messageOriginator><countryCode>1001110000</countryCode><providerIdentifier>35</providerIdentifier></messageOriginator><informationSenderID><countryCode>1001110000</countryCode><providerIdentifier>35</providerIdentifier></informationSenderID><informationrecipientID><countryCode>1001110000</countryCode><providerIdentifier>49</providerIdentifier></informationrecipientID><contextID>604</contextID><messageIdentifier>5896745</messageIdentifier><aduType><retrieveTollDeclarationADU/></aduType><numberofStructs>1</numberofStructs><messageDate>20160215141800Z</messageDate></apci><adu><retrieveTollDeclarationADU><RetrieveTollDeclarations><userId><pan>3156495000817002131F</pan><contractSerialNumber>100</contractSerialNumber><licensePlateNumber><countryCode>1001110000</countryCode><alphabetIndicator><latinAlphabetNo1/></alphabetIndicator><licensePlateNumber>41583034365845</licensePlateNumber></licensePlateNumber><obeID><manufacturerId>25</manufacturerId><equipmentOBUId>1325E34F</equipmentOBUId></obeID></userId><startTime>20140601121122.123Z</startTime><endTime>20140602121122.123Z</endTime></RetrieveTollDeclarations></retrieveTollDeclarationADU></adu></infoExchangeContent></InfoExchange>";
        private static final String REQUEST_WHITELIST = "<InfoExchange><infoExchangeContent><apci><messageOriginator><countryCode>1001010000</countryCode><providerIdentifier>123</providerIdentifier></messageOriginator><informationSenderID><countryCode>1001010000</countryCode><providerIdentifier>123</providerIdentifier></informationSenderID><informationrecipientID><countryCode>1001010000</countryCode><providerIdentifier>321</providerIdentifier></informationrecipientID><contextID>1</contextID><messageIdentifier>140731115877900100004</messageIdentifier><aduType><exceptionListADU/></aduType><numberofStructs>1</numberofStructs><messageDate>20140806074558.78Z</messageDate></apci><adu><exceptionListADU><exceptionListversion>1</exceptionListversion><exceptionListType>2</exceptionListType><exceptionListEntries><ExceptionListEntry><userId><pan>0000000000000000001F</pan><contractSerialNumber>12345</contractSerialNumber><licensePlateNumber><countryCode>1001010000</countryCode><alphabetIndicator><latinAlphabetNo1/></alphabetIndicator><licensePlateNumber>0E534B204B20323531320000000000</licensePlateNumber></licensePlateNumber><obeID><manufacturerId>54321</manufacturerId><equipmentOBUId>0442473031</equipmentOBUId></obeID></userId><blockType><allApplications/></blockType><reasonCode><normalUser/></reasonCode><dateAndTime>20140601121122.123Z</dateAndTime></ExceptionListEntry></exceptionListEntries></exceptionListADU></adu></infoExchangeContent></InfoExchange>";
        private static final String REQUEST_ABNORMAL_OBE = "<InfoExchange><infoExchangeContent><apci><messageOriginator><countryCode>1001110000</countryCode><providerIdentifier>35</providerIdentifier></messageOriginator><informationSenderID><countryCode>1001110000</countryCode><providerIdentifier>35</providerIdentifier></informationSenderID><informationrecipientID><countryCode>1001110000</countryCode><providerIdentifier>49</providerIdentifier></informationrecipientID><contextID>604</contextID><messageIdentifier>5896745</messageIdentifier><aduType><reportAbnormalOBEADU/></aduType><numberofStructs>1</numberofStructs><messageDate>20160215141800Z</messageDate></apci><adu><reportAbnormalOBEADU><userId><contractSerialNumber>100</contractSerialNumber><licensePlateNumber><countryCode>1001110000</countryCode><alphabetIndicator><latinAlphabetNo1/></alphabetIndicator><licensePlateNumber>0102030405060708</licensePlateNumber></licensePlateNumber><obeID><manufacturerId>25</manufacturerId><equipmentOBUId>1325E34F</equipmentOBUId></obeID></userId><dateAndTime>20160215141800Z</dateAndTime><abnormalOBEReasonCode><AbnormalOBEReasonCode>0</AbnormalOBEReasonCode></abnormalOBEReasonCode></reportAbnormalOBEADU></adu></infoExchangeContent></InfoExchange>";
        private static final String RESPONSE_ADDRESS_DATA = "<InfoExchange><infoExchangeContent><apci><messageOriginator><countryCode>1001110000</countryCode><providerIdentifier>0</providerIdentifier></messageOriginator><informationSenderID><countryCode>1001110000</countryCode><providerIdentifier>35</providerIdentifier></informationSenderID><informationrecipientID><countryCode>1001110000</countryCode><providerIdentifier>49</providerIdentifier></informationrecipientID><contextID>604</contextID><messageIdentifier>5896745</messageIdentifier><aduType><provideUserDetailsADU/></aduType><numberofStructs>1</numberofStructs><messageDate>20160215141800Z</messageDate></apci><adu><provideUserDetailsADU><ProvideUserDetails><originaluserIdRequest><pan>3156495000817002131F</pan><contractSerialNumber>100</contractSerialNumber><licensePlateNumber><countryCode>1001110000</countryCode><alphabetIndicator><latinAlphabetNo1/></alphabetIndicator><licensePlateNumber>41583034365845</licensePlateNumber></licensePlateNumber><obeID><manufacturerId>25</manufacturerId><equipmentOBUId>1325E34F</equipmentOBUId></obeID></originaluserIdRequest><userId><pan>3156495000817002131F</pan><contractSerialNumber>100</contractSerialNumber><licensePlateNumber><countryCode>1001110000</countryCode><alphabetIndicator><latinAlphabetNo1/></alphabetIndicator><licensePlateNumber>41583034365845</licensePlateNumber></licensePlateNumber><obeID><manufacturerId>25</manufacturerId><equipmentOBUId>1325E34F</equipmentOBUId></obeID></userId><statusFlag>standardPrivateUserContract</statusFlag><listOfUserParameters><UserParameterResponse><userParameterResponse><userPostalAddress><name>Sébastien</name><company>BuSI</company><street>rue des pommes</street><postcode>1020</postcode><town>Bruxelles</town><country>Belgium</country></userPostalAddress></userParameterResponse><userParameterStatus>6</userParameterStatus></UserParameterResponse></listOfUserParameters></ProvideUserDetails></provideUserDetailsADU></adu></infoExchangeContent></InfoExchange>";
        private static final String RESPONSE_VEHICLE_DATA = "<InfoExchange><infoExchangeContent><apci><messageOriginator><countryCode>1001110000</countryCode><providerIdentifier>0</providerIdentifier></messageOriginator><informationSenderID><countryCode>1001110000</countryCode><providerIdentifier>35</providerIdentifier></informationSenderID><informationrecipientID><countryCode>1001110000</countryCode><providerIdentifier>49</providerIdentifier></informationrecipientID><contextID>604</contextID><messageIdentifier>5896745</messageIdentifier><aduType><provideUserDetailsADU/></aduType><numberofStructs>1</numberofStructs><messageDate>20160215141800Z</messageDate></apci><adu><provideUserDetailsADU><ProvideUserDetails><originaluserIdRequest><pan>3156495000817002131F</pan><contractSerialNumber>100</contractSerialNumber><licensePlateNumber><countryCode>1001110000</countryCode><alphabetIndicator><latinAlphabetNo1/></alphabetIndicator><licensePlateNumber>41583034365845</licensePlateNumber></licensePlateNumber><obeID><manufacturerId>25</manufacturerId><equipmentOBUId>1325E34F</equipmentOBUId></obeID></originaluserIdRequest><userId><pan>3156495000817002131F</pan><contractSerialNumber>100</contractSerialNumber><licensePlateNumber><countryCode>1001110000</countryCode><alphabetIndicator><latinAlphabetNo1/></alphabetIndicator><licensePlateNumber>41583034365845</licensePlateNumber></licensePlateNumber><obeID><manufacturerId>25</manufacturerId><equipmentOBUId>1325E34F</equipmentOBUId></obeID></userId><statusFlag>standardPrivateUserContract</statusFlag><listOfUserParameters><UserParameterResponse><userParameterResponse><userPostalAddress><name>Sébastien</name><company>BuSI</company><street>rue des pommes</street><postcode>1020</postcode><town>Bruxelles</town><country>Belgium</country></userPostalAddress></userParameterResponse><userParameterStatus>6</userParameterStatus></UserParameterResponse></listOfUserParameters></ProvideUserDetails></provideUserDetailsADU></adu></infoExchangeContent></InfoExchange>";
        private static final String RESPONSE_OBU_COMPLIANCE_DATA = "<InfoExchange><infoExchangeContent><apci><messageOriginator><countryCode>1001110000</countryCode><providerIdentifier>35</providerIdentifier></messageOriginator><informationSenderID><countryCode>1001110000</countryCode><providerIdentifier>35</providerIdentifier></informationSenderID><informationrecipientID><countryCode>1001110000</countryCode><providerIdentifier>49</providerIdentifier></informationrecipientID><contextID>604</contextID><messageIdentifier>5896745</messageIdentifier><aduType><tollDeclarationADU/></aduType><numberofStructs>1</numberofStructs><messageDate>20160215141800Z</messageDate></apci><adu><tollDeclarationADU><tollDeclarationId><issuerId><countryCode>1001110000</countryCode><providerIdentifier>35</providerIdentifier></issuerId><declarationId>6584654654564</declarationId></tollDeclarationId><gnssTollDeclaration><ChargeReport><obeId><manufacturerId>25</manufacturerId><equipmentOBUId>1325E34F</equipmentOBUId></obeId><vehicleLPNr><countryCode>1001110000</countryCode><alphabetIndicator><latinAlphabetNo1/></alphabetIndicator><licensePlateNumber>0102030405060708</licensePlateNumber></vehicleLPNr><serviceProviderContract><contractProvider><countryCode>1001110000</countryCode><providerIdentifier>12587</providerIdentifier></contractProvider><typeOfContract>0102</typeOfContract><contextVersion>25</contextVersion></serviceProviderContract><timeOfReport><timeDate><year>2018</year><month>5</month><day>1</day></timeDate><timeCompact><hours>4</hours><mins>59</mins><double-secs>15</double-secs></timeCompact></timeOfReport><reportPeriod><beginOfPeriod><timeDate><year>2018</year><month>7</month><day>2</day></timeDate><timeCompact><hours>3</hours><mins>29</mins><double-secs>12</double-secs></timeCompact></beginOfPeriod><endOfPeriod><timeDate><year>2018</year><month>7</month><day>2</day></timeDate><timeCompact><hours>3</hours><mins>29</mins><double-secs>12</double-secs></timeCompact></endOfPeriod></reportPeriod><usageStatementList><UsageStatement><usageStatementID>458</usageStatementID><regimeID>15</regimeID><aggregatedSingleTariffClassSession><timePeriodCovered><beginOfPeriod><timeDate><year>2018</year><month>7</month><day>2</day></timeDate><timeCompact><hours>3</hours><mins>29</mins><double-secs>12</double-secs></timeCompact></beginOfPeriod><endOfPeriod><timeDate><year>2018</year><month>7</month><day>2</day></timeDate><timeCompact><hours>3</hours><mins>29</mins><double-secs>12</double-secs></timeCompact></endOfPeriod></timePeriodCovered><vehicleDescription><specificCharacteristics><environmentalCharacteristics><euroValue><euro-1/></euroValue><copValue><co2class1/></copValue></environmentalCharacteristics><engineCharacteristics>0</engineCharacteristics><descriptiveCharacteristics>0</descriptiveCharacteristics><futureCharacteristics>0</futureCharacteristics></specificCharacteristics><ladenWeight>23548</ladenWeight><weightLimits><vehicleMaxLadenWeight>500</vehicleMaxLadenWeight><vehicleTrainMaximumWeight>5006</vehicleTrainMaximumWeight><vehicleWeightUnladen>140</vehicleWeightUnladen></weightLimits></vehicleDescription><totalDistanceCovered><dist>4589</dist><disUnit><metres/></disUnit></totalDistanceCovered><feeExclVat><paymentFeeAmount>500</paymentFeeAmount><paymentFeeUnit>0978</paymentFeeUnit></feeExclVat><vat><paymentFeeAmount>500</paymentFeeAmount><paymentFeeUnit>0978</paymentFeeUnit></vat></aggregatedSingleTariffClassSession></UsageStatement></usageStatementList></ChargeReport></gnssTollDeclaration></tollDeclarationADU></adu></infoExchangeContent></InfoExchange>";
        private static final String RESPONSE_ABNORMAL_OBE = "<InfoExchange><infoExchangeContent><apci><messageOriginator><countryCode>1001110000</countryCode><providerIdentifier>0</providerIdentifier></messageOriginator><informationSenderID><countryCode>1001110000</countryCode><providerIdentifier>35</providerIdentifier></informationSenderID><informationrecipientID><countryCode>1001110000</countryCode><providerIdentifier>49</providerIdentifier></informationrecipientID><contextID>604</contextID><messageIdentifier>5896745</messageIdentifier><aduType><ackADU/></aduType><numberofStructs>1</numberofStructs><messageDate>20160215141800Z</messageDate></apci><adu><ackADU><aDUIdentifier>124586</aDUIdentifier><numberOfADUStructs>1</numberOfADUStructs><ackCode><obsoleteADU/></ackCode><aduCode><SEQUENCE><numberOfADUStruct>1</numberOfADUStruct><aDUReasonCode>trustObjectExpired</aDUReasonCode></SEQUENCE></aduCode></ackADU></adu></infoExchangeContent></InfoExchange>";
        private static final String RESPONSE_PROVIDE_DAILY_STATEMENT = "<InfoExchange><infoExchangeContent><apci><messageOriginator><countryCode>1001110000</countryCode><providerIdentifier>0</providerIdentifier></messageOriginator><informationSenderID><countryCode>1001110000</countryCode><providerIdentifier>35</providerIdentifier></informationSenderID><informationrecipientID><countryCode>1001110000</countryCode><providerIdentifier>49</providerIdentifier></informationrecipientID><contextID>604</contextID><messageIdentifier>5896745</messageIdentifier><aduType><ackADU/></aduType><numberofStructs>1</numberofStructs><messageDate>20160215141800Z</messageDate></apci><adu><ackADU><aDUIdentifier>124586</aDUIdentifier><numberOfADUStructs>1</numberOfADUStructs><ackCode><obsoleteADU/></ackCode><aduCode><SEQUENCE><numberOfADUStruct>1</numberOfADUStruct><aDUReasonCode>trustObjectExpired</aDUReasonCode></SEQUENCE></aduCode></ackADU></adu></infoExchangeContent></InfoExchange>";
        private static final String RESPONSE_WLBL = "<InfoExchange><infoExchangeContent><apci><messageOriginator><countryCode>1001110000</countryCode><providerIdentifier>0</providerIdentifier></messageOriginator><informationSenderID><countryCode>1001110000</countryCode><providerIdentifier>35</providerIdentifier></informationSenderID><informationrecipientID><countryCode>1001110000</countryCode><providerIdentifier>49</providerIdentifier></informationrecipientID><contextID>604</contextID><messageIdentifier>5896745</messageIdentifier><aduType><ackADU/></aduType><numberofStructs>1</numberofStructs><messageDate>20160215141800Z</messageDate></apci><adu><ackADU><aDUIdentifier>124586</aDUIdentifier><numberOfADUStructs>1</numberOfADUStructs><ackCode><obsoleteADU/></ackCode><aduCode><SEQUENCE><numberOfADUStruct>1</numberOfADUStruct><aDUReasonCode>trustObjectExpired</aDUReasonCode></SEQUENCE></aduCode></ackADU></adu></infoExchangeContent></InfoExchange>";


        /******************************    ADU TYPE    **********************************************************/

        private static final String ADU_TYPE_ACK_ADU = "ackADU";
        private static final String ADU_TYPE_EXCEPTION_LIST_ADU = "exceptionListADU";
        private static final String ADU_TYPE_REPORT_ABNORMAL_OBE_ADU = "reportAbnormalOBEADU";
        private static final String ADU_TYPE_TOLL_DECLARATION_ADU = "tollDeclarationADU";
        private static final String ADU_TYPE_RETRIEVE_USER_DETAILS_ADU = "retrieveUserDetailsADU";
        private static final String ADU_TYPE_PROVIDE_USER_DETAILS_ADU = "provideUserDetailsADU";
        private static final String ADU_TYPE_RETRIEVE_TOLL_DECLARATION_ADU = "retrieveTollDeclarationADU";

        /******************************    ADU TYPE   NOT USED   *************************************************/

        private static final String ADU_TYPE_REQUEST_ADU = "requestADU";
        private static final String ADU_TYPE_TRUST_OBJET_ADU = "trustObjectADU";
        private static final String ADU_TYPE_EFC_CONTEXT_DATA_ADU = "efcContextDataADU";
        private static final String ADU_TYPE_BILLING_DETAILS_ADU = "billingDetailsADU";
        private static final String ADU_TYPE_PAYMENT_CLAIM_ADU = "paymentClaimADU";
        private static final String ADU_TYPE_REPORT_QA_ADU = "reportQAADU";
        private static final String ADU_TYPE_STATUS_ADU = "statusADU";
        private static final String ADU_TYPE_REPORT_CCC_EVENT_ADU = "reportCCCEventADU";
        private static final String ADU_TYPE_RETRIEVE_CCC_EVENT_ADU = "retrieveCCCEventADU";

        public final Object[] parametersForTestFindADUTypeInRequestISOPath() {
                /**
                 * Check if the method find the correct ADU type from a xml file
                 */
                return new Object[]{
                        new Object[]{RESPONSE_PROVIDE_DAILY_STATEMENT_PATH, ADU_TYPE_ACK_ADU},
                        new Object[]{RESPONSE_PROVIDE_DAILY_STATEMENT_WRONG_GENERALIZED_TIME_PATH, ADU_TYPE_ACK_ADU},
                };
        }

        public final Object[] parametersForTestFindADUTypeInRequestISOString() {
                /**
                 * Check if the method find the correct ADU type from a string
                 */
                return new Object[]{
                        new Object[]{REQUEST_PROVIDE_DAILY_STATEMENT, ADU_TYPE_TOLL_DECLARATION_ADU},
                        new Object[]{REQUEST_GET_VEHICLE_DATA, ADU_TYPE_RETRIEVE_USER_DETAILS_ADU},
                        new Object[]{REQUEST_GET_ADDRESS_DATA, ADU_TYPE_RETRIEVE_USER_DETAILS_ADU},
                        new Object[]{REQUEST_GET_OBU_COMPLIANCE_DATA, ADU_TYPE_RETRIEVE_TOLL_DECLARATION_ADU},
                        new Object[]{REQUEST_WHITELIST, ADU_TYPE_EXCEPTION_LIST_ADU},
                        new Object[]{REQUEST_ABNORMAL_OBE, ADU_TYPE_REPORT_ABNORMAL_OBE_ADU},
                        new Object[]{RESPONSE_ADDRESS_DATA, ADU_TYPE_PROVIDE_USER_DETAILS_ADU},
                        new Object[]{RESPONSE_VEHICLE_DATA, ADU_TYPE_PROVIDE_USER_DETAILS_ADU},
                        new Object[]{RESPONSE_OBU_COMPLIANCE_DATA, ADU_TYPE_TOLL_DECLARATION_ADU},
                        new Object[]{RESPONSE_ABNORMAL_OBE, ADU_TYPE_ACK_ADU},
                        new Object[]{RESPONSE_PROVIDE_DAILY_STATEMENT, ADU_TYPE_ACK_ADU},
                        new Object[]{RESPONSE_WLBL, ADU_TYPE_ACK_ADU},
                };
        }

        /**
         *
         * @param xmlString
         * @return created Document with the xml String
         * @throws ParserConfigurationException
         * @throws IOException
         * @throws SAXException
         */
        static Document convertStringXMLToDocument(String xmlString) throws ParserConfigurationException, IOException, SAXException {
                DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                InputSource is = new InputSource();
                is.setCharacterStream(new StringReader(xmlString));
                Document doc = db.parse(is);
                return doc;
        }
        static Document convertXMLFileToXMLDocument(String filePath){
                //Parser that produces DOM object trees from XML content
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                //API to obtain DOM Document instance
                DocumentBuilder builder = null;
                try
                {
                        //Create DocumentBuilder with default configuration
                        builder = factory.newDocumentBuilder();

                        //Parse the content to Document object
                        Document doc = builder.parse(new File(filePath));
                        return doc;
                }
                catch (Exception e)
                {
                        e.printStackTrace();
                }
                return null;
        }

        @Test
        @Parameters
        public void testFindADUTypeInRequestISOString(String xmlString, String typeResult) throws SAXException, ParserConfigurationException, XPathExpressionException, IOException {
                doc = convertStringXMLToDocument(xmlString);
                nodeList = (NodeList) xPath.compile(XPATH_TREE_ADUTYPE_IN_XML).evaluate(doc, XPathConstants.NODESET);
                Assert.assertEquals(nodeList.item(0).getNodeName(), typeResult);
        }

        @Test
        @Parameters
        public void testFindADUTypeInRequestISOPath(String xmlPath, String typeResult) throws XPathExpressionException{
                doc = convertXMLFileToXMLDocument(xmlPath);
                nodeList = (NodeList) xPath.compile(XPATH_TREE_ADUTYPE_IN_XML).evaluate(doc, XPathConstants.NODESET);
                Assert.assertEquals(nodeList.item(0).getNodeName(), typeResult);
        }
}