/**
 * 
 */
package cn.aposoft.ecommerce.payment.wechat.impl;

import java.io.IOException;

import org.apache.log4j.Logger;

import cn.aposoft.ecommerce.payment.wechat.CloseOrder;
import cn.aposoft.ecommerce.payment.wechat.CloseOrderResponse;
import cn.aposoft.ecommerce.payment.wechat.Config;
import cn.aposoft.ecommerce.payment.wechat.Order;
import cn.aposoft.ecommerce.payment.wechat.OrderQuery;
import cn.aposoft.ecommerce.payment.wechat.OrderQueryResponse;
import cn.aposoft.ecommerce.payment.wechat.PayResponse;
import cn.aposoft.ecommerce.payment.wechat.PaymentService;
import cn.aposoft.ecommerce.payment.wechat.Refund;
import cn.aposoft.ecommerce.payment.wechat.RefundQuery;
import cn.aposoft.ecommerce.payment.wechat.RefundQueryResponse;
import cn.aposoft.ecommerce.payment.wechat.RefundResponse;
import cn.aposoft.ecommerce.payment.wechat.util.EntityUtil;
import cn.aposoft.ecommerce.payment.wechat.util.HttpClientUtil;

/**
 * 支付服务业务实现类
 * <ul>
 * <li>{@code preparePay} 实现微信支付的统一下单接口封装</li>
 * <li>{@code refund} 实现微信支付的申请退款接口</li>
 * <li>{@code query} 实现微信支付的订单查询接口</li>
 * <li>{@code closeOrder} 实现微信支付的关闭订单接口</li>
 * </ul>
 * 
 * @author LiuJian
 *
 */
public class PaymentServiceImpl implements PaymentService {
	private static final Logger logger = Logger.getLogger(PaymentServiceImpl.class);
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
	 * <p>
	 * 不需要证书
	 * 
	 * @see cn.aposoft.ecommerce.payment.wechat.PaymentService#prepareOrderPayRequest
	 *      (cn.aposoft.ecommerce.payment.wechat.Order)
	 */
	@Override
	public PayResponse preparePay(Order order) {
		String request = entityUtil.generatePayXml(order, config);
		String responseText;
		try {
			responseText = httpUtil.post(request, config, config.url());
			PayResponse payResponse = entityUtil.parsePayResponseXml(responseText);
			return payResponse;
		} catch (IOException e) {
			logger.error("订单支付时,发生错误:" + e.getMessage(), e);
			return null;
		}
	}

	/**
	 * 生成退款信息并发送请求到微信退款服务器
	 * <p>
	 * 需要双向认证证书
	 * 
	 * @param refund
	 * @return
	 * @author Yujinshui
	 */
	@Override
	public RefundResponse refund(Refund refund) {
		String request = entityUtil.generateRefundXml(refund, config);
		String responseText = "";
		try {
			responseText = httpUtil.refundPost(request, config, config.refundUrl());
		} catch (Exception e) {
			logger.error("发送退款请求时,发生错误:" + e.getMessage(), e);
		}
		RefundResponse payRefundResponse = entityUtil.parseRefundResponseXml(responseText);
		return payRefundResponse;
	}

	/**
	 * <p>
	 * 不需要证书
	 * 
	 * @see cn.aposoft.ecommerce.payment.wechat.PaymentService#query(cn.aposoft.ecommerce.payment.wechat.OrderQuery)
	 */
	@Override
	public OrderQueryResponse query(OrderQuery params) {
		String request = entityUtil.generateOrderQueryXml(params, config);
		String responseText = "";
		try {
			responseText = httpUtil.post(request, config, config.orderUrl());
		} catch (IOException e) {
			logger.error("订单查询时,发生错误:" + e.getMessage(), e);
		}
		OrderQueryResponse orderQueryResponse = entityUtil.parseOrderQueryResponseXml(responseText);
		return orderQueryResponse;
	}

	/**
	 * 关闭订单请求的实现
	 * {@link https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=9_3}
	 * 
	 * 接口链接：https://api.mch.weixin.qq.com/pay/closeorder
	 * <p>
	 * 不需要证书
	 * 
	 * @see cn.aposoft.ecommerce.payment.wechat.PaymentService#closeOrder(CloseOrder
	 *      params)
	 */
	@Override
	public CloseOrderResponse closeOrder(CloseOrder params) {
		String request = entityUtil.generateCloseOrderXml(params, config);
		String responseText = "";
		try {
			responseText = httpUtil.post(request, config, config.orderUrl());
		} catch (IOException e) {
			logger.error("订单查询时,发生错误:" + e.getMessage(), e);
		}
		CloseOrderResponse closeOrderResponse = entityUtil.parseCloseOrderResponseXml(responseText);
		return closeOrderResponse;
	}

	/**
	 * 退款查询服务接口:
	 * {@link https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=9_5}
	 * <p>
	 * 接口地址: https://api.mch.weixin.qq.com/pay/refundquery
	 * <p>
	 * 不需要证书
	 */
	@Override
	public RefundQueryResponse refundQuery(RefundQuery params) {
		String request = entityUtil.generateRefundQueryXml(params, config);
		String responseText = "";
		try {
			responseText = httpUtil.post(request, config, config.orderUrl());
		} catch (IOException e) {
			logger.error("订单查询时,发生错误:" + e.getMessage(), e);
		}
		RefundQueryResponse refundQueryResponse = entityUtil.parseRefundQueryResponseXml(responseText);
		return refundQueryResponse;
	}

}
