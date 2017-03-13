package ee.ttu.idu0080.hinnakiri.util;

import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

public class IsikukoodValidator {
	/** Each Estonian personal code must match this pattern*/
	private static final Pattern NUMBER_PATTERN = Pattern.compile("^\\d{11}$");
	
	public static boolean isValid(final String number) {
		return StringUtils.isNotBlank(number) 
				&& NUMBER_PATTERN.matcher(number).matches();
	}
}
