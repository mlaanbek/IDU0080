package ttu.idu0080.ee.order.service.client;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.7.18
 * 2017-05-28T12:57:10.643+03:00
 * Generated source version: 2.7.18
 * 
 */
@WebServiceClient(name = "OrderServiceService", 
                  wsdlLocation = "http://localhost:8080/KT4_services/services/OrderServicePort?wsdl",
                  targetNamespace = "http://service.order.ee.idu0080.ttu/") 
public class OrderServiceService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://service.order.ee.idu0080.ttu/", "OrderServiceService");
    public final static QName OrderServicePort = new QName("http://service.order.ee.idu0080.ttu/", "OrderServicePort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8080/KT4_services/services/OrderServicePort?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(OrderServiceService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://localhost:8080/KT4_services/services/OrderServicePort?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public OrderServiceService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public OrderServiceService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public OrderServiceService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public OrderServiceService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public OrderServiceService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public OrderServiceService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     *
     * @return
     *     returns OrderWebService
     */
    @WebEndpoint(name = "OrderServicePort")
    public OrderWebService getOrderServicePort() {
        return super.getPort(OrderServicePort, OrderWebService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns OrderWebService
     */
    @WebEndpoint(name = "OrderServicePort")
    public OrderWebService getOrderServicePort(WebServiceFeature... features) {
        return super.getPort(OrderServicePort, OrderWebService.class, features);
    }

}
