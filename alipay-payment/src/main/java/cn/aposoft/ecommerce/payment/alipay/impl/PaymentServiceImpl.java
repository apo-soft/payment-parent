package cn.aposoft.ecommerce.payment.alipay.impl;

import java.util.Map;

import cn.aposoft.ecommerce.payment.alipay.HttpClientUtil;
import cn.aposoft.ecommerce.payment.alipay.Order;
import cn.aposoft.ecommerce.payment.alipay.inter.Config;
import cn.aposoft.ecommerce.payment.alipay.inter.EntityUtil;
import cn.aposoft.ecommerce.payment.alipay.inter.PaymentService;

public class PaymentServiceImpl implements PaymentService {

	private HttpClientUtil httpclient;
	private EntityUtil entityUtil;
	private Config config;

	public PaymentServiceImpl(HttpClientUtil httpclient, EntityUtil entityUtil, Config config) {
		this.httpclient = httpclient;
		this.entityUtil = entityUtil;
		this.config = config;

	}

	@Override
	public PayResponse preparePay(Order order) {
		
		
		Map<String, String> params = entityUtil.generatePayMap(order);
		String resultXml = httpclient.post(params, config);
		return entityUtil.parsePayResponseXml(resultXml);
	}

	@Override
	public Map<String, String> prepareMap(Map<String, String> params) {
		String resultXml = httpclient.post(params, config);
		return entityUtil.parseMapXml(resultXml);

	}

}
