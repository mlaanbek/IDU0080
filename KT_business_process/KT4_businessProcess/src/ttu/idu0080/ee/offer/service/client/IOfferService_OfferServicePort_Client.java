
package ttu.idu0080.ee.offer.service.client;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.7.18
 * 2017-05-28T12:58:43.277+03:00
 * Generated source version: 2.7.18
 * 
 */
public final class IOfferService_OfferServicePort_Client {

    private static final QName SERVICE_NAME = new QName("http://service.offer.ee.idu0080.ttu/", "OfferServiceService");

    public IOfferService_OfferServicePort_Client() {
    }
    
    public TransportOffer getTransportOffer(int courierId, ttu.idu0080.ee.offer.service.client.Order order) {
    	URL wsdlURL = OfferServiceService.WSDL_LOCATION;
    	String args[] = {""};
    	TransportOffer transportOffer = new TransportOffer();
    	
    	if (args.length > 0) { 
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                   // wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
    	
    	OfferServiceService ss = new OfferServiceService(wsdlURL, SERVICE_NAME);
        IOfferService port = ss.getOfferServicePort();
        transportOffer = port.getTransportOffer(courierId, order);
    	   	
    	return transportOffer;
    }
}
