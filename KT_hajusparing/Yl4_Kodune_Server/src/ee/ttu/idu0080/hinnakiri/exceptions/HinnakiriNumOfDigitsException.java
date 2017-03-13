package ee.ttu.idu0080.hinnakiri.exceptions;

import javax.xml.ws.WebFault;

@WebFault(name = "HinnakiriNumOfDigitsFault")
public class HinnakiriNumOfDigitsException extends Exception {
	private HinnakiriNumOfDigitsFault faultInfo;
	
	public HinnakiriNumOfDigitsException() {
		this("Max two digits are allowed");
	}

	public HinnakiriNumOfDigitsException(String message) {
		super(message);
		
		// fault message
		faultInfo = new HinnakiriNumOfDigitsFault();
		faultInfo.setMessage(message);
	}
	
	public HinnakiriNumOfDigitsException(String message,
			HinnakiriNumOfDigitsFault faultInfo) {
		
		super(message);
		this.faultInfo = faultInfo;
	}
	
	public HinnakiriNumOfDigitsFault getFaultInfo() {
		return faultInfo;
	}
}
