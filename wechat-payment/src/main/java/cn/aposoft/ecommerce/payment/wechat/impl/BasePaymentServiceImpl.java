/**
 * 
 */
package cn.aposoft.ecommerce.payment.wechat.impl;

import java.io.Closeable;
import java.io.IOException;

import org.apache.log4j.Logger;

import cn.aposoft.ecommerce.payment.wechat.BasePaymentService;
import cn.aposoft.ecommerce.payment.wechat.CloseOrder;
import cn.aposoft.ecommerce.payment.wechat.CloseOrderResponse;
import cn.aposoft.ecommerce.payment.wechat.Config;
import cn.aposoft.ecommerce.payment.wechat.DownloadBill;
import cn.aposoft.ecommerce.payment.wechat.DownloadBillResponse;
import cn.aposoft.ecommerce.payment.wechat.EntityUtil;
import cn.aposoft.ecommerce.payment.wechat.HttpClientUtil;
import cn.aposoft.ecommerce.payment.wechat.Order;
import cn.aposoft.ecommerce.payment.wechat.OrderQuery;
import cn.aposoft.ecommerce.payment.wechat.OrderQueryResponse;
import cn.aposoft.ecommerce.payment.wechat.PayResponse;
import cn.aposoft.ecommerce.payment.wechat.Refund;
import cn.aposoft.ecommerce.payment.wechat.RefundQuery;
import cn.aposoft.ecommerce.payment.wechat.RefundQueryResponse;
import cn.aposoft.ecommerce.payment.wechat.RefundResponse;

/**
 * 实现订单支付访问的基础实现对象
 * 
 * @author Jann Liu
 *
 */
public class BasePaymentServiceImpl implements Closeable, BasePaymentService {

	private static final Logger logger = Logger.getLogger(PaymentServiceImpl.class);
	private EntityUtil entityUtil;
	private HttpClientUtil httpUtil;

	public BasePaymentServiceImpl(HttpClientUtil httpUtil, EntityUtil entityUtil) {
		this.entityUtil = entityUtil;
		this.httpUtil = httpUtil;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.aposoft.ecommerce.payment.wechat.impl.BasePaymentService#preparePay(cn
	 * .aposoft.ecommerce.payment.wechat.Order,
	 * cn.aposoft.ecommerce.payment.wechat.Config)
	 */
	@Override
	public PayResponse preparePay(Order order, Config config) {
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.aposoft.ecommerce.payment.wechat.impl.BasePaymentService#refund(cn.
	 * aposoft.ecommerce.payment.wechat.Refund,
	 * cn.aposoft.ecommerce.payment.wechat.Config)
	 */
	@Override
	public RefundResponse refund(Refund refund, Config config) {
		String request = entityUtil.generateRefundXml(refund, config);
		String responseText = "";
		try {
			responseText = httpUtil.keyCertPost(request, config, config.refundUrl());
			RefundResponse payRefundResponse = entityUtil.parseRefundResponseXml(responseText);
			return payRefundResponse;
		} catch (Exception e) {
			logger.error("发送退款请求时,发生错误:" + e.getMessage(), e);
			return null;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.aposoft.ecommerce.payment.wechat.impl.BasePaymentService#query(cn.
	 * aposoft.ecommerce.payment.wechat.OrderQuery,
	 * cn.aposoft.ecommerce.payment.wechat.Config)
	 */
	@Override
	public OrderQueryResponse query(OrderQuery params, Config config) {
		String request = entityUtil.generateOrderQueryXml(params, config);
		String responseText = "";
		try {
			responseText = httpUtil.post(request, config, config.orderQueryUrl());
			OrderQueryResponse orderQueryResponse = entityUtil.parseOrderQueryResponseXml(responseText);
			return orderQueryResponse;
		} catch (IOException e) {
			logger.error("订单查询时,发生错误:" + e.getMessage(), e);
			return null;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.aposoft.ecommerce.payment.wechat.impl.BasePaymentService#closeOrder(cn
	 * .aposoft.ecommerce.payment.wechat.CloseOrder,
	 * cn.aposoft.ecommerce.payment.wechat.Config)
	 */
	@Override
	public CloseOrderResponse closeOrder(CloseOrder params, Config config) {
		String request = entityUtil.generateCloseOrderXml(params, config);
		String responseText = "";
		try {
			responseText = httpUtil.post(request, config, config.orderQueryUrl());
			CloseOrderResponse closeOrderResponse = entityUtil.parseCloseOrderResponseXml(responseText);
			return closeOrderResponse;
		} catch (IOException e) {
			logger.error("订单查询时,发生错误:" + e.getMessage(), e);
			return null;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.aposoft.ecommerce.payment.wechat.impl.BasePaymentService#refundQuery(
	 * cn.aposoft.ecommerce.payment.wechat.RefundQuery,
	 * cn.aposoft.ecommerce.payment.wechat.Config)
	 */
	@Override
	public RefundQueryResponse refundQuery(RefundQuery params, Config config) {
		String request = entityUtil.generateRefundQueryXml(params, config);
		String responseText = "";
		try {
			responseText = httpUtil.post(request, config, config.refundQueryUrl());
			RefundQueryResponse refundQueryResponse = entityUtil.parseRefundQueryResponseXml(responseText);
			return refundQueryResponse;
		} catch (IOException e) {
			logger.error("订单查询时,发生错误:" + e.getMessage(), e);
			return null;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.aposoft.ecommerce.payment.wechat.impl.BasePaymentService#downloadBill(
	 * cn.aposoft.ecommerce.payment.wechat.DownloadBill,
	 * cn.aposoft.ecommerce.payment.wechat.Config)
	 */
	@Override
	public DownloadBillResponse downloadBill(DownloadBill params, Config config) {
		String request = entityUtil.generateDownloadBillXml(params, config);
		logger.debug(request);
		String responseText = "";
		try {
			responseText = httpUtil.post(request, config, config.downloadBillUrl());
			DownloadBillResponse refundQueryResponse = entityUtil.parseDownloadBillResponseXml(responseText);
			return refundQueryResponse;
		} catch (IOException e) {
			logger.error("订单查询时,发生错误:" + e.getMessage(), e);
			return null;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.aposoft.ecommerce.payment.wechat.impl.BasePaymentService#close()
	 */
	@Override
	public void close() throws IOException {
		httpUtil.close();
	}

}
