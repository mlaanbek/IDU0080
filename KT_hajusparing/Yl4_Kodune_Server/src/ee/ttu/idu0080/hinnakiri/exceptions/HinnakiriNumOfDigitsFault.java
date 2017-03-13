package ee.ttu.idu0080.hinnakiri.exceptions;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name ="HinnakiriNumOfDigitsFault")
public class HinnakiriNumOfDigitsFault {
	private String message;

	public HinnakiriNumOfDigitsFault() {}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
