package ttu.idu0080.ee.courier;

import java.util.ArrayList;
import java.util.List;

import ttu.idu0080.ee.order.Address;


public class Courier {
	private List<Address> addresses;
	private int courierId;
	private String courierName;
	private int percentFromOrder;
	
	public List<Address> getAddresses() {
		if (addresses == null) {
            addresses = new ArrayList<Address>();
        }
        return this.addresses;
	}
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	public int getCourierId() {
		return courierId;
	}
	public void setCourierId(int courierId) {
		this.courierId = courierId;
	}
	public String getCourierName() {
		return courierName;
	}
	public void setCourierName(String courierName) {
		this.courierName = courierName;
	}
	public int getPercentFromOrder() {
		return percentFromOrder;
	}
	public void setPercentFromOrder(int percentFromOrder) {
		this.percentFromOrder = percentFromOrder;
	}
}
