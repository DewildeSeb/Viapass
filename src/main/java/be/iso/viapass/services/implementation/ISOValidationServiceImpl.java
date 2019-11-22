package be.iso.viapass.services.implementation;

import be.iso.viapass.services.ISOValidationService;
import be.iso.viapass.util.ConstantsISO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.*;

@Service
public class ISOValidationServiceImpl implements ISOValidationService {

        private final static Logger LOG = LogManager.getLogger(ISOValidationServiceImpl.class);
        private static Schema schema;

        private InputStream asn1;
        private InputStream AVIAEINumberingAndDataStructures;
        private InputStream CccModule;
        private InputStream ChargingModule;
        private InputStream ContextDataModule;
        private InputStream DSRCData;
        private InputStream EFCInfoExchange;
        private InputStream EfcModule;
        private InputStream RoamingModule;

        @Override
        public Schema createSchemaISOValidation() {
                try {
                        asn1 = new FileInputStream(ConstantsISO.ASN1_ISOVALIDATION_XSD_PATH);
                        AVIAEINumberingAndDataStructures = new FileInputStream(ConstantsISO.AVIAEINUMBERINGANDDATASTRUCTURES_ISOVALIDATION_XSD_PATH);
                        CccModule = new FileInputStream(ConstantsISO.CCCMODULE_ISOVALIDATION_XSD_PATH);
                        ChargingModule = new FileInputStream(ConstantsISO.CHARGINGMODULE_ISOVALIDATION_XSD_PATH);
                        ContextDataModule = new FileInputStream(ConstantsISO.CONTEXTDATAMODULE_ISOVALIDATION_XSD_PATH);
                        DSRCData = new FileInputStream(ConstantsISO.DSRCDATA_ISOVALIDATION_XSD_PATH);
                        EFCInfoExchange = new FileInputStream(ConstantsISO.EFCINFOEXCHANGE_ISOVALIDATION_XSD_PATH);
                        EfcModule = new FileInputStream(ConstantsISO.EFCMODULE_ISOVALIDATION_XSD_PATH);
                        RoamingModule = new FileInputStream(ConstantsISO.ROAMINGMODULE_ISOVALIDATION_XSD_PATH);

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
                return schema;
        }

        @Override
        public Boolean validateRequestISO(String xmlString) {
                try {
                        createSchemaISOValidation();
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
}