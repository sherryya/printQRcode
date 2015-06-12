package util;

import java.nio.charset.Charset;

public class ChartSetUtil {
	public static boolean getCurrentCharSet(String parsm,String charset) {
		return Charset.forName(charset).newEncoder().canEncode(parsm);
	}
}
