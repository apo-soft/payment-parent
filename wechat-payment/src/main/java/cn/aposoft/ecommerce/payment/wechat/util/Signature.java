package cn.aposoft.ecommerce.payment.wechat.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/**
 * 创建签名Sign
 * 
 * @author Yujinshui
 *
 */
public class Signature {
	/**
	 * 签名算法[有问题，getDeclaredFields()会缺失内容]
	 * 
	 * @param o
	 *            要参与签名的数据对象
	 * @return 签名
	 * @throws IllegalAccessException
	 */
	public static String getSign(Object o, String key) throws IllegalAccessException {
		if (o == null) {
			throw new IllegalArgumentException("签名数据对象不可以为空.");
		}
		if (key == null || key.isEmpty()) {
			throw new IllegalArgumentException("签名key不能为空.");
		}
		ArrayList<String> list = new ArrayList<String>();
		Class<?> cls = o.getClass();
		Field[] fields = cls.getDeclaredFields();
		for (Field f : fields) {
			f.setAccessible(true);
			if (f.get(o) != null && f.get(o) != "") {
				list.add(f.getName() + "=" + f.get(o) + "&");
			}
		}
		int size = list.size();
		String[] arrayToSort = list.toArray(new String[size]);
		Arrays.sort(arrayToSort, String.CASE_INSENSITIVE_ORDER);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < size; i++) {
			sb.append(arrayToSort[i]);
		}
		String result = sb.toString();
		result += "key=" + key;
		result = MD5.MD5Encode(result).toUpperCase();
		return result;
	}

	/**
	 * 签名算法[有问题，getDeclaredFields()会缺失内容]
	 * 
	 * @param o
	 *            要参与签名的数据对象
	 * @return 签名
	 */
	public static String getMapSign(Map<String, String> map, String key) {
		if (map == null) {
			throw new IllegalArgumentException("签名数据对象不可以为空.");
		}
		if (key == null || key.isEmpty()) {
			throw new IllegalArgumentException("签名key不能为空.");
		}
		ArrayList<String> list = new ArrayList<String>();
		for (Map.Entry<String, String> entry : map.entrySet()) {
			if (entry.getValue() != null && entry.getValue() != "") {
				list.add(entry.getKey() + "=" + entry.getValue() + "&");
			}
		}
		int size = list.size();
		String[] arrayToSort = list.toArray(new String[size]);
		Arrays.sort(arrayToSort, String.CASE_INSENSITIVE_ORDER);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < size; i++) {
			sb.append(arrayToSort[i]);
		}
		String result = sb.toString();
		result += "key=" + key;
		result = MD5.MD5Encode(result).toUpperCase();
		return result;
	}
}
