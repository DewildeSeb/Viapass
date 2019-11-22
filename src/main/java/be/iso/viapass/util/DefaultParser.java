package be.iso.viapass.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.io.ClassPathResource;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.*;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

public class DefaultParser {

        private final static Logger LOG = LogManager.getLogger(DefaultParser.class);

        private File file;
        public DefaultParser(File file) {
                this.file = file;
        }

        private InputStream asn1;
        private InputStream AVIAEINumberingAndDataStructures;
        private InputStream CccModule;
        private InputStream ChargingModule;
        private InputStream ContextDataModule;
        private InputStream DSRCData;
        private InputStream EFCInfoExchange;
        private InputStream EfcModule;
        private InputStream RoamingModule;
        private Schema schema;

        public static NodeList getFirstLevelNodeList() {
                File file;
                NodeList nodeList = null;
                try {
                        FileInputStream fileIS = new FileInputStream("xmlFiles/tutorials.xml");
                        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();

                        DocumentBuilder builder = builderFactory.newDocumentBuilder();

                        Document xmlDocument = builder.parse(fileIS);

                        XPath xPath = XPathFactory.newInstance().newXPath();

                        String expression = "/tutorials/tutorial";

                        nodeList = (NodeList) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODESET);

                } catch (IOException | ParserConfigurationException | XPathExpressionException | org.xml.sax.SAXException e) {
                        e.printStackTrace();
                }
                return nodeList;
        }

        public void ISOValidation() {
                try {
                        asn1 = new ClassPathResource("asn1\\asn1.xsd").getInputStream();
                        AVIAEINumberingAndDataStructures = new ClassPathResource("asn1\\AVIAEINumberingAndDataStructures.xsd").getInputStream();
                        CccModule = new ClassPathResource("asn1\\CccModule.xsd").getInputStream();
                        ChargingModule = new ClassPathResource("asn1\\ChargingModule.xsd").getInputStream();
                        ContextDataModule = new ClassPathResource("asn1\\ContextDataModule.xsd").getInputStream();
                        DSRCData = new ClassPathResource("asn1\\DSRCData.xsd").getInputStream();
                        EFCInfoExchange = new ClassPathResource("asn1\\EFCInfoExchange.xsd").getInputStream();
                        EfcModule = new ClassPathResource("asn1\\EfcModule.xsd").getInputStream();
                        RoamingModule = new ClassPathResource("asn1\\RoamingModule.xsd").getInputStream();

                        schema = SchemaFactory.newInstance(
                                XMLConstants.W3C_XML_SCHEMA_NS_URI).newSchema(
                                new Source[]{
                                        new StreamSource(asn1),
                                        new StreamSource(AVIAEINumberingAndDataStructures),
                                        new StreamSource(EfcModule),
                                        new StreamSource(DSRCData),
                                        new StreamSource(CccModule),
                                        new StreamSource(ChargingModule),
                                        new StreamSource(ContextDataModule),
                                        new StreamSource(RoamingModule),
                                        new StreamSource(EFCInfoExchange),
                                }
                        );
                } catch (IOException io) {
                        LOG.error("Fatal error, cannot load file " + io.getMessage());
                } catch (SAXException sE) {
                        LOG.error("Fatal error, cannot load validator " + sE.getMessage());
                }
        }
}
