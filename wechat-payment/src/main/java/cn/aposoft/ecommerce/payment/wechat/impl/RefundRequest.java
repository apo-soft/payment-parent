package cn.aposoft.ecommerce.payment.wechat.impl;

/**
 * 退款相关字段信息
 * <p>
 * 
 * @author Yujinshui
 *
 */
public class RefundRequest extends PayBase {
	private String transaction_id; // 微信订单号
	private String out_refund_no; // 商户退款单号
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

}
