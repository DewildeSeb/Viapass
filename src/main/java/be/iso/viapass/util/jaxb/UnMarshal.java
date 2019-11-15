package be.iso.viapass.util.jaxb;

import be.iso.viapass.xmlobject.Vehicle;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Un-marshalling provides a client application the ability to convert XML data into JAXB derived Java objects.
 */
public class UnMarshal {

        public Vehicle unmarshallVehicle() throws JAXBException, IOException {
                JAXBContext context = JAXBContext.newInstance(Vehicle.class);
                return (Vehicle) context.createUnmarshaller()
                        .unmarshal(new FileReader("./resources/xmlFiles/vehicle.xml"));
        }
}
