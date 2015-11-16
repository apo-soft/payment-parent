package cn.aposoft.ecommerce.payment.alipay.test;

import java.math.BigDecimal;

import cn.aposoft.ecommerce.payment.alipay.Config;
import cn.aposoft.ecommerce.payment.alipay.HttpClientUtil;
import cn.aposoft.ecommerce.payment.alipay.PaymentService;
import cn.aposoft.ecommerce.payment.alipay.RefundResponse;
import cn.aposoft.ecommerce.payment.alipay.impl.PaymentServiceImpl;
import cn.aposoft.ecommerce.payment.alipay.util.DateUtil;
import cn.aposoft.ecommerce.payment.alipay.util.EntityUtil;

/**
 * 退款数据信息
 * 
 * @author Yujinshui
 *
 */
public class RefundDemo {
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
	public RefundDemo(Config config, HttpClientUtil httpclient, EntityUtil entityUtil) {
		this.config = config;
		this.httpclient = httpclient;
		this.entityUtil = entityUtil;

	}

	public String refundTest() {
		RefundVo fund = setValue();
		PaymentService ps = new PaymentServiceImpl(httpclient, entityUtil, config);
		RefundResponse response = ps.refund(fund);
		System.out.println(response.getResult());
		return null;
	}

	/**
	 * 赋值测试数据
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月16日 上午11:21:05
	 */
	private RefundVo setValue() {
		RefundVo fund = new RefundVo();
		fund.setService("alipay.acquire.refund");
		fund.setPartner(config.pid());
		fund.set_input_charset(config.charset());
		fund.setSign_type(config.sign_type());
		fund.setOut_trade_no("F6D8D840890B11E59840FC1C7E19F601");
		BigDecimal b = new BigDecimal(0.1);
		fund.setRefund_amount(b);

		return fund;
	}
}
