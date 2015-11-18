package cn.aposoft.ecommerce.payment.alipay;

import java.math.BigDecimal;

/**
 * 退款请求bean封装
 * 
 * @author Yujinshui
 *
 */
public class RefundRequest {

	/**
	 * 接口名称*
	 * <p>
	 * 接口名称。真实param<br>
	 * param_demo:refund_fastpay_by_platform_pwd
	 */
	private String service;
	/**
	 * 合作者身份ID*
	 * <p>
	 * 签约的支付宝账号对应的 支付宝唯一用户号。 以 2088 开头的 16 位纯数 字组成。 <br>
	 * param_demo:2088101008267254
	 */
	private String partner;
	/**
	 * 参数编码字符集*
	 * <p>
	 * 商户网站使用的编码格式， 如 utf-8、 gbk、 gb2312 等。<br>
	 * param_demo:utf-8
	 */
	private String _input_charset;
	/**
	 * 签名方式*
	 * <p>
	 * DSA、 RSA、 MD5 三个值 可选，必须大写。<br>
	 * param_demo:MD5
	 */
	private String sign_type;

	/**
	 * 签名类型
	 * <p>
	 * 签名类型。 1：证书签名 2：其他密钥签名 <br>
	 * 如果为空，默认为 2。
	 */
	private String alipay_ca_request;

	/********** 业务参数 ***********/
	/**
	 * 商户网站唯一订单号*
	 * <P>
	 * 支付宝合作商户网站唯一订 单号。
	 */
	private String out_trade_no;
	/**
	 * 退款金额*
	 * <P>
	 * 退款金额不能大于订单金 额，全额退款必须与订单金 额一致。
	 */
	private BigDecimal refund_amount;
	/**
	 * 支付宝交易号
	 * <P>
	 * 该交易在支付宝系统中的交 易流水号。<br>
	 * 最短 16 位，最长 64 位。<br>
	 * 如果同时传了 out_trade_no 和 trade_no，则以 trade_no 为准
	 */
	private String trade_no;
	/**
	 * 商户退款请求单号
	 * <P>
	 * 商户退款请求单号，用以标 识本次交易的退款请求。<br>
	 * 如果不传入本参数，则以 out_trade_no 填充本参数的 值。同时，认为本次请求为 全额退款，要求退款金额和 交易支付金额一致。
	 */
	private String out_request_no;
	/**
	 * 操作员类型
	 * <P>
	 * 操作员的类型：<br>
	 * 0：支付宝操作员<br>
	 * 1：商户的操作员<br>
	 * 如果传入其它值或者为空， 则默认设置为 1。
	 */

	private String operator_type;
	/**
	 * 操作员号
	 * <P>
	 * 卖家的操作员 ID。
	 */

	private String operator_id;
	/**
	 * 退款原因
	 * <P>
	 * 退款原因说明
	 */
	private String refund_reason;
	/**
	 * 业务关联ID集合
	 * <P>
	 * 业务关联ID集合，用于放置 商户的退款单号、退款流水 号等信息， json格式，具体请 参见“ 4.3 业务关联ID集合 说明”。
	 */
	private String ref_ids;
	/**
	 * 业务扩展信息
	 * <P>
	 * 用于商户退款业务信息的传 递，只有商户与支付宝约定 了传递此参数且约定了参数 含义，此参数才有效。 比如可传递条码支付场景下
	 * 的门店ID等信息，以json格式 传输，请参见“ 4.4 业务扩 展参数说明”。 可空 {"STORE_ID":"BJ_ZZ_0
	 * 01","STORE_TYPE":"0
	 */
	private String extend_params;

	/**
	 * 
	 * 接口名称*
	 * <p>
	 * 接口名称。真实param<br>
	 * param_demo:refund_fastpay_by_platform_pwd
	 * 
	 * @see cn.aposoft.ecommerce.payment.alipay.Refund#getService()
	 */

	public String getService() {
		return service;
	}

	/**
	 * 合作者身份ID*
	 * <p>
	 * 签约的支付宝账号对应的 支付宝唯一用户号。 以 2088 开头的 16 位纯数 字组成。 <br>
	 * param_demo:2088101008267254
	 * 
	 * @see cn.aposoft.ecommerce.payment.alipay.Refund#getPartner()
	 */

	public String getPartner() {
		return partner;
	}

	/**
	 * 参数编码字符集*
	 * <p>
	 * 商户网站使用的编码格式， 如 utf-8、 gbk、 gb2312 等。<br>
	 * param_demo:GBK
	 * 
	 * @see cn.aposoft.ecommerce.payment.alipay.Refund#get_input_charset()
	 */

	public String get_input_charset() {
		return _input_charset;
	}

	/**
	 * 签名方式*
	 * <p>
	 * DSA、 RSA、 MD5 三个值 可选，必须大写。<br>
	 * param_demo:MD5
	 * 
	 * @see cn.aposoft.ecommerce.payment.alipay.Refund#getSign_type()
	 */

	public String getSign_type() {
		return sign_type;
	}

	/**
	 * 
	 * 接口名称*
	 * <p>
	 * 接口名称。真实param<br>
	 * param_demo:refund_fastpay_by_platform_pwd
	 * 
	 * @param service
	 * @author Yujinshui
	 * @time 2015年11月16日 上午11:26:22
	 */
	public void setService(String service) {
		this.service = service;
	}

	/**
	 * 合作者身份ID*
	 * <p>
	 * 签约的支付宝账号对应的 支付宝唯一用户号。 以 2088 开头的 16 位纯数 字组成。 <br>
	 * param_demo:2088101008267254
	 * 
	 * @param partner
	 * @author Yujinshui
	 * @time 2015年11月16日 上午11:26:33
	 */
	public void setPartner(String partner) {
		this.partner = partner;
	}

	/**
	 * 参数编码字符集*
	 * <p>
	 * 商户网站使用的编码格式， 如 utf-8、 gbk、 gb2312 等。<br>
	 * param_demo:GBK
	 * 
	 * @param _input_charset
	 * @author Yujinshui
	 * @time 2015年11月16日 上午11:26:54
	 */
	public void set_input_charset(String _input_charset) {
		this._input_charset = _input_charset;
	}

	/**
	 * 签名方式*
	 * <p>
	 * DSA、 RSA、 MD5 三个值 可选，必须大写。<br>
	 * param_demo:MD5
	 * 
	 * @param sign_type
	 * @author Yujinshui
	 * @time 2015年11月16日 上午11:27:27
	 */
	public void setSign_type(String sign_type) {
		this.sign_type = sign_type;
	}

	public String getAlipay_ca_request() {
		return alipay_ca_request;
	}

	public void setAlipay_ca_request(String alipay_ca_request) {
		this.alipay_ca_request = alipay_ca_request;
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public BigDecimal getRefund_amount() {
		return refund_amount;
	}

	public void setRefund_amount(BigDecimal refund_amount) {
		this.refund_amount = refund_amount;
	}

	public String getTrade_no() {
		return trade_no;
	}

	public void setTrade_no(String trade_no) {
		this.trade_no = trade_no;
	}

	public String getOut_request_no() {
		return out_request_no;
	}

	public void setOut_request_no(String out_request_no) {
		this.out_request_no = out_request_no;
	}

	public String getOperator_type() {
		return operator_type;
	}

	public void setOperator_type(String operator_type) {
		this.operator_type = operator_type;
	}

	public String getOperator_id() {
		return operator_id;
	}

	public void setOperator_id(String operator_id) {
		this.operator_id = operator_id;
	}

	public String getRefund_reason() {
		return refund_reason;
	}

	public void setRefund_reason(String refund_reason) {
		this.refund_reason = refund_reason;
	}

	public String getRef_ids() {
		return ref_ids;
	}

	public void setRef_ids(String ref_ids) {
		this.ref_ids = ref_ids;
	}

	public String getExtend_params() {
		return extend_params;
	}

	public void setExtend_params(String extend_params) {
		this.extend_params = extend_params;
	}

}
