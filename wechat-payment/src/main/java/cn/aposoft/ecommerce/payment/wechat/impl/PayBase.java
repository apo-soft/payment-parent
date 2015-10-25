package cn.aposoft.ecommerce.payment.wechat.impl;

/**
 * 包含支付，退款的通用字段信息,子类进行继承
 * 
 * @author Yujinshui(new add)
 *
 */
public class PayBase {
	private String appid; // 公众账号ID-
	private String mch_id; // 商户号-
	private String device_info; // 设备号-
	private String nonce_str; // 随机字符串-
	private String sign; // 签名-
	private String out_trade_no; // 商户订单号-商户支付的订单号由商户自定义生成
	private Integer total_fee; // 总金额-

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
	 * 
	 * @return
	 */
	public Integer getTotal_fee() {
		return total_fee;
	}

	/**
	 * 
	 * @param total_fee
	 */
	public void setTotal_fee(Integer total_fee) {
		this.total_fee = total_fee;
	}

	/**
	 * 
	 * @return
	 */
	public String getOut_trade_no() {
		return out_trade_no;
	}

	/**
	 * 商户支付的订单号 由商户自定义生成
	 * @param out_trade_no
	 */
	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

}
