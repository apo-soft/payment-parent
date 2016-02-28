/**
 * 
 */
package cn.aposoft.ecommerce.payment.wechat.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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
			String orderNo = order.getOut_trade_no();
			Order order1 = paymentDao.getPrepareOrder(orderNo);
			// Assume.assumeTrue(order1 == null);
			if (order1 == null) {
				Boolean b = paymentDao.addPrepareOrder(order);
				assertTrue(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testAddOrder2() {
		try {
			Order order = createOrder("345678");
			String orderNo = order.getOut_trade_no();
			Order order1 = paymentDao.getPrepareOrder(orderNo);
			// Assume.assumeTrue(order1 == null);
			if (order1 == null) {
				Boolean b = paymentDao.addPrepareOrder(order);
				assertTrue(b);
			}
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

	@Test
	public void testGetOrder345678() {
		try {
			Order order = paymentDao.getPrepareOrder("345678");
			assertNotNull(order);
			assertEquals("345678", order.getOut_trade_no());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetOrder10000Times() {
		try {
			long begin = System.currentTimeMillis();
			for (int i = 0; i < 10000; i++) {
				String orderNo = i % 2 == 0 ? "123456" : "345678";
				Order order = paymentDao.getPrepareOrder(orderNo);
				assertNotNull(order);
				assertEquals(orderNo, order.getOut_trade_no());
			}
			long end = System.currentTimeMillis();
			System.out.println("Elapse:" + (end - begin) + ",Begin:" + begin + ",End:" + end);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 这种设置方式写入的是序列化的object,无法实际作为incr的对象
	 */
	@Test
	public void testGetNextOrderNo() {
		try {
			String result = paymentDao.getNextOrderNo();
			System.out.println(result);
			assertNotNull(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Order createOrder(String string) {
		OrderVo order = new OrderVo();
		order.setOut_trade_no(string);
		order.setBody("Iphone 7 玫瑰金订单");
		return order;
	}

	/**
	 * 
	 * @return
	 */
	private Order createOrder() {
		return createOrder("123456");

	}

}
