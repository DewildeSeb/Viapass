//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema.
//

package be.iso.viapass.util;

import javax.xml.bind.annotation.*;

/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="xerData" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "xerData"
})
@XmlRootElement(name = "IsoRequest")
public class IsoRequest {

        @XmlElement(required = true)
        public String xerData;

        /**
         * Gets the value of the xerData property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getXerData() {
                return xerData;
        }

        /**
         * Sets the value of the xerData property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setXerData(String value) {
                this.xerData = value;
        }

}