package cn.aposoft.ecommerce.payment.alipay.util;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;

/**
 * 利用fastjson.jar封装的json工具
 * 
 * @author dragon
 *
 */
public class JsonUtil {
	/**
	 * List集合转Json
	 * 
	 * @param list
	 * @return
	 */
	public static String listToJson(List<?> list) {
		return JSON.toJSONString(list);
	}

	/**
	 * Json转List
	 * 
	 * @param text
	 */
	public static List<?> jsonToList(String text, Class<?> className) {

		return JSON.parseArray(text, className);
	}

	/**
	 * Map转Json
	 * 
	 * @param map
	 * @return
	 */
	public static String maptoJson(Map<String, Object> map) {
		return JSON.toJSONString(map);
	}

	/**
	 * Json转Map
	 * 
	 * @param text
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> jsontoMap(String text) {
		return JSON.parseObject(text, Map.class);
	}

	/**
	 * 对象转Json
	 * 
	 * @param object
	 * @return
	 */
	public static String ObjectToJson(Object object) {
		return JSON.toJSONString(object);
	}

	/**
	 * Json转Object
	 * 
	 * @param text
	 * @param classname
	 * @return
	 */
	public static Object JsonToObject(String text, Class<?> classname) {
		return JSON.parseObject(text, classname);
	}

	/**
	 * Json转String
	 * 
	 * @param text
	 * @param classname
	 * @return
	 */
	public static String getString(String text) {
		return JSON.parseObject(text, String.class);
	}
}
