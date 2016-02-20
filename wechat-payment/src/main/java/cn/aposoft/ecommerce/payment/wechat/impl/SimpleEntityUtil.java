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
import cn.aposoft.ecommerce.payment.wechat.OrderQuery;
import cn.aposoft.ecommerce.payment.wechat.Refund;
import cn.aposoft.ecommerce.payment.wechat.RefundQuery;
import cn.aposoft.ecommerce.payment.wechat.RefundResultParser;
import cn.aposoft.ecommerce.payment.wechat.util.CommonUtil;
import cn.aposoft.ecommerce.payment.wechat.util.ParserFactory;
import cn.aposoft.ecommerce.payment.wechat.util.ParserFactory.ParserType;
import cn.aposoft.ecommerce.payment.wechat.util.Signature;
import cn.aposoft.ecommerce.payment.wechat.util.XMLUtil;

/**
 * 支付与退款的封装过程操作
 * 
 * @author Yujinshui
 *
 */
public class SimpleEntityUtil extends AbstractEntityUtil implements EntityUtil {

	private static EntityUtil instance = new SimpleEntityUtil();
	private static Logger logger = Logger.getLogger(SimpleEntityUtil.class);

	public static final EntityUtil getInstance() {
		return instance;
	}

	private SimpleEntityUtil() {

	}

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

	/**
	 * [支付]将返回的map结果解析成PayResponse-javabean
	 * 
	 * @param xml
	 *            响应的原始报文字符串
	 * @return 支付响应结果
	 */
	@Override
	public PayResponse parsePayResponseXml(String xml) {
		Map<String, String> result = null;
		try {
			result = XMLUtil.getMapFromXML(xml);
		} catch (ParserConfigurationException | IOException | SAXException e) {
			logger.error("解析支付结果时发生错误: " + e.getMessage(), e);
			return null;
		}
		PayResponse response = new PayResponse();

		response.setReturn_code(result.get("return_code"));
		response.setReturn_msg(result.get("return_msg"));

		response.setAppid(result.get("appid"));
		response.setMch_id(result.get("mch_id"));
		response.setDevice_info(result.get("device_info"));
		response.setNonce_str(result.get("nonce_str"));
		response.setSign(result.get("sign"));
		response.setResult_code(result.get("result_code"));
		response.setErr_code(result.get("err_code"));
		response.setErr_code_des(result.get("err_code_des"));

		response.setTrade_type(result.get("trade_type"));
		response.setPrepay_id(result.get("prepay_id"));
		response.setCode_url(result.get("code_url"));

		return response;
	}

	/**
	 * 根据order和config创建待发送的xml字符串
	 * 
	 * @param values
	 *            {@code PayRequest} 支付请求内容
	 * @return 支付传输的xml文件格式
	 */
	@Override
	protected String generatePayXml(PayRequest values) {
		SortedMap<String, Object> parameters = createPayTransferMap(values);
		return XMLUtil.createXML(parameters);
	}

	@Override
	public String createPaySign(PayRequest payRequest, String key) {
		// 签名
		Map<String, String> mapRequest = createPaySignMap(payRequest);
		String sign = Signature.getMapSign(mapRequest, key);
		return sign;
	}

	/**
	 * {@code createPayTransferMap}将数据封装为map类型，用于创建XML数据
	 * 
	 * @param value
	 *            用于交易的订单内容
	 * @return 用于数据传输的Map类型数据
	 * @bugfix: 2015/10/27 重命名方法,可见性改为私有
	 */
	private SortedMap<String, Object> createPayTransferMap(PayRequest value) {
		SortedMap<String, Object> parameters = new TreeMap<String, Object>();
		parameters.put("appid", value.getAppid());
		parameters.put("mch_id", value.getMch_id());
		parameters.put("device_info", value.getDevice_info());
		parameters.put("nonce_str", value.getNonce_str());
		parameters.put("sign", value.getSign());
		parameters.put("body", value.getBody());
		parameters.put("detail", value.getDetail());
		parameters.put("attach", value.getAttach());
		parameters.put("out_trade_no", value.getOut_trade_no());
		parameters.put("fee_type", value.getFee_type());
		parameters.put("total_fee", value.getTotal_fee());
		parameters.put("spbill_create_ip", value.getSpbill_create_ip());
		parameters.put("time_start", value.getTime_start());
		parameters.put("time_expire", value.getTime_expire());
		parameters.put("goods_tag", value.getGoods_tag());
		parameters.put("notify_url", value.getNotify_url());
		parameters.put("trade_type", value.getTrade_type());
		parameters.put("product_id", value.getProduct_id());
		parameters.put("limit_pay", value.getLimit_pay());
		parameters.put("openid", value.getOpenid());
		return parameters;
	}

	/**
	 * {@code createPaySignMap}将PayRequest 封装为Map类型,用于数据签名计算
	 * 
	 * @param payRequest
	 *            支付请求内容
	 * @return 支付请求内容的Map格式数据
	 */
	private Map<String, String> createPaySignMap(PayRequest payRequest) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("appid", payRequest.getAppid());
		map.put("mch_id", payRequest.getMch_id());
		map.put("device_info", payRequest.getDevice_info());
		map.put("nonce_str", payRequest.getNonce_str());
		map.put("sign", payRequest.getSign());
		map.put("body", payRequest.getBody());
		map.put("detail", payRequest.getDetail());
		map.put("attach", payRequest.getAttach());
		map.put("out_trade_no", payRequest.getOut_trade_no());
		map.put("fee_type", payRequest.getFee_type());
		map.put("total_fee", payRequest.getTotal_fee() + "");
		map.put("spbill_create_ip", payRequest.getSpbill_create_ip());
		map.put("time_start", payRequest.getTime_start());
		map.put("time_expire", payRequest.getTime_expire());
		map.put("goods_tag", payRequest.getGoods_tag());
		map.put("notify_url", payRequest.getNotify_url());
		map.put("trade_type", payRequest.getTrade_type());
		map.put("product_id", payRequest.getProduct_id());
		map.put("limit_pay", payRequest.getLimit_pay());
		map.put("openid", payRequest.getOpenid());
		return map;
	}

	/**
	 * 将支付成功后返回的原始xml报文转换为Notification对象
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
	 * [退款]将返回的xml结果解析成javabean
	 * 
	 * @param xml
	 *            退款响应的xml原始报文
	 * @return 退款响应数据
	 * @author Yujinshui
	 */
	@Override
	public RefundResponse parseRefundResponseXml(String xml) {

		Map<String, String> result = null;
		try {
			result = XMLUtil.getMapFromXML(xml);
		} catch (ParserConfigurationException | IOException | SAXException e) {
			logger.error("解析退款结果时发生错误: " + e.getMessage(), e);
			return null;
		}
		RefundResponse refundResponse = new RefundResponse();

		refundResponse.setReturn_code(result.get("return_code"));//
		refundResponse.setReturn_msg(result.get("return_msg"));//

		refundResponse.setResult_code(result.get("result_code"));
		refundResponse.setErr_code(result.get("err_code"));
		refundResponse.setErr_code_des(result.get("err_code_des"));

		refundResponse.setAppid(result.get("appid"));
		refundResponse.setMch_id(result.get("mch_id"));
		refundResponse.setDevice_info(result.get("device_info"));
		refundResponse.setNonce_str(result.get("nonce_str"));
		refundResponse.setSign(result.get("sign"));
		refundResponse.setTransaction_id(result.get("transaction_id"));
		refundResponse.setOut_trade_no(result.get("out_trade_no"));
		refundResponse.setOut_refund_no(result.get("out_refund_no"));
		refundResponse.setRefund_id(result.get("refund_id"));
		refundResponse.setRefund_channel(result.get("refund_channel"));
		refundResponse.setRefund_fee(CommonUtil.parseNum(result.get("refund_fee")));
		refundResponse.setTotal_fee(CommonUtil.parseNum(result.get("total_fee")));
		refundResponse.setFee_type(result.get("fee_type"));
		refundResponse.setCash_fee(CommonUtil.parseNum(result.get("cash_fee")));
		refundResponse.setCash_refund_fee(result.get("cash_refund_fee"));
		refundResponse.setCoupon_refund_count(CommonUtil.parseNum(result.get("coupon_refund_count")));
		refundResponse.setCoupon_refund_fee(CommonUtil.parseNum(result.get("coupon_refund_fee")));
		refundResponse.setCoupon_refund_id(result.get("coupon_refund_id"));

		return refundResponse;
	}

	/**
	 * 创建退款传输的Xml字符串
	 */
	@Override
	public String generateRefundXml(Refund refund, Config config) {
		checkConfig(config);
		RefundRequest values = null;
		values = createRefundRequest(refund, config);
		SortedMap<String, Object> parameters = createRefundTransferMap(values);
		return XMLUtil.createXML(parameters);
	}

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
	private RefundRequest createRefundRequest(Refund refund, Config config) {
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
		Map<String, String> parameters = createRefundSignMap(payRefund);
		String sign = Signature.getMapSign(parameters, config.key());

		payRefund.setSign(sign);

		return payRefund;
	}

	/**
	 * {@code createRefundSignMap}将RefundRequest 封装为Map类型,用于数据签名计算
	 * 
	 * @param value
	 *            退款请求数据
	 * @return 用于签名计算的 退款请求数据的Map格式
	 */
	private Map<String, String> createRefundSignMap(RefundRequest value) {
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("appid", value.getAppid());
		parameters.put("mch_id", value.getMch_id());
		parameters.put("device_info", value.getDevice_info());
		parameters.put("nonce_str", value.getNonce_str());
		parameters.put("sign", value.getSign());
		parameters.put("transaction_id", value.getTransaction_id());
		parameters.put("out_trade_no", value.getOut_trade_no());
		parameters.put("out_refund_no", value.getOut_refund_no());
		parameters.put("total_fee", value.getTotal_fee() + "");

		parameters.put("refund_fee", value.getRefund_fee() + "");
		parameters.put("refund_fee_type", value.getRefund_fee_type());
		parameters.put("op_user_id", value.getOp_user_id());
		return parameters;
	}

	/**
	 * {@code createReFundTransferMap}将退款数据封装为Map类型，用于创建构造post请求报文的XML文件
	 * 
	 * @param values
	 *            退款请求数据对象
	 * @return 用于生成支付xml文件的Map格式数据
	 * @author Yujinshui
	 */
	private SortedMap<String, Object> createRefundTransferMap(RefundRequest value) {
		SortedMap<String, Object> parameters = new TreeMap<String, Object>();
		parameters.put("appid", value.getAppid());
		parameters.put("mch_id", value.getMch_id());
		parameters.put("device_info", value.getDevice_info());
		parameters.put("nonce_str", value.getNonce_str());
		parameters.put("sign", value.getSign());
		parameters.put("transaction_id", value.getTransaction_id());
		parameters.put("out_trade_no", value.getOut_trade_no());
		parameters.put("out_refund_no", value.getOut_refund_no());
		parameters.put("total_fee", value.getTotal_fee() + "");

		parameters.put("refund_fee", value.getRefund_fee() + "");
		parameters.put("refund_fee_type", value.getRefund_fee_type());
		parameters.put("op_user_id", value.getOp_user_id());

		return parameters;
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

	private Coupon checkAndGetCoupon(Map<Integer, Coupon> couponMap, int n) {
		Coupon coupon = couponMap.get(n);
		if (coupon == null) {
			coupon = new Coupon(n);
			couponMap.put(n, coupon);
		}
		return coupon;
	}

	/**
	 * 将订单查询信息转换成为可发送的xml格式字符串
	 * <p>
	 * 
	 * @param params
	 *            查询条件 两个id不能全部为空
	 * @param config
	 *            商户的支付配置信息
	 * @return 生成的xml结果值
	 * @throws IllegalArgumentException
	 *             当config的必要信息为空或者params的查询参数均为空时,抛出此异常
	 */
	@Override
	public String generateOrderQueryXml(OrderQuery params, Config config) {
		checkConfig(config);
		if (params == null || (params.getTransaction_id() == null || params.getTransaction_id().isEmpty())
				&& (params.getOut_trade_no() == null || params.getOut_trade_no().isEmpty())) {
			throw new IllegalArgumentException("transaction_id与Out_trade_no不能同时为空.");
		}
		OrderQueryRequest values = createOrderQueryRequest(params, config);
		SortedMap<String, Object> parameters = createOrderQueryTransferMap(values);
		return XMLUtil.createXML(parameters);
	}

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
		Map<String, String> mapRequest = createOrderQuerySignMap(values);
		String sign = Signature.getMapSign(mapRequest, config.key());
		values.setSign(sign);

		return values;
	}

	/**
	 * {@code createOrderQuerySignMap} 用于创建订单查询对象签名的Map数据对象.
	 * 
	 * @param request
	 *            订单查询请求数据
	 * @return 订单查询请求数据Map
	 */
	private Map<String, String> createOrderQuerySignMap(OrderQueryRequest request) {
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("appid", request.getAppid());
		parameters.put("mch_id", request.getMch_id());
		parameters.put("nonce_str", request.getNonce_str());

		parameters.put("out_trade_no", request.getOut_trade_no());
		parameters.put("transaction_id", request.getTransaction_id());
		parameters.put("sign", request.getSign());
		return parameters;
	}

	/**
	 * {@code createOrderQueryTransferMap}用于将Java订单查询对象转换为Map数据格式
	 * 
	 * @param request
	 *            订单查询请求对象
	 * @return 订单查询对象的Map表示形式
	 */
	private SortedMap<String, Object> createOrderQueryTransferMap(OrderQueryRequest request) {
		SortedMap<String, Object> parameters = new TreeMap<String, Object>();
		parameters.put("appid", request.getAppid());
		parameters.put("mch_id", request.getMch_id());

		parameters.put("out_trade_no", request.getOut_trade_no());
		parameters.put("transaction_id", request.getTransaction_id());
		parameters.put("nonce_str", request.getNonce_str());
		parameters.put("sign", request.getSign());
		return parameters;
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
		SortedMap<String, Object> parameters = createCloseOrderTransferMap(values);
		return XMLUtil.createXML(parameters);
	}

	private CloseOrderRequest createCloseOrderRequest(CloseOrder params, Config config) {
		CloseOrderRequest request = new CloseOrderRequest();
		request.setAppid(config.appId());
		request.setMch_id(config.mchId());
		request.setOut_trade_no(params.getOut_trade_no());
		request.setNonce_str(RandomStringGenerator.getRandomStringByLength(20));

		// 签名
		Map<String, String> mapRequest = createCloseOrderSignMap(request);
		String sign = Signature.getMapSign(mapRequest, config.key());
		request.setSign(sign);

		return request;
	}

	/**
	 * 创建关闭订单发送接口的Map数据格式
	 * 
	 * @param request
	 *            发送的关闭订单请求对象
	 * @return 返回对象对应的Map数据格式
	 */
	private Map<String, String> createCloseOrderSignMap(CloseOrderRequest request) {
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("appid", request.getAppid());
		parameters.put("mch_id", request.getMch_id());
		parameters.put("out_trade_no", request.getOut_trade_no());
		parameters.put("nonce_str", request.getNonce_str());
		parameters.put("sign", request.getSign());
		return parameters;
	}

	private SortedMap<String, Object> createCloseOrderTransferMap(CloseOrderRequest request) {
		SortedMap<String, Object> parameters = new TreeMap<String, Object>();
		parameters.put("appid", request.getAppid());
		parameters.put("mch_id", request.getMch_id());
		parameters.put("out_trade_no", request.getOut_trade_no());
		parameters.put("nonce_str", request.getNonce_str());
		parameters.put("sign", request.getSign());
		return parameters;
	}

	/**
	 * 解析退款查询响应的xml文件
	 */
	@Override
	public RefundQueryResponse parseRefundQueryResponseXml(String xml) {
		Map<String, String> result = null;
		try {
			result = XMLUtil.getMapFromXML(xml);
		} catch (ParserConfigurationException | IOException | SAXException e) {
			logger.error("解析支付结果时发生错误: " + e.getMessage(), e);
			return null;
		}

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
	private List<RefundBill> createRefundBillItems(Map<String, String> srcItemsMap,
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
	private void checkAndSetRefundBill(Entry<String, String> refundBillDataItem, Map<Integer, RefundBill> bills,
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
	private Coupon checkAndgetRefundBillCoupon(Map<Integer, RefundBill> bills, String key,
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
	private Coupon checkAndGetCoupon(RefundBill bill, int m) {
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

	private RefundBill checkAndGetRefundBill(Map<Integer, RefundBill> bills, int n) {
		RefundBill bill = bills.get(n);
		if (bill == null) {
			bill = new RefundBill(n);
			bills.put(n, bill);
		}
		return bill;
	}

	/**
	 * 生成退款查询请求的xml报文
	 * 
	 * @param params
	 *            订单关闭请求的参数
	 * @param config
	 *            商户配置信息
	 * @return 发送的"关闭订单"报文
	 */
	@Override
	public String generateRefundQueryXml(RefundQuery params, Config config) {
		checkConfig(config);
		if (params == null //
				|| (params.getOut_trade_no() == null || params.getOut_trade_no().isEmpty())
						&& (params.getTransaction_id() == null || params.getTransaction_id().isEmpty())
						&& (params.getOut_refund_no() == null || params.getOut_refund_no().isEmpty())
						&& (params.getRefund_id() == null || params.getRefund_id().isEmpty())

		) {
			throw new IllegalArgumentException("transaction_id,out_trade_no,out_refund_no,refund_id不能同时为空.");
		}
		RefundQueryRequest values = createRefundQueryRequest(params, config);
		SortedMap<String, Object> parameters = createRefundQueryTransferMap(values);
		return XMLUtil.createXML(parameters);
	}

	private RefundQueryRequest createRefundQueryRequest(RefundQuery params, Config config) {
		RefundQueryRequest request = new RefundQueryRequest();
		request.setAppid(config.appId());
		request.setMch_id(config.mchId());
		request.setDevice_info(params.getDevice_info());

		request.setTransaction_id(params.getTransaction_id());
		request.setOut_trade_no(params.getOut_trade_no());
		request.setOut_refund_no(params.getOut_refund_no());
		request.setRefund_id(params.getRefund_id());

		request.setNonce_str(RandomStringGenerator.getRandomStringByLength(20));
		// 签名
		Map<String, String> mapRequest = createRefundQuerySignMap(request);
		String sign = Signature.getMapSign(mapRequest, config.key());
		request.setSign(sign);

		return request;
	}

	private Map<String, String> createRefundQuerySignMap(RefundQueryRequest request) {
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("appid", request.getAppid());
		parameters.put("mch_id", request.getMch_id());
		parameters.put("device_info", request.getDevice_info());
		parameters.put("nonce_str", request.getNonce_str());
		parameters.put("sign", request.getSign());

		parameters.put("transaction_id", request.getTransaction_id());
		parameters.put("out_trade_no", request.getOut_trade_no());
		parameters.put("out_refund_no", request.getOut_refund_no());
		parameters.put("refund_id", request.getRefund_id());
		return parameters;
	}

	private SortedMap<String, Object> createRefundQueryTransferMap(RefundQueryRequest request) {
		SortedMap<String, Object> parameters = new TreeMap<String, Object>();
		parameters.put("appid", request.getAppid());
		parameters.put("mch_id", request.getMch_id());
		parameters.put("nonce_str", request.getNonce_str());
		parameters.put("device_info", request.getDevice_info());
		parameters.put("sign", request.getSign());

		parameters.put("transaction_id", request.getTransaction_id());
		parameters.put("out_trade_no", request.getOut_trade_no());
		parameters.put("out_refund_no", request.getOut_refund_no());
		parameters.put("refund_id", request.getRefund_id());
		return parameters;
	}

	/**
	 * {@code parseDownloadBillResponseXml(String xml)} 完成对账单的解析和拆分
	 * 
	 * @param xml
	 *            返回的响应报文内容:
	 *            <p>
	 *            失败时:内容应为xml格式的错误信息
	 *            <p>
	 *            成功时:报文为对账单,不包含xml格式信息
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
	 * {@code generateDownloadBillXml(DownloadBill params, Config config)}
	 * 下载对账单请求对象构建方法
	 * 
	 * @param params
	 *            下载对账单查询参数
	 * @param config
	 *            商户配置信息
	 * @see cn.aposoft.ecommerce.payment.wechat.EntityUtil#generateDownloadBillXml(DownloadBill,Config)
	 */
	@Override
	public String generateDownloadBillXml(DownloadBill params, Config config) {
		checkConfig(config);
		if (params == null || params.getBill_date() == null) {
			throw new IllegalArgumentException("查询信息不能为空,日志不能为空.");
		}
		DownloadBillRequest values = createDownloadBillRequest(params, config);
		SortedMap<String, Object> parameters = createDownloadBillTransferMap(values);
		return XMLUtil.createXML(parameters);

	}

	private DownloadBillRequest createDownloadBillRequest(DownloadBill params, Config config) {
		DownloadBillRequest request = new DownloadBillRequest();
		request.setAppid(config.appId());
		request.setMch_id(config.mchId());
		request.setDevice_info(params.getDevice_info());
		request.setBill_date(params.getBill_date());
		request.setBill_type(params.getBill_type());
		request.setNonce_str(RandomStringGenerator.getRandomStringByLength(20));

		// 签名
		Map<String, String> mapRequest = createDownloadBillSignMap(request);
		String sign = Signature.getMapSign(mapRequest, config.key());
		request.setSign(sign);

		return request;
	}

	private Map<String, String> createDownloadBillSignMap(DownloadBillRequest request) {
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("appid", request.getAppid());
		parameters.put("mch_id", request.getMch_id());
		parameters.put("nonce_str", request.getNonce_str());
		parameters.put("device_info", request.getDevice_info());
		parameters.put("sign", request.getSign());

		parameters.put("bill_date", request.getBill_date());
		parameters.put("bill_type", request.getBill_type());
		return parameters;
	}

	private SortedMap<String, Object> createDownloadBillTransferMap(DownloadBillRequest request) {
		SortedMap<String, Object> parameters = new TreeMap<String, Object>();
		parameters.put("appid", request.getAppid());
		parameters.put("mch_id", request.getMch_id());
		parameters.put("nonce_str", request.getNonce_str());
		parameters.put("device_info", request.getDevice_info());
		parameters.put("sign", request.getSign());

		parameters.put("bill_date", request.getBill_date());
		parameters.put("bill_type", request.getBill_type());
		return parameters;
	}

	@Override
	public String createNotificationResultXml(NotificationResult notificationResult) {
		if (notificationResult == null) {
			notificationResult = new NotificationResult();
		}
		SortedMap<String, Object> parameters = createNotificationResultMap(notificationResult);
		return XMLUtil.createXML(parameters);
	}

	private SortedMap<String, Object> createNotificationResultMap(NotificationResult notificationResult) {
		SortedMap<String, Object> parameters = new TreeMap<String, Object>();
		parameters.put("return_code", notificationResult.getReturn_code());
		parameters.put("return_msg", notificationResult.getReturn_msg());
		return parameters;
	}

}
