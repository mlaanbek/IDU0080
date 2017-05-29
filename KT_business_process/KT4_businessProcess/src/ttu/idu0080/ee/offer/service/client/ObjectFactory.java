
package ttu.idu0080.ee.offer.service.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ttu.idu0080.ee.offer.service.client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetTransportOffer_QNAME = new QName("http://service.offer.ee.idu0080.ttu/", "getTransportOffer");
    private final static QName _GetTransportOfferResponse_QNAME = new QName("http://service.offer.ee.idu0080.ttu/", "getTransportOfferResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ttu.idu0080.ee.offer.service.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetTransportOffer }
     * 
     */
    public GetTransportOffer createGetTransportOffer() {
        return new GetTransportOffer();
    }

    /**
     * Create an instance of {@link GetTransportOfferResponse }
     * 
     */
    public GetTransportOfferResponse createGetTransportOfferResponse() {
        return new GetTransportOfferResponse();
    }

    /**
     * Create an instance of {@link OrderedProduct }
     * 
     */
    public OrderedProduct createOrderedProduct() {
        return new OrderedProduct();
    }

    /**
     * Create an instance of {@link Order }
     * 
     */
    public Order createOrder() {
        return new Order();
    }

    /**
     * Create an instance of {@link TransportOffer }
     * 
     */
    public TransportOffer createTransportOffer() {
        return new TransportOffer();
    }

    /**
     * Create an instance of {@link Address }
     * 
     */
    public Address createAddress() {
        return new Address();
    }

    /**
     * Create an instance of {@link Customer }
     * 
     */
    public Customer createCustomer() {
        return new Customer();
    }

    /**
     * Create an instance of {@link Seller }
     * 
     */
    public Seller createSeller() {
        return new Seller();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTransportOffer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.offer.ee.idu0080.ttu/", name = "getTransportOffer")
    public JAXBElement<GetTransportOffer> createGetTransportOffer(GetTransportOffer value) {
        return new JAXBElement<GetTransportOffer>(_GetTransportOffer_QNAME, GetTransportOffer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTransportOfferResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.offer.ee.idu0080.ttu/", name = "getTransportOfferResponse")
    public JAXBElement<GetTransportOfferResponse> createGetTransportOfferResponse(GetTransportOfferResponse value) {
        return new JAXBElement<GetTransportOfferResponse>(_GetTransportOfferResponse_QNAME, GetTransportOfferResponse.class, null, value);
    }

}
