package cn.aposoft.ecommerce.payment.alipay.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;
import cn.aposoft.ecommerce.payment.alipay.Config;
import cn.aposoft.ecommerce.payment.alipay.Order;
import cn.aposoft.ecommerce.payment.alipay.Refund;
import cn.aposoft.ecommerce.payment.alipay.RefundResponse;
import cn.aposoft.ecommerce.payment.alipay.util.EntityUtil;
import cn.aposoft.ecommerce.payment.alipay.util.MapUtil;
import cn.aposoft.ecommerce.payment.alipay.util.XMLUtil;

public class SimpleEntityUtil implements EntityUtil {
	private static Logger logger = Logger.getLogger(SimpleEntityUtil.class);

	/**
	 * 将返回的xml字符串转换为javabean形式输出
	 * 
	 * @see cn.aposoft.ecommerce.payment.alipay.util.EntityUtil#parsePayResponseXml(java.lang.String,
	 *      cn.aposoft.ecommerce.payment.alipay.Config)
	 */
	@Override
	public PayResponse parsePayResponseXml(String xml, Config config) {
		Map<String, String> result = null;
		PayResponse response = null;
		try {
			result = XMLUtil.getMapFromXML(xml);
			response = getPayResponse(result);

			// 对返回结果进行MD5签名校验
			checkPayResponseSign(response, config);
		} catch (ParserConfigurationException | IOException | SAXException e) {
			logger.error("解析支付结果时发生错误: " + e.getMessage(), e);
			response = new PayResponse();
			response.setReturnXml(xml);
			// return null;
		}

		return response;
	}

	/**
	 * 将退款返回字符串封装为bean类型
	 * 
	 * @see cn.aposoft.ecommerce.payment.alipay.util.EntityUtil#parseRefundResponseXml(java.lang.String)
	 */
	@Override
	public RefundResponse parseRefundResponseXml(String resultXml, Config config) {
		RefundResponse res = null;
		Map<String, String> result = null;
		try {
			result = XMLUtil.getMapFromXML(resultXml);
			res = getRefundResponse(result);
			res.setRefund_detail_item_list(getRefund_detail_item_listContent(resultXml));
			// 对返回结果进行MD5签名校验
			checkRefundResponseSign(res, config);
		} catch (ParserConfigurationException | IOException | SAXException e) {
			logger.error("解析退款结果时发生错误: " + e.getMessage(), e);
			res = new RefundResponse();
			res.setResult(resultXml);
		}
		return res;
	}

	/**
	 * 单独解析refund_detail_item_list内容
	 * 
	 * @param xml
	 * @author Yujinshui
	 * @time 2015年11月18日 下午7:28:36
	 */
	private String getRefund_detail_item_listContent(String xml) {
		int start = xml.indexOf("<Refund_detail_item_list>");
		int end = xml.indexOf("</Refund_detail_item_list>") + "</Refund_detail_item_list>".length();
		String out = null;
		if (start > 0 && end > 0) {
			out = xml.substring(start, end);
		}
		return out;

	}

	/**
	 * 订单数据转换
	 * 
	 * @param params
	 * @author Yujinshui
	 * @time 2015年11月12日 上午10:24:37
	 */
	@Override
	public Map<String, String> generatePayMap(Order order, Config config) {
		checkConfig(config);
		Map<String, String> params = new HashMap<String, String>();
		// 基本参数
		params.put("service", order.getService());//
		params.put("partner", config.pid());//
		params.put("_input_charset", config.charset());//
		/****** sign在计算出结果之后与sign_type同时进行赋值 *******/
		// params.put("sign_type", order. getSign_type());
		// params.put("sign", order. getSign());
		// 业务参数
		params.put("out_trade_no", order.getOut_trade_no());
		params.put("subject", order.getSubject());
		params.put("product_code", order.getProduct_code());
		params.put("total_fee", order.getTotal_fee() + "");
		// 以下为可选参数，可选参数部分，如果有null值的，会导致MD5签名错误，故进行处理，具体哪个参数影响签名，未进行详细检测
		params.put("notify_url", order.getNotify_url() == null ? "" : order.getNotify_url());
		params.put("alipay_ca_request", order.getAlipay_ca_request() == null ? "" : order.getAlipay_ca_request());
		params.put("seller_id", order.getSeller_id() == null ? "" : order.getSeller_id());
		params.put("seller_email", order.getSeller_email() == null ? "" : order.getSeller_email());
		params.put("operator_code", order.getOperator_code() == null ? "" : order.getOperator_code());
		params.put("operator_id", order.getOperator_id() == null ? "" : order.getOperator_id());
		params.put("body", order.getBody() == null ? "" : order.getBody());
		params.put("show_url", order.getShow_url() == null ? "" : order.getShow_url());
		params.put("currency", order.getCurrency() == null ? "" : order.getCurrency());
		params.put("price", order.getPrice() == null ? "" : order.getPrice() + "");
		params.put("quantity", order.getQuantity() == null ? "" : order.getQuantity());
		params.put("goods_detail", order.getGoods_detail() == null ? "" : order.getGoods_detail());
		params.put("extend_params", order.getExtend_params() == null ? "" : order.getExtend_params());
		params.put("it_b_pay", order.getIt_b_pay() == null ? "" : order.getIt_b_pay());
		params.put("royalty_type", order.getRoyalty_type() == null ? "" : order.getRoyalty_type());
		params.put("royalty_parameters", order.getRoyalty_parameters() == null ? "" : order.getRoyalty_parameters());
		params.put("channel_parameters", order.getChannel_parameters() == null ? "" : order.getChannel_parameters());
		return params;
	}

	/**
	 * 退款请求数据：将bean数据转换为map数据
	 * 
	 * @see cn.aposoft.ecommerce.payment.alipay.util.EntityUtil#generateRefundMap(cn.aposoft.ecommerce.payment.alipay.Refund)
	 */
	@Override
	public Map<String, String> generateRefundMap(Refund refund, Config config) {

		checkConfig(config);

		Map<String, String> params = new HashMap<String, String>();
		// 必填
		params.put("service", refund.getService());
		params.put("partner", config.pid());
		params.put("_input_charset", config.charset());
		params.put("sign_type", config.sign_type());
		params.put("out_trade_no", refund.getOut_trade_no());
		params.put("refund_amount", refund.getRefund_amount().doubleValue() + "");
		// 选填
		params.put("alipay_ca_request", refund.getAlipay_ca_request() == null ? "" : refund.getAlipay_ca_request());
		params.put("trade_no", refund.getTrade_no() == null ? "" : refund.getTrade_no());
		params.put("out_request_no", refund.getOut_request_no() == null ? "" : refund.getOut_request_no());
		params.put("operator_type", refund.getOperator_type() == null ? "" : refund.getOperator_type());
		params.put("operator_id", refund.getOperator_id() == null ? "" : refund.getOperator_id());
		params.put("refund_reason", refund.getRefund_reason() == null ? "" : refund.getRefund_reason());
		params.put("ref_ids", refund.getRef_ids() == null ? "" : refund.getRef_ids());
		params.put("extend_params", refund.getExtend_params() == null ? "" : refund.getExtend_params());
		return params;
	}

	/**
	 * 赋值部分
	 * 
	 * @param result
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月13日 下午5:03:04
	 */
	private PayResponse getPayResponse(Map<String, String> result) {
		PayResponse response = new PayResponse();
		response.setBig_pic_url(result.get("big_pic_url"));
		response.setDetail_error_code(result.get("detail_error_code"));
		response.setDetail_error_des(result.get("detail_error_des"));
		response.setIs_success(result.get("is_success"));
		response.setOut_trade_no(result.get("out_trade_no"));
		response.setPic_url(result.get("pic_url"));
		response.setQr_code(result.get("qr_code"));
		response.setResult_code(result.get("result_code"));
		response.setSign(result.get("sign"));
		response.setSign_type(result.get("sign_type"));
		response.setSmall_pic_url(result.get("small_pic_url"));
		response.setVoucher_type(result.get("voucher_type"));
		response.setError(result.get("error"));
		response.setTrade_no(result.get("trade_no"));
		return response;
	}

	/**
	 * 退款返回集合-bean,赋值部分
	 * 
	 * @param result
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月17日 下午5:43:59
	 */
	private RefundResponse getRefundResponse(Map<String, String> result) {
		RefundResponse res = new RefundResponse();
		// 必填
		res.setIs_success(result.get("is_success"));
		res.setResult_code(result.get("result_code"));
		// 选填
		res.setBuyer_logon_id(result.get("buyer_logon_id"));
		res.setBuyer_user_id(result.get("buyer_user_id"));
		res.setDetail_error_code(result.get("detail_error_code"));
		res.setDetail_error_des(result.get("detail_error_des"));
		res.setError(result.get("error"));
		res.setFund_change(result.get("fund_change"));
		res.setGmt_refund_pay(result.get("gmt_refund_pay"));
		res.setOut_trade_no(result.get("out_trade_no"));
		res.setRefund_fee(result.get("refund_fee"));
		res.setSign(result.get("sign"));
		res.setSign_type(result.get("sign_type"));
		res.setTrade_no(result.get("trade_no"));

		return res;
	}

	/**
	 * 将返回结果字符串解析为map类型【供测试使用】
	 * 
	 * @see cn.aposoft.ecommerce.payment.alipay.util.EntityUtil#parseMapXml(java.lang.String)
	 * @deprecated
	 */
	@Override
	public Map<String, String> parseMapXml(String xml) {
		Map<String, String> result = null;
		try {
			result = XMLUtil.getMapFromXML(xml);
		} catch (ParserConfigurationException | IOException | SAXException e) {
			logger.error("解析结果时发生错误: " + e.getMessage(), e);
			return null;
		}
		return result;
	}

	/**
	 * 用于检查config的信息载入是否正确,只检测必填配置项
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

		if (config.pid() == null || config.pid().isEmpty()) {
			throw new IllegalArgumentException("合作身份者ID、以2088开头的pid不能为空.");
		}

		if (config.key() == null || config.key().isEmpty()) {
			throw new IllegalArgumentException("商户配置信息的key不能为空.");
		}

		if (config.charset() == null || config.charset().isEmpty()) {
			throw new IllegalArgumentException("商户配置信息的_input_charset(项目编码)不能为空.");
		}
		if (config.sign_type() == null || config.sign_type().isEmpty()) {
			throw new IllegalArgumentException("商户配置信息的签名类型sign_type不能为空.");
		}
		if (config.ali_gateway() == null || config.ali_gateway().isEmpty()) {
			throw new IllegalArgumentException("商户配置信息的支付宝通用网关接口ali_gateway不能为空.");
		}
	}

	/**
	 * 对支付宝同步返回的结果进行签名比对验证
	 * 
	 * @param response
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月18日 下午3:17:57
	 */
	private void checkPayResponseSign(PayResponse response, Config config) {
		Map<String, String> map = new HashMap<String, String>();
		if (response.getError() != null) {
			map.put("error", response.getError());
		} else {

			map.put("result_code", response.getResult_code() == null ? "" : response.getResult_code());
			map.put("trade_no", response.getTrade_no() == null ? "" : response.getTrade_no());
			map.put("out_trade_no", response.getOut_trade_no() == null ? "" : response.getOut_trade_no());
			map.put("voucher_type", response.getVoucher_type() == null ? "" : response.getVoucher_type());
			map.put("qr_code", response.getQr_code() == null ? "" : response.getQr_code());
			map.put("pic_url", response.getPic_url() == null ? "" : response.getPic_url());
			map.put("small_pic_url", response.getSmall_pic_url() == null ? "" : response.getSmall_pic_url());
			// TODO 支付宝pdf文档中缺失该参数说明【TODO在此表示需要注意】
			map.put("big_pic_url", response.getBig_pic_url() == null ? "" : response.getBig_pic_url());
			map.put("detail_error_code",
					response.getDetail_error_code() == null ? "" : response.getDetail_error_code());
			map.put("detail_error_des", response.getDetail_error_des() == null ? "" : response.getDetail_error_des());
		}
		// 此处进行支付宝返回值的签名创建，用于进行签名验证
		map = MapUtil.createMapRequest(map, config);
		response.setIsAliPay(map.get("sign").equals(response.getSign()));
		response.setLocalSign(map.get("sign"));
	}

	/**
	 * 对支付宝同步返回的结果进行签名比对验证
	 * <p>
	 * 
	 * @author Yujinshui
	 * @time 2015年11月18日 下午5:05:19
	 */
	private void checkRefundResponseSign(RefundResponse refund, Config config) {
		Map<String, String> map = new HashMap<String, String>();
		if (refund.getError() != null) {
			map.put("error", refund.getError());
		} else {
			map.put("result_code", refund.getResult_code() == null ? "" : refund.getResult_code());
			map.put("trade_no", refund.getTrade_no() == null ? "" : refund.getTrade_no());
			map.put("out_trade_no", refund.getOut_trade_no() == null ? "" : refund.getOut_trade_no());
			map.put("buyer_user_id", refund.getBuyer_user_id() == null ? "" : refund.getBuyer_user_id());
			map.put("buyer_logon_id", refund.getBuyer_logon_id() == null ? "" : refund.getBuyer_logon_id());
			map.put("fund_change", refund.getFund_change() == null ? "" : refund.getFund_change());
			map.put("refund_fee", refund.getRefund_fee() == null ? "" : refund.getRefund_fee());
			map.put("gmt_refund_pay", refund.getGmt_refund_pay() == null ? "" : refund.getGmt_refund_pay());
			map.put("detail_error_code", refund.getDetail_error_code() == null ? "" : refund.getDetail_error_code());
			map.put("detail_error_des", refund.getDetail_error_des() == null ? "" : refund.getDetail_error_des());

			// refund_detail_item_list内容！
			map.put("refund_detail_item_list",
					refund.getRefund_detail_item_list() == null ? "" : refund.getRefund_detail_item_list());
		}
		// 此处进行支付宝返回值的签名创建，用于进行签名验证
		map = MapUtil.createMapRequest(map, config);
		refund.setIsAliPay(map.get("sign").equals(refund.getSign()));
		refund.setLocalSign(map.get("sign"));
	}

}
