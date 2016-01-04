package cn.aposoft.ecommerce.payment.alipay.test;

import java.math.BigDecimal;

import cn.aposoft.ecommerce.payment.alipay.Config;
import cn.aposoft.ecommerce.payment.alipay.EntityUtil;
import cn.aposoft.ecommerce.payment.alipay.HttpClientUtil;
import cn.aposoft.ecommerce.payment.alipay.PaymentService;
import cn.aposoft.ecommerce.payment.alipay.impl.PayResponse;
import cn.aposoft.ecommerce.payment.alipay.impl.PaymentServiceImpl;

public class PayDemo {
	Config config;
	HttpClientUtil httpclient;
	EntityUtil entityUtil;

	/**
	 * 初始化所需参数
	 * 
	 * @param config
	 * @param httpclient
	 * @param entityUtil
	 */
	public PayDemo(Config config, HttpClientUtil httpclient, EntityUtil entityUtil) {
		this.config = config;
		this.httpclient = httpclient;
		this.entityUtil = entityUtil;

	}

	/**
	 * 订单参数设置
	 * 
	 * @param order
	 * @author Yujinshui
	 * @time 2015年11月12日 上午10:44:28
	 */
	private void setOrder(AlipayRequest order) {
		// 二维码请求：alipay.acquire.precreate
		order.setService("alipay.acquire.precreate");
		order.setOut_trade_no("20160104_1");
		order.setSubject("标题20160104_1");//
		order.setTotal_fee(BigDecimal.valueOf(1.0/100));
		// 以下参数三选一
//		order.setSeller_id(config.pid());
		order.setProduct_code(config.qr_code_product());
		order.setNotify_url("http://yangxinxin-163.6655.la:16834/count/ali/paySuccess");
	}

	/**
	 * 支付测试
	 * 
	 * @author Yujinshui
	 * @time 2015年11月12日 上午10:26:23
	 */
	public PayResponse payTest() {
		AlipayRequest order = new AlipayRequest();
		this.setOrder(order);
		PaymentService ps = new PaymentServiceImpl(httpclient, entityUtil, config);
		PayResponse response = ps.preparePay(order);

		return response;
	}
}
