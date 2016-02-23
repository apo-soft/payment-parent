package cn.aposoft.ecommerce.payment.alipay.impl;

import java.util.Map;

import cn.aposoft.ecommerce.payment.alipay.AliConfig;
import cn.aposoft.ecommerce.payment.alipay.AliEntityUtil;
import cn.aposoft.ecommerce.payment.alipay.AliHttpClientUtil;
import cn.aposoft.ecommerce.payment.alipay.AliOrder;
import cn.aposoft.ecommerce.payment.alipay.AliPaymentService;
import cn.aposoft.ecommerce.payment.alipay.AliRefund;
import cn.aposoft.ecommerce.payment.alipay.util.MapUtil;

public class AliPaymentServiceImpl implements AliPaymentService {

	private AliHttpClientUtil httpclient;
	private AliEntityUtil entityUtil;
	private AliConfig config;

	public AliPaymentServiceImpl(AliHttpClientUtil httpclient, AliEntityUtil entityUtil, AliConfig config) {
		this.httpclient = httpclient;
		this.entityUtil = entityUtil;
		this.config = config;

	}

	/**
	 * 
	 * @see cn.aposoft.ecommerce.payment.alipay.AliPaymentService#preparePay(cn.aposoft.ecommerce.payment.alipay.AliOrder)
	 */
	@Override
	public AliPayResponse preparePay(AliOrder order) {

		Map<String, String> params = entityUtil.generatePayMap(order, config);
		params = MapUtil.createMapRequest(params, config);
		String resultXml = httpclient.post(params, config);
		return entityUtil.parsePayResponseXml(resultXml, config);
	}

	/**
	 * 退款接口付款完成的交易进行部分或全部的退还
	 * 
	 * @see cn.aposoft.ecommerce.payment.alipay.AliPaymentService#refund(cn.aposoft.ecommerce.payment.alipay.AliRefund)
	 */
	@Override
	public AliRefundResponse refund(AliRefund refund) {
		Map<String, String> params = entityUtil.generateRefundMap(refund, config);
		params = MapUtil.createMapRequest(params, config);
		String resultXml = httpclient.refund(params, config);
		return entityUtil.parseRefundResponseXml(resultXml, config);
	}

	/**
	 * 
	 * @see cn.aposoft.ecommerce.payment.alipay.AliPaymentService#prepareMap(java.util.Map)
	 * @deprecated
	 */
	@Override
	public Map<String, String> prepareMap(Map<String, String> params) {
		params = MapUtil.createMapRequest(params, config);
		String resultXml = httpclient.post(params, config);
		return entityUtil.parseMapXml(resultXml);

	}

}
