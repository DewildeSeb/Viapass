package be.iso.viapass.xmlobject;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@Getter
@Setter
@NoArgsConstructor
public class Tutorial {

        @XmlAttribute
        private String tutId;
        @XmlAttribute
        private String type;
        @XmlElement
        private String title;
        @XmlElement
        private String description;
        @XmlElement
        private String date;
        @XmlElement
        private String author;
}