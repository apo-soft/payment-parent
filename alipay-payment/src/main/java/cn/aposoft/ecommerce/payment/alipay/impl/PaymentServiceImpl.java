package cn.aposoft.ecommerce.payment.alipay.impl;

import java.util.Map;

import cn.aposoft.ecommerce.payment.alipay.Config;
import cn.aposoft.ecommerce.payment.alipay.HttpClientUtil;
import cn.aposoft.ecommerce.payment.alipay.Order;
import cn.aposoft.ecommerce.payment.alipay.PaymentService;
import cn.aposoft.ecommerce.payment.alipay.Refund;
import cn.aposoft.ecommerce.payment.alipay.RefundResponse;
import cn.aposoft.ecommerce.payment.alipay.util.EntityUtil;
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
	 * @see cn.aposoft.ecommerce.payment.alipay.PaymentService#preparePay(cn.aposoft.ecommerce.payment.alipay.Order)
	 */
	@Override
	public PayResponse preparePay(Order order) {

		Map<String, String> params = entityUtil.generatePayMap(order, config);
		params = MapUtil.createMapRequest(params, config);
		String resultXml = httpclient.post(params, config);
		return entityUtil.parsePayResponseXml(resultXml);
	}

	/**
	 * 
	 * @see cn.aposoft.ecommerce.payment.alipay.PaymentService#prepareMap(java.util.Map)
	 * @deprecated
	 */
	@Override
	public Map<String, String> prepareMap(Map<String, String> params) {
		params = MapUtil.createMapRequest(params, config);
		String resultXml = httpclient.post(params, config);
		return entityUtil.parseMapXml(resultXml);

	}

	/**
	 * 即时到账接口付款完成的交易进行部分或全部的退还。商户需输入支付密码。
	 * 
	 * @see cn.aposoft.ecommerce.payment.alipay.PaymentService#refund(cn.aposoft.ecommerce.payment.alipay.Refund)
	 */
	@Override
	public RefundResponse refund(Refund refund) {
		Map<String, String> params = entityUtil.generateRefundMap(refund, config);
		params = MapUtil.createMapRequest(params, config);
		String resultXml = httpclient.refund(params, config);
		// return
		// entityUtil.parsePayResponseXml(resultXml);createRefundTransferMap
		return entityUtil.parseRefundResponseXml(resultXml);
	}

}
