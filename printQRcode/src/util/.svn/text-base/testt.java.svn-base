package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class testt {
	public static void main(String args[]) {
		String str = "2a3333";

		// String regEx="^[a-z][a-z0-9_]{4,16}$";
		String regEx = "^[0-9a-zA-Z!@$#%^&*]{6,16}$";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str);
		boolean result = m.find();
		System.out.println(result);
	}
}
