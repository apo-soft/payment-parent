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
	/**
	 * 完成支付对象的保存
	 * 
	 * @param order
	 *            待存储的订单
	 * @return
	 * @throws PaymentStorageException
	 *             当存储时发生异常,抛出此异常
	 */
	Boolean addPrepareOrder(Order order) throws PaymentStorageException;

	/**
	 * 订单信息查询
	 * 
	 * @param orderNo
	 *            订单编号
	 * @return 订单信息
	 * @throws PaymentStorageException
	 */
	Order getPrepareOrder(String orderNo) throws PaymentStorageException;

	/**
	 * 
	 * @param response
	 * @throws PaymentStorageException
	 *             当存储时发生异常,抛出此异常
	 */
	void setPrepareOrderResponse(PayResponse response) throws PaymentStorageException;

	/**
	 * 
	 * 
	 * @param notification
	 *            微信服务器回调通知接口
	 * @throws PaymentStorageException
	 *             当存储时发生异常,抛出此异常
	 */
	void addPayNotification(Notification notification) throws PaymentStorageException;

	/**
	 * 自动化自增的seq生成方法
	 * 
	 * @return 获取下一个订单编号
	 */
	String getNextOrderNo() throws PaymentStorageException;
}
