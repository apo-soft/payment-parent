/**
 * 
 */
package cn.aposoft.ecommerce.payment.wechat.impl;

import cn.aposoft.ecommerce.payment.wechat.CloseOrder;
import cn.aposoft.ecommerce.payment.wechat.Config;
import cn.aposoft.ecommerce.payment.wechat.DownloadBill;
import cn.aposoft.ecommerce.payment.wechat.EntityUtil;
import cn.aposoft.ecommerce.payment.wechat.Order;
import cn.aposoft.ecommerce.payment.wechat.OrderQuery;
import cn.aposoft.ecommerce.payment.wechat.Refund;
import cn.aposoft.ecommerce.payment.wechat.RefundQuery;

/**
 * @author Jann Liu
 *
 */
public abstract class AbstractEntityUtil implements EntityUtil {

	/**
	 * 用于检查config的信息载入是否正确
	 * 
	 * @param config
	 *            待检测的配置信息
	 * @throws IllegalArgumentException
	 *             当config参数不正确时,抛出此异常
	 */
	private void checkConfig(Config config) {
		if (config == null) {
			throw new IllegalArgumentException("支付配置信息不能为NULL.");
		}

		if (config.appId() == null || config.appId().isEmpty()) {
			throw new IllegalArgumentException("商户配置信息的app_id不能为空.");
		}

		if (config.mchId() == null || config.mchId().isEmpty()) {
			throw new IllegalArgumentException("商户配置信息的mch_id不能为空.");
		}

		if (config.key() == null || config.key().isEmpty()) {
			throw new IllegalArgumentException("商户配置信息的key不能为空.");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.aposoft.ecommerce.payment.wechat.EntityUtil#generatePayXml(cn.aposoft.
	 * ecommerce.payment.wechat.Order,
	 * cn.aposoft.ecommerce.payment.wechat.Config)
	 */
	@Override
	public String generatePayXml(Order order, Config config) {
		checkConfig(config);
		PayRequest values = null;
		values = createPayRequest(order, config);
		return generatePayXml(values);
	}

	/**
	 * 由具体的继承类实现,从bean到微信定义的xml格式的转换
	 * 
	 * @param values
	 * 
	 * @return
	 */
	protected abstract String generatePayXml(PayRequest values);

	protected abstract String createPaySign(PayRequest payRequest, String key);

	/**
	 * 根据Order和config生成PayRequest
	 * 
	 * @param order
	 *            用于支付的订单信息
	 * @param config
	 *            商户配置信息
	 * @return 创建的用于订单支付的完整请求对象
	 */
	public PayRequest createPayRequest(Order order, Config config) {
		PayRequest payRequest = new PayRequest();

		payRequest.setAppid(config.appId());
		payRequest.setMch_id(config.mchId());

		payRequest.setDevice_info(order.getDevice_info());

		// 商品描述
		payRequest.setBody(order.getBody());
		payRequest.setDetail(order.getDetail());
		payRequest.setAttach(order.getAttach());
		// 商户订单号
		payRequest.setOut_trade_no(order.getOut_trade_no());

		payRequest.setFee_type(order.getFee_type());

		// 总金额
		payRequest.setTotal_fee(order.getTotal_fee());

		payRequest.setSpbill_create_ip(order.getSpbill_create_ip());
		payRequest.setTime_start(order.getTime_start());
		payRequest.setTime_expire(order.getTime_expire());

		payRequest.setGoods_tag(order.getGoods_tag());

		// 支付成功,微信反馈的url地址
		payRequest.setNotify_url(config.notifyUrl());

		payRequest.setTrade_type(order.getTrade_type());
		// 此id为二维码中包含的商品ID
		payRequest.setProduct_id(order.getProduct_id());

		payRequest.setLimit_pay(order.getLimit_pay());
		payRequest.setOpenid(config.openid());

		// 随机数创建
		payRequest.setNonce_str(RandomStringGenerator.getRandomStringByLength(20));

		// 签名
		String sign;
		sign = createPaySign(payRequest, config.key());
		payRequest.setSign(sign);

		return payRequest;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.aposoft.ecommerce.payment.wechat.EntityUtil#generateRefundXml(cn.
	 * aposoft.ecommerce.payment.wechat.Refund,
	 * cn.aposoft.ecommerce.payment.wechat.Config)
	 */
	@Override
	public String generateRefundXml(Refund refund, Config config) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.aposoft.ecommerce.payment.wechat.EntityUtil#parsePayResponseXml(java.
	 * lang.String)
	 */
	@Override
	public PayResponse parsePayResponseXml(String xml) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.aposoft.ecommerce.payment.wechat.EntityUtil#parseNotificationXml(java.
	 * lang.String)
	 */
	@Override
	public Notification parseNotificationXml(String xml) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.aposoft.ecommerce.payment.wechat.EntityUtil#parseRefundResponseXml(
	 * java.lang.String)
	 */
	@Override
	public RefundResponse parseRefundResponseXml(String xml) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.aposoft.ecommerce.payment.wechat.EntityUtil#generateOrderQueryXml(cn.
	 * aposoft.ecommerce.payment.wechat.OrderQuery,
	 * cn.aposoft.ecommerce.payment.wechat.Config)
	 */
	@Override
	public String generateOrderQueryXml(OrderQuery params, Config config) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.aposoft.ecommerce.payment.wechat.EntityUtil#parseOrderQueryResponseXml
	 * (java.lang.String)
	 */
	@Override
	public OrderQueryResponse parseOrderQueryResponseXml(String responseText) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.aposoft.ecommerce.payment.wechat.EntityUtil#generateCloseOrderXml(cn.
	 * aposoft.ecommerce.payment.wechat.CloseOrder,
	 * cn.aposoft.ecommerce.payment.wechat.Config)
	 */
	@Override
	public String generateCloseOrderXml(CloseOrder params, Config config) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.aposoft.ecommerce.payment.wechat.EntityUtil#parseCloseOrderResponseXml
	 * (java.lang.String)
	 */
	@Override
	public CloseOrderResponse parseCloseOrderResponseXml(String xml) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.aposoft.ecommerce.payment.wechat.EntityUtil#generateRefundQueryXml(cn.
	 * aposoft.ecommerce.payment.wechat.RefundQuery,
	 * cn.aposoft.ecommerce.payment.wechat.Config)
	 */
	@Override
	public String generateRefundQueryXml(RefundQuery params, Config config) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.aposoft.ecommerce.payment.wechat.EntityUtil#
	 * parseRefundQueryResponseXml(java.lang.String)
	 */
	@Override
	public RefundQueryResponse parseRefundQueryResponseXml(String xml) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.aposoft.ecommerce.payment.wechat.EntityUtil#generateDownloadBillXml(cn
	 * .aposoft.ecommerce.payment.wechat.DownloadBill,
	 * cn.aposoft.ecommerce.payment.wechat.Config)
	 */
	@Override
	public String generateDownloadBillXml(DownloadBill params, Config config) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.aposoft.ecommerce.payment.wechat.EntityUtil#
	 * parseDownloadBillResponseXml(java.lang.String)
	 */
	@Override
	public DownloadBillResponse parseDownloadBillResponseXml(String responseText) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.aposoft.ecommerce.payment.wechat.EntityUtil#
	 * createNotificationResultXml(cn.aposoft.ecommerce.payment.wechat.impl.
	 * NotificationResult)
	 */
	@Override
	public String createNotificationResultXml(NotificationResult notificationResult) {
		// TODO Auto-generated method stub
		return null;
	}

}
