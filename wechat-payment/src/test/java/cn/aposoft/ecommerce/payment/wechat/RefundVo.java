package cn.aposoft.ecommerce.payment.wechat;

public class RefundVo implements Refund {

	/**
	 * 设备号
	 */
	private String device_info;
	/**
	 * <font color=red>必需</font>-随机字符串
	 */
	private String nonce_str;
	private String out_trade_no; // 商户订单号-
	private Integer total_fee; // 总金额-
	private String transaction_id; // 微信订单号
	private String out_refund_no; // 商户退款单号
	private Integer refund_fee; // 退款金额
	private String refund_fee_type; // 货币种类
	private String op_user_id; // 操作员

	public void setDevice_info(String device_info) {
		this.device_info = device_info;
	}

	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public void setTotal_fee(Integer total_fee) {
		this.total_fee = total_fee;
	}

	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}

	public void setOut_refund_no(String out_refund_no) {
		this.out_refund_no = out_refund_no;
	}

	public void setRefund_fee(Integer refund_fee) {
		this.refund_fee = refund_fee;
	}

	public void setRefund_fee_type(String refund_fee_type) {
		this.refund_fee_type = refund_fee_type;
	}

	public void setOp_user_id(String op_user_id) {
		this.op_user_id = op_user_id;
	}

	@Override
	public String getDevice_info() {
		return device_info;
	}

	@Override
	public String getNonce_str() {
		return nonce_str;
	}

	@Override
	public Integer getTotal_fee() {
		return total_fee;
	}

	@Override
	public String getOut_trade_no() {
		return out_trade_no;
	}

	@Override
	public String getTransaction_id() {
		return transaction_id;
	}

	@Override
	public String getOut_refund_no() {
		return out_refund_no;
	}

	@Override
	public Integer getRefund_fee() {
		return refund_fee;
	}

	@Override
	public String getRefund_fee_type() {
		return refund_fee_type;
	}

	@Override
	public String getOp_user_id() {
		return op_user_id;
	}

	/**
	 * 用于测试的demo对象
	 * 
	 * @return {@see Refund} 退款请求对象
	 */
	public static Refund demo() {
		RefundVo refund = new RefundVo();

		// refund.setDevice_info("设备信息");

		refund.setNonce_str("201601141855");
		refund.setOp_user_id("wechat-1");
		refund.setOut_refund_no("1009160896201601142697805964");// 退款单号（支付单号）

		refund.setOut_trade_no("A7E7ABE0BAAB11E5B0E4B53447D52D06");
		refund.setRefund_fee(400);
		refund.setRefund_fee_type("CNY");
		refund.setTotal_fee(400);
		return refund;
	}

}
