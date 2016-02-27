/**
 * 
 */
package cn.aposoft.ecommerce.payment.wechat.dao.impl;

import java.io.Serializable;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.util.StringUtils;

import cn.aposoft.ecommerce.payment.wechat.Notification;
import cn.aposoft.ecommerce.payment.wechat.Order;
import cn.aposoft.ecommerce.payment.wechat.PayResponse;
import cn.aposoft.ecommerce.payment.wechat.dao.PaymentDao;

/**
 * Jedis实现的持久化支付数据的数据访问器
 * 
 * @author Jann Liu
 *
 */
public class JedisPaymentDao implements PaymentDao {

	private final static String ORDER_PREFIX = "wechat_order_no:";
	private final static String ORDER_RESP_PREFIX = "wechat_order-resp_no:";
	private final static String ORDER_PAY_NOTIFICATION_PREFIX = "";
	private RedisTemplate<String, Serializable> redisTemplate;

	private ValueOperations<String, Serializable> simpleOps;

	public JedisPaymentDao(RedisTemplate<String, Serializable> template) {
		this.redisTemplate = template;
		simpleOps = redisTemplate.opsForValue();
	}

	/**
	 * 
	 * 
	 * @param order
	 *            订单
	 */
	@Override
	public Boolean addPrepareOrder(Order order) {
		if (order == null) {
			throw new IllegalArgumentException("order must not be null.");
		}
		return simpleOps.setIfAbsent(ORDER_PREFIX + order.getOut_trade_no(), order);
	}

	@Override
	public Order getPrepareOrder(String orderNo) {
		if (StringUtils.isEmpty(orderNo)) {
			throw new IllegalArgumentException("orderNo must not be empty.");
		}
		return (Order) simpleOps.get(ORDER_PREFIX + orderNo);
	}

	@Override
	public void setPrepareOrderResponse(String orderNo, PayResponse response) {
		if (StringUtils.isEmpty(orderNo)) {
			throw new IllegalArgumentException("orderNo must not be empty.");
		}
		if (response == null) {
			throw new IllegalArgumentException("response must not be null.");
		}
		simpleOps.setIfAbsent(ORDER_RESP_PREFIX + orderNo, response);
	}

	@Override
	public void setPayNotification(Notification notification) {
		simpleOps.setIfAbsent(ORDER_PAY_NOTIFICATION_PREFIX + notification.getOut_trade_no(), notification);
	}

}
