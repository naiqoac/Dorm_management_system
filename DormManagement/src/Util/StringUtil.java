package Util;

public class StringUtil {
	public static boolean Empty(String str) {
		if((str==null)||"".equals(str.trim())) {
			return true;
		}
		else {
			return false;
		}
	}
}
