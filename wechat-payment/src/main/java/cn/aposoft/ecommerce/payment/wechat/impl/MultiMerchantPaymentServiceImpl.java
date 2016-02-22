/**
 * 
 */
package cn.aposoft.ecommerce.payment.wechat.impl;

import cn.aposoft.ecommerce.payment.wechat.BasePaymentService;
import cn.aposoft.ecommerce.payment.wechat.CloseOrder;
import cn.aposoft.ecommerce.payment.wechat.DownloadBill;
import cn.aposoft.ecommerce.payment.wechat.MerchantConfigProvider;
import cn.aposoft.ecommerce.payment.wechat.MultiMerchantPaymentService;
import cn.aposoft.ecommerce.payment.wechat.Order;
import cn.aposoft.ecommerce.payment.wechat.OrderQuery;
import cn.aposoft.ecommerce.payment.wechat.Refund;
import cn.aposoft.ecommerce.payment.wechat.RefundQuery;

/**
 * 实现微信支付的多商户动态匹配的服务
 * 
 * @see MultiMerchantPaymentService
 * @author Jann Liu
 *
 */
public class MultiMerchantPaymentServiceImpl implements MultiMerchantPaymentService {

	private BasePaymentService paymentService = null;
	private MerchantConfigProvider provider = null;

	/**
	 * 
	 * @param paymentService
	 * @param provider
	 */
	public MultiMerchantPaymentServiceImpl(BasePaymentService paymentService, MerchantConfigProvider provider) {
		this.paymentService = paymentService;
		this.provider = provider;
	}

	/**
	 * 该方法必须在初始化时调用,否则后续操作会抛出NullPointerException
	 */
	@Override
	public synchronized void setMerchantConfigProvider(MerchantConfigProvider provider) {
		this.provider = provider;
	}

	protected synchronized MerchantConfigProvider getMerchantConfigProvider() {
		return this.provider;
	}

	@Override
	public PayResponse preparePay(Order order) {
		return paymentService.preparePay(order, provider.getConfig(order));
	}

	@Override
	public RefundResponse refund(Refund refund) {
		return paymentService.refund(refund, provider.getConfig(refund));
	}

	@Override
	public OrderQueryResponse query(OrderQuery params) {
		return paymentService.query(params, provider.getConfig(params));
	}

	@Override
	public CloseOrderResponse closeOrder(CloseOrder params) {
		return paymentService.closeOrder(params, provider.getConfig(params));
	}

	@Override
	public RefundQueryResponse refundQuery(RefundQuery params) {
		return paymentService.refundQuery(params, provider.getConfig(params));
	}

	@Override
	public DownloadBillResponse downloadBill(DownloadBill params) {
		return paymentService.downloadBill(params, provider.getConfig(params));
	}

}
