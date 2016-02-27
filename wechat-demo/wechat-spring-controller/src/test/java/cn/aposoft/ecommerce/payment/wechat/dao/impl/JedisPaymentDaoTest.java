/**
 * 
 */
package cn.aposoft.ecommerce.payment.wechat.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.aposoft.ecommerce.payment.wechat.Order;
import cn.aposoft.ecommerce.payment.wechat.bean.OrderVo;
import cn.aposoft.ecommerce.payment.wechat.dao.PaymentDao;

/**
 * @author Jann Liu
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-config.xml")
public class JedisPaymentDaoTest {

	@Autowired
	private PaymentDao paymentDao;

	@Test
	public void testAddOrder() {
		try {
			Order order = createOrder();
			paymentDao.addPrepareOrder(order);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetOrder() {
		try {
			Order order = paymentDao.getPrepareOrder("123456");
			assertNotNull(order);
			assertEquals("123456", order.getOut_trade_no());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Order createOrder() {
		OrderVo order = new OrderVo();
		order.setOut_trade_no("123456");

		return order;
	}

}
