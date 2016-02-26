package cn.aposoft.ecommerce.payment.wechat.util;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
	private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d",
			"e", "f" };

	private final static MessageDigest MD5 = createMD5Digest();

	private final static Charset CHARSET = Charset.forName("UTF-8");

	/**
	 * 转换字节数组为16进制字串
	 * 
	 * @param b
	 *            字节数组
	 * @return 16进制字串
	 */
	public static String byteArrayToHexString(byte[] b) {
		StringBuilder resultSb = new StringBuilder();
		for (byte aB : b) {
			resultSb.append(byteToHexString(aB));
		}
		return resultSb.toString();
	}

	private static MessageDigest createMD5Digest() {
		MessageDigest messageDigest;
		try {
			messageDigest = MessageDigest.getInstance("MD5");
			return messageDigest;
		} catch (NoSuchAlgorithmException e) {
			// this will never happen
			return null;
		}

	}

	/**
	 * 转换byte到16进制
	 * 
	 * @param b
	 *            要转换的byte
	 * @return 16进制格式
	 */
	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0) {
			n = 256 + n;
		}
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}

	/**
	 * MD5编码
	 * 
	 * @param origin
	 *            原始字符串
	 * @return 经过MD5加密之后的结果
	 */
	public static String MD5Encode(String origin) {
		if (origin == null) {
			throw new IllegalArgumentException("Origin String must not be null.");
		}
		String resultString = null;
		try {
			resultString = origin;
			resultString = byteArrayToHexString(MD5.digest(origin.getBytes(CHARSET)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultString;
	}

}
