/**
 * 
 */
package cn.aposoft.ecommerce.payment.wechat.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import cn.aposoft.ecommerce.payment.wechat.CloseOrder;
import cn.aposoft.ecommerce.payment.wechat.Config;
import cn.aposoft.ecommerce.payment.wechat.CouponParser;
import cn.aposoft.ecommerce.payment.wechat.DownloadBill;
import cn.aposoft.ecommerce.payment.wechat.EntityUtil;
import cn.aposoft.ecommerce.payment.wechat.Order;
import cn.aposoft.ecommerce.payment.wechat.OrderQuery;
import cn.aposoft.ecommerce.payment.wechat.Refund;
import cn.aposoft.ecommerce.payment.wechat.RefundQuery;
import cn.aposoft.ecommerce.payment.wechat.RefundResultParser;
import cn.aposoft.ecommerce.payment.wechat.util.CommonUtil;
import cn.aposoft.ecommerce.payment.wechat.util.ParserFactory;
import cn.aposoft.ecommerce.payment.wechat.util.ParserFactory.ParserType;
import cn.aposoft.ecommerce.payment.wechat.util.XMLUtil;

/**
 * 微信支付的bean处理的抽象模板方法 <br />
 * 
 * 已通过测试接口: <br />
 * 1. prepare预支付接口已经完成 {@code generatePayXml } {@code parsePayResponseXml} <br/>
 * 
 * @author Jann Liu
 *
 */
public abstract class AbstractEntityUtil implements EntityUtil {
	private static Logger logger = Logger.getLogger(SimpleEntityUtil.class);

	/**
	 * 用于检查config的信息载入是否正确
	 * 
	 * @param config
	 *            待检测的配置信息
	 * @throws IllegalArgumentException
	 *             当config参数不正确时,抛出此异常
	 */
	protected final void checkConfig(Config config) {
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

	/**
	 * 解析微信的xml响应报文,返回通用的 xmlMap key value pair
	 * 
	 * @param xml
	 *            微信响应的xml报文
	 * @return 报文对应的map对象
	 */
	protected final Map<String, String> getResponseMap(String xml) {
		Map<String, String> result = null;
		try {
			result = XMLUtil.getMapFromXML(xml);
			return result;
		} catch (ParserConfigurationException | IOException | SAXException e) {
			logger.error("解析支付结果时发生错误: " + e.getMessage(), e);
			return null;
		}
	}

	/**
	 * 根据order和config创建待发送的支付信息xml字符串
	 * 
	 * @param order
	 *            订单信息
	 * @param config
	 *            配置内容
	 * @return 预支付请求的xml报文
	 * 
	 * @see cn.aposoft.ecommerce.payment.wechat.EntityUtil#generatePayXml(cn.aposoft.
	 *      ecommerce.payment.wechat.Order,
	 *      cn.aposoft.ecommerce.payment.wechat.Config)
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
	 * (non-Javadoc)
	 * 
	 * @see cn.aposoft.ecommerce.payment.wechat.EntityUtil#parsePayResponseXml(java.
	 *      lang.String)
	 */
	@Override
	public PayResponse parsePayResponseXml(String xml) {
		Map<String, String> result = getResponseMap(xml);
		return createPayResponseBean(result);
	}

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

	/**
	 * 从微信响应的原生xmlMap创建PayResponse对象
	 * 
	 * 可以使用反射重写此方法
	 * 
	 * @param srcMap
	 *            从xml中Parse出的key value pair
	 * @return 预支付结果响应对象 {@code PayResponse}
	 */
	protected PayResponse createPayResponseBean(Map<String, String> srcMap) {
		PayResponse response = new PayResponse();

		response.setReturn_code(srcMap.get("return_code"));
		response.setReturn_msg(srcMap.get("return_msg"));

		response.setAppid(srcMap.get("appid"));
		response.setMch_id(srcMap.get("mch_id"));
		response.setDevice_info(srcMap.get("device_info"));
		response.setNonce_str(srcMap.get("nonce_str"));
		response.setSign(srcMap.get("sign"));
		response.setResult_code(srcMap.get("result_code"));
		response.setErr_code(srcMap.get("err_code"));
		response.setErr_code_des(srcMap.get("err_code_des"));

		response.setTrade_type(srcMap.get("trade_type"));
		response.setPrepay_id(srcMap.get("prepay_id"));
		response.setCode_url(srcMap.get("code_url"));

		return response;
	}

	/**
	 * 解析退款响应请求,返回退款响应对象实例
	 * 
	 * @param xml
	 *            微信响应的xml报文
	 * @return 微信退款响应定义对象 {@link RefundResponse}
	 * 
	 * @see cn.aposoft.ecommerce.payment.wechat.EntityUtil#parseRefundResponseXml(
	 *      java.lang.String)
	 */
	@Override
	public RefundResponse parseRefundResponseXml(String xml) {
		Map<String, String> result = getResponseMap(xml);
		return createRefundResponseBean(result);
	}

	/**
	 * 创建退款响应Bean
	 * 
	 * @param map
	 *            xml解析的map对象
	 * @return {@code RefundResponse}bean的退款对象
	 */
	public RefundResponse createRefundResponseBean(Map<String, String> map) {
		RefundResponse refundResponse = new RefundResponse();

		refundResponse.setReturn_code(map.get("return_code"));//
		refundResponse.setReturn_msg(map.get("return_msg"));//

		refundResponse.setResult_code(map.get("result_code"));
		refundResponse.setErr_code(map.get("err_code"));
		refundResponse.setErr_code_des(map.get("err_code_des"));

		refundResponse.setAppid(map.get("appid"));
		refundResponse.setMch_id(map.get("mch_id"));
		refundResponse.setDevice_info(map.get("device_info"));
		refundResponse.setNonce_str(map.get("nonce_str"));
		refundResponse.setSign(map.get("sign"));
		refundResponse.setTransaction_id(map.get("transaction_id"));
		refundResponse.setOut_trade_no(map.get("out_trade_no"));
		refundResponse.setOut_refund_no(map.get("out_refund_no"));
		refundResponse.setRefund_id(map.get("refund_id"));
		refundResponse.setRefund_channel(map.get("refund_channel"));
		refundResponse.setRefund_fee(CommonUtil.parseNum(map.get("refund_fee")));
		refundResponse.setTotal_fee(CommonUtil.parseNum(map.get("total_fee")));
		refundResponse.setFee_type(map.get("fee_type"));
		refundResponse.setCash_fee(CommonUtil.parseNum(map.get("cash_fee")));
		refundResponse.setCash_refund_fee(map.get("cash_refund_fee"));
		refundResponse.setCoupon_refund_count(CommonUtil.parseNum(map.get("coupon_refund_count")));
		refundResponse.setCoupon_refund_fee(CommonUtil.parseNum(map.get("coupon_refund_fee")));
		refundResponse.setCoupon_refund_id(map.get("coupon_refund_id"));

		return refundResponse;
	}

	/**
	 * 生成退款的xml
	 * 
	 * @see cn.aposoft.ecommerce.payment.wechat.EntityUtil#generateRefundXml(cn.
	 *      aposoft.ecommerce.payment.wechat.Refund,
	 *      cn.aposoft.ecommerce.payment.wechat.Config)
	 */
	@Override
	public String generateRefundXml(Refund refund, Config config) {
		checkConfig(config);
		RefundRequest values = createRefundRequest(refund, config);
		return generateRefundXml(values);
	}

	/**
	 * 将退款bean对象转换为传输使用的xml形式
	 * 
	 * @param values
	 *            退款对象bean
	 * @return 传输使用的xml格式文本
	 */
	public abstract String generateRefundXml(RefundRequest values);

	/**
	 * 子类需要实现生成key的算法
	 * 
	 * @param payRefund
	 *            退款信息
	 * @param key
	 *            加密key
	 * @return 加密的字符串
	 */
	protected abstract String createRefundSign(RefundRequest payRefund, String key);

	/**
	 * 创建退款传输实例数据对象
	 * 
	 * @param refund
	 *            退款数据对象
	 * @param config
	 *            商户配置信息
	 * @return 退款请求完整信息
	 * @author Yujinshui
	 */
	public RefundRequest createRefundRequest(Refund refund, Config config) {
		RefundRequest payRefund = new RefundRequest();
		payRefund.setAppid(config.appId());
		payRefund.setMch_id(config.mchId());
		payRefund.setDevice_info(refund.getDevice_info());

		payRefund.setTransaction_id(refund.getTransaction_id());
		payRefund.setOut_trade_no(refund.getOut_trade_no());
		payRefund.setOut_refund_no(refund.getOut_refund_no());
		payRefund.setTotal_fee(refund.getTotal_fee());
		payRefund.setRefund_fee(refund.getRefund_fee());
		payRefund.setRefund_fee_type(refund.getRefund_fee_type());
		payRefund.setOp_user_id(refund.getOp_user_id());

		payRefund.setNonce_str(RandomStringGenerator.getRandomStringByLength(20));
		String sign = createRefundSign(payRefund, config.key());

		payRefund.setSign(sign);

		return payRefund;
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
		try {
			Map<String, String> resultMap = XMLUtil.getMapFromXML(xml);
			Notification origin = convertToNotification(resultMap);
			Notification result = setNotificationResult(origin);
			return result;
		} catch (ParserConfigurationException | IOException | SAXException e) {
			logger.error(e.getMessage(), e);
			return createErrorResponse(e);
		}
	}

	private Notification createErrorResponse(Exception e) {
		Notification notification = new Notification();
		NotificationResult result = NotificationResult.errorResult(e);
		notification.setResult(result);
		return notification;
	}

	/**
	 * 将map类型映射为javabean，返回给用户
	 * 
	 * @param resultMap
	 *            结果Map
	 * @return 支付成功返回请求
	 * @author Yujinshui
	 */
	private Notification convertToNotification(Map<String, String> resultMap) {
		Notification notification = new Notification();

		notification.setAppid(resultMap.get("appid"));// 公众账号ID
		notification.setMch_id(resultMap.get("mch_id"));// 商户号
		notification.setDevice_info(resultMap.get("device_info"));// 设备号
		notification.setNonce_str(resultMap.get("nonce_str"));// 随机字符串
		notification.setSign(resultMap.get("sign"));// 签名
		notification.setResult_code(resultMap.get("result_code"));// 业务结果
		notification.setErr_code(resultMap.get("err_code"));// 错误代码
		notification.setErr_code_des(resultMap.get("err_code_des"));// 错误代码描述
		notification.setOpenid(resultMap.get("openid"));// 用户标识
		notification.setIs_subscribe(resultMap.get("is_subscribe"));// 是否关注公众账号
		notification.setTrade_type(resultMap.get("trade_type"));// 交易类型
		notification.setBank_type(resultMap.get("bank_type"));// 付款银行
		notification.setTotal_fee(CommonUtil.parseNum(resultMap.get("total_fee")));// 总金额
		notification.setFee_type(resultMap.get("fee_type"));// 货币种类
		notification.setCash_fee(resultMap.get("cash_fee"));// 现金支付金额
		notification.setCash_fee_type(resultMap.get("cash_fee_type"));// 现金支付货币类型
		notification.setCoupon_fee(resultMap.get("coupon_fee"));// 代金券或立减优惠金额
		notification.setCoupon_count(resultMap.get("coupon_count"));// 代金券或立减优惠使用数量
		notification.setCoupon_id_$n(resultMap.get("coupon_id_$n"));// 代金券或立减优惠ID
		notification.setCoupon_fee_$n(resultMap.get("coupon_fee_$n"));// 单个代金券或立减优惠支付金额
		notification.setTransaction_id(resultMap.get("transaction_id"));// 微信支付订单号
		notification.setOut_trade_no(resultMap.get("out_trade_no"));// 商户订单号
		notification.setAttach(resultMap.get("attach"));// 商家数据包
		notification.setTime_end(resultMap.get("time_end"));// 支付完成时间

		return notification;
	}

	/**
	 * 校验通知消息检验结果
	 * 
	 * @param origin
	 *            原始的通知消息对象
	 * @return 附加了通知返回结果的Notification
	 */
	private Notification setNotificationResult(Notification origin) {
		if (origin == null || origin.getResult_code() == null) {
			return defaultNullResponse();
		} else {
			origin.setResult(NotificationResult.successResult());
			return origin;
		}
	}

	private Notification defaultNullResponse() {
		Notification notification = new Notification();
		NotificationResult result = NotificationResult.nullResult();
		notification.setResult(result);
		return notification;
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
		checkConfig(config);
		if (params == null || (params.getTransaction_id() == null || params.getTransaction_id().isEmpty())
				&& (params.getOut_trade_no() == null || params.getOut_trade_no().isEmpty())) {
			throw new IllegalArgumentException("transaction_id与Out_trade_no不能同时为空.");
		}

		OrderQueryRequest values = createOrderQueryRequest(params, config);

		return generateOrderQueryXml(values);

	}

	/**
	 * 生成订单查询请求的字符串
	 * 
	 * @param values
	 *            订单查询请求的bean对象
	 * @return 查询请求传输的xml字符串
	 */
	public abstract String generateOrderQueryXml(OrderQueryRequest values);

	/**
	 * 
	 * @param values
	 * @return
	 */
	protected abstract String createOrderQuerySign(OrderQueryRequest values, String key);

	/**
	 * 创建订单查询请求对象,包含随机数生成及签名的计算
	 * 
	 * @param params
	 *            订单查询参数
	 * @param config
	 *            商户配置信息
	 * @return 用于post请求的数据完整对象
	 */
	private OrderQueryRequest createOrderQueryRequest(OrderQuery params, Config config) {
		OrderQueryRequest values = new OrderQueryRequest();
		values.setAppid(config.appId());
		values.setMch_id(config.mchId());

		values.setTransaction_id(params.getTransaction_id());
		values.setOut_trade_no(params.getOut_trade_no());
		// 随机字符串生成
		values.setNonce_str(RandomStringGenerator.getRandomStringByLength(20));
		// 签名
		String sign = createOrderQuerySign(values, config.key());
		values.setSign(sign);
		return values;
	}

	/**
	 * {@code parseOrderQueryResponseXml}用于解析订单查询结果的原始报文响应
	 * 
	 * @param responseText
	 *            订单查询响应的原始xml报文信息
	 * @return 订单查询响应的实例化对象
	 */
	@Override
	public OrderQueryResponse parseOrderQueryResponseXml(String xml) {

		Map<String, String> result = null;
		try {
			result = XMLUtil.getMapFromXML(xml);
		} catch (ParserConfigurationException | IOException | SAXException e) {
			logger.error("解析支付结果时发生错误: " + e.getMessage(), e);
			return null;
		}

		OrderQueryResponse response = new OrderQueryResponse();

		response.setReturn_code(result.get("return_code"));
		response.setReturn_msg(result.get("return_msg"));
		// 当return_code =="SUCCESS"时,有以下内容
		response.setAppid(result.get("appid"));
		response.setMch_id(result.get("mch_id"));

		response.setNonce_str(result.get("nonce_str"));
		response.setSign(result.get("sign"));
		response.setResult_code(result.get("result_code"));
		response.setErr_code(result.get("err_code"));
		response.setErr_code_des(result.get("err_code_des"));
		// 当return_code =="SUCCESS" && result_code =="SUCCESS" 时,有以下内容
		// 为ResponseBase的内容
		response.setDevice_info(result.get("device_info"));
		// 以下为OrderQueryResponse的内容
		response.setOpenid(result.get("openid"));
		response.setIs_subscribe(result.get("is_subscribe"));
		response.setTrade_type(result.get("trade_type"));
		response.setTrade_state(result.get("trade_state"));
		response.setBank_type(result.get("bank_type"));
		response.setTotal_fee(CommonUtil.parseNum(result.get("total_fee")));
		response.setFee_type(result.get("fee_type"));
		response.setCash_fee(CommonUtil.parseNum(result.get("cash_fee")));
		response.setCash_fee_type(result.get("cash_fee_type"));
		response.setCoupon_fee(CommonUtil.parseNum(result.get("coupon_fee")));
		response.setCoupon_count(CommonUtil.parseNum(result.get("coupon_count")));

		response.setTransaction_id(result.get("transaction_id"));
		response.setOut_trade_no(result.get("out_trade_no"));
		response.setAttach(result.get("attach"));
		response.setTime_end(result.get("time_end"));
		response.setTrade_state_desc(result.get("trade_state_desc"));

		/*
		 * 代金券或立减优惠批次ID coupon_batch_id_$n 否 String(20) 100 代金券或立减优惠批次ID
		 * ,$n为下标，从0开始编号 代金券或立减优惠ID coupon_id_$n 否 String(20) 10000 代金券或立减优惠ID,
		 * $n为下标，从0开始编号 单个代金券或立减优惠支付金额 coupon_fee_$n 否 Int 100 单个代金券或立减优惠支付金额,
		 * $n为下标，从0开始编号
		 */
		// 优惠券明细列表
		response.setCouponItems(createCouponItems(result, ParserFactory.getCouponParser(ParserType.OrderQuery)));

		return response;
	}

	/**
	 * 用于订单查询的CouponItems的生成Coupon集合
	 * 
	 * @param result
	 *            订单查询响应的xml解析结果
	 * @param couponParser
	 * @return 查询结果中的Coupon集合
	 */
	private List<Coupon> createCouponItems(Map<String, String> result, CouponParser couponParser) {

		Map<Integer, Coupon> couponMap = new HashMap<Integer, Coupon>();
		for (Entry<String, String> entry : result.entrySet()) {
			checkAndSetCoupon(entry, couponMap, couponParser);
		}
		List<Coupon> couponItems = new ArrayList<Coupon>(couponMap.size());

		couponItems.addAll(couponMap.values());
		// 根据N进行排序
		Collections.sort(couponItems);
		return couponItems;
	}

	/**
	 * 用于订单查询检查并添加CouponList的数据
	 * 
	 * @param couponDataItem
	 *            优惠券数据项键值对
	 * @param couponMap
	 *            优惠券集合
	 * @param couponParser
	 */
	private void checkAndSetCoupon(Entry<String, String> couponDataItem, Map<Integer, Coupon> couponMap,
			CouponParser couponParser) {

		if (couponParser.isCoupon_batch_id(couponDataItem.getKey())) {
			int n = couponParser.getN(couponDataItem.getKey());
			Coupon coupon = checkAndGetCoupon(couponMap, n);
			coupon.setCoupon_batch_id(couponDataItem.getValue());
			return;
		}

		if (couponParser.isCoupon_id(couponDataItem.getKey())) {
			int n = couponParser.getN(couponDataItem.getKey());
			Coupon coupon = checkAndGetCoupon(couponMap, n);
			coupon.setCoupon_id(couponDataItem.getValue());
			return;
		}

		if (couponParser.isCoupon_fee(couponDataItem.getKey())) {
			int n = couponParser.getN(couponDataItem.getKey());
			Coupon coupon = checkAndGetCoupon(couponMap, n);
			coupon.setCoupon_fee(CommonUtil.parseNum(couponDataItem.getValue()));
			return;
		}
	}

	/**
	 * 生成关闭订单请求的xml报文
	 * 
	 * @param params
	 *            订单关闭请求的参数
	 * @param config
	 *            商户配置信息
	 * @return 发送的"关闭订单"报文
	 */
	@Override
	public String generateCloseOrderXml(CloseOrder params, Config config) {
		checkConfig(config);
		if (params == null || params.getOut_trade_no() == null || params.getOut_trade_no().isEmpty()) {
			throw new IllegalArgumentException("transaction_id与Out_trade_no不能同时为空.");
		}
		CloseOrderRequest values = createCloseOrderRequest(params, config);
		return generateCloseOrderXml(values);
	}

	/**
	 * 生成关闭订单的请求xml报文内容
	 * 
	 * @param values
	 *            待生成xml请求的信息
	 * @return xml格式请求报文
	 */
	public abstract String generateCloseOrderXml(CloseOrderRequest values);

	/**
	 * 生成关闭订单签名字符串
	 * 
	 * @param request
	 *            关闭订单的请求内容
	 * @param key
	 *            签名使用的key
	 * @return 签名
	 */
	protected abstract String createCloseOrderSign(CloseOrderRequest request, String key);

	// 创建请求的bean
	public CloseOrderRequest createCloseOrderRequest(CloseOrder params, Config config) {
		CloseOrderRequest request = new CloseOrderRequest();
		request.setAppid(config.appId());
		request.setMch_id(config.mchId());
		request.setOut_trade_no(params.getOut_trade_no());
		request.setNonce_str(RandomStringGenerator.getRandomStringByLength(20));

		String sign = createCloseOrderSign(request, config.key());
		request.setSign(sign);

		return request;
	}

	/**
	 * 解析{@code closeOrder} 关闭订单接口的返回报文
	 * 
	 * @param xml
	 *            接收的微信的响应报文内容
	 * @return 关闭订单接口返回的报文对象
	 */
	@Override
	public CloseOrderResponse parseCloseOrderResponseXml(String xml) {
		Map<String, String> result = null;
		try {
			result = XMLUtil.getMapFromXML(xml);
		} catch (ParserConfigurationException | IOException | SAXException e) {
			logger.error("解析支付结果时发生错误: " + e.getMessage(), e);
			return null;
		}

		CloseOrderResponse response = new CloseOrderResponse();

		response.setReturn_code(result.get("return_code"));
		response.setReturn_msg(result.get("return_msg"));
		// 当return_code =="SUCCESS"时,有以下内容
		response.setAppid(result.get("appid"));
		response.setMch_id(result.get("mch_id"));

		response.setNonce_str(result.get("nonce_str"));
		response.setSign(result.get("sign"));
		response.setErr_code(result.get("err_code"));
		response.setErr_code_des(result.get("err_code_des"));

		return response;
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
		checkConfig(config);
		if (params == null //
				|| (params.getOut_trade_no() == null //
						|| params.getOut_trade_no().isEmpty())
						&& (params.getTransaction_id() == null || params.getTransaction_id().isEmpty())
						&& (params.getOut_refund_no() == null || params.getOut_refund_no().isEmpty())
						&& (params.getRefund_id() == null || params.getRefund_id().isEmpty())) {
			throw new IllegalArgumentException("transaction_id,out_trade_no,out_refund_no,refund_id不能同时为空.");
		}
		RefundQueryRequest values = createRefundQueryRequest(params, config);

		String xmlResponse = createRefundQueryRequestXml(values);
		return xmlResponse;
	}

	/**
	 * 
	 * 
	 * @see cn.aposoft.ecommerce.payment.wechat.EntityUtil#
	 *      parseRefundQueryResponseXml(java.lang.String)
	 */
	@Override
	public RefundQueryResponse parseRefundQueryResponseXml(String xml) {
		Map<String, String> result = getResponseMap(xml);
		return createRefundQueryResponseBean(result);
	}

	/**
	 * 创建微信退款查询的签名
	 * 
	 * @param request
	 *            退款查询请求bean对象
	 * @param key
	 *            签名的key
	 * @return 签名字符串
	 */
	protected abstract String createRefundQueryRequestSign(RefundQueryRequest request, String key);

	/**
	 * 由退款查询请求对象,生成直接请求的xml对象
	 * 
	 * @param values
	 *            退款查询请求的bean对象.
	 * @return xml字符串,用于直接向微信发送请求
	 */
	public abstract String createRefundQueryRequestXml(RefundQueryRequest values);

	/**
	 * 创建退款查询请求
	 * 
	 * @param params
	 *            退款查询数据
	 * @param config
	 *            商户配置信息
	 * @return 退款查询请求bean,用于生成对微信的查询请求xml文件
	 */
	RefundQueryRequest createRefundQueryRequest(RefundQuery params, Config config) {
		RefundQueryRequest request = new RefundQueryRequest();
		request.setAppid(config.appId());
		request.setMch_id(config.mchId());
		request.setDevice_info(params.getDevice_info());

		request.setTransaction_id(params.getTransaction_id());
		request.setOut_trade_no(params.getOut_trade_no());
		request.setOut_refund_no(params.getOut_refund_no());
		request.setRefund_id(params.getRefund_id());

		request.setNonce_str(RandomStringGenerator.getRandomStringByLength(20));

		String sign = createRefundQueryRequestSign(request, config.key());
		request.setSign(sign);
		return request;
	}

	/**
	 * 退款查询,响应结果
	 * 
	 * @param result
	 *            退款查询结果的Map形式
	 * @return 退款查询结果的对象
	 */
	protected RefundQueryResponse createRefundQueryResponseBean(Map<String, String> result) {
		RefundQueryResponse response = new RefundQueryResponse();

		response.setReturn_code(result.get("return_code"));
		response.setReturn_msg(result.get("return_msg"));
		// 当return_code =="SUCCESS"时,有以下内容
		response.setResult_code(result.get("result_code"));
		response.setErr_code(result.get("err_code"));
		response.setErr_code_des(result.get("err_code_des"));
		response.setAppid(result.get("appid"));
		response.setMch_id(result.get("mch_id"));
		response.setDevice_info(result.get("device_info"));
		response.setNonce_str(result.get("nonce_str"));
		response.setSign(result.get("sign"));

		// 退款信息
		response.setTransaction_id(result.get("transaction_id"));
		response.setOut_trade_no(result.get("out_trade_no"));
		response.setTotal_fee(CommonUtil.parseNum(result.get("total_fee")));
		response.setFee_type(result.get("fee_type"));
		response.setCash_fee(CommonUtil.parseNum(result.get("cash_fee")));
		response.setRefund_count(CommonUtil.parseNum(result.get("refund_count")));

		// 退款记录
		response.setRefundBillItems(createRefundBillItems(result, ParserFactory.getRefundResultParser()));

		return response;
	}

	/**
	 * {@code createRefundBillItems}从微信响应返回值中,读取退款单明细记录内容,并以列表形式返回
	 * 
	 * @param srcItemsMap
	 * @param refundResultParser
	 *            解析算法策略类
	 * @return 退款单记录明细列表
	 */
	protected List<RefundBill> createRefundBillItems(Map<String, String> srcItemsMap,
			RefundResultParser refundResultParser) {
		Map<Integer, RefundBill> bills = new HashMap<Integer, RefundBill>();
		for (Entry<String, String> entry : srcItemsMap.entrySet()) {
			checkAndSetRefundBill(entry, bills, refundResultParser);
		}
		List<RefundBill> result = new ArrayList<RefundBill>(bills.size());
		result.addAll(bills.values());
		Collections.sort(result);
		return result;
	}

	/**
	 * 
	 * @param couponDataItem
	 *            退款数据对象条目
	 * @param bills
	 *            退款单明细
	 * @param refundResultParser
	 *            退款单明细相关判断算法
	 */
	protected void checkAndSetRefundBill(Entry<String, String> refundBillDataItem, Map<Integer, RefundBill> bills,
			RefundResultParser refundResultParser) {
		// RefundBill信息
		if (refundResultParser.isOut_refund_no(refundBillDataItem.getKey())) {
			int n = refundResultParser.getN(refundBillDataItem.getKey());
			RefundBill bill = checkAndGetRefundBill(bills, n);
			bill.setOut_refund_no(refundBillDataItem.getValue());
			return;
		}

		if (refundResultParser.isRefund_id(refundBillDataItem.getKey())) {
			int n = refundResultParser.getN(refundBillDataItem.getKey());
			RefundBill bill = checkAndGetRefundBill(bills, n);
			bill.setRefund_id(refundBillDataItem.getValue());
			return;
		}

		if (refundResultParser.isRefund_channel(refundBillDataItem.getKey())) {
			int n = refundResultParser.getN(refundBillDataItem.getKey());
			RefundBill bill = checkAndGetRefundBill(bills, n);
			bill.setRefund_channel(refundBillDataItem.getValue());
			return;
		}

		if (refundResultParser.isRefund_fee(refundBillDataItem.getKey())) {
			int n = refundResultParser.getN(refundBillDataItem.getKey());
			RefundBill bill = checkAndGetRefundBill(bills, n);
			bill.setRefund_fee(CommonUtil.parseNum(refundBillDataItem.getValue()));
			return;
		}

		if (refundResultParser.isCoupon_refund_fee(refundBillDataItem.getKey())) {
			int n = refundResultParser.getN(refundBillDataItem.getKey());
			RefundBill bill = checkAndGetRefundBill(bills, n);
			bill.setCoupon_refund_fee(CommonUtil.parseNum(refundBillDataItem.getValue()));
			return;
		}

		if (refundResultParser.isCoupon_refund_count(refundBillDataItem.getKey())) {
			int n = refundResultParser.getN(refundBillDataItem.getKey());
			RefundBill bill = checkAndGetRefundBill(bills, n);
			bill.setCoupon_refund_count(CommonUtil.parseNum(refundBillDataItem.getValue()));
			return;
		}

		if (refundResultParser.isRefund_status(refundBillDataItem.getKey())) {
			int n = refundResultParser.getN(refundBillDataItem.getKey());
			RefundBill bill = checkAndGetRefundBill(bills, n);
			bill.setRefund_status(refundBillDataItem.getValue());
			return;
		}
		///////////////////////////////////////////////////////////////////////////////////////////////////////
		// Coupon 信息
		if (refundResultParser.isCoupon_batch_id(refundBillDataItem.getKey())) {
			Coupon coupon = checkAndgetRefundBillCoupon(bills, refundBillDataItem.getKey(), refundResultParser);
			coupon.setCoupon_batch_id(refundBillDataItem.getValue());
		}

		if (refundResultParser.isCoupon_id(refundBillDataItem.getKey())) {
			Coupon coupon = checkAndgetRefundBillCoupon(bills, refundBillDataItem.getKey(), refundResultParser);
			coupon.setCoupon_id(refundBillDataItem.getValue());
		}

		if (refundResultParser.isCoupon_fee(refundBillDataItem.getKey())) {
			Coupon coupon = checkAndgetRefundBillCoupon(bills, refundBillDataItem.getKey(), refundResultParser);
			coupon.setCoupon_fee(CommonUtil.parseNum(refundBillDataItem.getValue()));
		}
	}

	/**
	 * 验证并创建RefundBill和其子Coupon的封装方法
	 * 
	 * @param bills
	 * @param key
	 * @param refundResultParser
	 * @return
	 */
	protected Coupon checkAndgetRefundBillCoupon(Map<Integer, RefundBill> bills, String key,
			RefundResultParser refundResultParser) {
		int n = refundResultParser.getN(key);
		RefundBill bill = checkAndGetRefundBill(bills, n);
		int m = refundResultParser.getM(key);
		Coupon coupon = checkAndGetCoupon(bill, m);
		return coupon;
	}

	/*
	 * 检查bill是否包含coupon,如果不存在则添加,最终返回指定序号的coupon
	 * 
	 * @param bill 退款单实例
	 * 
	 * @param m coupon在退款单中的序号
	 * 
	 * @return 优惠券对象实例
	 */
	protected Coupon checkAndGetCoupon(RefundBill bill, int m) {
		List<Coupon> couponItems = bill.getCouponItems();
		if (couponItems == null) {
			couponItems = new ArrayList<Coupon>();
			bill.setCouponItems(couponItems);
		}
		// 检查如果存在则返回
		for (Coupon coupon : couponItems) {
			if (coupon.getN() == m) {
				return coupon;
			} else if (coupon.getN() > m) {
				break;
			}
		}
		// 不存在则添加
		Coupon coupon = new Coupon(m);
		couponItems.add(coupon);
		// 每次添加后都重排list,保持优惠券有序
		Collections.sort(couponItems);
		return coupon;
	}

	protected Coupon checkAndGetCoupon(Map<Integer, Coupon> couponMap, int n) {
		Coupon coupon = couponMap.get(n);
		if (coupon == null) {
			coupon = new Coupon(n);
			couponMap.put(n, coupon);
		}
		return coupon;
	}

	protected RefundBill checkAndGetRefundBill(Map<Integer, RefundBill> bills, int n) {
		RefundBill bill = bills.get(n);
		if (bill == null) {
			bill = new RefundBill(n);
			bills.put(n, bill);
		}
		return bill;
	}

	/**
	 * {@code generateDownloadBillXml(DownloadBill params, Config config)}
	 * 下载对账单请求对象构建方法
	 * 
	 * @param params
	 *            下载对账单查询参数
	 * @param config
	 *            商户配置信息
	 * @return 发送到微信端的请求报文
	 * @see cn.aposoft.ecommerce.payment.wechat.EntityUtil#generateDownloadBillXml(cn
	 *      .aposoft.ecommerce.payment.wechat.DownloadBill,
	 *      cn.aposoft.ecommerce.payment.wechat.Config)
	 */
	@Override
	public String generateDownloadBillXml(DownloadBill params, Config config) {
		checkConfig(config);
		if (params == null || params.getBill_date() == null) {
			throw new IllegalArgumentException("查询信息不能为空,日志不能为空.");
		}
		DownloadBillRequest values = createDownloadBillRequest(params, config);
		return generateDownloadBillXml(values);
	}

	/**
	 * 生成下载账单的xml输出文件
	 * 
	 * @param values
	 *            下载账单的请求参数对象
	 * @return 下载账单业务的xml格式的微信请求报文
	 */
	public abstract String generateDownloadBillXml(DownloadBillRequest values);

	/**
	 * 创建微信 下载账单的签名
	 * 
	 * @param request
	 *            下载账单请求bean对象
	 * @param key
	 *            签名的key
	 * @return 签名字符串
	 */
	protected abstract String createDownloadBillSign(DownloadBillRequest request, String key);

	private DownloadBillRequest createDownloadBillRequest(DownloadBill params, Config config) {
		DownloadBillRequest request = new DownloadBillRequest();
		request.setAppid(config.appId());
		request.setMch_id(config.mchId());
		request.setDevice_info(params.getDevice_info());
		request.setBill_date(params.getBill_date());
		request.setBill_type(params.getBill_type());
		request.setNonce_str(RandomStringGenerator.getRandomStringByLength(20));

		String sign = createDownloadBillSign(request, config.key());

		request.setSign(sign);

		return request;
	}

	/**
	 * 微信对账单返回信息的定制查询
	 * 
	 * @param xml
	 *            返回的响应报文内容:
	 *            <p>
	 *            失败时:内容应为xml格式的错误信息
	 *            <p>
	 *            成功时:报文为对账单,不包含xml格式信息
	 * @return 响应信息的实例对象
	 * @see cn.aposoft.ecommerce.payment.wechat.EntityUtil#parseDownloadBillResponseXml(String)
	 */
	@Override
	public DownloadBillResponse parseDownloadBillResponseXml(String xml) {
		if (xml == null || xml.isEmpty())
			return null;
		Map<String, String> result = null;

		DownloadBillResponse response = new DownloadBillResponse();
		if (xml.startsWith("<xml>")) {
			try {
				result = XMLUtil.getMapFromXML(xml);
				response.setReturn_code(result.get("return_code"));
				response.setReturn_msg(result.get("return_msg"));
			} catch (ParserConfigurationException | IOException | SAXException e) {
				logger.error("解析支付结果时发生错误: " + e.getMessage(), e);
			}
		} else {
			response.setData(xml);
		}
		return response;
	}

	/**
	 * @param 通知结果对象的xml文件格式
	 * @return xml格式的返回值对象
	 */
	@Override
	public String createNotificationResultXml(NotificationResult notificationResult) {
		if (notificationResult == null) {
			notificationResult = new NotificationResult();
		}
		SortedMap<String, String> parameters = createNotificationResultMap(notificationResult);
		return XMLUtil.createXML(parameters);
	}

	/**
	 * 将通知结果对象转换为map对象
	 * 
	 * @param notificationResult
	 *            通知结果对象
	 * @return 排序Map格式的对象数据
	 */
	private SortedMap<String, String> createNotificationResultMap(NotificationResult notificationResult) {
		SortedMap<String, String> parameters = new TreeMap<String, String>();
		parameters.put("return_code", notificationResult.getReturn_code());
		parameters.put("return_msg", notificationResult.getReturn_msg());
		return parameters;
	}

}
