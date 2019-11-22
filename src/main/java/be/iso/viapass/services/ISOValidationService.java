package be.iso.viapass.services;

import javax.xml.validation.Schema;

public interface ISOValidationService {

        Schema createSchemaISOValidation();

        Boolean validateRequestISO(String xml);

        Boolean validateRequestISO(String xml, String xsd);

}
