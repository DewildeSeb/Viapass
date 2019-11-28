package be.iso.viapass.services;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;

public interface ISOValidationService {

        Boolean validateRequestISO(String xml);

        Boolean validateRequestISOFromXMLString(String xml, String xsd);

        Boolean validateRequestISO(String xml, String xsd);

        String findADUTypeInRequestISOPath(String xmlPath) throws XPathExpressionException, IOException, SAXException, ParserConfigurationException;

        String findADUTypeInRequestISOString(String xmlString) throws XPathExpressionException, IOException, SAXException, ParserConfigurationException;

}
