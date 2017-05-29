package ttu.idu0080.ee.order;

import java.util.ArrayList;
import java.util.List;

public class Order {
	private Customer customer;
	private int orderId;
	private List<OrderedProduct> orderedProducts;
	private float priceTotal;
	private Seller seller;
	private Address shippingAddress;
	
	
	public Customer getCustomer() {
		return customer;
	}
	public int getOrderId() {
		return orderId;
	}
	public List<OrderedProduct> getOrderedProducts() {
		if (orderedProducts == null) {
            orderedProducts = new ArrayList<OrderedProduct>();
        }	
		return orderedProducts;
	}
	public float getPriceTotal() {
		return priceTotal;
	}
	public Seller getSeller() {
		return seller;
	}
	public Address getShippingAddress() {
		return shippingAddress;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public void setPriceTotal(float priceTotal) {
		this.priceTotal = priceTotal;
	}
	public void setSeller(Seller seller) {
		this.seller = seller;
	}
	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
}
