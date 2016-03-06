/**
 * 
 */
package cn.aposoft.ecommerce.payment.wechat.dao.impl;

import java.io.UnsupportedEncodingException;

import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import cn.aposoft.ecommerce.payment.wechat.Notification;
import cn.aposoft.ecommerce.payment.wechat.Order;
import cn.aposoft.ecommerce.payment.wechat.PayResponse;
import cn.aposoft.ecommerce.payment.wechat.dao.PaymentDao;
import cn.aposoft.ecommerce.payment.wechat.dao.commonDao.impl.RedisDao;
import cn.aposoft.ecommerce.payment.wechat.util.WechatStringUtil;

/**
 * Jedis实现的持久化支付数据的数据访问器
 * 
 * @author Jann Liu
 *
 */
@Repository("paymentDao")
public class JedisPaymentDao extends RedisDao<Order> implements PaymentDao {

	private final static String ORDER_NO_NEXT_SEQ_KEY = "wechat_order_no:next_seq";
	private final static String ORDER_PREFIX = "wechat_order_no:order:";
	private final static String ORDER_RESP_PREFIX = "wechat_order_no:resp:";
	private final static String ORDER_PAY_NOTIFICATION_PREFIX = "wechat_order_no:notify:";
	/*private RedisTemplate<String, Serializable> redisTemplate;

	private ValueOperations<String, Serializable> simpleOps;

	public JedisPaymentDao(RedisTemplate<String, Serializable> template) {
		this.redisTemplate = template;
		simpleOps = redisTemplate.opsForValue();
	}*/

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
		return redisTemplate.opsForValue().setIfAbsent(ORDER_PREFIX + order.getOut_trade_no(), order);
	}

	@Override
	public Order getPrepareOrder(String orderNo) {
		if (StringUtils.isEmpty(orderNo)) {
			throw new IllegalArgumentException("orderNo must not be empty.");
		}
		return (Order) redisTemplate.opsForValue().get(ORDER_PREFIX + orderNo);
	}

	@Override
	public void setPrepareOrderResponse(String orderNo, PayResponse response) {
		if (StringUtils.isEmpty(orderNo)) {
			throw new IllegalArgumentException("orderNo must not be empty.");
		}
		if (response == null) {
			throw new IllegalArgumentException("response must not be null.");
		}
		redisTemplate.opsForValue().setIfAbsent(ORDER_RESP_PREFIX + orderNo, response);
	}

	@Override
	public void setPayNotification(Notification notification) {
		redisTemplate.opsForValue().setIfAbsent(ORDER_PAY_NOTIFICATION_PREFIX + notification.getOut_trade_no(), notification);
	}

	@Override
	public String getNextOrderNo() {
		RedisConnection conn = redisTemplate.getConnectionFactory().getConnection();
		byte[] keyBytes = getTextUtf8Bytes(ORDER_NO_NEXT_SEQ_KEY);
		return WechatStringUtil.toString(conn.incr(keyBytes));
	}

	@Override
	public Boolean setInitOrderNo(long num) {
		RedisConnection conn = redisTemplate.getConnectionFactory().getConnection();
		byte[] keyBytes = getTextUtf8Bytes(ORDER_NO_NEXT_SEQ_KEY);

		return conn.setNX(keyBytes, getTextUtf8Bytes(String.valueOf(num)));
	}

	public final static byte[] getTextUtf8Bytes(String string) {
		try {
			return string.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("This shouldn't happen.", e);
		}
	}
}
