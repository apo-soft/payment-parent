package cn.aposoft.ecommerce.payment.wechat.impl;

/**
 * 退款相关字段信息
 * <p>
 * 
 * <pre>
 	<xml>
	   <appid>wx2421b1c4370ec43b</appid>
	   <mch_id>10000100</mch_id>
	   <nonce_str>6cefdb308e1e2e8aabd48cf79e546a02</nonce_str>
	   <op_user_id>10000100</op_user_id>
	   <out_refund_no>1415701182</out_refund_no>
	   <out_trade_no>1415757673</out_trade_no>
	   <refund_fee>1</refund_fee>
	   <total_fee>1</total_fee>
	   <transaction_id></transaction_id>
	   <sign>FE56DD4AA85C0EECA82C35595A69E153</sign>
	</xml>
 * </pre>
 * 
 * @author Yujinshui
 *
 */
public class RefundRequest extends RequestBase {

	private String transaction_id; // 微信订单号
	private String out_refund_no; // 商户退款单号
	/**
	 * 总金额 total_fee 是 Int 888 订单总金额，单位为分，详见支付金额
	 */
	private Integer total_fee; // 总金额-
	private Integer refund_fee; // 退款金额
	private String refund_fee_type; // 货币种类
	private String op_user_id; // 操作员

	public String getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}

	public String getOut_refund_no() {
		return out_refund_no;
	}

	public void setOut_refund_no(String out_refund_no) {
		this.out_refund_no = out_refund_no;
	}

	public Integer getRefund_fee() {
		return refund_fee;
	}

	public void setRefund_fee(Integer refund_fee) {
		this.refund_fee = refund_fee;
	}

	public String getRefund_fee_type() {
		return refund_fee_type;
	}

	public void setRefund_fee_type(String refund_fee_type) {
		this.refund_fee_type = refund_fee_type;
	}

	public String getOp_user_id() {
		return op_user_id;
	}

	public void setOp_user_id(String op_user_id) {
		this.op_user_id = op_user_id;
	}

	/**
	 * 
	 * @return
	 */
	public Integer getTotal_fee() {
		return total_fee;
	}

	/**
	 * 
	 * @param total_fee
	 */
	public void setTotal_fee(Integer total_fee) {
		this.total_fee = total_fee;
	}

}
