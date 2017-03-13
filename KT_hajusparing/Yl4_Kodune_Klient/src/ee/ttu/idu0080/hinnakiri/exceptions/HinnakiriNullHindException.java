package ee.ttu.idu0080.hinnakiri.exceptions;

import javax.xml.ws.WebFault;

@WebFault(name = "HinnakiriNullHindFault")
public class HinnakiriNullHindException extends Exception {
	
	private HinnakiriNullHindFault faultInfo;
	
	public HinnakiriNullHindException() {
		this("Zero number is not allowed");
	}
	
	public HinnakiriNullHindException(String message) {
		super(message);
		
		// set fault message
		faultInfo = new HinnakiriNullHindFault();
		faultInfo.setMessage(message);
	}
	
	public HinnakiriNullHindException(String message, HinnakiriNullHindFault faultInfo) {
		super(message);
		
		this.faultInfo = faultInfo;
	}

	public HinnakiriNullHindFault getFaultInfo() {
		return faultInfo;
	}
	
}
