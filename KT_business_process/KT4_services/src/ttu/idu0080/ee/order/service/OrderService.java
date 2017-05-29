package ttu.idu0080.ee.order.service;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import ttu.idu0080.ee.order.Address;
import ttu.idu0080.ee.order.Customer;
import ttu.idu0080.ee.order.Order;
import ttu.idu0080.ee.order.OrderedProduct;
import ttu.idu0080.ee.order.Seller;


@WebService(targetNamespace = "http://service.order.ee.idu0080.ttu/", endpointInterface = "ttu.idu0080.ee.order.service.OrderWebService", portName = "OrderServicePort", serviceName = "OrderServiceService")
public class OrderService implements IOrderService, OrderWebService {

	@Override
	public Order getOrderById(int orderId) {
		Order order = new Order();
		order.setOrderId(1);
		order.setPriceTotal(13);
		
		Customer customer = new Customer();
		customer.setCustomerId(1);
		customer.setFirstName("Marek");
		customer.setLastName("Laanbek");
		order.setCustomer(customer);
		
		List<OrderedProduct> orderedProducts = new ArrayList<OrderedProduct>();
		OrderedProduct product1 = new OrderedProduct();
		product1.setProductId(1);
		product1.setProductName("Sai");
		product1.setPrice(5);
		product1.setProductCount(2);
		product1.setPriceTotal(10);
		orderedProducts.add(product1);
		
		OrderedProduct product2 = new OrderedProduct();
		product2.setProductId(2);
		product2.setProductName("Leib");
		product2.setPrice(3);
		product2.setProductCount(1);
		product2.setPriceTotal(3);
		orderedProducts.add(product2);
		
		Seller seller = new Seller();
		List<Address> sellerAddresses = new ArrayList<Address>();
		Address sellerAddress1 = new Address();
		sellerAddress1.setCountry("Eesti");
		sellerAddress1.setCounty("Hiiumaa");
		sellerAddresses.add(sellerAddress1);
		seller.setAddresses(sellerAddresses);
		seller.setSellerId(1);
		seller.setSellerName("Kauplus Videvik");
		order.setSeller(seller);
		
		Address shippingAddress = new Address();
		shippingAddress.setCountry("Eesti");
		shippingAddress.setCounty("Saaremaa");
		
		order.setShippingAddress(shippingAddress);
			
		return order;
	}
	
}
