package cn.aposoft.ecommerce.payment.wechat.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import cn.aposoft.ecommerce.payment.wechat.Config;
import cn.aposoft.ecommerce.payment.wechat.Notification;
import cn.aposoft.ecommerce.payment.wechat.Order;
import cn.aposoft.ecommerce.payment.wechat.PayResponse;
import cn.aposoft.ecommerce.payment.wechat.Refund;
import cn.aposoft.ecommerce.payment.wechat.RefundResponse;
import cn.aposoft.ecommerce.payment.wechat.impl.PayRequest;
import cn.aposoft.ecommerce.payment.wechat.impl.RefundRequest;

/**
 * 支付与退款的封装过程操作
 * 
 * @author Yujinshui
 *
 */
public class SimpleEntityUtil implements EntityUtil {

	private static EntityUtil instance = new SimpleEntityUtil();
	private static Logger logger = Logger.getLogger(SimpleEntityUtil.class);

	public static final EntityUtil getInstance() {
		return instance;
	}

	private SimpleEntityUtil() {

	}

	/**
	 * 根据order和config创建待发送的xml字符串
	 * 
	 * @param order
	 *            订单信息
	 * @param config
	 *            配置内容
	 * @return
	 */
	@Override
	public String generatePayXml(Order order, Config config) {
		PayRequest values = null;
		try {
			values = createPayRequest(order, config);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		SortedMap<String, Object> parameters = getMapPayValues(values);
		return XMLUtil.createXML(parameters);
	}

	/**
	 * 将数据封装为map类型，用于创建xml数据
	 * 
	 * @param value
	 * @return
	 */
	private SortedMap<String, Object> getMapPayValues(PayRequest value) {
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
		parameters.put("openid", value.getOpenid());
		return parameters;
	}

	/**
	 * 将支付成功后返回的结果进行javabean格式化
	 */
	@Override
	public Notification parseNotificationXml(String xml) {
		try {
			Map<String, String> resultMap = XMLUtil.getMapFromXML(xml);
			return convertToNotification(resultMap);
		} catch (ParserConfigurationException | IOException | SAXException e) {
			logger.error(e.getMessage(), e);
			return null;
		}

	}

	/**
	 * 将map类型映射为javabean，返回给用户
	 * 
	 * @param resultMap
	 * @return
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
	 * [支付]将返回的map结果解析成PayResponse-javabean
	 * 
	 * @param xml
	 * @return
	 */
	@Override
	public PayResponse parsePayResponseXml(String xml) {
		Map<String, String> result = null;
		try {
			result = XMLUtil.getMapFromXML(xml);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
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
	 * [退款]将返回的xml结果解析成javabean
	 * 
	 * @param xml
	 * @return
	 * @author Yujinshui
	 */
	@Override
	public RefundResponse parsePayRefundResponseXml(String xml) {

		Map<String, String> result = null;
		try {
			result = XMLUtil.getMapFromXML(xml);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
		RefundResponse refundResponse = new RefundResponse();

		refundResponse.setReturn_code(result.get("return_code"));//
		refundResponse.setReturn_msg(result.get("return_msg"));//

		refundResponse.setAppid(result.get("appid"));
		refundResponse.setCash_fee(CommonUtil.parseNum(result.get("cash_fee")));
		refundResponse.setCash_refund_fee(result.get("cash_refund_fee"));
		refundResponse.setCoupon_refund_count(CommonUtil.parseNum(result.get("coupon_refund_count")));
		refundResponse.setCoupon_refund_fee(CommonUtil.parseNum(result.get("coupon_refund_fee")));
		refundResponse.setCoupon_refund_id(result.get("coupon_refund_id"));
		refundResponse.setDevice_info(result.get("device_info"));
		refundResponse.setErr_code(result.get("err_code"));
		refundResponse.setErr_code_des(result.get("err_code_des"));
		refundResponse.setFee_type(result.get("fee_type"));
		refundResponse.setMch_id(result.get("mch_id"));
		refundResponse.setNonce_str(result.get("nonce_str"));
		refundResponse.setOut_refund_no(result.get("out_refund_no"));
		refundResponse.setOut_trade_no(result.get("out_trade_no"));
		refundResponse.setRefund_channel(result.get("refund_channel"));
		refundResponse.setRefund_fee(CommonUtil.parseNum(result.get("refund_fee")));
		refundResponse.setRefund_id(result.get("refund_id"));
		refundResponse.setResult_code(result.get("result_code"));
		refundResponse.setSign(result.get("sign"));
		refundResponse.setTotal_fee(CommonUtil.parseNum(result.get("total_fee")));
		refundResponse.setTransaction_id(result.get("transaction_id"));

		return refundResponse;
	}

	/**
	 * 根据Order和config生成PayRequest
	 * 
	 * @param order
	 * @param config
	 * @return
	 */
	private PayRequest createPayRequest(Order order, Config config) throws IllegalAccessException {
		PayRequest payRequest = new PayRequest();

		payRequest.setAppid(config.appId());
		payRequest.setAttach(order.getAttach());
		// 商品描述
		payRequest.setBody(order.getBody());
		payRequest.setDetail(order.getDetail());
		payRequest.setDevice_info(order.getDevice_info());
		payRequest.setFee_type(order.getFee_type());
		payRequest.setGoods_tag(order.getGoods_tag());
		payRequest.setMch_id(config.mchId());
		// 随机数创建
		payRequest.setNonce_str(RandomStringGenerator.getRandomStringByLength(20) + "");

		payRequest.setNotify_url(order.getNotify_url());
		// payRequest.setOpenid(openid);// 暂时用不到
		// 商户订单号
		payRequest.setOut_trade_no(order.getOut_trade_no());
		// 此id为二维码中包含的商品ID
		payRequest.setProduct_id(order.getProduct_id());

		payRequest.setSpbill_create_ip(order.getSpbill_create_ip());
		payRequest.setTime_expire(order.getTime_expire());
		payRequest.setTime_start(order.getTime_start());
		// 总金额
		payRequest.setTotal_fee(order.getTotal_fee());
		payRequest.setTrade_type(order.getTrade_type());

		// 签名
		Map<String, String> mapRequest = parseRequest(payRequest);
		String sign = Signature.getMapSign(mapRequest, config.key());
		payRequest.setSign(sign);

		return payRequest;

	}

	/**
	 * 将数据封装为map类型
	 * 
	 * @param payRequest
	 * @return
	 * @author Yujinshui
	 */
	public Map<String, String> parseRequest(PayRequest payRequest) {
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
		map.put("openid", payRequest.getOpenid());
		return map;
	}

	/**
	 * 退款操作
	 * 
	 * @param refund
	 * @param config
	 * @return
	 * @author Yujinshui
	 */
	private RefundRequest createPayRefundRequest(Refund refund, Config config) throws IllegalAccessException {
		RefundRequest payRefund = new RefundRequest();
		payRefund.setAppid(refund.getAppid());
		payRefund.setDevice_info(refund.getDevice_info());
		payRefund.setMch_id(refund.getMch_id());
		payRefund.setNonce_str(refund.getNonce_str());
		payRefund.setOp_user_id(refund.getOp_user_id());
		payRefund.setOut_refund_no(refund.getOut_refund_no());
		payRefund.setOut_trade_no(refund.getOut_trade_no());
		payRefund.setRefund_fee(refund.getRefund_fee());
		payRefund.setRefund_fee_type(refund.getRefund_fee_type());
		payRefund.setTotal_fee(refund.getTotal_fee());

		Map<String, String> parameters = parseMapReFundValue(payRefund);
		String sign = Signature.getMapSign(parameters, config.key());

		payRefund.setSign(sign);

		payRefund.setTotal_fee(refund.getTotal_fee());
		payRefund.setTransaction_id(refund.getTransaction_id());

		return payRefund;
	}

	@Override
	public String generatePayRefundXml(Refund refund, Config config) {
		RefundRequest values = null;
		try {
			values = createPayRefundRequest(refund, config);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		SortedMap<String, Object> parameters = getMapReFundValues(values);
		return XMLUtil.createXML(parameters);
	}

	private Map<String, String> parseMapReFundValue(RefundRequest value) {
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("appid", value.getAppid());
		parameters.put("mch_id", value.getMch_id());
		parameters.put("device_info", value.getDevice_info());
		parameters.put("nonce_str", value.getNonce_str());
		parameters.put("sign", value.getSign());
		parameters.put("out_trade_no", value.getOut_trade_no());
		parameters.put("total_fee", value.getTotal_fee() + "");
		parameters.put("op_user_id", value.getOp_user_id());
		parameters.put("out_refund_no", value.getOut_refund_no());
		parameters.put("refund_fee", value.getRefund_fee() + "");
		parameters.put("refund_fee_type", value.getRefund_fee_type());
		parameters.put("transaction_id", value.getTransaction_id());

		return parameters;
	}

	/**
	 * 将退款数据封装为map类型，创建xml数据
	 * 
	 * @param values
	 * @return
	 * @author Yujinshui
	 */
	private SortedMap<String, Object> getMapReFundValues(RefundRequest value) {
		SortedMap<String, Object> parameters = new TreeMap<String, Object>();
		parameters.put("appid", value.getAppid());
		parameters.put("mch_id", value.getMch_id());
		parameters.put("device_info", value.getDevice_info());
		parameters.put("nonce_str", value.getNonce_str());
		parameters.put("sign", value.getSign());
		parameters.put("out_trade_no", value.getOut_trade_no());
		parameters.put("total_fee", value.getTotal_fee());
		parameters.put("op_user_id", value.getOp_user_id());
		parameters.put("out_refund_no", value.getOut_refund_no());
		parameters.put("refund_fee", value.getRefund_fee());
		parameters.put("refund_fee_type", value.getRefund_fee_type());
		parameters.put("transaction_id", value.getTransaction_id());

		return parameters;
	}

}
