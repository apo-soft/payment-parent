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
public class RefundQueryRequest {

	/**
	 * 公众账号ID appid 是 String(32) wx8888888888888888 微信分配的公众账号ID
	 */
	private String appid;

	/**
	 * 商户号 mch_id 是 String(32)1900000109 微信支付分配的商户号
	 */
	private String mch_id;

	/**
	 * 设备号 device_info 否 String(32) 013467007045764 商户自定义的终端设备号，如门店编号、设备的ID等
	 */
	private String device_info;
	/**
	 * 随机字符串 nonce_str 是 String(32) 5K8264ILTKCH16CQ2502SI8ZNMTM67VS
	 * 商户系统内部的订单号,32个字符内、可包含字母, 其他说明见商户订单号
	 * 
	 */
	private String nonce_str;

	/**
	 * 签名 sign 是 String(32) C380BEC2BFD727A4B6845133519F3AD6 签名，详见签名生成算法
	 */
	private String sign;

	/**
	 * 微信订单号 transaction_id 否 String(28) 1217752501201407033233368018 微信订单号
	 * 
	 */
	private String transaction_id;

	/**
	 * 商户订单号 out_trade_no 是 String(32) 1217752501201407033233368018 商户系统内部的订单号
	 */
	private String out_trade_no;

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

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getMch_id() {
		return mch_id;
	}

	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}

	public String getDevice_info() {
		return device_info;
	}

	public void setDevice_info(String device_info) {
		this.device_info = device_info;
	}

	public String getNonce_str() {
		return nonce_str;
	}

	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
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
