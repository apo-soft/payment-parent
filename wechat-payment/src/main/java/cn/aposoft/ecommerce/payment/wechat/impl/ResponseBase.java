package cn.aposoft.ecommerce.payment.wechat.impl;

/**
 * 支付，退款返回部分通用字段 查询xml样式 查询参数xml格式：
 * 
 * @author Yujinshui
 *
 */
public class ResponseBase {

	/**
	 * <font color=red>必需</font>-返回状态码
	 */
	private String return_code;
	/**
	 * 返回信息
	 */
	private String return_msg;
	/********** 以下字段在return_code为SUCCESS的时候有返回 **************/
	/**
	 * <font color=red>必需</font>-公众账号ID
	 */
	private String appid;
	/**
	 * <font color=red>必需</font>-商户号
	 */
	private String mch_id;
	/**
	 * 设备号
	 */
	private String device_info;
	/**
	 * <font color=red>必需</font>-随机字符串
	 */
	private String nonce_str;
	/**
	 * <font color=red>必需</font>-签名
	 */
	private String sign;
	/**
	 * <font color=red>必需</font>-业务结果
	 */
	private String result_code;
	/**
	
	 */
	private String err_code;
	/**
	 * 错误代码描述
	 */
	private String err_code_des;

	/**
	 * <font color=red>必需</font>-返回状态码
	 */
	public String getReturn_code() {
		return return_code;
	}

	/**
	 * <font color=red>必需</font>-返回状态码
	 */
	public void setReturn_code(String return_code) {
		this.return_code = return_code;
	}

	/**
	 * 返回信息
	 */
	public String getReturn_msg() {
		return return_msg;
	}

	/**
	 * 返回信息
	 */
	public void setReturn_msg(String return_msg) {
		this.return_msg = return_msg;
	}

	/**
	 * <font color=red>必需</font>-公众账号ID
	 */
	public String getAppid() {
		return appid;
	}

	/**
	 * <font color=red>必需</font>-公众账号ID
	 */
	public void setAppid(String appid) {
		this.appid = appid;
	}

	/**
	 * <font color=red>必需</font>-商户号
	 */
	public String getMch_id() {
		return mch_id;
	}

	/**
	 * <font color=red>必需</font>-商户号
	 */
	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}

	/**
	 * 设备号
	 */
	public String getDevice_info() {
		return device_info;
	}

	/**
	 * 设备号
	 */
	public void setDevice_info(String device_info) {
		this.device_info = device_info;
	}

	/**
	 * <font color=red>必需</font>-随机字符串
	 */
	public String getNonce_str() {
		return nonce_str;
	}

	/**
	 * <font color=red>必需</font>-随机字符串
	 */
	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}

	/**
	 * <font color=red>必需</font>-签名
	 */
	public String getSign() {
		return sign;
	}

	/**
	 * <font color=red>必需</font>-签名
	 */
	public void setSign(String sign) {
		this.sign = sign;
	}

	/**
	 * <font color=red>必需</font>-业务结果
	 */
	public String getResult_code() {
		return result_code;
	}

	/**
	 * <font color=red>必需</font>-业务结果
	 */
	public void setResult_code(String result_code) {
		this.result_code = result_code;
	}

	/**
	 * 错误代码
	 */
	public String getErr_code() {
		return err_code;
	}

	/**
	 * 错误代码
	 */
	public void setErr_code(String err_code) {
		this.err_code = err_code;
	}

	/**
	 * 错误代码描述
	 */
	public String getErr_code_des() {
		return err_code_des;
	}

	/**
	 * 错误代码描述
	 */
	public void setErr_code_des(String err_code_des) {
		this.err_code_des = err_code_des;
	}

}
