package ttu.idu0080.ee.bp;

import ttu.idu0080.ee.courier.service.client.Courier;
import ttu.idu0080.ee.offer.service.client.TransportOffer;

public class CourierOffer {
	private Courier courier;
	private TransportOffer transportOffer;
	
	public Courier getCourier() {
		return courier;
	}
	
	public CourierOffer(Courier courier, TransportOffer transportOffer) {
		this.courier = courier;
		this.transportOffer = transportOffer;
	}
	

	public TransportOffer getTransportOffer() {
		return transportOffer;
	}
	
	
}
