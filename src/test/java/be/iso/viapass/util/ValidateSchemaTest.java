package be.iso.viapass.util;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
class ValidateSchemaTest {

        @Test
        void validateXMLSchema() {

                System.out.println("EmployeeRequest.xml validates against Employee.xsd? "+ValidateSchema.validateXMLSchema(ConstantsISO.EMPLOYEE_XSD_PATH, ConstantsISO.EMPLOYEE_REQUEST_XML_PATH));
                System.out.println("EmployeeResponse.xml validates against Employee.xsd? "+ValidateSchema.validateXMLSchema(ConstantsISO.EMPLOYEE_XSD_PATH, ConstantsISO.EMPLOYEE_RESPONSE_XML_PATH));
                System.out.println("employee.xml validates against Employee.xsd? "+ValidateSchema.validateXMLSchema(ConstantsISO.EMPLOYEE_XSD_PATH, ConstantsISO.EMPLOYEE_XML_PATH));
        }
}