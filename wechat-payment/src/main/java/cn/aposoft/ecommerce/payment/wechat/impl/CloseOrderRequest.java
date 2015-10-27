package cn.aposoft.ecommerce.payment.wechat.impl;

public class CloseOrderRequest {

	/**
	 * 公众账号ID appid 是 String(32) wx8888888888888888 微信分配的公众账号ID
	 */
	private String appid;

	/**
	 * 商户号 mch_id 是 String(32)1900000109 微信支付分配的商户号
	 */
	private String mch_id;

	/**
	 * 商户订单号 out_trade_no 否 String(32)1217752501201407033233368018 商户系统内部的订单号
	 */
	private String out_trade_no;

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

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
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
}
