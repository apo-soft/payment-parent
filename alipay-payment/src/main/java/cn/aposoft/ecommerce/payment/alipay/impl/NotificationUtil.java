package cn.aposoft.ecommerce.payment.alipay.impl;

import java.util.HashMap;
import java.util.Map;

import cn.aposoft.ecommerce.payment.alipay.AliConfig;
import cn.aposoft.ecommerce.payment.alipay.util.MapUtil;

/**
 * 进行支付完成后的MD5签名验证
 * <p>
 * z 验证签名条件：在通知返回参数列表中，除去 sign、sign_type 两个参数外，凡是通知返回回来的参数皆是要签名的参数。
 * 
 * @author Yujinshui
 */
public class NotificationUtil {

	/**
	 * 根据支付宝返回的信息，进行签名验证
	 * 
	 * @param noti
	 * @param config
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月19日 下午12:36:17
	 */
	public static AliNotification checkAliSign(AliNotification noti, AliConfig config) {
		Map<String, String> map = new HashMap<String, String>();

		map.put("notify_time", noti.getNotify_time() == null ? "" : noti.getNotify_time());
		map.put("notify_type", noti.getNotify_type() == null ? "" : noti.getNotify_type());
		map.put("notify_id", noti.getNotify_id() == null ? "" : noti.getNotify_id());
		map.put("notify_action_type", noti.getNotify_action_type() == null ? "" : noti.getNotify_action_type());
		map.put("out_trade_no", noti.getOut_trade_no() == null ? "" : noti.getOut_trade_no());
		map.put("subject", noti.getSubject() == null ? "" : noti.getSubject());
		map.put("trade_no", noti.getTrade_no() == null ? "" : noti.getTrade_no());
		map.put("trade_status", noti.getTrade_status() == null ? "" : noti.getTrade_status());
		map.put("gmt_create", noti.getGmt_create() == null ? "" : noti.getGmt_create());
		map.put("gmt_payment", noti.getGmt_payment() == null ? "" : noti.getGmt_payment());
		map.put("seller_email", noti.getSeller_email() == null ? "" : noti.getSeller_email());
		map.put("buyer_email", noti.getBuyer_email() == null ? "" : noti.getBuyer_email());
		map.put("seller_id", noti.getSeller_id() == null ? "" : noti.getSeller_id());
		map.put("buyer_id", noti.getBuyer_id() == null ? "" : noti.getBuyer_id());
		map.put("price", noti.getPrice() == null ? "" : noti.getPrice());
		map.put("quantity", noti.getQuantity() == null ? "" : noti.getQuantity());
		map.put("total_fee", noti.getTotal_fee() == null ? "" : noti.getTotal_fee());
		map.put("body", noti.getBody() == null ? "" : noti.getBody());
		map.put("refund_fee", noti.getRefund_fee() == null ? "" : noti.getRefund_fee());
		map.put("out_biz_no", noti.getOut_biz_no() == null ? "" : noti.getOut_biz_no());
		map.put("paytools_pay_amount", noti.getPaytools_pay_amount() == null ? "" : noti.getPaytools_pay_amount());
		map.put("extra_common_param", noti.getExtra_common_param() == null ? "" : noti.getExtra_common_param());
		// 此处进行支付宝返回值的签名创建，用于进行签名验证
		map = MapUtil.createMapRequest(map, config);
		noti.setIsAliPay(map.get("sign").equals(noti.getSign()));

		return noti;
	}

}
