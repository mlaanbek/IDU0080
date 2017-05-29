package ttu.idu0080.ee.offer;

import java.math.BigInteger;

public class TransportOffer {
	private String offerId;
	private float transportPrice;
	private BigInteger deliveryDate;
	
	public String getOfferId() {
		return offerId;
	}
	public void setOfferId(String offerId) {
		this.offerId = offerId;
	}
	public float getTransportPrice() {
		return transportPrice;
	}
	public void setTransportPrice(float transportPrice) {
		this.transportPrice = transportPrice;
	}
	public BigInteger getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(BigInteger deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
}
