package cn.aposoft.ecommerce.payment.alipay;

import java.util.Date;

/**
 * 支付成功后的回调结果解析后的值对象类
 * <p>
 * 调用者可直接进行实例化调用、存储
 * 
 * @author Yujinshui
 * @deprecated
 */
public class Notification {
	/**
	 * 通知时间*
	 * <p>
	 * 通知的发送时间。 格式为yyyy-MM-ddHH:mm:ss。
	 */
	private Date notify_time;
	/**
	 * 通知类型*
	 * <p>
	 */
	private String notify_type;
	/**
	 * 通知校验ID*
	 * <p>
	 */
	private String notify_id;
	/**
	 * 签名方式*
	 * <p>
	 * DSA、RSA、MD5三个值可选，必须大写。
	 */
	private String sign_type;
	/**
	 * 签名*
	 * <p>
	 */
	private String sign;
	/**
	 * 通知动作类型
	 * <p>
	 * 通知动作类型：创建： createDirectPayTradeBy BuyerAction<br>
	 * 支付： payByAccountAction<br>
	 * 退款：refundFPAction<br>
	 * 撤销：reverseAction<br>
	 * 关闭：closeTradeAction<br>
	 * 交易完成：finishFPAction
	 * 
	 */
	private String notify_action_type;
	/**
	 * 商户网站唯一订单号
	 * <p>
	 * 对应商户网站的订单系统中的唯一订单号，非支付宝交易号。<br>
	 * 需保证在商户网站中的唯一性。是请求时对应的参数，原样返回。
	 * 
	 */
	private String out_trade_no;
	/**
	 * 商品名称
	 * <p>
	 * 商品的标题/交易标题/订单标题/订单关键字等。<br>
	 * 它在支付宝的交易明细中排在第一列，对于财务对账尤为重要。是请求时对应的参数，原样通知回来。
	 * 
	 */
	private String subject;
	/**
	 * 支付宝交易号
	 * <p>
	 * 该交易在支付宝系统中的交易流水号。<br>
	 * 最短16位，最长64位。
	 * 
	 */
	private String trade_no;
	/**
	 * 交易状态
	 * <p>
	 * 交易目前所处的状态，取值范 围请参见“10.4交易状态”
	 * 
	 */
	private String trade_status;
	/**
	 * 交易创建时间
	 * <p>
	 * 该笔交易创建的时间。 格式为yyyy-MM-ddHH:mm:ss。
	 * 
	 */
	private Date gmt_create;
	/**
	 * 交易付款时间
	 * <p>
	 * 该笔交易的买家付款时间。 格式为yyyy-MM-ddHH:mm:ss。
	 * 
	 */
	private Date gmt_payment;
	/**
	 * 卖家支付宝账号
	 * <p>
	 * 卖家支付宝账号，可以是email和手机号码。
	 */
	private String seller_email;
	/**
	 * 买家支付宝账号
	 * <p>
	 * 买家支付宝账号，可以是 Email或手机号码。
	 * 
	 */
	private String buyer_email;
	/**
	 * 卖家支付宝用户号
	 * <p>
	 * 卖家支付宝账号对应的支付宝唯一用户号。 以2088开头的纯16位数字。
	 * 
	 */
	private String seller_id;
	/**
	 * 买家支付宝用户号
	 * <p>
	 * 买家支付宝账号对应的支付宝唯一用户号。 以2088开头的纯16位数字。
	 * 
	 */
	private String buyer_id;
	/**
	 * 商品单价
	 * <p>
	 * 对应请求时的price参数，原样通知回来
	 */
	private double price;
	/**
	 * 购买数量
	 * <p>
	 * 对应请求时的quantity参数，原样通知回来。
	 */
	private double quantity;
	/**
	 * 交易金额
	 * <p>
	 * 该笔订单的总金额。 请求时对应的参数，原样通知回来
	 * 
	 */
	private double total_fee;
	/**
	 * 商品描述
	 * <p>
	 * 该笔订单的备注、描述、明细等。 对应请求时的body参数，原样通知回来。
	 * 
	 */
	private String body;
	/**
	 * 退款金额
	 * <p>
	 * 退款通知中，返回退款金额，单位为元。
	 */
	private double refund_fee;
	/**
	 * 商户业务号
	 * <p>
	 * 商户业务ID，主要是退款通知中返回退款申请的流水号。
	 */
	private String out_biz_no;
	/**
	 * 支付金额信息
	 * <p>
	 * 支付成功的各个渠道金额信息，具体请参见“6.3支付金额信息说明”。
	 */
	private String paytools_pay_amount;
	/**
	 * 业务透传参数
	 * <p>
	 * 原样返回商户请求下单时的passback_parameters参数。
	 */
	private String extra_common_param;

	public Date getNotify_time() {
		return notify_time;
	}

	public void setNotify_time(Date notify_time) {
		this.notify_time = notify_time;
	}

	public String getNotify_type() {
		return notify_type;
	}

	public void setNotify_type(String notify_type) {
		this.notify_type = notify_type;
	}

	public String getNotify_id() {
		return notify_id;
	}

	public void setNotify_id(String notify_id) {
		this.notify_id = notify_id;
	}

	public String getSign_type() {
		return sign_type;
	}

	public void setSign_type(String sign_type) {
		this.sign_type = sign_type;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getNotify_action_type() {
		return notify_action_type;
	}

	public void setNotify_action_type(String notify_action_type) {
		this.notify_action_type = notify_action_type;
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTrade_no() {
		return trade_no;
	}

	public void setTrade_no(String trade_no) {
		this.trade_no = trade_no;
	}

	public String getTrade_status() {
		return trade_status;
	}

	public void setTrade_status(String trade_status) {
		this.trade_status = trade_status;
	}

	public Date getGmt_create() {
		return gmt_create;
	}

	public void setGmt_create(Date gmt_create) {
		this.gmt_create = gmt_create;
	}

	public Date getGmt_payment() {
		return gmt_payment;
	}

	public void setGmt_payment(Date gmt_payment) {
		this.gmt_payment = gmt_payment;
	}

	public String getSeller_email() {
		return seller_email;
	}

	public void setSeller_email(String seller_email) {
		this.seller_email = seller_email;
	}

	public String getBuyer_email() {
		return buyer_email;
	}

	public void setBuyer_email(String buyer_email) {
		this.buyer_email = buyer_email;
	}

	public String getSeller_id() {
		return seller_id;
	}

	public void setSeller_id(String seller_id) {
		this.seller_id = seller_id;
	}

	public String getBuyer_id() {
		return buyer_id;
	}

	public void setBuyer_id(String buyer_id) {
		this.buyer_id = buyer_id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getTotal_fee() {
		return total_fee;
	}

	public void setTotal_fee(double total_fee) {
		this.total_fee = total_fee;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public double getRefund_fee() {
		return refund_fee;
	}

	public void setRefund_fee(double refund_fee) {
		this.refund_fee = refund_fee;
	}

	public String getOut_biz_no() {
		return out_biz_no;
	}

	public void setOut_biz_no(String out_biz_no) {
		this.out_biz_no = out_biz_no;
	}

	public String getPaytools_pay_amount() {
		return paytools_pay_amount;
	}

	public void setPaytools_pay_amount(String paytools_pay_amount) {
		this.paytools_pay_amount = paytools_pay_amount;
	}

	public String getExtra_common_param() {
		return extra_common_param;
	}

	public void setExtra_common_param(String extra_common_param) {
		this.extra_common_param = extra_common_param;
	}

	public String toString() {
		return "notify_time:\r\n" + notify_time//
				+ "notify_type:\r\n" + notify_type//
				+ "notify_id:\r\n" + notify_id//
				+ "sign_type:\r\n" + sign_type//
				+ "sign:\r\n" + sign//
				+ "notify_action_type:\r\n" + notify_action_type//
				+ "out_trade_no:\r\n" + out_trade_no//
				+ "subject:\r\n" + subject//
				+ "trade_no:\r\n" + trade_no//
				+ "trade_status:\r\n" + trade_status//
				+ "gmt_create:\r\n" + gmt_create//
				+ "gmt_payment:\r\n" + gmt_payment//
				+ "seller_email:\r\n" + seller_email//
				+ "buyer_email:\r\n" + buyer_email//
				+ "seller_id:\r\n" + seller_id//
				+ "buyer_id:\r\n" + buyer_id//
				+ "price:\r\n" + price//
				+ "quantity:\r\n" + quantity//
				+ "total_fee:\r\n" + total_fee//
				+ "body:\r\n" + body//
				+ "refund_fee:\r\n" + refund_fee//
				+ "out_biz_no:\r\n" + out_biz_no//
				+ "paytools_pay_amount:\r\n" + paytools_pay_amount//
				+ "extra_common_param:" + extra_common_param; //
	}

}