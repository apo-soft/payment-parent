/**
 * 
 */
package cn.aposoft.ecommerce.payment.wechat.impl;

import cn.aposoft.ecommerce.payment.wechat.Config;
import cn.aposoft.ecommerce.payment.wechat.Order;
import cn.aposoft.ecommerce.payment.wechat.PayResponse;
import cn.aposoft.ecommerce.payment.wechat.PaymentService;
import cn.aposoft.ecommerce.payment.wechat.Refund;
import cn.aposoft.ecommerce.payment.wechat.RefundResponse;
import cn.aposoft.ecommerce.payment.wechat.util.EntityUtil;
import cn.aposoft.ecommerce.payment.wechat.util.HttpClientUtil;

/**
 * @author LiuJian
 *
 */
public class PaymentServiceImpl implements PaymentService {

	private Config config;

	private EntityUtil entityUtil;
	private HttpClientUtil httpUtil;

	public PaymentServiceImpl(Config config, HttpClientUtil httpUtil, EntityUtil entityUtil) {
		this.config = config;
		this.entityUtil = entityUtil;
		this.httpUtil = httpUtil;
	}

	/**
	 * 实现支付订单的发送及返回值的返回
	 * 
	 * @see cn.aposoft.ecommerce.payment.wechat.PaymentService#prepareOrderPayRequest
	 *      (cn.aposoft.ecommerce.payment.wechat.Order)
	 */
	@Override
	public PayResponse preparePay(Order order) {
		String request = entityUtil.generatePayXml(order, config);
		String responseText = httpUtil.post(request, config, config.url());
		PayResponse payResponse = entityUtil.parsePayResponseXml(responseText);
		return payResponse;
	}

	/**
	 * 生成退款信息并发送请求到微信退款服务器
	 * 
	 * @param refund
	 * @return
	 * @author Yujinshui
	 */
	@Override
	public RefundResponse refund(Refund refund) {
		String request = entityUtil.generatePayRefundXml(refund, config);
		String responseText = "";
		try {
			responseText = httpUtil.refundPost(request, config, config.refundUrl());
		} catch (Exception e) {
			e.printStackTrace();
		}
		RefundResponse payRefundResponse = entityUtil.parsePayRefundResponseXml(responseText);
		return payRefundResponse;
	}

}
