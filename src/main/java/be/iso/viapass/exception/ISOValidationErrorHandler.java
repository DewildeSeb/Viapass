package be.iso.viapass.exception;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 * Created by BartDeBoec on 08-Mar-16.
 */
public class ISOValidationErrorHandler implements ErrorHandler {

        public ISOValidationErrorHandler() {
                resetErrorStatus();
        }

        public void warning(SAXParseException exception) throws SAXException {
                System.out.println("\nWARNING");
                exception.printStackTrace();
        }

        public void error(SAXParseException exception) throws SAXException {
                errorStatus = true;
                messageBuffer.append("ERROR " + exception.getMessage() + System.lineSeparator());
        }

        public void fatalError(SAXParseException exception) throws SAXException {
                errorStatus = true;
                messageBuffer.append("FATAL ERROR " + exception.getMessage() + System.lineSeparator());
        }

        public Boolean foundErrorOrFatalError() {
                return errorStatus;
        }

        public String getErrorAndFatalErrorMessages() {
                return messageBuffer.toString();
        }

        public void resetErrorStatus() {
                errorStatus = false;
        }

        private Boolean errorStatus = false;

        private StringBuilder messageBuffer = new StringBuilder();
}