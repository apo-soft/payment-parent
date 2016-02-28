/**
 * 
 */
package cn.aposoft.ecommerce.payment.wechat.dao;

import cn.aposoft.ecommerce.payment.wechat.Notification;
import cn.aposoft.ecommerce.payment.wechat.Order;
import cn.aposoft.ecommerce.payment.wechat.PayResponse;

/**
 * 
 * 实现订单交易对象持久化 本例假定订单编号是唯一的
 * 
 * @author Jann Liu
 *
 */
public interface PaymentDao {
	/**
	 * 读取下一个订单编号
	 * 
	 * @return 订单编号
	 */
	String getNextOrderNo();

	/**
	 * 添加订单
	 * 
	 * @param order
	 *            订单信息
	 * @return 订单添加结果
	 */
	Boolean addPrepareOrder(Order order);

	/**
	 * 根据订单编号,读取订单信息
	 * 
	 * @param orderNo
	 *            订单编号
	 * @return 订单信息
	 */
	Order getPrepareOrder(String orderNo);

	/**
	 * 设置支付提醒: 支付成功的提醒,应当只有一个支付成功提醒
	 * 
	 * @param notification
	 *            支付提醒
	 */
	void setPayNotification(Notification notification);

	/**
	 * 设置支付响应记录
	 * 
	 * @param orderNo
	 *            订单编号
	 * @param response
	 *            支付响应记录
	 */
	void setPrepareOrderResponse(String orderNo, PayResponse response);

	/**
	 * 初始化订单编号
	 * 
	 * @param num
	 *            {@code long} 初始化数值
	 * @return 设置是否成功
	 */
	Boolean setInitOrderNo(long num);
}
