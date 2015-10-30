package cn.aposoft.ecommerce.payment.wechat.impl;

/**
 * 包含支付，退款的通用字段信息,子类进行继承
 * 
 * @author Yujinshui(new add)
 *
 */
public class RequestBase {
	/**
	 * 公众账号ID appid 是 String(32) wx8888888888888888 微信分配的公众账号ID
	 */
	private String appid;

	/**
	 * 商户号 mch_id 是 String(32) 1900000109 微信支付分配的商户号
	 */
	private String mch_id;

	/**
	 * 设备号 device_info 否 String(32) 013467007045764
	 * 微信支付分配的终端设备号，填写此字段，只下载该设备号的对账单
	 */
	private String device_info;
	/**
	 * 随机字符串 nonce_str 是 String(32) 5K8264ILTKCH16CQ2502SI8ZNMTM67VS
	 * 随机字符串，不长于32位。推荐随机数生成算法
	 */
	private String nonce_str;
	/**
	 * 签名 sign 是 String(32) C380BEC2BFD727A4B6845133519F3AD6 签名，详见签名生成算法
	 */
	private String sign;

	/**
	 * 商户订单号 out_trade_no 否 String(32)1217752501201407033233368018 商户系统内部的订单号
	 */
	private String out_trade_no; // 商户订单号-商户支付的订单号由商户自定义生成



	/**
	 * 公众账号ID
	 * 
	 * @return
	 */
	public String getAppid() {
		return appid;
	}

	/**
	 * 公众账号ID
	 * 
	 * @param appid
	 */
	public void setAppid(String appid) {
		this.appid = appid;
	}

	/**
	 * 商户号
	 * 
	 * @return
	 */
	public String getMch_id() {
		return mch_id;
	}

	/**
	 * 商户号
	 * 
	 * @param mch_id
	 */
	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}

	/**
	 * 
	 * @return
	 */
	public String getDevice_info() {
		return device_info;
	}

	/**
	 * 
	 * @param device_info
	 */
	public void setDevice_info(String device_info) {
		this.device_info = device_info;
	}

	/**
	 * 
	 * @return
	 */
	public String getNonce_str() {
		return nonce_str;
	}

	/**
	 * 
	 * @param nonce_str
	 */
	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}

	/**
	 * 
	 * @return
	 */
	public String getSign() {
		return sign;
	}

	/**
	 * 
	 * @param sign
	 */
	public void setSign(String sign) {
		this.sign = sign;
	}

	/**
	 * 商户订单号 String(32)
	 * 
	 * @return 返回商户订单号值
	 */
	public String getOut_trade_no() {
		return out_trade_no;
	}

	/**
	 * 商户支付的订单号 由商户自定义生成
	 * 
	 * @param out_trade_no
	 *            传入的商户订单号值
	 */
	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

}
