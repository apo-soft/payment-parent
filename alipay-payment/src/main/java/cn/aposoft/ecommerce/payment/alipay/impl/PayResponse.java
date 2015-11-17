package cn.aposoft.ecommerce.payment.alipay.impl;

/**
 * 
 * 响应结果封装bean
 * <p>
 * 参数说明无官方解释，个人提供，仅供参考 以下属性以abc标记用途
 * 
 * @author Yujinshui
 */
public class PayResponse {

	/*************** 当返回内容无法正常解析时，直接进行原内容返回 ******************/
	/**
	 * 返回原始字符串[个人添加]
	 */
	private String returnXml;

	/**
	 * 返回原始字符串[个人添加]
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月15日 上午10:07:59
	 */
	public String getReturnXml() {
		return returnXml;
	}

	/**
	 * 返回原始字符串[个人添加]
	 * 
	 * @param returnXml
	 * @author Yujinshui
	 * @time 2015年11月15日 上午10:08:04
	 */
	public void setReturnXml(String returnXml) {
		this.returnXml = returnXml;
	}

	/**
	 * 请求是否成功[T:成功。F:失败]
	 */
	private String is_success;
	/**
	 * 签名类型
	 */
	private String sign_type;
	/************* 通用参数 ***************/
	/**
	 * 返回支付宝sign签名
	 */
	private String sign;

	/**
	 * 错误代码
	 * <p>
	 * 请求成功时，不存在本参 数；<br>
	 * 请求失败时，本参数为错误 代码，参见“ 10.2 接入错 误码”和“ 10.3 系统错误 码”。
	 */
	private String error;
	/**
	 * 响应码[SUCCESS/FAIL]
	 */
	private String result_code;
	/**
	 * 支付宝交易号
	 * <p>
	 * 该交易在支付宝系统中的交易 流水号。 最短 16 位，最长 64 位。
	 */
	private String trade_no;
	/**
	 * 商户网站 唯一订单 号
	 */
	private String out_trade_no;
	/**
	 * 凭证类型
	 * <p>
	 * 凭证类型，目前仅支持 （二维码）。 qrcode
	 */
	private String voucher_type;
	/**
	 * 二维码码串的内容。[用于生成二维码]
	 */
	private String qr_code;
	/**
	 * 二维码地址【图片尺寸：中】
	 */
	private String pic_url;
	/************* 成功返回参数 ***************/
	/**
	 * 二维码浏览器地址【图片尺寸：小】
	 */
	private String small_pic_url;
	/************* 失败返回参数 ***************/
	/**
	 * 详细错误码
	 * <p>
	 * 对返回响应码进行原因说明， 请参见“ 10.1 业务错误码”。 当 result_code 响应码为 SUCCESS 时，不返回该参数。
	 */
	private String detail_error_code;
	/**
	 * 错误码说明
	 */
	private String detail_error_des;

	/**
	 * 二维码浏览器地址【图片尺寸：大】
	 */
	private String big_pic_url;

	/**
	 * 返回支付宝sign签名
	 */
	public String getSign() {
		return sign;
	}

	/**
	 * 返回支付宝sign签名
	 */
	public void setSign(String sign) {
		this.sign = sign;
	}

	/**
	 * 签名类型
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月13日 下午4:38:09
	 */
	public String getSign_type() {
		return sign_type;
	}

	/**
	 * 签名类型
	 * 
	 * @param sign_type
	 * @author Yujinshui
	 * @time 2015年11月13日 下午4:38:24
	 */
	public void setSign_type(String sign_type) {
		this.sign_type = sign_type;
	}

	/**
	 * 返回标志码[SUCCESS/FAIL]
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月13日 下午4:38:34
	 */
	public String getResult_code() {
		return result_code;
	}

	/**
	 * 返回标志码[SUCCESS/FAIL]
	 * 
	 * @param result_code
	 * @author Yujinshui
	 * @time 2015年11月13日 下午4:38:39
	 */
	public void setResult_code(String result_code) {
		this.result_code = result_code;
	}

	/**
	 * 商户交易订单号
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月13日 下午4:38:45
	 */
	public String getOut_trade_no() {
		return out_trade_no;
	}

	/**
	 * 商户交易订单号
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月13日 下午4:38:45
	 */
	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	/**
	 * 请求是否成功[T:成功。F:失败]
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月13日 下午4:38:45
	 */
	public String getIs_success() {
		return is_success;
	}

	/**
	 * 请求是否成功[T:成功。F:失败]
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月13日 下午4:38:45
	 */
	public void setIs_success(String is_success) {
		this.is_success = is_success;
	}

	/**
	 * 错误码
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月13日 下午4:38:45
	 */
	public String getDetail_error_code() {
		return detail_error_code;
	}

	/**
	 * 错误码
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月13日 下午4:38:45
	 */
	public void setDetail_error_code(String detail_error_code) {
		this.detail_error_code = detail_error_code;
	}

	/**
	 * 错误码说明
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月13日 下午4:38:45
	 */
	public String getDetail_error_des() {
		return detail_error_des;
	}

	/**
	 * 错误码说明
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月13日 下午4:38:45
	 */
	public void setDetail_error_des(String detail_error_des) {
		this.detail_error_des = detail_error_des;
	}

	/**
	 * 二维码浏览器地址【图片尺寸：小】
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月13日 下午4:38:45
	 */
	public String getSmall_pic_url() {
		return small_pic_url;
	}

	/**
	 * 二维码浏览器地址【图片尺寸：小】
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月13日 下午4:38:45
	 */
	public void setSmall_pic_url(String small_pic_url) {
		this.small_pic_url = small_pic_url;
	}

	/**
	 * 收据类型
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月13日 下午4:38:45
	 */
	public String getVoucher_type() {
		return voucher_type;
	}

	/**
	 * 收据类型
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月13日 下午4:38:45
	 */
	public void setVoucher_type(String voucher_type) {
		this.voucher_type = voucher_type;
	}

	/**
	 * 二维码链接[用于生成二维码]
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月13日 下午4:38:45
	 */
	public String getQr_code() {
		return qr_code;
	}

	/**
	 * 二维码链接[用于生成二维码]
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月13日 下午4:38:45
	 */
	public void setQr_code(String qr_code) {
		this.qr_code = qr_code;
	}

	/**
	 * 二维码浏览器地址【图片尺寸：中】
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月13日 下午4:38:45
	 */
	public String getPic_url() {
		return pic_url;
	}

	/**
	 * 二维码浏览器地址【图片尺寸：中】
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月13日 下午4:38:45
	 */
	public void setPic_url(String pic_url) {
		this.pic_url = pic_url;
	}

	/**
	 * 二维码浏览器地址【图片尺寸：大】
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月13日 下午4:38:45
	 */
	public String getBig_pic_url() {
		return big_pic_url;
	}

	/**
	 * 二维码浏览器地址【图片尺寸：大】
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月13日 下午4:38:45
	 */
	public void setBig_pic_url(String big_pic_url) {
		this.big_pic_url = big_pic_url;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getTrade_no() {
		return trade_no;
	}

	public void setTrade_no(String trade_no) {
		this.trade_no = trade_no;
	}

}
