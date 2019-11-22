package be.iso.viapass.xmlobject;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@XmlRootElement
public class Tutorials {

        @XmlElement
        private List<Tutorial> tutorial;
}