package be.iso.viapass.util.jaxb;

import be.iso.viapass.xmlobject.Vehicle;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;


/**
 * Marshalling provides a client application the ability to convert a JAXB derived Java object tree into XML data.
 * By default, the Marshaller uses UTF-8 encoding when generating XML data.
 */
public class Marshal {

        public void marshalVehicle() throws JAXBException, IOException {
                Vehicle vehicle = new Vehicle();
                vehicle.setVehicleClass("test");
                vehicle.setVehicleDimensions("test");
                vehicle.setVehicleWeightLaden("test");
                vehicle.setVehicleWeightLimits("test");
                vehicle.setEnvironmentalCharacteristics("test");
                vehicle.setEngineCharacteristics("test");

                JAXBContext context = JAXBContext.newInstance(Vehicle.class);
                Marshaller marshaller = context.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
                marshaller.marshal(vehicle, new File("./resources/xmlFiles/vehicle.xml"));
        }
}
