
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

@XmlRootElement(name = "getTransportOfferResponse", namespace = "http://service.offer.ee.idu0080.ttu/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getTransportOfferResponse", namespace = "http://service.offer.ee.idu0080.ttu/")

public class GetTransportOfferResponse {

    @XmlElement(name = "return")
    private ttu.idu0080.ee.offer.TransportOffer _return;

    public ttu.idu0080.ee.offer.TransportOffer getReturn() {
        return this._return;
    }

    public void setReturn(ttu.idu0080.ee.offer.TransportOffer new_return)  {
        this._return = new_return;
    }

}

