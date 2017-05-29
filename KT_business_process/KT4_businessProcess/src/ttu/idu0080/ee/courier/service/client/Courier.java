
package ttu.idu0080.ee.courier.service.client;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for courier complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="courier">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="addresses" type="{http://service.courier.ee.idu0080.ttu/}address" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="courierId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="courierName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="percentFromOrder" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "courier", propOrder = {
    "addresses",
    "courierId",
    "courierName",
    "percentFromOrder"
})
public class Courier {

    @XmlElement(nillable = true)
    protected List<Address> addresses;
    protected int courierId;
    protected String courierName;
    protected int percentFromOrder;

    /**
     * Gets the value of the addresses property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the addresses property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAddresses().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Address }
     * 
     * 
     */
    public List<Address> getAddresses() {
        if (addresses == null) {
            addresses = new ArrayList<Address>();
        }
        return this.addresses;
    }

    /**
     * Gets the value of the courierId property.
     * 
     */
    public int getCourierId() {
        return courierId;
    }

    /**
     * Sets the value of the courierId property.
     * 
     */
    public void setCourierId(int value) {
        this.courierId = value;
    }

    /**
     * Gets the value of the courierName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCourierName() {
        return courierName;
    }

    /**
     * Sets the value of the courierName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCourierName(String value) {
        this.courierName = value;
    }

    /**
     * Gets the value of the percentFromOrder property.
     * 
     */
    public int getPercentFromOrder() {
        return percentFromOrder;
    }

    /**
     * Sets the value of the percentFromOrder property.
     * 
     */
    public void setPercentFromOrder(int value) {
        this.percentFromOrder = value;
    }

}
