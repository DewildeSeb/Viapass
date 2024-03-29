package be.iso.viapass.xmlobject;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "vehicle")
@XmlType(propOrder = {"environmentalCharacteristics", "engineCharacteristics", "vehicleClass", "vehicleDimensions", "vehicleWeightLaden", "vehicleWeightLimits"})
@Getter
@Setter
@NoArgsConstructor
public class Vehicle {
        @XmlElement(name = "vehicleClass")
        private String vehicleClass;

        @XmlElement(name = "vehicleDimensions")
        private String vehicleDimensions;

        @XmlElement(name = "vehicleWeightLaden")
        private String vehicleWeightLaden;

        @XmlElement(name = "vehicleWeightLimits")
        private String vehicleWeightLimits;
}
