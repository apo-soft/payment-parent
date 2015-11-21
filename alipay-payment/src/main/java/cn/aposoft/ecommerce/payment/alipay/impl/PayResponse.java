package cn.aposoft.ecommerce.payment.alipay.impl;

/**
 * 
 * 响应结果封装bean
 * <p>
 * <b>注意</b>： 以下参数得到后需要进行签名验证，比对支付宝返回的sign值是否一致<br>
 * error <br>
 * result_code <br>
 * trade_no <br>
 * out_trade_no <br>
 * voucher_type <br>
 * qr_code <br>
 * pic_url <br>
 * small_pic_url <br>
 * detail_error_code <br>
 * detail_error_des
 * 
 * 
 * @author Yujinshui
 */
public class PayResponse extends ResponseBase {

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
	/**
	 * 二维码浏览器地址【图片尺寸：大】
	 */
	private String big_pic_url;

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

	public String toString() {
		return "本地计算的签名值localSign：" + localSign //
				+ "\r\n <br> 解析失败时返回returnXml：" + returnXml //
				+ "\r\n <br> isAliPay：" + isAliPay //
				+ "\r\n <br> sign_type：" + sign_type //
				+ "\r\n <br> sign：" + sign //
				+ "\r\n <br> is_success：" + is_success //
				+ "\r\n <br> error：" + error //
				+ "\r\n <br> result_code：" + result_code //
				+ "\r\n <br> trade_no：" + trade_no //
				+ "\r\n <br> out_trade_no：" + out_trade_no //
				+ "\r\n <br> detail_error_code：" + detail_error_code //
				+ "\r\n <br> detail_error_des：" + detail_error_des //
				+ "\r\n <br> voucher_type：" + voucher_type //
				+ "\r\n <br> qr_code：" + qr_code //
				+ "\r\n <br> pic_url：" + pic_url //
				+ "\r\n <br> small_pic_url：" + small_pic_url //
				+ "\r\n <br> big_pic_url	：" + big_pic_url; // 
	}

}
