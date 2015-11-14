package cn.aposoft.ecommerce.payment.alipay.impl;

import java.util.Map;

import cn.aposoft.ecommerce.payment.alipay.HttpClientUtil;
import cn.aposoft.ecommerce.payment.alipay.Order;
import cn.aposoft.ecommerce.payment.alipay.inter.Config;
import cn.aposoft.ecommerce.payment.alipay.inter.EntityUtil;
import cn.aposoft.ecommerce.payment.alipay.inter.PaymentService;
import cn.aposoft.ecommerce.payment.alipay.util.MapUtil;

public class PaymentServiceImpl implements PaymentService {

	private HttpClientUtil httpclient;
	private EntityUtil entityUtil;
	private Config config;

	public PaymentServiceImpl(HttpClientUtil httpclient, EntityUtil entityUtil, Config config) {
		this.httpclient = httpclient;
		this.entityUtil = entityUtil;
		this.config = config;

	}

	/**
	 * 
	 * @see cn.aposoft.ecommerce.payment.alipay.inter.PaymentService#preparePay(cn.aposoft.ecommerce.payment.alipay.Order)
	 */
	@Override
	public PayResponse preparePay(Order order) {

		Map<String, String> params = entityUtil.generatePayMap(order);
		params = MapUtil.createMapRequest(params, config);
		String resultXml = httpclient.post(params, config);
		return entityUtil.parsePayResponseXml(resultXml);
	}

	/**
	 * 
	 * @see cn.aposoft.ecommerce.payment.alipay.inter.PaymentService#prepareMap(java.util.Map)
	 * @deprecated
	 */
	@Override
	public Map<String, String> prepareMap(Map<String, String> params) {
		params = MapUtil.createMapRequest(params, config);
		String resultXml = httpclient.post(params, config);
		return entityUtil.parseMapXml(resultXml);

	}

}
