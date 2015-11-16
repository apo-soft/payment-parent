package cn.aposoft.ecommerce.payment.alipay.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import cn.aposoft.ecommerce.payment.alipay.Config;
import cn.aposoft.ecommerce.payment.alipay.Order;
import cn.aposoft.ecommerce.payment.alipay.Refund;
import cn.aposoft.ecommerce.payment.alipay.RefundRequest;
import cn.aposoft.ecommerce.payment.alipay.RefundResponse;
import cn.aposoft.ecommerce.payment.alipay.util.EntityUtil;
import cn.aposoft.ecommerce.payment.alipay.util.XMLUtil;

public class SimpleEntityUtil implements EntityUtil {
	private static Logger logger = Logger.getLogger(SimpleEntityUtil.class);

	/**
	 * 将返回的xml字符串转换为javabean形式输出
	 * 
	 * @see cn.aposoft.ecommerce.payment.alipay.util.EntityUtil#parsePayResponseXml(java.lang.String)
	 */
	@Override
	public PayResponse parsePayResponseXml(String xml) {
		Map<String, String> result = null;
		PayResponse response = null;
		try {
			result = XMLUtil.getMapFromXML(xml);
			response = getPayResponse(result);
		} catch (ParserConfigurationException | IOException | SAXException e) {
			logger.error("解析支付结果时发生错误: " + e.getMessage(), e);
			response = new PayResponse();
			response.setReturnXml(xml);
			// return null;
		}

		return response;
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
		return response;
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
			logger.error("解析支付结果时发生错误: " + e.getMessage(), e);
			return null;
		}
		return result;
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
		Map<String, String> params = new HashMap<String, String>();
		// params.put("", order);
		// 基本参数
		params.put("service", order.getService());//
		params.put("partner", config.pid());//
		params.put("_input_charset", config.charset());//
		// 业务参数
		params.put("out_trade_no", order.getOut_trade_no());//
		params.put("subject", order.getSubject());//
		params.put("payment_type", order.getPayment_type());
		params.put("total_fee", order.getTotal_fee() + "");//
		params.put("seller_id", order.getSeller_id());
		// params.put("notify_url",
		// "http://123.57.147.240:8087/svmservice/alipay/paySuccess");
		// params.put("seller_email", order.getSeller_email());
		// params.put("seller_account_name", order.getSeller_account_name());
		// params.put("qr_pay_mode", order.getQr_pay_mode());
		params.put("product_code", "QR_CODE_OFFLINE");// 目前属于固定参数，api无相关说明
		// TODO 其他参数尚未一一进行赋值处理
		return params;
	}

	/**
	 * 退款请求：将bean数据转换为map数据
	 * 
	 * @see cn.aposoft.ecommerce.payment.alipay.util.EntityUtil#generateRefundMap(cn.aposoft.ecommerce.payment.alipay.Refund)
	 */
	@Override
	public Map<String, String> generateRefundMap(Refund refund, Config config) {
		RefundRequest refundRequest = createRefundRequest(refund, config);
		Map<String, String> params = new HashMap<String, String>();

		params.put("service", refundRequest.getService());
		params.put("partner", refundRequest.getPartner());
		params.put("_input_charset", refundRequest.get_input_charset());
		params.put("sign_type", refundRequest.getSign_type());
		params.put("out_trade_no", refundRequest.getOut_trade_no());
		params.put("refund_amount",
				refundRequest.getRefund_amount().setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue() + "");
		return params;
	}

	/**
	 * 创建退款请求bean
	 * 
	 * @param refund
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月16日 下午2:09:30
	 */
	private RefundRequest createRefundRequest(Refund refund, Config config) {
		RefundRequest fund = new RefundRequest();
		fund.setService(refund.getService());
		fund.setPartner(config.pid());
		fund.set_input_charset(config.charset());
		fund.setSign_type(config.sign_type());
		fund.setOut_trade_no(refund.getOut_trade_no());
		fund.setRefund_amount(refund.getRefund_amount());

		return fund;
	}

	@Override
	public RefundResponse parseRefundResponseXml(String resultXml) {
		RefundResponse res = new RefundResponse();
		res.setResult(resultXml);
		return res;
	}

}
