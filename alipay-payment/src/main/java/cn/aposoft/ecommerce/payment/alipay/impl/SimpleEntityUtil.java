package cn.aposoft.ecommerce.payment.alipay.impl;

import java.io.IOException;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import cn.aposoft.ecommerce.payment.alipay.inter.EntityUtil;
import cn.aposoft.ecommerce.payment.alipay.util.XMLUtil;

public class SimpleEntityUtil implements EntityUtil {
	private static Logger logger = Logger.getLogger(SimpleEntityUtil.class);

	@Override
	public PayResponse parsePayResponseXml(String xml) {
		Map<String, String> result = null;
		try {
			result = XMLUtil.getMapFromXML(xml);
		} catch (ParserConfigurationException | IOException | SAXException e) {
			logger.error("解析支付结果时发生错误: " + e.getMessage(), e);
			return null;
		}

		PayResponse response = new PayResponse();
		// TODO 赋值操作
		return response;
	}

	/**
	 * 将返回结果字符串解析为map类型【供测试使用】
	 * 
	 * @see cn.aposoft.ecommerce.payment.alipay.inter.EntityUtil#parseMapXml(java.lang.String)
	 * @deprecated
	 */
	@Override
	public Map<String, String> parseMapXml(String xml) {
		Map<String, String> result = null;
		try {
			result = XMLUtil.getMapFromXML(xml);
		} catch (ParserConfigurationException | IOException | SAXException e) {
			logger.error("解析支付结果时发生错误: " + e.getMessage(), e);
			return null;
		}
		return result;
	}

}
