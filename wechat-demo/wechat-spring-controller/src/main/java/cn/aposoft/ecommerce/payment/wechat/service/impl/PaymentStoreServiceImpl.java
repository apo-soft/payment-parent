/**
 * 
 */
package cn.aposoft.ecommerce.payment.wechat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
@Service("paymentStoreService")
public class PaymentStoreServiceImpl implements PaymentStoreService {
	//
	@Autowired
	private PaymentDao paymentDao;

	/**
	 * 构造函数
	 * 
	 * @param paymentDao
	 *            订单数据层访问方法
	 */
	public PaymentStoreServiceImpl(){
		
	}
	
	public PaymentStoreServiceImpl(PaymentDao paymentDao) {
		this.paymentDao = paymentDao;
	}

	/**
	 * 添加订单(仅当订单不存在时添加)
	 * 
	 * @param order
	 *            订单信息
	 * @return 订单添加结果
	 * @throws PaymentStorageException 
	 */
	@Override
	public Boolean addPrepareOrder(Order order) throws PaymentStorageException {
		try {
			return paymentDao.addPrepareOrder(order);
		} catch (RuntimeException e) {
			throw new PaymentStorageException("添加订单时,发生数据持久化异常.", e);
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
	public Order getPrepareOrder(String orderNo) throws PaymentStorageException {
		try {
			return paymentDao.getPrepareOrder(orderNo);
		} catch (RuntimeException e) {
			throw new PaymentStorageException("读取订单时,发生数据持久化异常.", e);
		}

	}

	@Override
	public void setPrepareOrderResponse(PayResponse response) {

	}

	@Override
	public void addPayNotification(Notification notification) {

	}

	@Override
	public String getNextOrderNo() throws PaymentStorageException {
		try {
			return paymentDao.getNextOrderNo();
		} catch (RuntimeException e) {
			throw new PaymentStorageException("读取订单时,发生数据持久化异常.", e);
		}
	}

}
