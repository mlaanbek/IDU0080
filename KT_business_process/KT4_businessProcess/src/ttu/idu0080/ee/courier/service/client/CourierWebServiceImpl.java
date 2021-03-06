
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package ttu.idu0080.ee.courier.service.client;

import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.7.18
 * 2017-05-28T12:58:09.203+03:00
 * Generated source version: 2.7.18
 * 
 */

@javax.jws.WebService(
                      serviceName = "CourierServiceService",
                      portName = "CourierServicePort",
                      targetNamespace = "http://service.courier.ee.idu0080.ttu/",
                      wsdlLocation = "http://localhost:8080/KT4_services/services/CourierServicePort?wsdl",
                      endpointInterface = "ttu.idu0080.ee.courier.service.client.CourierWebService")
                      
public class CourierWebServiceImpl implements CourierWebService {

    private static final Logger LOG = Logger.getLogger(CourierWebServiceImpl.class.getName());

    /* (non-Javadoc)
     * @see ttu.idu0080.ee.courier.service.client.CourierWebService#getAllCouriers(*
     */
    public java.util.List<ttu.idu0080.ee.courier.service.client.Courier> getAllCouriers() { 
        LOG.info("Executing operation getAllCouriers");
        try {
            java.util.List<ttu.idu0080.ee.courier.service.client.Courier> _return = new java.util.ArrayList<ttu.idu0080.ee.courier.service.client.Courier>();
            ttu.idu0080.ee.courier.service.client.Courier _returnVal1 = new ttu.idu0080.ee.courier.service.client.Courier();
            java.util.List<ttu.idu0080.ee.courier.service.client.Address> _returnVal1Addresses = new java.util.ArrayList<ttu.idu0080.ee.courier.service.client.Address>();
            ttu.idu0080.ee.courier.service.client.Address _returnVal1AddressesVal1 = new ttu.idu0080.ee.courier.service.client.Address();
            _returnVal1AddressesVal1.setCountry("Country-2008490808");
            _returnVal1AddressesVal1.setCounty("County-1063964860");
            _returnVal1Addresses.add(_returnVal1AddressesVal1);
            _returnVal1.getAddresses().addAll(_returnVal1Addresses);
            _returnVal1.setCourierId(2080597490);
            _returnVal1.setCourierName("CourierName-1094439883");
            _returnVal1.setPercentFromOrder(-1141390606);
            _return.add(_returnVal1);
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see ttu.idu0080.ee.courier.service.client.CourierWebService#getCourierById(int  arg0 )*
     */
    public ttu.idu0080.ee.courier.service.client.Courier getCourierById(int arg0) { 
        LOG.info("Executing operation getCourierById");
        System.out.println(arg0);
        try {
            ttu.idu0080.ee.courier.service.client.Courier _return = new ttu.idu0080.ee.courier.service.client.Courier();
            java.util.List<ttu.idu0080.ee.courier.service.client.Address> _returnAddresses = new java.util.ArrayList<ttu.idu0080.ee.courier.service.client.Address>();
            ttu.idu0080.ee.courier.service.client.Address _returnAddressesVal1 = new ttu.idu0080.ee.courier.service.client.Address();
            _returnAddressesVal1.setCountry("Country1304828852");
            _returnAddressesVal1.setCounty("County198688514");
            _returnAddresses.add(_returnAddressesVal1);
            _return.getAddresses().addAll(_returnAddresses);
            _return.setCourierId(625743846);
            _return.setCourierName("CourierName798632177");
            _return.setPercentFromOrder(-800735696);
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

}
