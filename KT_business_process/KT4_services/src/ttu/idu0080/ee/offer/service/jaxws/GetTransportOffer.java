
package ttu.idu0080.ee.offer.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 2.7.18
 * Sun May 28 12:46:20 EEST 2017
 * Generated source version: 2.7.18
 */

@XmlRootElement(name = "getTransportOffer", namespace = "http://service.offer.ee.idu0080.ttu/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getTransportOffer", namespace = "http://service.offer.ee.idu0080.ttu/", propOrder = {"arg0", "arg1"})

public class GetTransportOffer {

    @XmlElement(name = "arg0")
    private int arg0;
    @XmlElement(name = "arg1")
    private ttu.idu0080.ee.order.Order arg1;

    public int getArg0() {
        return this.arg0;
    }

    public void setArg0(int newArg0)  {
        this.arg0 = newArg0;
    }

    public ttu.idu0080.ee.order.Order getArg1() {
        return this.arg1;
    }

    public void setArg1(ttu.idu0080.ee.order.Order newArg1)  {
        this.arg1 = newArg1;
    }

}
