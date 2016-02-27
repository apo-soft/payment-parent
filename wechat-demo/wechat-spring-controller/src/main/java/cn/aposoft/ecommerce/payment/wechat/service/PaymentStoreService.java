package cn.aposoft.ecommerce.payment.wechat.service;

import cn.aposoft.ecommerce.payment.wechat.Notification;
import cn.aposoft.ecommerce.payment.wechat.Order;
import cn.aposoft.ecommerce.payment.wechat.PayResponse;

/**
 * 支付存储服务
 * 
 * @author Jann Liu
 *
 */
public interface PaymentStoreService {

	void addPrepareOrder(Order order);

	void setPrepareOrderResponse(PayResponse response);

	void setPayNotification(Notification notification);
}
