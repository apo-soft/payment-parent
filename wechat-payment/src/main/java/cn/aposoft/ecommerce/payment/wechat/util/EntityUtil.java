/**
 * 
 */
package cn.aposoft.ecommerce.payment.wechat.util;

import cn.aposoft.ecommerce.payment.wechat.Config;
import cn.aposoft.ecommerce.payment.wechat.Notification;
import cn.aposoft.ecommerce.payment.wechat.Order;
import cn.aposoft.ecommerce.payment.wechat.OrderQuery;
import cn.aposoft.ecommerce.payment.wechat.OrderQueryResponse;
import cn.aposoft.ecommerce.payment.wechat.PayResponse;
import cn.aposoft.ecommerce.payment.wechat.Refund;
import cn.aposoft.ecommerce.payment.wechat.RefundResponse;

/**
 * 支付与退款的过程封装
 * 
 * @author LiuJian
 *
 */
public interface EntityUtil {
	/**
	 * 根据order和config创建待发送的支付信息xml字符串
	 * 
	 * @param order
	 *            订单信息
	 * @param config
	 *            配置内容
	 * @return
	 */
	String generatePayXml(Order order, Config config);

	/**
	 * 根据refund和config创建退款信息xml字符串
	 * 
	 * @param refund
	 *            退款信息
	 * @param config
	 *            配置内容
	 * @return
	 * @author Yujinshui
	 */
	String generateRefundXml(Refund refund, Config config);

	/**
	 * [支付]将返回的map结果解析成PayResponse-javabean
	 * 
	 * @param xml
	 * @return
	 */
	PayResponse parsePayResponseXml(String xml);

	/**
	 * 将支付成功后返回的结果进行javabean格式化
	 * 
	 * @param xml
	 * @return
	 */
	Notification parseNotificationXml(String xml);

	/**
	 * [退款]将返回的map结果解析成javabean
	 * 
	 * @param xml
	 * @return
	 * @author Yujinshui
	 */
	RefundResponse parseRefundResponseXml(String xml);

	/**
	 * TODO 创建订单查询xml字符串
	 * @param params
	 * @param config
	 * @return
	 * @author Yujinshui
	 * @time 2015年10月26日 下午10:30:40
	 */
	String generateOrderQueryXml(OrderQuery params, Config config);
	
	/**
	 * TODO 解析订单查询字符结果，并返回OrderQueryResponse对象
	 * @param responseText
	 * @return
	 * @author Yujinshui
	 * @time 2015年10月26日 下午10:31:20
	 */
	OrderQueryResponse parseOrderQueryResponseXml(String responseText);
}
