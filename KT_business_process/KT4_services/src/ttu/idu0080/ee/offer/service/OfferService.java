package ttu.idu0080.ee.offer.service;

import java.io.IOException;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.jws.WebService;

import ttu.idu0080.ee.courier.Courier;
import ttu.idu0080.ee.courier.service.CourierService;
import ttu.idu0080.ee.offer.TransportOffer;
import ttu.idu0080.ee.order.Address;
import ttu.idu0080.ee.order.Order;

@WebService(targetNamespace = "http://service.offer.ee.idu0080.ttu/", endpointInterface = "ttu.idu0080.ee.offer.service.IOfferService", portName = "OfferServicePort", serviceName = "OfferServiceService")
public class OfferService implements IOfferService {
	private static final String LOG_FILE = "/Users/marek/Documents/Ajutine/bp_server_log.txt";
	private static final Logger LOG = getLogger();
	
	private static Logger getLogger() {
		
		Logger logger = Logger.getLogger(OfferService.class.getName());
		
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

	@Override
	public TransportOffer getTransportOffer(int courierId, Order order) {
		LOG.setUseParentHandlers(false);
		
		String logText = "";
		
		TransportOffer offer = new TransportOffer();
		Courier courier = new Courier();
		float transportPrice = 0;
		int transportDiscount = 0;
		String offerId = "";
		
		CourierService courierService = new CourierService();
		courier = courierService.getCourierById(courierId);
		
		logText = "\n---------------------------\nOfferService starts\nreceived courier id: [" + courierId + "] order price: [" + order.getPriceTotal() 
		+ "] shipping address county: [" + order.getShippingAddress().getCounty() + "]\nKullerfirma protsent: [" 
				+ courier.getPercentFromOrder() + "]";
		
		
		// if shipping address county is the same as one of courier's counties, apply 30% discount
		for (Address courierAddress: courier.getAddresses()) {
			if (courierAddress.getCounty().equals(order.getShippingAddress().getCounty())) {
				transportDiscount += 30;
				logText += "\nShipping address langeb kokku kullerfirma aadressiga";
				break;
			}
			
		}
		
		
		// if at least one of seller's county equals one of courier's county, apply 30% discount
		for (Address sellerAddress: order.getSeller().getAddresses()) {
			for (Address courierAddress: courier.getAddresses()) {
				if (sellerAddress.getCounty().equals(courierAddress.getCounty())) {
					transportDiscount += 30;
					break;
				}
			}
		}
		logText += "\nOffer discount: [" + transportDiscount + "]";
		
		
		// calculate transport offer price
		transportPrice = (order.getPriceTotal() * courier.getPercentFromOrder() 
				* (100 - transportDiscount)) / (100 * 100);
		
		offer.setTransportPrice(transportPrice);
		offerId = generateOfferId();
		offer.setOfferId(offerId);
		offer.setDeliveryDate(BigInteger.valueOf(5));
		
		Calendar approxDeliveryDate = Calendar.getInstance();
		approxDeliveryDate.add(Calendar.DATE, offer.getDeliveryDate().intValue());
		String approxDeliveryDateTxt = String.format("%s", new SimpleDateFormat("yyyy-mm-dd").format(approxDeliveryDate.getTime()));
		
		logText += "\noffer: offer_id: [" + offer.getOfferId() + "] offer price: [" + offer.getTransportPrice() 
				+ "] approx. delivery date: [" + approxDeliveryDateTxt 
				+ "]\nOfferService ends\n-----------------------\n\n";
		
		LOG.info(logText);
		
		return offer;
	}


	private String generateOfferId() {
		Random rnd = new Random();
		Random rndBoolean = new Random();
		String offerId = "";
		
		// 'a'=97, 'z'=122
		for (int i = 0; i < 11; i++) {
			boolean b = rndBoolean.nextBoolean();
			if (b) {
				int j = rnd.nextInt((9 - 1) + 1) + 1;
				offerId += j + "";
			} else {
				int j = 97 + rnd.nextInt(122-97);
				offerId += (char) j + "";
			}
		}
		return offerId;
	}


}
