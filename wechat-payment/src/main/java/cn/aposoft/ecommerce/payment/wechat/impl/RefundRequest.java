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
	/**
	 * 微信订单号 transaction_id 二选一 String(28) 1217752501201407033233368018
	 * 微信生成的订单号，在支付通知中有返回
	 */
	private String transaction_id; // 微信订单号
	// private String out_trade_no;// 商户订单号 base
	/**
	 * 商户退款单号 out_refund_no 是 String(32) 1217752501201407033233368018
	 * 商户系统内部的退款单号，商户系统内部唯一，同一退款单号多次请求只退一笔
	 */
	private String out_refund_no; // 商户退款单号
	/**
	 * 总金额 total_fee 是 Int 888 订单总金额，单位为分，详见支付金额
	 * <p>
	 * {@link https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=4_2}
	 */
	private Integer total_fee;
	/**
	 * 退款金额 refund_fee 是 Int 100 退款总金额，订单总金额，单位为分，只能为整数，详见支付金额
	 * <p>
	 * {@link https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=4_2}
	 */
	private Integer refund_fee; // 退款金额
	/**
	 * 货币种类 refund_fee_type 否 String(8) CNY 货币类型，符合ISO
	 * 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型
	 * <p>
	 * {@link https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=4_2}
	 */
	private String refund_fee_type;
	/**
	 * 操作员 op_user_id 是 String(32) 1900000109 操作员帐号, 默认为商户号
	 */
	private String op_user_id;

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
	 * 读取总金额
	 * 
	 * @return 返回总金额 单位:分
	 */
	public Integer getTotal_fee() {
		return total_fee;
	}

	/**
	 * 设置总金额
	 * 
	 * @param total_fee
	 *            总金额数值 单位:分
	 */
	public void setTotal_fee(Integer total_fee) {
		this.total_fee = total_fee;
	}

}
