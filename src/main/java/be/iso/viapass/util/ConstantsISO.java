package be.iso.viapass.util;

import lombok.NoArgsConstructor;

/**
 * Application constants.
 */
@NoArgsConstructor
public final class ConstantsISO {

        public static final String XPATH_TREE_ADUTYPE_IN_XML = "/InfoExchange/infoExchangeContent/apci/aduType/*";

        public static final String RESPONSE_ANORMAL_OBE_XML_PATH = "src/main/resources/xmlFiles/Response_abnormal_OBE.xml";

        /*************** All path of Common xsd file in the project****************/
        public static final String ASN1_XSD_PATH = "src/main/resources/xsdFiles/asn1.xsd";
        public static final String COMMON_XSD_PATH = "src/main/resources/xsdFiles/Common.xsd";
        public static final String COMMON_APCI_XSD_PATH = "src/main/resources/xsdFiles/CommonAPCI.xsd";

        /*************** All path of response xsd file in the project****************/
        public static final String RESPONSE_ABNORMAL_OBE_XSD_PATH = "src/main/resources/xsdFiles/Response_Abnormal_OBE.xsd";
        public static final String RESPONSE_PROVIDE_DAILY_STATEMENT_XSD_PATH = "src/main/resources/xsdFiles/Response_Provide_Daily_Statement.xsd";
        public static final String RESPONSE_WLBL_XSD_PATH = "src/main/resources/xsdFiles/Response_WLBL.xsd";
        public static final String RESPONSE_ADDRESS_DATA_XSD_PATH = "src/main/resources/xsdFiles/Response_Address_Data.xsd";
        public static final String RESPONSE_VEHICLE_DATA_XSD_PATH = "src/main/resources/xsdFiles/Response_Vehicle_Data.xsd";
        public static final String RESPONSE_OBU_COMPLIANCE_DATA_XSD_PATH = "src/main/resources/xsdFiles/Response_OBU_Compliance_Data.xsd";

        /*************** All path of request xsd file in the project****************/
        public static final String REQUEST_ANORMAL_OBE_XSD_PATH = "src/main/resources/xsdFiles/Request_Abnormal_OBE.xsd";
        public static final String REQUEST_PROVIDE_DAILY_STATEMENT_XSD_PATH = "src/main/resources/xsdFiles/Request_Provide_Daily_Statement.xsd";
        public static final String REQUEST_WLBL_XSD_PATH = "src/main/resources/xsdFiles/Request_WLBL.xsd";
        public static final String REQUEST_ADDRESS_DATA_XSD_PATH = "src/main/resources/xsdFiles/Request_Address_Data.xsd";
        public static final String REQUEST_VEHICLE_DATA_XSD_PATH = "src/main/resources/xsdFiles/Request_Vehicle_Data.xsd";
        public static final String REQUEST_OBU_COMPLIANCE_DATA_XSD_PATH = "src/main/resources/xsdFiles/Request_OBU_Compliance_Data.xsd";



        //others
        public static final String DB_NAME = "viapass";
        public static final String EMPLOYEE_XSD_PATH = "src/main/resources/xsdFiles/Employee.xsd";
        public static final String EMPLOYEE_XML_PATH = "src/main/resources/xmlFiles/Employee.xml";
        public static final String EMPLOYEE_REQUEST_XML_PATH = "src/main/resources/xmlFiles/EmployeeRequest.xml";
        public static final String EMPLOYEE_RESPONSE_XML_PATH = "src/main/resources/xmlFiles/EmployeeResponse.xml";
        public static final String VEHICLE_XML_PATH = "src/main/resources/xmlFiles/vehicle.xml";

}
