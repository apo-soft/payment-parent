package cn.aposoft.payment.alipay2;

import java.util.Map;

/**
 * 支付与退款的过程封装
 * 
 * @author Yujinshui
 *
 */
public interface Ali2EntityUtil {
	/**
	 * [支付]将返回的xml字符串结果解析成PayResponse-javabean
	 * 
	 * @param xml
	 * @return
	 */
	// PayResponse parsePayResponseXml(String xml);

	/**
	 * 将返回的xml字符串解析成map类型返回
	 * 
	 * @param xml
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月12日 下午8:24:28
	 */
	Map<String, String> parseMapXml(String xml);

	// Map<String, String> generatePayMap(Order order, Config config);

	/**
	 * 退款请求：将bean数据转换为map数据
	 * 
	 * @param refund
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月16日 下午12:15:12
	 */
	// Map<String, String> generateRefundMap(Refund refund, Config config);

	/**
	 * 将退款返回字符串封装为bean类型
	 * 
	 * @param resultXml
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月16日 下午2:41:16
	 */
	// RefundResponse parseRefundResponseXml(String resultXml);
}
