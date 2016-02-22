package cn.aposoft.ecommerce.payment.wechat.impl;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import org.apache.log4j.Logger;

import cn.aposoft.ecommerce.payment.wechat.EntityUtil;
import cn.aposoft.ecommerce.payment.wechat.util.CommonUtil;
import cn.aposoft.ecommerce.payment.wechat.util.Signature;
import cn.aposoft.ecommerce.payment.wechat.util.XMLUtil;

/**
 * 支付与退款的封装过程操作
 * 
 * @author Yujinshui
 *
 */
public class SimpleEntityUtil extends AbstractEntityUtil implements EntityUtil {

	private static final EntityUtil instance = new SimpleEntityUtil();
	private static Logger logger = Logger.getLogger(SimpleEntityUtil.class);

	public static final EntityUtil getInstance() {
		return instance;
	}

	private SimpleEntityUtil() {
	}

	/**
	 * 根据PayRequest创建待发送的xml字符串,供模板方法调用
	 * 
	 * @param values
	 *            {@code PayRequest} 支付请求内容
	 * @return 支付传输的xml文件格式
	 */
	@Override
	protected String generatePayXml(PayRequest values) {
		SortedMap<String, String> parameters = createPayMap(values);
		return XMLUtil.createXML(parameters);
	}

	/**
	 * 根据order和config创建待发送的xml字符串
	 * 
	 * @param values
	 *            {@code PayRequest} 支付请求内容
	 * @return 支付传输的xml文件格式
	 */
	@Override
	protected String createPaySign(PayRequest payRequest, String key) {
		// 签名
		Map<String, String> mapRequest = createPayMap(payRequest);
		return Signature.getMapSign(mapRequest, key);
	}

	/**
	 * {@code createPayTransferMap}将数据封装为map类型，用于创建XML数据
	 * 
	 * @param value
	 *            用于交易的订单内容
	 * @return 用于数据传输的Map类型数据
	 * @bugfix: 2015/10/27 重命名方法,可见性改为私有
	 */
	private SortedMap<String, String> createPayMap(PayRequest value) {
		SortedMap<String, String> parameters = new TreeMap<String, String>();
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
		parameters.put("total_fee", CommonUtil.toString(value.getTotal_fee()));
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
	 * 生成退款请求的xml字符串
	 * 
	 * @param values
	 *            退款请求的字段
	 * @return 退款请求的字符串
	 */
	@Override
	public String generateRefundXml(RefundRequest values) {
		SortedMap<String, String> parameters = createRefundMap(values);
		return XMLUtil.createXML(parameters);
	}

	// /**
	// * 创建退款传输的Xml字符串
	// */

	/**
	 * 计算退款的签名字符串
	 * 
	 * @param payRefund
	 *            退款请求的属性
	 * @param key
	 *            签名用key
	 */
	@Override
	protected String createRefundSign(RefundRequest payRefund, String key) {
		Map<String, String> map = createRefundMap(payRefund);
		return Signature.getMapSign(map, key);
	}

	/**
	 * {@code createReFundTransferMap}将退款数据封装为Map类型，用于创建构造post请求报文的XML文件
	 * 
	 * @param values
	 *            退款请求数据对象
	 * @return 用于生成支付xml文件的Map格式数据
	 * @author Yujinshui
	 */
	private SortedMap<String, String> createRefundMap(RefundRequest value) {
		SortedMap<String, String> parameters = new TreeMap<String, String>();
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

	@Override
	public String generateOrderQueryXml(OrderQueryRequest values) {
		SortedMap<String, String> parameters = createOrderQueryMap(values);
		return XMLUtil.createXML(parameters);
	}

	/**
	 * 计算订单查询的签名
	 */
	@Override
	protected String createOrderQuerySign(OrderQueryRequest values, String key) {
		Map<String, String> mapRequest = createOrderQueryMap(values);
		return Signature.getMapSign(mapRequest, key);
	}

	/**
	 * {@code createOrderQueryTransferMap}用于将Java订单查询对象转换为Map数据格式
	 * 
	 * @param request
	 *            订单查询请求对象
	 * @return 订单查询对象的Map表示形式
	 */
	private SortedMap<String, String> createOrderQueryMap(OrderQueryRequest request) {
		SortedMap<String, String> parameters = new TreeMap<String, String>();
		parameters.put("appid", request.getAppid());
		parameters.put("mch_id", request.getMch_id());

		parameters.put("out_trade_no", request.getOut_trade_no());
		parameters.put("transaction_id", request.getTransaction_id());
		parameters.put("nonce_str", request.getNonce_str());
		parameters.put("sign", request.getSign());
		return parameters;
	}

	/**
	 * 生成关闭订单xml报文
	 */
	@Override
	public String generateCloseOrderXml(CloseOrderRequest values) {
		SortedMap<String, String> parameters = createCloseOrderMap(values);
		return XMLUtil.createXML(parameters);
	}

	/**
	 * 生成关闭订单签名
	 */
	@Override
	protected String createCloseOrderSign(CloseOrderRequest request, String key) {
		// 签名
		Map<String, String> mapRequest = createCloseOrderMap(request);
		return Signature.getMapSign(mapRequest, key);
	}

	/**
	 * 创建关闭订单发送接口的Map数据格式
	 * 
	 * @param request
	 *            发送的关闭订单请求对象
	 * @return 返回对象对应的Map数据格式
	 */
	private SortedMap<String, String> createCloseOrderMap(CloseOrderRequest request) {
		SortedMap<String, String> parameters = new TreeMap<String, String>();
		parameters.put("appid", request.getAppid());
		parameters.put("mch_id", request.getMch_id());
		parameters.put("out_trade_no", request.getOut_trade_no());
		parameters.put("nonce_str", request.getNonce_str());
		parameters.put("sign", request.getSign());
		return parameters;
	}

	/**
	 * 微信退款查询请求对象转换,仅供内部使用
	 * 
	 * @param values
	 *            退款查询请求对象
	 * @return 退款查询请求xml文本
	 */
	public String createRefundQueryRequestXml(RefundQueryRequest values) {
		SortedMap<String, String> parameters = createRefundQueryMap(values);
		return XMLUtil.createXML(parameters);
	}

	// 创建退款查询的签名请求
	protected String createRefundQueryRequestSign(RefundQueryRequest request, String key) {
		// 签名
		Map<String, String> mapRequest = createRefundQueryMap(request);
		return Signature.getMapSign(mapRequest, key);
	}

	private SortedMap<String, String> createRefundQueryMap(RefundQueryRequest request) {
		SortedMap<String, String> parameters = new TreeMap<String, String>();
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

	private SortedMap<String, String> createDownloadBillMap(DownloadBillRequest request) {
		SortedMap<String, String> parameters = new TreeMap<String, String>();
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
	public String generateDownloadBillXml(DownloadBillRequest values) {
		SortedMap<String, String> parameters = createDownloadBillMap(values);
		return XMLUtil.createXML(parameters);
	}

	@Override
	protected String createDownloadBillSign(DownloadBillRequest request, String key) {
		// 签名
		Map<String, String> mapRequest = createDownloadBillMap(request);
		return Signature.getMapSign(mapRequest, key);
	}

}
