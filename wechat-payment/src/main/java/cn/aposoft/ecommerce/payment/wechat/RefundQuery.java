package cn.aposoft.ecommerce.payment.wechat;

/**
 * 微信支付退款查询请求参数接口
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
 * </pre>
 * <p>
 * 微信退款单号:
 * 
 * refund_id、out_refund_no、out_trade_no、transaction_id四个参数必填一个，如果同时存在优先级为：
 * 
 * refund_id>out_refund_no>transaction_id>out_trade_no
 * 
 * @author Jann Liu
 *	
 */
public interface RefundQuery {

	/**
	 * 设备号 device_info 否 String(32) 013467007045764 商户自定义的终端设备号，如门店编号、设备的ID等
	 * 
	 * @return 商户自定义设备号
	 */
	String getDevice_info();

	/**
	 * 微信订单号 transaction_id 否 String(28) 1217752501201407033233368018 微信订单号
	 * 
	 * @return ID字符串
	 */
	String getTransaction_id();

	/**
	 * 商户订单号 out_trade_no 是 String(32) 1217752501201407033233368018 商户系统内部的订单号
	 * 
	 * @return 商户自定义订单编号
	 */
	String getOut_trade_no();

	/**
	 * 商户退款单号 out_refund_no 否 String(32) 1217752501201407033233368018 商户退款单号
	 * 
	 * @return 退款编号
	 */
	String getOut_refund_no();

	/**
	 * 微信退款单号 refund_id 否 String(28) 1217752501201407033233368018
	 * 
	 * 微信退款单号
	 * 
	 * refund_id、out_refund_no、out_trade_no、transaction_id四个参数必填一个，如果同时存在优先级为：
	 * 
	 * refund_id>out_refund_no>transaction_id>out_trade_no
	 * 
	 * @return 退款ID
	 */
	String getRefund_id();

}