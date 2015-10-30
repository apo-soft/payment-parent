/**
 * 
 */
package cn.aposoft.ecommerce.payment.wechat;

/**
 * 支付响应对象
 * 
 * @author Jann Liu
 *
 */
public class PayResponse extends ResponseBase {
	/************ 以下字段在return_code 和result_code都为SUCCESS的时候有返回 ****************/
	/**
	 * <font color=red>必需</font>-交易类型
	 */
	private String trade_type;
	/**
	 * <font color=red>必需</font>-预支付交易会话标识
	 */
	private String prepay_id;
	/**
	 * 二维码链接 code_url 否 String(64)
	 * <p>
	 * URl：weixin://wxpay/s/An4baqw
	 * <p>
	 * trade_type为NATIVE是有返回，可将该参数值生成二维码展示出来进行扫码支付
	 */
	private String code_url;

	/**
	 * <font color=red>必需</font>-交易类型
	 */
	public String getTrade_type() {
		return trade_type;
	}

	/**
	 * <font color=red>必需</font>-交易类型
	 */
	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}

	/**
	 * <font color=red>必需</font>-预支付交易会话标识
	 */
	public String getPrepay_id() {
		return prepay_id;
	}

	/**
	 * <font color=red>必需</font>-预支付交易会话标识
	 */
	public void setPrepay_id(String prepay_id) {
		this.prepay_id = prepay_id;
	}

	/**
	 * 二维码链接
	 */
	public String getCode_url() {
		return code_url;
	}

	/**
	 * 二维码链接
	 */
	public void setCode_url(String code_url) {
		this.code_url = code_url;
	}

}
