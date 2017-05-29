package ttu.idu0080.ee.offer.service;

import javax.jws.WebService;

import ttu.idu0080.ee.order.Order;
import ttu.idu0080.ee.offer.TransportOffer;

@WebService(name = "IOfferService", targetNamespace = "http://service.offer.ee.idu0080.ttu/")
public interface IOfferService {

		public TransportOffer getTransportOffer(int courierId, Order order);
}
