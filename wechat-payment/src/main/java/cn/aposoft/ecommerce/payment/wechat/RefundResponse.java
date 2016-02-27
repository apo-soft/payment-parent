package cn.aposoft.ecommerce.payment.wechat;

/**
 * 退款响应报文解析结果对象
 * 
 * @author Yujinshui
 *
 */
public class RefundResponse extends ResponseBase {
	private static final long serialVersionUID = 5584057621473123066L;
	private String transaction_id;// 微信订单号 [是] String(28)
	private String out_trade_no;// 商户订单号 [是] String(32)
	private String out_refund_no;// 商户退款单号 [是] String(32)
	private String refund_id;// 微信退款单号 [是] String(28)
	private String refund_channel;// 退款渠道 [否]String(16)
									// 【ORIGINAL—原路退款，BALANCE—退回到余额】
	private Integer refund_fee;// 退款金额 [是] Int 100
	private Integer total_fee;// 订单总金额 [是] Int
	private String fee_type;// 订单金额货币种类 [否] String(8)
	private Integer cash_fee;// 现金支付金额 [是] Int
	private String cash_refund_fee;// 现金退款金额 [否] Int
	private Integer coupon_refund_fee;// 代金券或立减优惠退款金额 [否] Int
	private Integer coupon_refund_count;// 代金券或立减优惠使用数量 [否] Int
	private String coupon_refund_id;// 代金券或立减优惠ID [否] String(20)

	public String getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public String getOut_refund_no() {
		return out_refund_no;
	}

	public void setOut_refund_no(String out_refund_no) {
		this.out_refund_no = out_refund_no;
	}

	public String getRefund_id() {
		return refund_id;
	}

	public void setRefund_id(String refund_id) {
		this.refund_id = refund_id;
	}

	public String getRefund_channel() {
		return refund_channel;
	}

	public void setRefund_channel(String refund_channel) {
		this.refund_channel = refund_channel;
	}

	public Integer getRefund_fee() {
		return refund_fee;
	}

	public void setRefund_fee(Integer refund_fee) {
		this.refund_fee = refund_fee;
	}

	public Integer getTotal_fee() {
		return total_fee;
	}

	public void setTotal_fee(Integer total_fee) {
		this.total_fee = total_fee;
	}

	public String getFee_type() {
		return fee_type;
	}

	public void setFee_type(String fee_type) {
		this.fee_type = fee_type;
	}

	public Integer getCash_fee() {
		return cash_fee;
	}

	public void setCash_fee(Integer cash_fee) {
		this.cash_fee = cash_fee;
	}

	public String getCash_refund_fee() {
		return cash_refund_fee;
	}

	public void setCash_refund_fee(String cash_refund_fee) {
		this.cash_refund_fee = cash_refund_fee;
	}

	public Integer getCoupon_refund_fee() {
		return coupon_refund_fee;
	}

	public void setCoupon_refund_fee(Integer coupon_refund_fee) {
		this.coupon_refund_fee = coupon_refund_fee;
	}

	public Integer getCoupon_refund_count() {
		return coupon_refund_count;
	}

	public void setCoupon_refund_count(Integer coupon_refund_count) {
		this.coupon_refund_count = coupon_refund_count;
	}

	public String getCoupon_refund_id() {
		return coupon_refund_id;
	}

	public void setCoupon_refund_id(String coupon_refund_id) {
		this.coupon_refund_id = coupon_refund_id;
	}

	public String toString() {
		return "return_code : " + return_code//
				+ "\r\n <br> return_msg : " + return_msg//
				+ "\r\n <br> appid : " + appid//
				+ "\r\n <br> mch_id : " + mch_id//
				+ "\r\n <br> device_info : " + device_info//
				+ "\r\n <br> nonce_str : " + nonce_str//
				+ "\r\n <br> sign : " + sign//
				+ "\r\n <br> result_code : " + result_code//
				+ "\r\n <br> err_code : " + err_code//
				+ "\r\n <br> err_code_des : " + err_code_des //

				+ "\r\n <br> transaction_id : " + transaction_id//
				+ "\r\n <br> out_trade_no : " + out_trade_no//
				+ "\r\n <br> out_refund_no : " + out_refund_no//
				+ "\r\n <br> refund_id : " + refund_id//
				+ "\r\n <br> refund_channel : " + refund_channel//
				+ "\r\n <br> refund_fee : " + refund_fee//
				+ "\r\n <br> total_fee : " + total_fee//
				+ "\r\n <br> fee_type : " + fee_type//
				+ "\r\n <br> cash_fee : " + cash_fee//
				+ "\r\n <br> cash_refund_fee : " + cash_refund_fee//
				+ "\r\n <br> coupon_refund_fee : " + coupon_refund_fee//
				+ "\r\n <br> coupon_refund_count : " + coupon_refund_count//
				+ "\r\n <br> coupon_refund_id : " + coupon_refund_id

		;
	}
}
