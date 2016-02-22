package cn.aposoft.ecommerce.payment.wechat.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import cn.aposoft.ecommerce.payment.wechat.Config;
import cn.aposoft.ecommerce.payment.wechat.OrderQuery;
import cn.aposoft.ecommerce.payment.wechat.OrderQueryVo;
import cn.aposoft.ecommerce.payment.wechat.OrderVo;
import cn.aposoft.ecommerce.payment.wechat.Refund;
import cn.aposoft.ecommerce.payment.wechat.RefundQuery;
import cn.aposoft.ecommerce.payment.wechat.RefundQueryVo;
import cn.aposoft.ecommerce.payment.wechat.RefundVo;

/**
 * 反射实现的EntityUtil的Test
 * 
 * @author Jann Liu
 *
 */
public class ReflectionEntityUtilCompareTest {
	private static Config config = new PropertiesConfig("E:/environments/pay/wechat/wechatpay.properties", "utf-8");
	private static int i = 1;

	public static OrderVo createPaymentRequestOrder(Config config) {
		i++;
		OrderVo order = new OrderVo();
		order.setBody("iPhone 6s Plus 16GB 金色");
		order.setGoods_tag("no");
		order.setOut_trade_no("20160113_" + i);// 只要未支付，即可继续重复使用该单号
		order.setSpbill_create_ip("127.0.0.1");
		order.setTrade_type("NATIVE");
		order.setTotal_fee(100);
		return order;
	}

	/**
	 * 退款查询请求对象一致性对比
	 */
	@Test
	public void assertPayRequestXmlEquals() {
		OrderVo order = createPaymentRequestOrder(config);
		SimpleEntityUtil utl1 = (SimpleEntityUtil) SimpleEntityUtil.getInstance();
		ReflectEntityUtil utl2 = new ReflectEntityUtil();
		PayRequest request = utl1.createPayRequest(order, config);
		String xml1 = utl1.generatePayXml(request);
		String xml2 = utl2.generatePayXml(request);
		assertEquals(xml1, xml2);
	}

	/**
	 * 确认退款查询的请求xml与原来一致
	 */
	@Test
	public void assertRefundQueryRequestXmlEquals() {
		RefundQuery bean = RefundQueryVo.demo();
		SimpleEntityUtil utl1 = (SimpleEntityUtil) SimpleEntityUtil.getInstance();
		ReflectEntityUtil utl2 = new ReflectEntityUtil();
		RefundQueryRequest req = utl1.createRefundQueryRequest(bean, config);
		String xml1 = utl1.createRefundQueryRequestXml(req);
		String xml2 = utl2.createRefundQueryRequestXml(req);
		assertEquals(xml1, xml2);

	}

	/**
	 * 确认退款查询的请求xml与原来一致
	 */
	@Test
	public void assertRefundRequestXmlEquals() {
		Refund refund = RefundVo.demo();
		SimpleEntityUtil utl1 = (SimpleEntityUtil) SimpleEntityUtil.getInstance();
		ReflectEntityUtil utl2 = new ReflectEntityUtil();
		RefundRequest request = utl1.createRefundRequest(refund, config);
		String xml1 = utl1.generateRefundXml(request);
		String xml2 = utl2.generateRefundXml(request);
		assertEquals(xml1, xml2);
	}

	/**
	 * 确认退款查询的请求xml与原来一致
	 */
	@Test
	public void assertOrderQueryRequestXmlEquals() {
		OrderQuery demo1 = OrderQueryVo.demo1();
		SimpleEntityUtil utl1 = (SimpleEntityUtil) SimpleEntityUtil.getInstance();
		ReflectEntityUtil utl2 = new ReflectEntityUtil();
		OrderQueryRequest request = utl1.createOrderQueryRequest(demo1, config);
		String xml1 = utl1.generateOrderQueryXml(request);
		String xml2 = utl2.generateOrderQueryXml(request);
		assertEquals(xml1, xml2);
		OrderQuery demo2 = OrderQueryVo.demo2();
		OrderQueryRequest request2 = utl1.createOrderQueryRequest(demo2, config);
		String xml21 = utl1.generateOrderQueryXml(request2);
		String xml22 = utl2.generateOrderQueryXml(request2);
		assertEquals(xml21, xml22);
	}
	
	
	

	public static void main(String[] args) {
		ReflectionEntityUtilCompareTest test = new ReflectionEntityUtilCompareTest();
		test.assertPayRequestXmlEquals();
		test.assertRefundQueryRequestXmlEquals();
		test.assertRefundRequestXmlEquals();
		test.assertOrderQueryRequestXmlEquals();
	}
}
