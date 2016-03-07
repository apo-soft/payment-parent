/**
 * 
 */
package cn.aposoft.ecommerce.payment.wechat.dao;

import java.math.BigDecimal;
import java.math.MathContext;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.aposoft.ecommerce.payment.wechat.bean.OrderBill;
import cn.aposoft.ecommerce.payment.wechat.bean.OrderBillExample;
import cn.aposoft.ecommerce.payment.wechat.bean.OrderBillExample.Criteria;

/**
 * OrderBill测试类
 * 
 * @author Jann Liu
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-mybatis-config.xml" })
public class OrderBillMapperTest {
	private boolean tested = false;

	private boolean execute = false;
	@Autowired
	private DataSource dataSource;

	@Autowired
	private OrderBillMapper orderBillMapper;

	@Before
	public void init() {
		if (tested) {
			return;
		}
		System.out.println("initialize: test DataSource.");
		if (dataSource != null) {
			try (Connection conn = dataSource.getConnection();) {
				System.out.println("get connection successful.");
				execute = true;
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
				execute = false;
			}
		}
		System.out.println("ignore:" + execute);
		tested = true;
	}

	/**
	 * 验证CreateOrderBill成功
	 */
	@Test
	public void testCreateOrderBill() {
		// 验证测试用例是否可以有效执行
		Assume.assumeTrue(execute);
		if (!execute) {
			return;
		}
		OrderBill record = createDemoOrderBill();
		orderBillMapper.insertSelective(record);

		Assert.assertTrue(true);
	}

	/**
	 * 测试根据id读取订单
	 */
	@Test
	public void testGetOrderById() {
		// 验证测试用例是否可以有效执行
		Assume.assumeTrue(execute);
		if (!execute) {
			return;
		}
		final BigDecimal d001 = new BigDecimal("0.01");
		OrderBill orderBill = getDemoOrderBill(1);
		Assert.assertNotNull(orderBill);
		Assert.assertEquals(1, orderBill.getOrderId().intValue());
		Assert.assertEquals("1123", orderBill.getOrderNo());
		Assert.assertEquals("test bill", orderBill.getOrderDesc());
		Assert.assertEquals(d001, orderBill.getOrderAmount());
		Assert.assertEquals(d001, orderBill.getOrderPaidAmount());
		Assert.assertEquals(0, orderBill.getOrderState().intValue());
	}

	/**
	 * 查询示例订单信息
	 * 
	 * @return 示例订单信息
	 */
	OrderBill getDemoOrderBill(int orderId) {
		OrderBillExample example = new OrderBillExample();

		Criteria criteria = example.createCriteria();
		criteria.andOrderIdEqualTo(orderId);
		List<OrderBill> orderBills = orderBillMapper.selectByExample(example);
		if (orderBills != null && !orderBills.isEmpty()) {
			return orderBills.get(0);
		} else {
			return null;
		}
	}

	/**
	 * 验证UpdateOrderBill成功 updateTime 修改成功
	 */
	@Test
	public void testUpdateOrderBill() {
		// 验证测试用例是否可以有效执行
		Assume.assumeTrue(execute);
		if (!execute) {
			System.out.println("ignored.");
			return;
		}
		OrderBill record = getDemoOrderBill(11);
		record.setUpdateTime(new Date());

		OrderBillExample example = new OrderBillExample();
		example.createCriteria().andOrderIdEqualTo(record.getOrderId());
		orderBillMapper.updateByExampleSelective(record, example);
		Assert.assertTrue(true);
	}

	/**
	 * 验证GetBill成功
	 */
	public OrderBill createDemoOrderBill() {
		Date date = new Date();
		OrderBill record = new OrderBill();
		long curr = System.currentTimeMillis();
		record.setOrderNo(String.valueOf(curr));
		record.setOrderDesc("iPhone 7 preview");
		record.setOrderAmount(new BigDecimal("0.01", MathContext.DECIMAL128));
		record.setOrderPaidAmount(new BigDecimal("0.01", MathContext.DECIMAL128));
		record.setOrderState(OrderBill.OrderBillState.CREATED);
		record.setClosedTime(null);
		record.setCreateTime(date);
		record.setUpdateTime(date);

		return record;
	}

}
