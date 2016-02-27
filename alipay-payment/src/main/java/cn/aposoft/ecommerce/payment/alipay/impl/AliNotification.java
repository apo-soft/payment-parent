package cn.aposoft.ecommerce.payment.alipay.impl;

/**
 * 支付成功后的回调结果解析后的值对象类，如果不使用该类，则签名验证部分需要自行编码判断
 * <p>
 * 调用者可直接进行实例化调用、存储
 * 
 * @author Yujinshui
 */
public class AliNotification {

	/**
	 * 通过比对支付宝返回的sign签名，判断是否为true
	 * <p>
	 * true:是支付宝返回结果<br>
	 * false:警告！非支付宝返回结果
	 */
	private boolean isAliPay;

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
	 * 根据支付宝返回信息生成的sign签名信息
	 * <p>
	 * 用于跟支付宝sign进行数据对比
	 */
	private String localSign;

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

	/***************************/
	/**
	 * 通知时间*
	 * <p>
	 * 通知的发送时间。 格式为yyyy-MM-ddHH:mm:ss。
	 */
	private String notify_time;
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
	private String gmt_create;
	/**
	 * 交易付款时间
	 * <p>
	 * 该笔交易的买家付款时间。 格式为yyyy-MM-ddHH:mm:ss。
	 * 
	 */
	private String gmt_payment;
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
	private String price;
	/**
	 * 购买数量
	 * <p>
	 * 对应请求时的quantity参数，原样通知回来。
	 */
	private String quantity;
	/**
	 * 交易金额
	 * <p>
	 * 该笔订单的总金额。 请求时对应的参数，原样通知回来
	 * 
	 */
	private String total_fee;
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
	private String refund_fee;
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

	/**
	 * 通知时间*
	 * <p>
	 * 通知的发送时间。 格式为yyyy-MM-ddHH:mm:ss。
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月19日 下午12:38:15
	 */
	public String getNotify_time() {
		return notify_time;
	}

	/**
	 * 通知时间*
	 * <p>
	 * 通知的发送时间。 格式为yyyy-MM-ddHH:mm:ss。
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月19日 下午12:38:15
	 */
	public void setNotify_time(String notify_time) {
		this.notify_time = notify_time;
	}

	/**
	 * 通知类型*
	 * <p>
	 * trade_status_sync
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月19日 下午12:38:15
	 */
	public String getNotify_type() {
		return notify_type;
	}

	/**
	 * 通知类型*
	 * <p>
	 * trade_status_sync
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月19日 下午12:38:15
	 */
	public void setNotify_type(String notify_type) {
		this.notify_type = notify_type;
	}

	/**
	 * 通知校验ID*
	 * <p>
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月19日 下午12:38:15
	 */
	public String getNotify_id() {
		return notify_id;
	}

	/**
	 * 通知校验ID*
	 * <p>
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月19日 下午12:38:15
	 */
	public void setNotify_id(String notify_id) {
		this.notify_id = notify_id;
	}

	/**
	 * 签名方式*
	 * <p>
	 * DSA、RSA、MD5三个值可选，必须大写。
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月19日 下午12:38:15
	 */
	public String getSign_type() {
		return sign_type;
	}

	/**
	 * 签名方式*
	 * <p>
	 * DSA、RSA、MD5三个值可选，必须大写。
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月19日 下午12:38:15
	 */
	public void setSign_type(String sign_type) {
		this.sign_type = sign_type;
	}

	/**
	 * 签名*
	 * <p>
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月19日 下午12:38:15
	 */
	public String getSign() {
		return sign;
	}

	/**
	 * 签名*
	 * <p>
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月19日 下午12:38:15
	 */
	public void setSign(String sign) {
		this.sign = sign;
	}

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
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月19日 下午12:38:15
	 */
	public String getNotify_action_type() {
		return notify_action_type;
	}

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
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月19日 下午12:38:15
	 */
	public void setNotify_action_type(String notify_action_type) {
		this.notify_action_type = notify_action_type;
	}

	/**
	 * 商户网站唯一订单号
	 * <p>
	 * 对应商户网站的订单系统中的唯一订单号，非支付宝交易号。<br>
	 * 需保证在商户网站中的唯一性。是请求时对应的参数，原样返回。
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月19日 下午12:38:15
	 */
	public String getOut_trade_no() {
		return out_trade_no;
	}

	/**
	 * 商户网站唯一订单号
	 * <p>
	 * 对应商户网站的订单系统中的唯一订单号，非支付宝交易号。<br>
	 * 需保证在商户网站中的唯一性。是请求时对应的参数，原样返回。
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月19日 下午12:38:15
	 */
	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	/**
	 * 商品名称
	 * <p>
	 * 商品的标题/交易标题/订单标题/订单关键字等。<br>
	 * 它在支付宝的交易明细中排在第一列，对于财务对账尤为重要。是请求时对应的参数，原样通知回来。
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月19日 下午12:38:15
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * 商品名称
	 * <p>
	 * 商品的标题/交易标题/订单标题/订单关键字等。<br>
	 * 它在支付宝的交易明细中排在第一列，对于财务对账尤为重要。是请求时对应的参数，原样通知回来。
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月19日 下午12:38:15
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * 支付宝交易号
	 * <p>
	 * 该交易在支付宝系统中的交易流水号。<br>
	 * 最短16位，最长64位。
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月19日 下午12:38:15
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
	 * @time 2015年11月19日 下午12:38:15
	 */
	public void setTrade_no(String trade_no) {
		this.trade_no = trade_no;
	}

	/**
	 * 交易状态
	 * <p>
	 * 交易目前所处的状态，取值范 围请参见“10.4交易状态”
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月19日 下午12:38:15
	 */
	public String getTrade_status() {
		return trade_status;
	}

	/**
	 * 交易状态
	 * <p>
	 * 交易目前所处的状态，取值范 围请参见“10.4交易状态”
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月19日 下午12:38:15
	 */
	public void setTrade_status(String trade_status) {
		this.trade_status = trade_status;
	}

	/**
	 * 交易创建时间
	 * <p>
	 * 该笔交易创建的时间。 格式为yyyy-MM-ddHH:mm:ss。
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月19日 下午12:38:15
	 */
	public String getGmt_create() {
		return gmt_create;
	}

	/**
	 * 交易创建时间
	 * <p>
	 * 该笔交易创建的时间。 格式为yyyy-MM-ddHH:mm:ss。
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月19日 下午12:38:15
	 */
	public void setGmt_create(String gmt_create) {
		this.gmt_create = gmt_create;
	}

	/**
	 * 交易付款时间
	 * <p>
	 * 该笔交易的买家付款时间。 格式为yyyy-MM-ddHH:mm:ss。
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月19日 下午12:38:15
	 */
	public String getGmt_payment() {
		return gmt_payment;
	}

	/**
	 * 交易付款时间
	 * <p>
	 * 该笔交易的买家付款时间。 格式为yyyy-MM-ddHH:mm:ss。
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月19日 下午12:38:15
	 */
	public void setGmt_payment(String gmt_payment) {
		this.gmt_payment = gmt_payment;
	}

	/**
	 * 卖家支付宝账号
	 * <p>
	 * 卖家支付宝账号，可以是email和手机号码。
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月19日 下午12:38:15
	 */
	public String getSeller_email() {
		return seller_email;
	}

	/**
	 * 卖家支付宝账号
	 * <p>
	 * 卖家支付宝账号，可以是email和手机号码。
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月19日 下午12:38:15
	 */
	public void setSeller_email(String seller_email) {
		this.seller_email = seller_email;
	}

	/**
	 * 买家支付宝账号
	 * <p>
	 * 买家支付宝账号，可以是 Email或手机号码。
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月19日 下午12:38:15
	 */
	public String getBuyer_email() {
		return buyer_email;
	}

	/**
	 * 买家支付宝账号
	 * <p>
	 * 买家支付宝账号，可以是 Email或手机号码。
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月19日 下午12:38:15
	 */
	public void setBuyer_email(String buyer_email) {
		this.buyer_email = buyer_email;
	}

	/**
	 * 卖家支付宝用户号
	 * <p>
	 * 卖家支付宝账号对应的支付宝唯一用户号。 以2088开头的纯16位数字。
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月19日 下午12:38:15
	 */
	public String getSeller_id() {
		return seller_id;
	}

	/**
	 * 卖家支付宝用户号
	 * <p>
	 * 卖家支付宝账号对应的支付宝唯一用户号。 以2088开头的纯16位数字。
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月19日 下午12:38:15
	 */
	public void setSeller_id(String seller_id) {
		this.seller_id = seller_id;
	}

	/**
	 * 买家支付宝用户号
	 * <p>
	 * 买家支付宝账号对应的支付宝唯一用户号。 以2088开头的纯16位数字。
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月19日 下午12:38:15
	 */
	public String getBuyer_id() {
		return buyer_id;
	}

	/**
	 * 买家支付宝用户号
	 * <p>
	 * 买家支付宝账号对应的支付宝唯一用户号。 以2088开头的纯16位数字。
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月19日 下午12:38:15
	 */
	public void setBuyer_id(String buyer_id) {
		this.buyer_id = buyer_id;
	}

	/**
	 * 商品单价
	 * <p>
	 * 对应请求时的price参数，原样通知回来
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月19日 下午12:38:15
	 */
	public String getPrice() {
		return price;
	}

	/**
	 * 商品单价
	 * <p>
	 * 对应请求时的price参数，原样通知回来
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月19日 下午12:38:15
	 */
	public void setPrice(String price) {
		this.price = price;
	}

	/**
	 * 购买数量
	 * <p>
	 * 对应请求时的quantity参数，原样通知回来。
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月19日 下午12:38:15
	 */
	public String getQuantity() {
		return quantity;
	}

	/**
	 * 购买数量
	 * <p>
	 * 对应请求时的quantity参数，原样通知回来。
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月19日 下午12:38:15
	 */
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	/**
	 * 交易金额
	 * <p>
	 * 该笔订单的总金额。 请求时对应的参数，原样通知回来
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月19日 下午12:38:15
	 */
	public String getTotal_fee() {
		return total_fee;
	}

	/**
	 * 交易金额
	 * <p>
	 * 该笔订单的总金额。 请求时对应的参数，原样通知回来
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月19日 下午12:38:15
	 */
	public void setTotal_fee(String total_fee) {
		this.total_fee = total_fee;
	}

	/**
	 * 商品描述
	 * <p>
	 * 该笔订单的备注、描述、明细等。 对应请求时的body参数，原样通知回来。
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月19日 下午12:38:15
	 */
	public String getBody() {
		return body;
	}

	/**
	 * 商品描述
	 * <p>
	 * 该笔订单的备注、描述、明细等。 对应请求时的body参数，原样通知回来。
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月19日 下午12:38:15
	 */
	public void setBody(String body) {
		this.body = body;
	}

	/**
	 * 退款金额
	 * <p>
	 * 退款通知中，返回退款金额，单位为元。
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月19日 下午12:38:15
	 */
	public String getRefund_fee() {
		return refund_fee;
	}

	/**
	 * 退款金额
	 * <p>
	 * 退款通知中，返回退款金额，单位为元。
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月19日 下午12:38:15
	 */
	public void setRefund_fee(String refund_fee) {
		this.refund_fee = refund_fee;
	}

	/**
	 * 商户业务号
	 * <p>
	 * 商户业务ID，主要是退款通知中返回退款申请的流水号。
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月19日 下午12:38:15
	 */
	public String getOut_biz_no() {
		return out_biz_no;
	}

	/**
	 * 商户业务号
	 * <p>
	 * 商户业务ID，主要是退款通知中返回退款申请的流水号。
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月19日 下午12:38:15
	 */
	public void setOut_biz_no(String out_biz_no) {
		this.out_biz_no = out_biz_no;
	}

	/**
	 * 支付金额信息
	 * <p>
	 * 支付成功的各个渠道金额信息，具体请参见“6.3支付金额信息说明”。
	 *
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月19日 下午12:38:15
	 */
	public String getPaytools_pay_amount() {
		return paytools_pay_amount;
	}

	/**
	 * 支付金额信息
	 * <p>
	 * 支付成功的各个渠道金额信息，具体请参见“6.3支付金额信息说明”。
	 *
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月19日 下午12:38:15
	 */
	public void setPaytools_pay_amount(String paytools_pay_amount) {
		this.paytools_pay_amount = paytools_pay_amount;
	}

	/**
	 * 业务透传参数
	 * <p>
	 * 原样返回商户请求下单时的passback_parameters参数。
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月19日 下午12:38:15
	 */
	public String getExtra_common_param() {
		return extra_common_param;
	}

	/**
	 * 业务透传参数
	 * <p>
	 * 原样返回商户请求下单时的passback_parameters参数。
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月19日 下午12:38:15
	 */
	public void setExtra_common_param(String extra_common_param) {
		this.extra_common_param = extra_common_param;
	}

	/**
	 * 打印得到的结果值
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "isAliPay:" + isAliPay//
				+ "\r\n <br> notify_time:" + notify_time//
				+ "\r\n <br> notify_type:" + notify_type//
				+ "\r\n <br> notify_id:" + notify_id//
				+ "\r\n <br> sign_type:" + sign_type//
				+ "\r\n <br> sign:" + sign//
				+ "\r\n <br> notify_action_type:" + notify_action_type//
				+ "\r\n <br> out_trade_no:" + out_trade_no//
				+ "\r\n <br> subject:" + subject//
				+ "\r\n <br> trade_no:" + trade_no//
				+ "\r\n <br> trade_status:" + trade_status//
				+ "\r\n <br> gmt_create:" + gmt_create//
				+ "\r\n <br> gmt_payment:" + gmt_payment//
				+ "\r\n <br> seller_email:" + seller_email//
				+ "\r\n <br> buyer_email:" + buyer_email//
				+ "\r\n <br> seller_id:" + seller_id//
				+ "\r\n <br> buyer_id:" + buyer_id//
				+ "\r\n <br> price:" + price//
				+ "\r\n <br> quantity:" + quantity//
				+ "\r\n <br> total_fee:" + total_fee//
				+ "\r\n <br> body:" + body//
				+ "\r\n <br> refund_fee:" + refund_fee//
				+ "\r\n <br> out_biz_no:" + out_biz_no//
				+ "\r\n <br> paytools_pay_amount:" + paytools_pay_amount//
				+ "\r\n <br> extra_common_param:" + extra_common_param; //
	}

}
