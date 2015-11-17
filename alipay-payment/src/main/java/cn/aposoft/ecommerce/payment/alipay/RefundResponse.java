package cn.aposoft.ecommerce.payment.alipay;

import java.util.Date;
import java.util.List;

/**
 * 退款请求-返回结果bean
 * 
 * @author Yujinshui
 *
 */
public class RefundResponse {

	private String result;

	/**
	 * 解析失败时将原始返回结果放进这里[个人提供]
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月17日 下午4:50:37
	 */
	public String getResult() {
		return result;
	}

	/**
	 * 解析失败时将原始返回结果放进这里[个人提供]
	 * 
	 * @param result
	 * @author Yujinshui
	 * @time 2015年11月17日 下午4:50:01
	 */
	public void setResult(String result) {
		this.result = result;
	}

	/******** 基本参数 *********/
	/**
	 * 请求是否成功*
	 * <p>
	 * 请求是否成功。请求成功不代表业务处理成功。<br>
	 * T代表成功<br>
	 * F代表失败
	 * 
	 */
	private String is_success;
	/**
	 * 签名方式
	 * <p>
	 * DSA、RSA、MD5三个值可选，必须大写。
	 */
	private String sign_type;
	/**
	 * 签名
	 * <p>
	 * 请参见“7签名机制”。
	 */
	private String sign;
	/**
	 * 错误代码
	 * <p>
	 * 请求成功时，不存在本参数；<br>
	 * 请求失败时，本参数为错误代码，参见“8.2接入错误码”和“8.3系统错误码”。
	 * 
	 */
	private String error;
	/******** 业务参数 *******/
	/**
	 * 响应码*
	 * <p>
	 * 退款处理结果响应码。 <br>
	 * SUCCESS：退款成功<br>
	 * FAIL：退款失败<br>
	 * UNKNOWN：结果未知
	 */
	private String result_code;
	/**
	 * 支付宝交易号
	 * <p>
	 * 该交易在支付宝系统中的交易流水号。<br>
	 * 最短16位，最长64位。
	 * 
	 */
	private String trade_no;
	/**
	 * 商户网站唯一订单号
	 * <p>
	 * 对应商户网站的订单系统中的唯一订单号，非支付宝交易号。需保证在商户网站中的唯一 性。是请求时对应的参数，原样返回。
	 * 
	 */
	private String out_trade_no;
	/**
	 * 买家支付宝用户号
	 * <p>
	 * 买家支付宝账号对应的支付宝唯一用户号。 以2088开头的纯16位数字。
	 * 
	 */
	private String buyer_user_id;
	/**
	 * 买家支付宝账号
	 * <p>
	 * 买家支付宝账号，可以是 Email或手机号码。
	 * 
	 */
	private String buyer_logon_id;
	/**
	 * 本次退款请求是否发生资金变动
	 * <p>
	 * 对同一个商户退款请求，如果该笔退款已退款过，则直接返回上一次的退款结果。同时，返回本次请求是否发生了资金变动的标识。 <br>
	 * Y：本次退款请求发生资金变动；<br>
	 * N：本次退款请求未发送资金变动。
	 * 
	 */
	private String fund_change;
	/**
	 * 退款金额
	 * <p>
	 * 实际退款金额，单位为元。
	 */
	private double refund_fee;
	/**
	 * 退款时间
	 * <p>
	 * 退款时间，格式为yyyy-MM-ddHH:mm:ss。
	 */
	private Date gmt_refund_pay;
	/**
	 * 退款渠道列表
	 * <p>
	 * 退款金额的退回渠道，xml格式，可返回多个退款渠道子节点<TradeFundBill>，该节点包含的参数请参见“5.3退款渠道列表信息”。
	 */
	private List<RefundDetailList> refund_detail_item_list;
	/**
	 * 详细错误码
	 * <p>
	 * 对返回响应码进行原因说明，请参见“8.1业务错误码”。<br>
	 * 当result_code响应码为 SUCCESS时，不返回该参数。
	 * 
	 */
	private String detail_error_code;
	/**
	 * 详细错误描述
	 * <p>
	 * 对详细错误码进行文字说明。<br>
	 * 当result_code响应码为 SUCCESS时，不返回该参数。
	 * 
	 */
	private String detail_error_des;

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
	 * 买家支付宝用户号
	 * <p>
	 * 买家支付宝账号对应的支付宝唯一用户号。 以2088开头的纯16位数字。
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月17日 下午5:25:01
	 */

	public String getBuyer_user_id() {
		return buyer_user_id;
	}

	/**
	 * 买家支付宝用户号
	 * <p>
	 * 买家支付宝账号对应的支付宝唯一用户号。 以2088开头的纯16位数字。
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月17日 下午5:25:01
	 */

	public void setBuyer_user_id(String buyer_user_id) {
		this.buyer_user_id = buyer_user_id;
	}

	/**
	 * 买家支付宝账号
	 * <p>
	 * 买家支付宝账号，可以是 Email或手机号码。
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月17日 下午5:25:01
	 */

	public String getBuyer_logon_id() {
		return buyer_logon_id;
	}

	/**
	 * 买家支付宝账号
	 * <p>
	 * 买家支付宝账号，可以是 Email或手机号码。
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月17日 下午5:25:01
	 */

	public void setBuyer_logon_id(String buyer_logon_id) {
		this.buyer_logon_id = buyer_logon_id;
	}

	/**
	 * 本次退款请求是否发生资金变动
	 * <p>
	 * 对同一个商户退款请求，如果该笔退款已退款过，则直接返回上一次的退款结果。同时，返回本次请求是否发生了资金变动的标识。 <br>
	 * Y：本次退款请求发生资金变动；<br>
	 * N：本次退款请求未发送资金变动。
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月17日 下午5:25:01
	 */

	public String getFund_change() {
		return fund_change;
	}

	/**
	 * 本次退款请求是否发生资金变动
	 * <p>
	 * 对同一个商户退款请求，如果该笔退款已退款过，则直接返回上一次的退款结果。同时，返回本次请求是否发生了资金变动的标识。 <br>
	 * Y：本次退款请求发生资金变动；<br>
	 * N：本次退款请求未发送资金变动。
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月17日 下午5:25:01
	 */

	public void setFund_change(String fund_change) {
		this.fund_change = fund_change;
	}

	/**
	 * 退款金额
	 * <p>
	 * 实际退款金额，单位为元。
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月17日 下午5:25:01
	 */

	public double getRefund_fee() {
		return refund_fee;
	}

	/**
	 * 退款金额
	 * <p>
	 * 实际退款金额，单位为元。
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月17日 下午5:25:01
	 */

	public void setRefund_fee(double refund_fee) {
		this.refund_fee = refund_fee;
	}

	/**
	 * 退款时间
	 * <p>
	 * 退款时间，格式为yyyy-MM-ddHH:mm:ss。
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月17日 下午5:25:01
	 */

	public Date getGmt_refund_pay() {
		return gmt_refund_pay;
	}

	/**
	 * 退款时间
	 * <p>
	 * 退款时间，格式为yyyy-MM-ddHH:mm:ss。
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月17日 下午5:25:01
	 */

	public void setGmt_refund_pay(Date gmt_refund_pay) {
		this.gmt_refund_pay = gmt_refund_pay;
	}

	/**
	 * 退款渠道列表
	 * <p>
	 * 退款金额的退回渠道，xml格式，可返回多个退款渠道子节点<TradeFundBill>，该节点包含的参数请参见“5.3退款渠道列表信息”。
	 *
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月17日 下午5:25:01
	 */

	public List<RefundDetailList> getRefund_detail_item_list() {
		return refund_detail_item_list;
	}

	/**
	 * 退款渠道列表
	 * <p>
	 * 退款金额的退回渠道，xml格式，可返回多个退款渠道子节点<TradeFundBill>，该节点包含的参数请参见“5.3退款渠道列表信息”。
	 *
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月17日 下午5:25:01
	 */

	public void setRefund_detail_item_list(List<RefundDetailList> refund_detail_item_list) {
		this.refund_detail_item_list = refund_detail_item_list;
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

/**
 * 5.3 退款渠道列表信息
 * 
 * @author Yujinshui
 *
 */
class RefundDetailList {
	/**
	 * 退款渠道
	 * <p>
	 * 退款渠道，参见“8.4退款渠道”
	 */
	private String fund_channel;
	/**
	 * 退款金额
	 * <p>
	 * 使用指定退款渠道退还的金额，单位为元。
	 */
	private String amount;

	/**
	 * 退款渠道
	 * <p>
	 * 退款渠道，参见“8.4退款渠道”
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月17日 下午5:17:24
	 */
	public String getFund_channel() {
		return fund_channel;
	}

	/**
	 * 退款渠道
	 * <p>
	 * 退款渠道，参见“8.4退款渠道”
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月17日 下午5:17:24
	 */
	public void setFund_channel(String fund_channel) {
		this.fund_channel = fund_channel;
	}

	/**
	 * 退款金额
	 * <p>
	 * 使用指定退款渠道退还的金额，单位为元。
	 * 
	 * @return
	 * @author Yujinshui
	 * @time 2015年11月17日 下午5:17:35
	 */
	public String getAmount() {
		return amount;
	}

	/**
	 * 退款金额
	 * <p>
	 * 使用指定退款渠道退还的金额，单位为元。
	 * 
	 * @param amount
	 * @author Yujinshui
	 * @time 2015年11月17日 下午5:17:39
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}

}
