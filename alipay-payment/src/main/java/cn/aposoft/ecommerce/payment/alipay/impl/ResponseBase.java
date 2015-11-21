package cn.aposoft.ecommerce.payment.alipay.impl;

/**
 * 公共VO部分，包括request&response两部分
 * 
 * @author Yujinshui
 *
 */
public class ResponseBase {
	/**
	 * 根据支付宝返回信息生成的sign签名信息
	 * <p>
	 * 用于跟支付宝sign进行数据对比
	 */
	protected String localSign;

	/**
	 * 根据支付宝返回信息生成的sign签名信息
	 * <p>
	 * 用于跟支付宝sign进行数据对比
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月19日 下午4:26:49
	 */
	public String getLocalSign() {
		return localSign;
	}

	/**
	 * 根据支付宝返回信息生成的sign签名信息
	 * <p>
	 * 用于跟支付宝sign进行数据对比
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月19日 下午4:26:49
	 */
	public void setLocalSign(String localSign) {
		this.localSign = localSign;
	}

	/**
	 * 通过比对支付宝返回的sign签名，判断是否为true
	 * <p>
	 * true:是支付宝返回结果<br>
	 * false:警告！非支付宝返回结果
	 */
	protected boolean isAliPay;
	/**
	 * 签名方式
	 * <p>
	 * DSA、RSA、MD5三个值可选，必须大写。
	 */
	protected String sign_type;
	/**
	 * 签名
	 * <p>
	 * 请参见“7签名机制”。
	 */
	protected String sign;
	/******** 基本参数 *********/
	/**
	 * 请求是否成功*
	 * <p>
	 * 请求是否成功。请求成功不代表业务处理成功。<br>
	 * T代表成功<br>
	 * F代表失败
	 * 
	 */
	protected String is_success;
	/**
	 * 错误代码
	 * <p>
	 * 请求成功时，不存在本参数；<br>
	 * 请求失败时，本参数为错误代码，参见“8.2接入错误码”和“8.3系统错误码”。
	 * 
	 */
	protected String error;
	/******** 业务参数 *******/
	/**
	 * 响应码*
	 * <p>
	 * 退款处理结果响应码。 <br>
	 * SUCCESS：退款成功<br>
	 * FAIL：退款失败<br>
	 * UNKNOWN：结果未知
	 */
	protected String result_code;
	/**
	 * 支付宝交易号
	 * <p>
	 * 该交易在支付宝系统中的交易流水号。<br>
	 * 最短16位，最长64位。
	 * 
	 */
	protected String trade_no;
	/**
	 * 商户网站唯一订单号
	 * <p>
	 * 对应商户网站的订单系统中的唯一订单号，非支付宝交易号。需保证在商户网站中的唯一 性。是请求时对应的参数，原样返回。
	 * 
	 */
	protected String out_trade_no;
	/**
	 * 详细错误码
	 * <p>
	 * 对返回响应码进行原因说明，请参见“8.1业务错误码”。<br>
	 * 当result_code响应码为 SUCCESS时，不返回该参数。
	 * 
	 */
	protected String detail_error_code;
	/**
	 * 详细错误描述
	 * <p>
	 * 对详细错误码进行文字说明。<br>
	 * 当result_code响应码为 SUCCESS时，不返回该参数。
	 * 
	 */
	protected String detail_error_des;

	/**
	 * 通过比对支付宝返回的sign签名，判断是否为true
	 * <p>
	 * true:是支付宝返回结果<br>
	 * false:警告！非支付宝返回结果
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月18日 下午3:10:36
	 */
	public boolean getIsAliPay() {
		return isAliPay;
	}

	/**
	 * 通过比对支付宝返回的sign签名，判断是否为true
	 * <p>
	 * true:是支付宝返回结果<br>
	 * false:警告！非支付宝返回结果
	 * 
	 * @param isAliPay
	 * @author Yujinshui
	 * @time 2015年11月18日 下午3:10:41
	 */
	public void setIsAliPay(boolean isAliPay) {
		this.isAliPay = isAliPay;
	}

	/**
	 * 签名方式
	 * <p>
	 * DSA、RSA、MD5三个值可选，必须大写。
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月17日 下午5:25:01
	 */

	public String getSign_type() {
		return sign_type;
	}

	/**
	 * 签名方式
	 * <p>
	 * DSA、RSA、MD5三个值可选，必须大写。
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月17日 下午5:25:01
	 */

	public void setSign_type(String sign_type) {
		this.sign_type = sign_type;
	}

	/**
	 * 签名
	 * <p>
	 * 请参见“7签名机制”。
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月17日 下午5:25:01
	 */

	public String getSign() {
		return sign;
	}

	/**
	 * 签名
	 * <p>
	 * 请参见“7签名机制”。
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月17日 下午5:25:01
	 */

	public void setSign(String sign) {
		this.sign = sign;
	}

	/**
	 * 请求是否成功*
	 * <p>
	 * 请求是否成功。请求成功不代表业务处理成功。<br>
	 * T代表成功<br>
	 * F代表失败
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月17日 下午5:25:01
	 */
	public String getIs_success() {
		return is_success;
	}

	/**
	 * 请求是否成功*
	 * <p>
	 * 请求是否成功。请求成功不代表业务处理成功。<br>
	 * T代表成功<br>
	 * F代表失败
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月17日 下午5:25:01
	 */

	public void setIs_success(String is_success) {
		this.is_success = is_success;
	}

	/**
	 * 错误代码
	 * <p>
	 * 请求成功时，不存在本参数；<br>
	 * 请求失败时，本参数为错误代码，参见“8.2接入错误码”和“8.3系统错误码”。
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月17日 下午5:25:01
	 */

	public String getError() {
		return error;
	}

	/**
	 * 错误代码
	 * <p>
	 * 请求成功时，不存在本参数；<br>
	 * 请求失败时，本参数为错误代码，参见“8.2接入错误码”和“8.3系统错误码”。
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月17日 下午5:25:01
	 */

	public void setError(String error) {
		this.error = error;
	}

	/**
	 * 响应码*
	 * <p>
	 * 退款处理结果响应码。 <br>
	 * SUCCESS：退款成功<br>
	 * FAIL：退款失败<br>
	 * UNKNOWN：结果未知
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月17日 下午5:25:01
	 */

	public String getResult_code() {
		return result_code;
	}

	/**
	 * 响应码*
	 * <p>
	 * 退款处理结果响应码。 <br>
	 * SUCCESS：退款成功<br>
	 * FAIL：退款失败<br>
	 * UNKNOWN：结果未知
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月17日 下午5:25:01
	 */

	public void setResult_code(String result_code) {
		this.result_code = result_code;
	}

	/**
	 * 支付宝交易号
	 * <p>
	 * 该交易在支付宝系统中的交易流水号。<br>
	 * 最短16位，最长64位。
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月17日 下午5:25:01
	 */

	public String getTrade_no() {
		return trade_no;
	}

	/**
	 * 支付宝交易号
	 * <p>
	 * 该交易在支付宝系统中的交易流水号。<br>
	 * 最短16位，最长64位。
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月17日 下午5:25:01
	 */

	public void setTrade_no(String trade_no) {
		this.trade_no = trade_no;
	}

	/**
	 * 商户网站唯一订单号
	 * <p>
	 * 对应商户网站的订单系统中的唯一订单号，非支付宝交易号。需保证在商户网站中的唯一 性。是请求时对应的参数，原样返回。
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月17日 下午5:25:01
	 */

	public String getOut_trade_no() {
		return out_trade_no;
	}

	/**
	 * 商户网站唯一订单号
	 * <p>
	 * 对应商户网站的订单系统中的唯一订单号，非支付宝交易号。需保证在商户网站中的唯一 性。是请求时对应的参数，原样返回。
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月17日 下午5:25:01
	 */

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	/**
	 * 详细错误码
	 * <p>
	 * 对返回响应码进行原因说明，请参见“8.1业务错误码”。<br>
	 * 当result_code响应码为 SUCCESS时，不返回该参数。
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月17日 下午5:25:01
	 */

	public String getDetail_error_code() {
		return detail_error_code;
	}

	/**
	 * 详细错误码
	 * <p>
	 * 对返回响应码进行原因说明，请参见“8.1业务错误码”。<br>
	 * 当result_code响应码为 SUCCESS时，不返回该参数。
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月17日 下午5:25:01
	 */

	public void setDetail_error_code(String detail_error_code) {
		this.detail_error_code = detail_error_code;
	}

	/**
	 * 详细错误描述
	 * <p>
	 * 对详细错误码进行文字说明。<br>
	 * 当result_code响应码为 SUCCESS时，不返回该参数。
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月17日 下午5:25:01
	 */

	public String getDetail_error_des() {
		return detail_error_des;
	}

	/**
	 * 详细错误描述
	 * <p>
	 * 对详细错误码进行文字说明。<br>
	 * 当result_code响应码为 SUCCESS时，不返回该参数。
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月17日 下午5:25:01
	 */

	public void setDetail_error_des(String detail_error_des) {
		this.detail_error_des = detail_error_des;
	}

}
