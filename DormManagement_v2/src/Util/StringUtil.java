package Util;

public class StringUtil {
	/**
	 * used to check if a string is null
	 * @param str
	 * @return true if it is null , false if not
	 */
	public static boolean Empty(String str) {
		if((str==null)||"".equals(str.trim())) {
			return true;
		}
		else {
			return false;
		}
	}
}
