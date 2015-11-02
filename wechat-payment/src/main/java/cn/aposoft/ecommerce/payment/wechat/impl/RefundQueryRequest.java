/**
 * 
 */
package cn.aposoft.ecommerce.payment.wechat.impl;

/**
 * 查询退款请求对象实体
 * 
 * <pre>
 <xml>
   <appid>wx2421b1c4370ec43b</appid>
   <mch_id>10000100</mch_id>
   <nonce_str>0b9f35f484df17a732e537c37708d1d0</nonce_str>
   <out_refund_no></out_refund_no>
   <out_trade_no>1415757673</out_trade_no>
   <refund_id></refund_id>
   <transaction_id></transaction_id>
   <sign>66FFB727015F450D167EF38CCC549521</sign>
</xml>
 * 
 * </pre>
 * 
 * @author Jann Liu
 *
 */
public class RefundQueryRequest extends RequestBase {

	/**
	 * 微信订单号 transaction_id 否 String(28) 1217752501201407033233368018 微信订单号
	 * 
	 */
	private String transaction_id;

	// private String out_trade_no;// 商户订单号 --// base
	/**
	 * 商户退款单号 out_refund_no 否 String(32) 1217752501201407033233368018 商户退款单号
	 * 
	 */
	private String out_refund_no;

	/**
	 * 微信退款单号 refund_id 否 String(28) 1217752501201407033233368018
	 * 
	 * 微信退款单号
	 * refund_id、out_refund_no、out_trade_no、transaction_id四个参数必填一个，如果同时存在优先级为：
	 * 
	 * refund_id>out_refund_no>transaction_id>out_trade_no
	 */
	private String refund_id;

	public String getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}

	public String getOut_refund_no() {
		return out_refund_no;
	}

	public void setOut_refund_no(String out_refund_no) {
		this.out_refund_no = out_refund_no;
	}

	public String getRefund_id() {
		return refund_id;
	}

	public void setRefund_id(String refund_id) {
		this.refund_id = refund_id;
	}

}
