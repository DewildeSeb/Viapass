package be.iso.viapass.services.implementation;

import be.iso.viapass.services.ISOValidationService;
import be.iso.viapass.util.ConstantsISO;
import be.iso.viapass.util.Converter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.*;

@Service
public class ISOValidationServiceImpl implements ISOValidationService {

        private final static Logger LOG = LogManager.getLogger(ISOValidationServiceImpl.class);
        private Schema schema;
        private NodeList nodeList;
        private XPath xPath = XPathFactory.newInstance().newXPath();

        @Override
        public Boolean validateRequestISO(String xmlString) {
                try {
                        Validator validator = schema.newValidator();
                        validator.validate(new StreamSource(ConstantsISO.VEHICLE_XML_PATH));
                } catch (IOException | SAXException e) {
                        System.out.println("Exception: " + e.getMessage());
                        return false;
                }
                return true;
        }

        @Override
        public Boolean validateRequestISO(String xmlPath, String xsdPath) {
                try {
                        SchemaFactory factory =
                                SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
                        Schema schema = factory.newSchema(new File(xsdPath));
                        Validator validator = schema.newValidator();
                        validator.validate(new StreamSource(new File(xmlPath)));
                } catch (IOException | SAXException e) {
                        System.out.println("Exception: " + e.getMessage());
                        return false;
                }
                return true;
        }

        @Override
        public String findADUTypeInRequestISOPath(String xmlpath) throws XPathExpressionException, IOException, SAXException, ParserConfigurationException {

                Document doc = Converter.convertXMLFileToXMLDocument(xmlpath);
                nodeList = (NodeList) xPath.compile(ConstantsISO.XPATH_TREE_ADUTYPE_IN_XML).evaluate(doc, XPathConstants.NODESET);

                return nodeList.item(0).getNodeName();
        }

        @Override
        public String findADUTypeInRequestISOString(String xmlString) throws XPathExpressionException, IOException, SAXException, ParserConfigurationException {

                Document doc = Converter.convertStringXMLToDocument(xmlString);
                nodeList = (NodeList) xPath.compile(ConstantsISO.XPATH_TREE_ADUTYPE_IN_XML).evaluate(doc, XPathConstants.NODESET);

                return nodeList.item(0).getNodeName();
        }
}