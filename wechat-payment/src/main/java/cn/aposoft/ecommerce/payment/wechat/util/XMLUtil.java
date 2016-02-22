package cn.aposoft.ecommerce.payment.wechat.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLUtil {
	/**
	 * 将返回的字符串xml进行map解析
	 * 
	 * @param xmlString
	 * @return 返回xml字符串解析生成的Map对象
	 * @throws ParserConfigurationException
	 * @throws IOException
	 * @throws SAXException
	 */
	public static Map<String, String> getMapFromXML(String xmlString)
			throws ParserConfigurationException, IOException, SAXException {

		// 这里用Dom的方式解析回包的最主要目的是防止API新增回包字段
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		InputStream is = getStringStream(xmlString);
		Document document = builder.parse(is);

		// 获取到document里面的全部结点
		NodeList allNodes = document.getFirstChild().getChildNodes();
		Node node;
		Map<String, String> map = new HashMap<String, String>();
		int i = 0;
		while (i < allNodes.getLength()) {
			node = allNodes.item(i);
			if (node instanceof Element) {
				map.put(node.getNodeName(), node.getTextContent());
			}
			i++;
		}
		return map;
	}

	public static String createXML(Object o) throws IllegalAccessException {
		SortedMap<String, Object> parameters = new TreeMap<String, Object>();
		Class<?> cls = o.getClass();
		Field[] fields = cls.getDeclaredFields();
		for (Field f : fields) {
			f.setAccessible(true);
			Object v = f.get(o);
			if (v != null && v != "") {
				parameters.put(f.getName(), v);
			}

		}
		/**
		 * 迭代读取父类
		 */
		for (Class<?> superCls = cls.getSuperclass(); superCls != null; superCls = superCls.getSuperclass()) {
			fields = superCls.getDeclaredFields();
			for (Field f : fields) {
				f.setAccessible(true);
				Object v = f.get(o);
				if (v != null && v != "") {
					parameters.put(f.getName(), v);
				}
			}
		}

		return createXML(parameters);
	}

	/**
	 * 创建xml发送串
	 * 
	 * @param parameters
	 *            传入的报文内容参数Map
	 * @return 发送报文的xml字符串形式
	 */
	public static String createXML(SortedMap<String, String> parameters) {
		StringBuilder buffer = new StringBuilder();
		buffer.append("<xml>");
		for (Entry<String, String> entry : parameters.entrySet()) {
			String k = entry.getKey();
			String v = entry.getValue();
			if (v != null && !"".equals(v)) {
				buffer.append("<" + k + ">" + v + "</" + k + ">" + "\r\n");
			}
		}
		buffer.append("</xml>");
		return buffer.toString();
	}

	/**
	 * 字符串转输入流
	 * 
	 * @param sInputString
	 * @return
	 */
	public static InputStream getStringStream(String sInputString) {
		ByteArrayInputStream tInputStringStream = null;
		if (sInputString != null && !sInputString.trim().equals("")) {
			byte[] bytes;
			try {
				bytes = sInputString.getBytes("UTF-8");
				tInputStringStream = new ByteArrayInputStream(bytes);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}

		}
		return tInputStringStream;
	}

}
