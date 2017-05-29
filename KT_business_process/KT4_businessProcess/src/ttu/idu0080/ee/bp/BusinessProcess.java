package ttu.idu0080.ee.bp;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


import ttu.idu0080.ee.courier.service.client.Courier;
import ttu.idu0080.ee.courier.service.client.CourierWebService_CourierServicePort_Client;
import ttu.idu0080.ee.offer.service.client.Address;
import ttu.idu0080.ee.offer.service.client.IOfferService_OfferServicePort_Client;
import ttu.idu0080.ee.offer.service.client.TransportOffer;
import ttu.idu0080.ee.order.service.client.Order;
import ttu.idu0080.ee.order.service.client.OrderWebService_OrderServicePort_Client;

public class BusinessProcess {
	
	private static final String LOG_FILE = "/Users/marek/Documents/Ajutine/bp_client_log.txt";
	private static final Logger LOG = getLogger();
	
	private static Logger getLogger() {
		
		Logger logger = Logger.getLogger(BusinessProcess.class.getName());
		
		try {
			FileHandler fileHandler = new FileHandler(LOG_FILE);
			fileHandler.setFormatter(new SimpleFormatter());
			logger.addHandler(fileHandler);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return logger;
	}
	
	public static void main(String[] args) {
		OrderWebService_OrderServicePort_Client orderServicePort = 
				new OrderWebService_OrderServicePort_Client();
		
		Order order = new Order();
		TransportOffer offer = new TransportOffer();
		
		
		order = orderServicePort.getOrderById(1);
		offer = getBestTransportOfferForOrder(order);
	}

	private static TransportOffer getBestTransportOfferForOrder(Order order) {
		TransportOffer bestOffer = new TransportOffer();
		String logText = "";
		
		ttu.idu0080.ee.offer.service.client.Order orderToOffer = new ttu.idu0080.ee.offer.service.client.Order();
		ttu.idu0080.ee.offer.service.client.Customer orderToOffer_customer = new ttu.idu0080.ee.offer.service.client.Customer();
		orderToOffer_customer.setCustomerId(order.getCustomer().getCustomerId());
		orderToOffer_customer.setFirstName(order.getCustomer().getFirstName());
		orderToOffer_customer.setLastName(order.getCustomer().getLastName());
		orderToOffer.setCustomer(orderToOffer_customer);
		
		orderToOffer.setOrderId(order.getOrderId());
		orderToOffer.setPriceTotal(order.getPriceTotal());
		
		ttu.idu0080.ee.offer.service.client.Seller orderToOffer_seller = new ttu.idu0080.ee.offer.service.client.Seller();
		orderToOffer_seller.setSellerId(order.getSeller().getSellerId());
		orderToOffer_seller.setSellerName(order.getSeller().getSellerName());
		List<Address> sellerAddresses = new ArrayList<Address>();
		Address sellerAddress = new Address();
		sellerAddress.setCountry("Eesti");
		sellerAddress.setCounty("Saaremaa");
		sellerAddresses.add(sellerAddress);
		orderToOffer_seller.setAddresses(sellerAddresses);
		orderToOffer.setSeller(orderToOffer_seller);
		
		ttu.idu0080.ee.offer.service.client.Address orderToOffer_shippingAddress = new ttu.idu0080.ee.offer.service.client.Address();
		orderToOffer_shippingAddress.setCountry(order.getShippingAddress().getCountry());
		orderToOffer_shippingAddress.setCounty(order.getShippingAddress().getCounty());
		orderToOffer.setShippingAddress(orderToOffer_shippingAddress);
		
		
		CourierWebService_CourierServicePort_Client courierServicePort = 
				new CourierWebService_CourierServicePort_Client();
		
		IOfferService_OfferServicePort_Client offerServicePort = 
				new IOfferService_OfferServicePort_Client();
		
		List<TransportOffer> transportOfferList = new ArrayList<TransportOffer>();
		List<Courier> courierList = new ArrayList<Courier>();
		List<CourierOffer> courierOfferList = new ArrayList<CourierOffer>();
		courierList = courierServicePort.getAllCouriers();
		
		logText += "\nÄriprotsessi algus\n--------------------\norder_id: " + order.getOrderId() 
				+ " order price: " + order.getPriceTotal(); 
		
		
		
		if (courierList.isEmpty()) {
			// do nothing
		} else {
			for (Courier c: courierList) {
				TransportOffer offer = new TransportOffer();
				offer = offerServicePort.getTransportOffer(c.getCourierId(), orderToOffer);
				CourierOffer courierOffer = new CourierOffer(c, offer);
				courierOfferList.add(courierOffer);
				transportOfferList.add(offer);

			}
		}
		
		logText += "\nreceived " + transportOfferList.size() + " offers\n-----------------";
		
		
		TransportOffer bestTransportOffer = null;
		BigDecimal bestOfferPrice = null;
		Courier bestCourier = null;
		
		for (CourierOffer courierOffer: courierOfferList) {
			Courier courier = courierOffer.getCourier();
			TransportOffer transportOffer = courierOffer.getTransportOffer();
			BigDecimal transportOfferPrice = (new BigDecimal(transportOffer.getTransportPrice())).multiply(new BigDecimal(transportOffer.getDeliveryDate()));
			
			Calendar deliveryDate = Calendar.getInstance();
			deliveryDate.add(Calendar.DATE, transportOffer.getDeliveryDate().intValue());
			String deliveryDateTxt = String.format("%s", new SimpleDateFormat("yyyy-mm-dd").format(deliveryDate.getTime()));
			
			if (bestOfferPrice == null || transportOfferPrice.compareTo(bestOfferPrice) < 0) {
				bestOfferPrice = transportOfferPrice;
				bestTransportOffer = transportOffer;
				bestCourier = courier;
			}
			logText += "\nrank: [" + transportOfferPrice + "] Courier: [" + courier.getCourierName() 
					+ "] Transport offer price: [" + transportOffer.getTransportPrice() + "] days: [" 
					+ transportOffer.getDeliveryDate() + "] approximate delivery date: [" + deliveryDateTxt + "]";
		}
		
		logText += "\n-----------------------\nSelected offer: courier: [" + bestCourier.getCourierName() 
				+ "] offer id: [" + bestTransportOffer.getOfferId() + "] offer price: [" 
				+ bestTransportOffer.getTransportPrice() + "]\nProtsessi lõpp\n--------------------";
		
		LOG.info(logText);
		
		return bestOffer;
	}


}
