/**
 * 
 */
package cn.aposoft.ecommerce.payment.wechat.service.impl;

import cn.aposoft.ecommerce.payment.wechat.Notification;
import cn.aposoft.ecommerce.payment.wechat.Order;
import cn.aposoft.ecommerce.payment.wechat.PayResponse;
import cn.aposoft.ecommerce.payment.wechat.dao.PaymentDao;
import cn.aposoft.ecommerce.payment.wechat.service.PaymentStorageException;
import cn.aposoft.ecommerce.payment.wechat.service.PaymentStoreService;

/**
 * 
 * 实现订单交易对象持久化
 * 
 * @author Jann Liu
 *
 */
public class PaymentStoreServiceImpl implements PaymentStoreService {
	//
	private PaymentDao paymentDao;

	/**
	 * 构造函数
	 * 
	 * @param paymentDao
	 *            订单数据层访问方法
	 */
	public PaymentStoreServiceImpl(PaymentDao paymentDao) {
		this.paymentDao = paymentDao;
	}

	/**
	 * 添加订单(仅当订单不存在时添加)
	 * 
	 * @param order
	 *            订单信息
	 * @return 订单添加结果
	 */
	@Override
	public Boolean addPrepareOrder(Order order) {
		try {
			return paymentDao.addPrepareOrder(order);
		} catch (RuntimeException e) {
			throw new PaymentStorageException("", e);
		}
	}

	/**
	 * 读取预付款订单信息
	 * 
	 * @param orderNo
	 *            订单编号
	 * @return 订单信息
	 */
	@Override
	public Order getPrepareOrder(String orderNo) {
		return paymentDao.getPrepareOrder(orderNo);
	}

	@Override
	public void setPrepareOrderResponse(PayResponse response) {

	}

	@Override
	public void addPayNotification(Notification notification) {

	}

}
