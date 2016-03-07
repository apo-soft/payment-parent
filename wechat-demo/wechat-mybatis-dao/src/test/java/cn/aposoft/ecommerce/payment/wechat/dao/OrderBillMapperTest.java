/**
 * 
 */
package cn.aposoft.ecommerce.payment.wechat.dao;

import java.math.BigDecimal;
import java.math.MathContext;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

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
	private OrderBillMapper orderBillDao;

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
			System.out.println("ignored.");
			return;
		}
		OrderBill record = createDemoOrderBill();
		orderBillDao.insert(record);

		Assert.assertTrue(true);
	}

	/**
	 * BigDecimal 操作验证
	 */
	@Test
	public void testBigDecimalScale() {
		OrderBill orderBill = createDemoOrderBill();
		//
		System.out.println(orderBill.getOrderAmount());
		System.out.println(orderBill.getOrderAmount().scale());
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
