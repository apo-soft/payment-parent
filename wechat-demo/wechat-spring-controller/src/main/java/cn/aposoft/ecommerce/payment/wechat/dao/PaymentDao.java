/**
 * 
 */
package cn.aposoft.ecommerce.payment.wechat.dao;

import cn.aposoft.ecommerce.payment.wechat.Notification;
import cn.aposoft.ecommerce.payment.wechat.Order;
import cn.aposoft.ecommerce.payment.wechat.PayResponse;

/**
 * 
 * 实现订单交易对象持久化
 * 
 * @author Jann Liu
 *
 */
public interface PaymentDao {
	Boolean addPrepareOrder(Order order);

	Order getPrepareOrder(String orderNo);

	void setPayNotification(Notification notification);

	void setPrepareOrderResponse(String orderNo, PayResponse response);
}
