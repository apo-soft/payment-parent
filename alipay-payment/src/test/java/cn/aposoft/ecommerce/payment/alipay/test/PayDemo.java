package cn.aposoft.ecommerce.payment.alipay.test;

import java.math.BigDecimal;

import cn.aposoft.ecommerce.payment.alipay.AliConfig;
import cn.aposoft.ecommerce.payment.alipay.AliEntityUtil;
import cn.aposoft.ecommerce.payment.alipay.AliHttpClientUtil;
import cn.aposoft.ecommerce.payment.alipay.AliPaymentService;
import cn.aposoft.ecommerce.payment.alipay.impl.AliPayResponse;
import cn.aposoft.ecommerce.payment.alipay.impl.AliPaymentServiceImpl;

public class PayDemo {
	AliConfig config;
	AliHttpClientUtil httpclient;
	AliEntityUtil entityUtil;

	/**
	 * 初始化所需参数
	 * 
	 * @param config
	 * @param httpclient
	 * @param entityUtil
	 */
	public PayDemo(AliConfig config, AliHttpClientUtil httpclient, AliEntityUtil entityUtil) {
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
	public AliPayResponse payTest() {
		AlipayRequest order = new AlipayRequest();
		this.setOrder(order);
		AliPaymentService ps = new AliPaymentServiceImpl(httpclient, entityUtil, config);
		AliPayResponse response = ps.preparePay(order);

		return response;
	}
}
