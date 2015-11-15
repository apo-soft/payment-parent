package cn.aposoft.ecommerce.payment.alipay.util;

import java.util.Map;

import cn.aposoft.ecommerce.payment.alipay.Order;
import cn.aposoft.ecommerce.payment.alipay.impl.PayResponse;
import cn.aposoft.ecommerce.payment.alipay.test.InstantCountRequest;

/**
 * 支付与退款的过程封装
 * 
 * @author Yujinshui
 *
 */
public interface EntityUtil {
	/**
	 * [支付]将返回的xml字符串结果解析成PayResponse-javabean
	 * 
	 * @param xml
	 * @return
	 */
	PayResponse parsePayResponseXml(String xml);

	/**
	 * 将返回的xml字符串解析成map类型返回
	 * 
	 * @param xml
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月12日 下午8:24:28
	 */
	Map<String, String> parseMapXml(String xml);

	Map<String, String> generatePayMap(Order order);
}
