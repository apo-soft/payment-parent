package cn.aposoft.ecommerce.payment.alipay.util;

import java.util.Map;

import cn.aposoft.ecommerce.payment.alipay.Config;
import cn.aposoft.ecommerce.payment.alipay.Order;
import cn.aposoft.ecommerce.payment.alipay.Refund;
import cn.aposoft.ecommerce.payment.alipay.RefundResponse;
import cn.aposoft.ecommerce.payment.alipay.impl.PayResponse;

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
	 * @param config
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月18日 下午3:59:38
	 */
	PayResponse parsePayResponseXml(String xml, Config config);

	/**
	 * 将返回的xml字符串解析成map类型返回【测试环境使用】
	 * 
	 * @param xml
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月12日 下午8:24:28
	 * @deprecated
	 */
	Map<String, String> parseMapXml(String xml);

	Map<String, String> generatePayMap(Order order, Config config);

	/**
	 * 退款请求：将bean数据转换为map数据
	 * 
	 * @param refund
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月16日 下午12:15:12
	 */
	Map<String, String> generateRefundMap(Refund refund, Config config);

	/**
	 * 将退款返回字符串封装为bean类型
	 * 
	 * @param resultXml
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月16日 下午2:41:16
	 */
	RefundResponse parseRefundResponseXml(String resultXml, Config config);
}
