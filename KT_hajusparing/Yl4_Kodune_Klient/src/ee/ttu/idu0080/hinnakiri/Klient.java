package ee.ttu.idu0080.hinnakiri;

/**
 * Klient hinnakirja teenusele
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.ws.soap.SOAPFaultException;

import org.apache.cxf.wsn.jaxws.GetResourcePropertyService;

import ee.ttu.idu0080.hinnakiri.exceptions.HinnakiriNegNumberFormatException;
import ee.ttu.idu0080.hinnakiri.exceptions.HinnakiriNullHindException;
import ee.ttu.idu0080.hinnakiri.exceptions.HinnakiriNumOfDigitsException;
import ee.ttu.idu0080.hinnakiri.exceptions.HinnakiriNumberFormatException;
import ee.ttu.idu0080.hinnakiri.service.HinnakiriService;
import ee.ttu.idu0080.hinnakiri.service.HinnakiriService_Service;
import ee.ttu.idu0080.hinnakiri.types.GetHinnakiriResponse;
import ee.ttu.idu0080.hinnakiri.types.Hinnakiri;
import ee.ttu.idu0080.hinnakiri.types.Hinnakiri.HinnakirjaRida;
import java.util.ArrayList;

/**
 * This class was generated by Apache CXF 2.2.6 Thu Mar 04 16:26:57 EET 2010
 * Generated source version: 2.2.6
 * 
 */

public final class Klient {
	private static final int NUM_OF_CONNECTION_TRIALS = 10;
	
	public static void main(String args[]) throws Exception {
		URL wsdlURL = parseArguments(args);
		
		/*
		ArrayList isikukoodid = new ArrayList();
		isikukoodid.add("38211080297");
		isikukoodid.add("3438211080297");
		isikukoodid.add("8211080297");
		isikukoodid.add("48211080297");
		isikukoodid.add("123");
		isikukoodid.add("58211080297");
		isikukoodid.add("enn");
		*/
		
		GetHinnakiriResponse response = null;
		//for (int i = 0; i < isikukoodid.size(); i++) {
		
		HinnakiriService port;
		for (int j = 0; j < NUM_OF_CONNECTION_TRIALS; j++) {
			
			// trying to connect
			try {
				HinnakiriService_Service service = new HinnakiriService_Service(wsdlURL);
				port = service.getHinnakiriPort();
			} catch (Exception e) {
				System.out.println("Ei saa serveriga ühendust (katse " + (j+1) + "). Viga: " + e);
				
				// try again connecting service
				continue;
			}
			
			// connection established
			try {
				String[] responsesToTest = {"12.00A", 
											"12A", 
											"12.34",
											"12.340",
											"12.345",
											"12.0",
											"-12.00",
											"0.000"};
				
				for (int i = 0; i < responsesToTest.length; i++) {
					
					try {
						response = port.getHinnakiri(responsesToTest[i]);
						System.out.println(responsesToTest[i] + " - korras");
						printToConsole(response.getHinnakiri());
						
					} catch(HinnakiriNumberFormatException e) {
						System.out.println(responsesToTest[i] + " - hind ei ole numbrilises formaadis: " + e);
					} catch (HinnakiriNegNumberFormatException e) {
						System.out.println(responsesToTest[i] + " - hind ei tohi olla negatiivne: " + e);
					} catch (HinnakiriNullHindException e) {
						System.out.println(responsesToTest[i] + " - hind ei tohi olla null: " + e);
					} catch (HinnakiriNumOfDigitsException e) {
						System.out.println(responsesToTest[i] + " - max kaks koma kohta on lubatud: " + e);
					}				
				}
				
			} 
			catch (SOAPFaultException e) {
				System.out.println("soapfaultexception: "  + e);
			}
			catch (Exception e) {
				System.out.println("Üldine viga: " + e);
			}
				
			// service rendered, no need to connect again to service
			return;
		}
		
		if(response == null)
			return;
		
		printToConsole(response.getHinnakiri());
	}

	/**
	 * Prindib konsoolile hinnakirja
	 * 
	 * @param hinnakiri
	 */
	private static void printToConsole(Hinnakiri hinnakiri) {

		System.out.println("Hinnakiri:");

		for (HinnakirjaRida hinnakirjaRida : hinnakiri.getHinnakirjaRida()) {
			StringBuilder outRida = new StringBuilder();
			outRida.append(hinnakirjaRida.getToode().getKood());
			outRida.append("\t");
			outRida.append(hinnakirjaRida.getToode().getNimetus());
			outRida.append("\t");
			outRida.append(hinnakirjaRida.getHind().getSumma());
			outRida.append(" ");
			outRida.append(hinnakirjaRida.getHind().getValuuta());

			System.out.println(outRida);
		}
	}

	/**
	 * Parsib välja programmi argumentide hulgast WSDL-i URL-i
	 * 
	 * @param args
	 *            argumendid
	 * @return URL
	 */
	private static URL parseArguments(String[] args) {

		URL wsdlURL = HinnakiriService_Service.WSDL_LOCATION;

		try {
			if (args.length > 0) {
				String firstArg = args[0];

				if (firstArg.startsWith("http:")) {
					wsdlURL = new URL(firstArg);
				} else {
					File wsdlFile = new File(firstArg);
					if (wsdlFile.exists()) {
						wsdlURL = wsdlFile.toURI().toURL();
					} else {
						wsdlURL = new URL(firstArg);
					}
				}
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		return wsdlURL;
	}

}
