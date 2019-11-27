package be.iso.viapass.util;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;

/**
 * Converter class bring together each converter needed in the project.
 * this could be String to Document or many other type
 */
public interface Converter {

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

        static Document convertXMLFileToXMLDocument(String filePath)
        {
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
}
