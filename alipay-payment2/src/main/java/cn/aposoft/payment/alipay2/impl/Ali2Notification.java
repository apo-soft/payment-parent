package cn.aposoft.payment.alipay2.impl;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 新版-支付成功后的回调结果解析后的值对象类
 * <p>
 * 1.必须保证服务器异步通知页面（notify_url）上无任何字符，如空格、HTML标签、开发系统自带抛出的异常提示信息等；<br>
 * 2.支付宝是用POST方式发送通知信息，因此该页面中获取参数的方式，如：request.Form(“out_trade_no”)、$_POST[‘
 * out_trade_no’]；<br>
 * 3.支付宝主动发起通知，该方式才会被启用；<br>
 * 4.只有在支付宝的交易管理中存在该笔交易，且发生了交易状态的改变，支付宝才会通过该方式发起服务器通知（即时到账中交易状态为“等待买家付款”
 * 的状态默认是不会发送通知的）；<br>
 * 5.服务器间的交互，不像页面跳转同步通知可以在页面上显示出来，这种交互方式是不可见的；<br>
 * 6.第一次交易状态改变（即时到账中此时交易状态是交易完成）时，不仅页面跳转同步通知页面会启用，而且服务器异步通知页面也会收到支付宝发来的处理结果通知；
 * <br>
 * 7.程序执行完后必须打印输出“success”（不包含引号）。如果商户反馈给支付宝的字符不是success这7个字符，支付宝服务器会不断重发通知，
 * 直到超过24小时22分钟。一般情况下，25小时以内完成8次通知（通知的间隔频率一般是：2m,10m,10m,1h,2h,6h,15h）；<br>
 * 8.程序执行完成后，该页面不能执行页面跳转。如果执行页面跳转，支付宝会收不到success字符，会被支付宝服务器判定为该页面程序运行出现异常，
 * 而重发处理结果通知；<br>
 * 9.cookies、session等在此页面会失效，即无法获取这些数据；<br>
 * 10.该方式的调试与运行必须在服务器上，即互联网上能访问；<br>
 * 11.该方式的作用主要防止订单丢失，即页面跳转同步通知没有处理订单更新，它则去处理；<br>
 * 12.当商户收到服务器异步通知并打印出success时，服务器异步通知参数notify_id才会失效。也就是说在支付宝发送同一条异步通知时（
 * 包含商户并未成功打印出success导致支付宝重发数次通知），服务器异步通知参数notify_id是不变的。<br>
 * <br>
 * 
 * @author Yujinshui
 *
 */
public class Ali2Notification {

	/**
	 * 通知时间*
	 * <p>
	 * 通知的发送时间。格式为yyyy-MM-dd HH:mm:ss。 <br>
	 * param_demo: 2009-08-12 11:08:32
	 */
	private Date notify_time;
	/**
	 * 通知类型*
	 * <p>
	 * 通知的类型。 <br>
	 * param_demo: trade_status_sync
	 */
	private String notify_type;
	/**
	 * 通知校验ID*
	 * <p>
	 * 通知校验ID。 <br>
	 * param_demo: 70fec0c2730b27528665af4517c27b95
	 */
	private String notify_id;
	/**
	 * 签名方式*
	 * <p>
	 * DSA、RSA、MD5三个值可选，必须大写。 <br>
	 * param_demo: DSA
	 */
	private String sign_type;
	/**
	 * 签名*
	 * <p>
	 * 请参见签名验证。 <br>
	 * param_demo: _p_w_l_h_j0b_gd_aejia7n_ko4_m%
	 * 2Fu_w_jd3_nx_s_k_mxus9_hoxg_y_r_lunli_pmma29_t_q%3D
	 */
	private String sign;
	/**
	 * 商户网站唯一订单号
	 * <p>
	 * 对应商户网站的订单系统中的唯一订单号，非支付宝交易号。需保证在商户网站中的唯一性。是请求时对应的参数，原样返回。 <br>
	 * param_demo: 3618810634349901
	 */
	private String out_trade_no;
	/**
	 * 商品名称
	 * <p>
	 * 商品的标题/交易标题/订单标题/订单关键字等。它在支付宝的交易明细中排在第一列，对于财务对账尤为重要。是请求时对应的参数，原样通知回来。 <br>
	 * param_demo: phone手机
	 */
	private String subject;
	/**
	 * 支付类型
	 * <p>
	 * 取值范围请参见收款类型。 <br>
	 * param_demo: 1
	 */
	private String payment_type;
	/**
	 * 支付宝交易号
	 * <p>
	 * 该交易在支付宝系统中的交易流水号。最长64位。 <br>
	 * param_demo: 2014040311001004370000361525
	 */
	private String trade_no;
	/**
	 * 交易状态
	 * <p>
	 * 取值范围请参见交易状态。 <br>
	 * param_demo: TRADE_FINISHED
	 */
	private String trade_status;
	/**
	 * 交易创建时间
	 * <p>
	 * 该笔交易创建的时间。格式为yyyy-MM-dd HH:mm:ss。 <br>
	 * param_demo: 2008-10-22 20:49:31
	 */
	private Date gmt_create;
	/**
	 * 交易付款时间
	 * <p>
	 * 该笔交易的买家付款时间。格式为yyyy-MM-dd HH:mm:ss。 <br>
	 * param_demo: 2008-10-22 20:49:50
	 */
	private Date gmt_payment;
	/**
	 * 交易关闭时间
	 * <p>
	 * 交易关闭时间。格式为yyyy-MM-dd HH:mm:ss。 <br>
	 * param_demo: 2008-10-22 20:49:46
	 */
	private Date gmt_close;
	/**
	 * 退款状态
	 * <p>
	 * 取值范围请参见退款状态。 <br>
	 * param_demo: REFUND_SUCCESS
	 */
	private String refund_status;
	/**
	 * 退款时间
	 * <p>
	 * 卖家退款的时间，退款通知时会发送。格式为yyyy-MM-dd HH:mm:ss。 <br>
	 * param_demo: 2008-10-29 19:38:25
	 */
	private Date gmt_refund;
	/**
	 * 卖家支付宝账号
	 * <p>
	 * 卖家支付宝账号，可以是email和手机号码。 <br>
	 * param_demo: chao.chenc1@alipay.com
	 */
	private String seller_email;
	/**
	 * 买家支付宝账号
	 * <p>
	 * 买家支付宝账号，可以是Email或手机号码。 <br>
	 * param_demo: 13758698870
	 */
	private String buyer_email;
	/**
	 * 卖家支付宝账户号
	 * <p>
	 * 卖家支付宝账号对应的支付宝唯一用户号。以2088开头的纯16位数字。 <br>
	 * param_demo: 2088002007018916
	 */
	private String seller_id;
	/**
	 * 买家支付宝账户号
	 * <p>
	 * 买家支付宝账号对应的支付宝唯一用户号。以2088开头的纯16位数字。 <br>
	 * param_demo: 2088002007013600
	 */
	private String buyer_id;
	/**
	 * 商品单价
	 * <p>
	 * 如果请求时使用的是total_fee，那么price等于total_fee；如果请求时使用的是price，那么对应请求时的price参数，
	 * 原样通知回来。 <br>
	 * param_demo: 10.00
	 */
	private BigDecimal price;
	/**
	 * 交易金额
	 * <p>
	 * 该笔订单的总金额。请求时对应的参数，原样通知回来。 <br>
	 * param_demo: 10.00
	 */
	private BigDecimal total_fee;
	/**
	 * 购买数量
	 * <p>
	 * 如果请求时使用的是total_fee，那么quantity等于1；如果请求时使用的是quantity，那么对应请求时的quantity参数，
	 * 原样通知回来。 <br>
	 * param_demo: 1
	 */
	private BigDecimal quantity;
	/**
	 * 商品描述
	 * <p>
	 * 该笔订单的备注、描述、明细等。对应请求时的body参数，原样通知回来。 <br>
	 * param_demo: Hello
	 */
	private String body;
	/**
	 * 折扣
	 * <p>
	 * 支付宝系统会把discount的值加到交易金额上，如果需要折扣，本参数为负数。 <br>
	 * param_demo: -5
	 */
	private BigDecimal discount;
	/**
	 * 是否调整总价
	 * <p>
	 * 该交易是否调整过价格。 <br>
	 * param_demo: N
	 */
	private String is_total_fee_adjust;
	/**
	 * 是否使用红包买家
	 * <p>
	 * 是否在交易过程中使用了红包。 <br>
	 * param_demo: N
	 */
	private String use_coupon;
	/**
	 * 公用回传参数
	 * <p>
	 * 用于商户回传参数，该值不能包含“=”、“&”等特殊字符。如果用户请求时传递了该参数，则返回给商户时会回传该参数。 <br>
	 * param_demo: 你好，这是测试商户的广告。
	 */
	private String extra_common_param;
	/**
	 * 支付渠道组合信息
	 * <p>
	 * 该笔交易所使用的支付渠道。格式为：渠道1|渠道2|…，如果有多个渠道，用“|”隔开。取值范围请参见渠道类型说明与币种列表。 <br>
	 * param_demo: OPTIMIZED_MOTO|BALANCE
	 */
	private String out_channel_type;
	/**
	 * 支付金额组合信息
	 * <p>
	 * 该笔交易通过使用各支付渠道所支付的金额。格式为：金额1|金额2|…，如果有多个支付渠道，各渠道所支付金额用“|”隔开。 <br>
	 * param_demo: 90.00|10.00
	 */
	private String out_channel_amount;
	/**
	 * 实际支付渠道
	 * <p>
	 * 该交易支付时实际使用的银行渠道。格式为：支付渠道1|支付渠道2|…，如果有多个支付渠道，用“|”隔开。取值范围请参见实际支付渠道列表。
	 * 该参数需要联系支付宝开通。<br>
	 * param_demo: ICBC
	 */
	private String out_channel_inst;
	/**
	 * 是否扫码支付
	 * <p>
	 * 回传给商户此标识为qrpay时，表示对应交易为扫码支付。目前只有qrpay一种回传值。非扫码支付方式下，目前不会返回该参数。 <br>
	 * param_demo: qrpay
	 */
	private String business_scene;

	/**
	 * 通知时间*
	 * <p>
	 * 通知的发送时间。格式为yyyy-MM-dd HH:mm:ss。 <br>
	 * param_demo: 2009-08-12 11:08:32
	 */
	public Date getNotify_time() {
		return notify_time;
	}

	/**
	 * 通知时间*
	 * <p>
	 * 通知的发送时间。格式为yyyy-MM-dd HH:mm:ss。 <br>
	 * param_demo: 2009-08-12 11:08:32
	 */
	public void setNotify_time(Date notify_time) {
		this.notify_time = notify_time;
	}

	/**
	 * 通知类型*
	 * <p>
	 * 通知的类型。 <br>
	 * param_demo: trade_status_sync
	 */
	public String getNotify_type() {
		return notify_type;
	}

	/**
	 * 通知类型*
	 * <p>
	 * 通知的类型。 <br>
	 * param_demo: trade_status_sync
	 */
	public void setNotify_type(String notify_type) {
		this.notify_type = notify_type;
	}

	/**
	 * 通知校验ID*
	 * <p>
	 * 通知校验ID。 <br>
	 * param_demo: 70fec0c2730b27528665af4517c27b95
	 */
	public String getNotify_id() {
		return notify_id;
	}

	/**
	 * 通知校验ID*
	 * <p>
	 * 通知校验ID。 <br>
	 * param_demo: 70fec0c2730b27528665af4517c27b95
	 */
	public void setNotify_id(String notify_id) {
		this.notify_id = notify_id;
	}

	/**
	 * 签名方式*
	 * <p>
	 * DSA、RSA、MD5三个值可选，必须大写。 <br>
	 * param_demo: DSA
	 */
	public String getSign_type() {
		return sign_type;
	}

	/**
	 * 签名方式*
	 * <p>
	 * DSA、RSA、MD5三个值可选，必须大写。 <br>
	 * param_demo: DSA
	 */
	public void setSign_type(String sign_type) {
		this.sign_type = sign_type;
	}

	/**
	 * 签名*
	 * <p>
	 * 请参见签名验证。 <br>
	 * param_demo: _p_w_l_h_j0b_gd_aejia7n_ko4_m%
	 * 2Fu_w_jd3_nx_s_k_mxus9_hoxg_y_r_lunli_pmma29_t_q%3D
	 */
	public String getSign() {
		return sign;
	}

	/**
	 * 签名*
	 * <p>
	 * 请参见签名验证。 <br>
	 * param_demo: _p_w_l_h_j0b_gd_aejia7n_ko4_m%
	 * 2Fu_w_jd3_nx_s_k_mxus9_hoxg_y_r_lunli_pmma29_t_q%3D
	 */
	public void setSign(String sign) {
		this.sign = sign;
	}

	/**
	 * 商户网站唯一订单号
	 * <p>
	 * 对应商户网站的订单系统中的唯一订单号，非支付宝交易号。需保证在商户网站中的唯一性。是请求时对应的参数，原样返回。 <br>
	 * param_demo: 3618810634349901
	 */
	public String getOut_trade_no() {
		return out_trade_no;
	}

	/**
	 * 商户网站唯一订单号
	 * <p>
	 * 对应商户网站的订单系统中的唯一订单号，非支付宝交易号。需保证在商户网站中的唯一性。是请求时对应的参数，原样返回。 <br>
	 * param_demo: 3618810634349901
	 */
	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	/**
	 * 商品名称
	 * <p>
	 * 商品的标题/交易标题/订单标题/订单关键字等。它在支付宝的交易明细中排在第一列，对于财务对账尤为重要。是请求时对应的参数，原样通知回来。 <br>
	 * param_demo: phone手机
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * 商品名称
	 * <p>
	 * 商品的标题/交易标题/订单标题/订单关键字等。它在支付宝的交易明细中排在第一列，对于财务对账尤为重要。是请求时对应的参数，原样通知回来。 <br>
	 * param_demo: phone手机
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * 支付类型
	 * <p>
	 * 取值范围请参见收款类型。 <br>
	 * param_demo: 1
	 */
	public String getPayment_type() {
		return payment_type;
	}

	/**
	 * 支付类型
	 * <p>
	 * 取值范围请参见收款类型。 <br>
	 * param_demo: 1
	 */
	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}

	/**
	 * 支付宝交易号
	 * <p>
	 * 该交易在支付宝系统中的交易流水号。最长64位。 <br>
	 * param_demo: 2014040311001004370000361525
	 */
	public String getTrade_no() {
		return trade_no;
	}

	/**
	 * 支付宝交易号
	 * <p>
	 * 该交易在支付宝系统中的交易流水号。最长64位。 <br>
	 * param_demo: 2014040311001004370000361525
	 */
	public void setTrade_no(String trade_no) {
		this.trade_no = trade_no;
	}

	/**
	 * 交易状态
	 * <p>
	 * 取值范围请参见交易状态。 <br>
	 * param_demo: TRADE_FINISHED
	 */
	public String getTrade_status() {
		return trade_status;
	}

	/**
	 * 交易状态
	 * <p>
	 * 取值范围请参见交易状态。 <br>
	 * param_demo: TRADE_FINISHED
	 */
	public void setTrade_status(String trade_status) {
		this.trade_status = trade_status;
	}

	/**
	 * 交易创建时间
	 * <p>
	 * 该笔交易创建的时间。格式为yyyy-MM-dd HH:mm:ss。 <br>
	 * param_demo: 2008-10-22 20:49:31
	 */
	public Date getGmt_create() {
		return gmt_create;
	}

	/**
	 * 交易创建时间
	 * <p>
	 * 该笔交易创建的时间。格式为yyyy-MM-dd HH:mm:ss。 <br>
	 * param_demo: 2008-10-22 20:49:31
	 */
	public void setGmt_create(Date gmt_create) {
		this.gmt_create = gmt_create;
	}

	/**
	 * 交易付款时间
	 * <p>
	 * 该笔交易的买家付款时间。格式为yyyy-MM-dd HH:mm:ss。 <br>
	 * param_demo: 2008-10-22 20:49:50
	 */
	public Date getGmt_payment() {
		return gmt_payment;
	}

	/**
	 * 交易付款时间
	 * <p>
	 * 该笔交易的买家付款时间。格式为yyyy-MM-dd HH:mm:ss。 <br>
	 * param_demo: 2008-10-22 20:49:50
	 */
	public void setGmt_payment(Date gmt_payment) {
		this.gmt_payment = gmt_payment;
	}

	/**
	 * 交易关闭时间
	 * <p>
	 * 交易关闭时间。格式为yyyy-MM-dd HH:mm:ss。 <br>
	 * param_demo: 2008-10-22 20:49:46
	 */
	public Date getGmt_close() {
		return gmt_close;
	}

	/**
	 * 交易关闭时间
	 * <p>
	 * 交易关闭时间。格式为yyyy-MM-dd HH:mm:ss。 <br>
	 * param_demo: 2008-10-22 20:49:46
	 */
	public void setGmt_close(Date gmt_close) {
		this.gmt_close = gmt_close;
	}

	/**
	 * 退款状态
	 * <p>
	 * 取值范围请参见退款状态。 <br>
	 * param_demo: REFUND_SUCCESS
	 */
	public String getRefund_status() {
		return refund_status;
	}

	/**
	 * 退款状态
	 * <p>
	 * 取值范围请参见退款状态。 <br>
	 * param_demo: REFUND_SUCCESS
	 */
	public void setRefund_status(String refund_status) {
		this.refund_status = refund_status;
	}

	/**
	 * 退款时间
	 * <p>
	 * 卖家退款的时间，退款通知时会发送。格式为yyyy-MM-dd HH:mm:ss。 <br>
	 * param_demo: 2008-10-29 19:38:25
	 */
	public Date getGmt_refund() {
		return gmt_refund;
	}

	/**
	 * 退款时间
	 * <p>
	 * 卖家退款的时间，退款通知时会发送。格式为yyyy-MM-dd HH:mm:ss。 <br>
	 * param_demo: 2008-10-29 19:38:25
	 */
	public void setGmt_refund(Date gmt_refund) {
		this.gmt_refund = gmt_refund;
	}

	/**
	 * 卖家支付宝账号
	 * <p>
	 * 卖家支付宝账号，可以是email和手机号码。 <br>
	 * param_demo: chao.chenc1@alipay.com
	 */
	public String getSeller_email() {
		return seller_email;
	}

	/**
	 * 卖家支付宝账号
	 * <p>
	 * 卖家支付宝账号，可以是email和手机号码。 <br>
	 * param_demo: chao.chenc1@alipay.com
	 */
	public void setSeller_email(String seller_email) {
		this.seller_email = seller_email;
	}

	/**
	 * 买家支付宝账号
	 * <p>
	 * 买家支付宝账号，可以是Email或手机号码。 <br>
	 * param_demo: 13758698870
	 */
	public String getBuyer_email() {
		return buyer_email;
	}

	/**
	 * 买家支付宝账号
	 * <p>
	 * 买家支付宝账号，可以是Email或手机号码。 <br>
	 * param_demo: 13758698870
	 */
	public void setBuyer_email(String buyer_email) {
		this.buyer_email = buyer_email;
	}

	/**
	 * 卖家支付宝账户号
	 * <p>
	 * 卖家支付宝账号对应的支付宝唯一用户号。以2088开头的纯16位数字。 <br>
	 * param_demo: 2088002007018916
	 */
	public String getSeller_id() {
		return seller_id;
	}

	/**
	 * 卖家支付宝账户号
	 * <p>
	 * 卖家支付宝账号对应的支付宝唯一用户号。以2088开头的纯16位数字。 <br>
	 * param_demo: 2088002007018916
	 */
	public void setSeller_id(String seller_id) {
		this.seller_id = seller_id;
	}

	/**
	 * 买家支付宝账户号
	 * <p>
	 * 买家支付宝账号对应的支付宝唯一用户号。以2088开头的纯16位数字。 <br>
	 * param_demo: 2088002007013600
	 */
	public String getBuyer_id() {
		return buyer_id;
	}

	/**
	 * 买家支付宝账户号
	 * <p>
	 * 买家支付宝账号对应的支付宝唯一用户号。以2088开头的纯16位数字。 <br>
	 * param_demo: 2088002007013600
	 */
	public void setBuyer_id(String buyer_id) {
		this.buyer_id = buyer_id;
	}

	/**
	 * 商品单价
	 * <p>
	 * 如果请求时使用的是total_fee，那么price等于total_fee；如果请求时使用的是price，那么对应请求时的price参数，
	 * 原样通知回来。 <br>
	 * param_demo: 10.00
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * 商品单价
	 * <p>
	 * 如果请求时使用的是total_fee，那么price等于total_fee；如果请求时使用的是price，那么对应请求时的price参数，
	 * 原样通知回来。 <br>
	 * param_demo: 10.00
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	/**
	 * 交易金额
	 * <p>
	 * 该笔订单的总金额。请求时对应的参数，原样通知回来。 <br>
	 * param_demo: 10.00
	 */
	public BigDecimal getTotal_fee() {
		return total_fee;
	}

	/**
	 * 交易金额
	 * <p>
	 * 该笔订单的总金额。请求时对应的参数，原样通知回来。 <br>
	 * param_demo: 10.00
	 */
	public void setTotal_fee(BigDecimal total_fee) {
		this.total_fee = total_fee;
	}

	/**
	 * 购买数量
	 * <p>
	 * 如果请求时使用的是total_fee，那么quantity等于1；如果请求时使用的是quantity，那么对应请求时的quantity参数，
	 * 原样通知回来。 <br>
	 * param_demo: 1
	 */
	public BigDecimal getQuantity() {
		return quantity;
	}

	/**
	 * 购买数量
	 * <p>
	 * 如果请求时使用的是total_fee，那么quantity等于1；如果请求时使用的是quantity，那么对应请求时的quantity参数，
	 * 原样通知回来。 <br>
	 * param_demo: 1
	 */
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	/**
	 * 商品描述
	 * <p>
	 * 该笔订单的备注、描述、明细等。对应请求时的body参数，原样通知回来。 <br>
	 * param_demo: Hello
	 */
	public String getBody() {
		return body;
	}

	/**
	 * 商品描述
	 * <p>
	 * 该笔订单的备注、描述、明细等。对应请求时的body参数，原样通知回来。 <br>
	 * param_demo: Hello
	 */
	public void setBody(String body) {
		this.body = body;
	}

	/**
	 * 折扣
	 * <p>
	 * 支付宝系统会把discount的值加到交易金额上，如果需要折扣，本参数为负数。 <br>
	 * param_demo: -5
	 */
	public BigDecimal getDiscount() {
		return discount;
	}

	/**
	 * 折扣
	 * <p>
	 * 支付宝系统会把discount的值加到交易金额上，如果需要折扣，本参数为负数。 <br>
	 * param_demo: -5
	 */
	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	/**
	 * 是否调整总价
	 * <p>
	 * 该交易是否调整过价格。 <br>
	 * param_demo: N
	 */
	public String getIs_total_fee_adjust() {
		return is_total_fee_adjust;
	}

	/**
	 * 是否调整总价
	 * <p>
	 * 该交易是否调整过价格。 <br>
	 * param_demo: N
	 */
	public void setIs_total_fee_adjust(String is_total_fee_adjust) {
		this.is_total_fee_adjust = is_total_fee_adjust;
	}

	/**
	 * 是否使用红包买家
	 * <p>
	 * 是否在交易过程中使用了红包。 <br>
	 * param_demo: N
	 */
	public String getUse_coupon() {
		return use_coupon;
	}

	/**
	 * 是否使用红包买家
	 * <p>
	 * 是否在交易过程中使用了红包。 <br>
	 * param_demo: N
	 */
	public void setUse_coupon(String use_coupon) {
		this.use_coupon = use_coupon;
	}

	/**
	 * 公用回传参数
	 * <p>
	 * 用于商户回传参数，该值不能包含“=”、“&”等特殊字符。如果用户请求时传递了该参数，则返回给商户时会回传该参数。 <br>
	 * param_demo: 你好，这是测试商户的广告。
	 */
	public String getExtra_common_param() {
		return extra_common_param;
	}

	/**
	 * 公用回传参数
	 * <p>
	 * 用于商户回传参数，该值不能包含“=”、“&”等特殊字符。如果用户请求时传递了该参数，则返回给商户时会回传该参数。 <br>
	 * param_demo: 你好，这是测试商户的广告。
	 */
	public void setExtra_common_param(String extra_common_param) {
		this.extra_common_param = extra_common_param;
	}

	/**
	 * 支付渠道组合信息
	 * <p>
	 * 该笔交易所使用的支付渠道。格式为：渠道1|渠道2|…，如果有多个渠道，用“|”隔开。取值范围请参见渠道类型说明与币种列表。 <br>
	 * param_demo: OPTIMIZED_MOTO|BALANCE
	 */
	public String getOut_channel_type() {
		return out_channel_type;
	}

	/**
	 * 支付渠道组合信息
	 * <p>
	 * 该笔交易所使用的支付渠道。格式为：渠道1|渠道2|…，如果有多个渠道，用“|”隔开。取值范围请参见渠道类型说明与币种列表。 <br>
	 * param_demo: OPTIMIZED_MOTO|BALANCE
	 */
	public void setOut_channel_type(String out_channel_type) {
		this.out_channel_type = out_channel_type;
	}

	/**
	 * 支付金额组合信息
	 * <p>
	 * 该笔交易通过使用各支付渠道所支付的金额。格式为：金额1|金额2|…，如果有多个支付渠道，各渠道所支付金额用“|”隔开。 <br>
	 * param_demo: 90.00|10.00
	 */
	public String getOut_channel_amount() {
		return out_channel_amount;
	}

	/**
	 * 支付金额组合信息
	 * <p>
	 * 该笔交易通过使用各支付渠道所支付的金额。格式为：金额1|金额2|…，如果有多个支付渠道，各渠道所支付金额用“|”隔开。 <br>
	 * param_demo: 90.00|10.00
	 */
	public void setOut_channel_amount(String out_channel_amount) {
		this.out_channel_amount = out_channel_amount;
	}

	/**
	 * 实际支付渠道
	 * <p>
	 * 该交易支付时实际使用的银行渠道。格式为：支付渠道1|支付渠道2|…，如果有多个支付渠道，用“|”隔开。取值范围请参见实际支付渠道列表。
	 * 该参数需要联系支付宝开通。<br>
	 * param_demo: ICBC
	 */
	public String getOut_channel_inst() {
		return out_channel_inst;
	}

	/**
	 * 实际支付渠道
	 * <p>
	 * 该交易支付时实际使用的银行渠道。格式为：支付渠道1|支付渠道2|…，如果有多个支付渠道，用“|”隔开。取值范围请参见实际支付渠道列表。
	 * 该参数需要联系支付宝开通。<br>
	 * param_demo: ICBC
	 */
	public void setOut_channel_inst(String out_channel_inst) {
		this.out_channel_inst = out_channel_inst;
	}

	/**
	 * 是否扫码支付
	 * <p>
	 * 回传给商户此标识为qrpay时，表示对应交易为扫码支付。目前只有qrpay一种回传值。非扫码支付方式下，目前不会返回该参数。 <br>
	 * param_demo: qrpay
	 */
	public String getBusiness_scene() {
		return business_scene;
	}

	/**
	 * 是否扫码支付
	 * <p>
	 * 回传给商户此标识为qrpay时，表示对应交易为扫码支付。目前只有qrpay一种回传值。非扫码支付方式下，目前不会返回该参数。 <br>
	 * param_demo: qrpay
	 */
	public void setBusiness_scene(String business_scene) {
		this.business_scene = business_scene;
	}

}
