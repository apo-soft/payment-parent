package cn.aposoft.ecommerce.payment.alipay.test;

import java.math.BigDecimal;

import cn.aposoft.ecommerce.payment.alipay.Config;
import cn.aposoft.ecommerce.payment.alipay.HttpClientUtil;
import cn.aposoft.ecommerce.payment.alipay.PaymentService;
import cn.aposoft.ecommerce.payment.alipay.impl.PayResponse;
import cn.aposoft.ecommerce.payment.alipay.impl.PaymentServiceImpl;
import cn.aposoft.ecommerce.payment.alipay.util.EntityUtil;

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
	private void setOrder(InstantCountRequest order) {
		order.setService("alipay.acquire.precreate");// 目前属于固定参数，api无相关说明
		order.setPartner(config.pid());//
		order.set_input_charset(config.charset());//
		// order.setSign_type("MD5");
		order.setOut_trade_no("F6D8D840890B11E59840FC1C7E19F60_1");
		order.setSubject("测试商品");//
		// order.setPayment_type("1");
		order.setTotal_fee(BigDecimal.valueOf(0.01));
		// 以下参数三选一
		order.setSeller_id(config.pid());
		// order.setSeller_email(seller_email);
		// order.setSeller_account_name(seller_account_name);
		// order.setQr_pay_mode(config.qr_pay_mode());
	}

	/**
	 * 支付测试
	 * 
	 * @author Yujinshui
	 * @time 2015年11月12日 上午10:26:23
	 */
	public PayResponse payTest() {
		InstantCountRequest order = new InstantCountRequest();
		this.setOrder(order);

		// Map<String, String> params = new HashMap<String, String>();
		// this.convertOrder2Map(params, order);
		// System.out.println(params);

		PaymentService ps = new PaymentServiceImpl(httpclient, entityUtil, config);
		// Map<String, String> result = ps.prepareMap(params);
		PayResponse response = ps.preparePay(order);

		return response;
	}
}
