package be.iso.viapass.services.implementation;

import be.iso.viapass.services.ISOValidationService;
import be.iso.viapass.xmlobject.Vehicle;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;

public class ISOValidationServiceImpl implements ISOValidationService {

        public void marshalVehicle() throws JAXBException, IOException {
                Vehicle vehicle = new Vehicle();
                vehicle.setVehicleClass("test");
                vehicle.setVehicleDimensions("test");
                vehicle.setVehicleWeightLaden("test");
                vehicle.setVehicleWeightLimits("test");

                JAXBContext context = JAXBContext.newInstance(Vehicle.class);
                Marshaller mar= context.createMarshaller();
                mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
                mar.marshal(vehicle, new File("./book.xml"));
        }
}