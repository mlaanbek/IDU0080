package ttu.idu0080.ee.courier.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.jws.WebService;

import ttu.idu0080.ee.courier.Courier;
import ttu.idu0080.ee.offer.service.OfferService;
import ttu.idu0080.ee.order.Address;


@WebService(targetNamespace = "http://service.courier.ee.idu0080.ttu/", endpointInterface = "ttu.idu0080.ee.courier.service.CourierWebService", portName = "CourierServicePort", serviceName = "CourierServiceService")
public class CourierService implements ICourierService, CourierWebService {
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
	public List<Courier> getAllCouriers() {
		List<Courier> couriers = generateCouriers();
		String logText = "\n----------------\nCourierService starts";
		
		for (Courier c: couriers) {
			logText += "\nCourier: [" + c.getCourierName() + "]";
		}
		
		logText += "\nCourierService ends";
		LOG.info(logText);
		
		return couriers;
	}
	
	

	private List<Courier> generateCouriers() {
		List<Courier> courierList = new ArrayList<Courier>();
		
		// Possible addresses
		Address address1 = new Address();
		address1.setCountry("Eesti");
		address1.setCounty("Saaremaa");
		
		Address address2 = new Address();
		address2.setCountry("Eesti");
		address2.setCounty("Hiiumaa");
		
		Address address3 = new Address();
		address3.setCountry("Soome");
		address3.setCounty("Karjala");
		
		Address address4 = new Address();
		address4.setCountry("Eesti");
		address4.setCounty("Tartu");
		
		Address address5 = new Address();
		address5.setCountry("Eesti");
		address5.setCounty("Viljandi");
		
		// courier 1
		Courier courier1 = new Courier();
		courier1.setCourierId(1);
		courier1.setCourierName("DHL");
		courier1.setPercentFromOrder(10);
		List<Address> courier1Addresses = new ArrayList<Address>();
		courier1Addresses.add(address1);
		courier1Addresses.add(address2);
		courier1.setAddresses(courier1Addresses);
		
		// courier 2
		Courier courier2 = new Courier();
		courier2.setCourierId(2);
		courier2.setCourierName("Speedy Gonzales");
		courier2.setPercentFromOrder(15);
		List<Address> courier2Addresses = new ArrayList<Address>();

		courier2Addresses.add(address2);
		courier2Addresses.add(address3);
		courier2Addresses.add(address4);
		courier2Addresses.add(address5);
		courier2.setAddresses(courier2Addresses);
		
		// courier 3
		Courier courier3 = new Courier();
		courier3.setCourierId(3);
		courier3.setCourierName("Kiirkuller");
		courier3.setPercentFromOrder(25);
		List<Address> courier3Addresses = new ArrayList<Address>();

		courier3Addresses.add(address1);
		courier3Addresses.add(address4);
		courier3Addresses.add(address5);
		courier3.setAddresses(courier3Addresses);
		
		// courier 4
		Courier courier4 = new Courier();
		courier4.setCourierId(4);
		courier4.setCourierName("UBS");
		courier4.setPercentFromOrder(5);
		List<Address> courier4Addresses = new ArrayList<Address>();

		courier4Addresses.add(address2);
		courier4Addresses.add(address5);
		courier4.setAddresses(courier4Addresses);
		
		courierList.add(courier1);
		courierList.add(courier2);
		courierList.add(courier3);
		courierList.add(courier4);
		
		return courierList;
	}

	@Override
	public Courier getCourierById(int courierId) {
		List<Courier> courierList = generateCouriers();
		Courier courier = null;
		
		for (Courier c: courierList) {
			if (c.getCourierId() == courierId) {
				courier = c;
				break;
			}
		}
		
		return courier;
	}

}
