/**
 * 
 */
package cn.aposoft.ecommerce.payment.wechat.impl;

import java.util.List;

/**
 * 退款查询响应报文
 * <p>
 * 退款金额 refund_fee_$n 是 Int 100 退款总金额,单位为分,可以做部分退款
 * </p>
 * <p>
 * 货币种类 fee_type_$n 否 String(8) CNY 货币类型，符合ISO
 * 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型
 * </p>
 * <p>
 * 代金券或立减优惠退款金额 coupon_refund_fee_$n 否 Int 100
 * 代金券或立减优惠退款金额<=退款金额，退款金额-代金券或立减优惠退款金额为现金，说明详见代金券或立减优惠
 * </p>
 * <p>
 * 代金券或立减优惠使用数量 coupon_refund_count_$n 否 Int 1 代金券或立减优惠使用数量 ,$n为下标,从0开始编号
 * </p>
 * <p>
 * 代金券或立减优惠批次ID coupon_refund_batch_id_$n_$m
 * 
 * 否 String(20) 100 批次ID ,$n为下标，$m为下标，从0开始编号
 * </p>
 * <p>
 * 代金券或立减优惠ID coupon_refund_id_$n_$m 否 String(20) 10000 代金券或立减优惠ID,
 * $n为下标，$m为下标，从0开始编号
 * </p>
 * <p>
 * 单个代金券或立减优惠支付金额 coupon_refund_fee_$n_$m 否 Int 100 单个代金券或立减优惠支付金额,$n为下标，$m为下标，
 * 从0开始编号
 * </p>
 * <p>
 * 退款状态 refund_status_$n 是 String(16) SUCCESS 退款状态：
 * 
 * SUCCESS—退款成功
 * 
 * FAIL—退款失败
 * 
 * PROCESSING—退款处理中
 * 
 * NOTSURE—未确定，需要商户原退款单号重新发起
 * 
 * CHANGE—转入代发，退款到银行发现用户的卡作废或者冻结了，导致原路退款银行卡失败，资金回流到商户的现金帐号，需要商户人工干预，
 * 通过线下或者财付通转账的方式进行退款。
 * </p>
 * 
 * <pre>
   <xml>
	   <appid><![CDATA[wx2421b1c4370ec43b]]></appid>
	   <mch_id><![CDATA[10000100]]></mch_id>
	   <nonce_str><![CDATA[TeqClE3i0mvn3DrK]]></nonce_str>
	   <out_refund_no_0><![CDATA[1415701182]]></out_refund_no_0>
	   <out_trade_no><![CDATA[1415757673]]></out_trade_no>
	   <refund_count>1</refund_count>
	   <refund_fee_0>1</refund_fee_0>
	   <refund_id_0><![CDATA[2008450740201411110000174436]]></refund_id_0>
	   <refund_status_0><![CDATA[PROCESSING]]></refund_status_0>
	   <result_code><![CDATA[SUCCESS]]></result_code>
	   <return_code><![CDATA[SUCCESS]]></return_code>
	   <return_msg><![CDATA[OK]]></return_msg>
	   <sign><![CDATA[1F2841558E233C33ABA71A961D27561C]]></sign>
	   <transaction_id><![CDATA[1008450740201411110005820873]]></transaction_id>
	</xml>
 * </pre>
 * 
 * <pre>
		错误码
		<ul>
			<li>名称 	描述 	原因 	解决方案</li>
			<li>SYSTEMERROR 	接口返回错误 	系统超时 	请尝试再次掉调用API。</li>
			<li>INVALID_TRANSACTIONID 	无效transaction_id 	请求参数未按指引进行填写 	请求参数错误，检查原交易号是否存在或发起支付交易接口返回失败</li>
			<li>PARAM_ERROR 	参数错误 	请求参数未按指引进行填写 	请求参数错误，请检查参数再调用退款申请</li>
			<li>APPID_NOT_EXIST 	APPID不存在 	参数中缺少APPID 	请检查APPID是否正确</li>
			<li>MCHID_NOT_EXIST 	MCHID不存在 	参数中缺少MCHID 	请检查MCHID是否正确</li>
			<li>APPID_MCHID_NOT_MATCH 	appid和mch_id不匹配 	appid和mch_id不匹配 	请确认appid和mch_id是否匹配</li>
			<li>REQUIRE_POST_METHOD 	请使用post方法 	未使用post传递参数  	请检查请求参数是否通过post方法提交</li>
			<li>SIGNERROR 	签名错误 	参数签名结果不正确 	请检查签名参数和方法是否都符合签名算法要求</li>
			<li>XML_FORMAT_ERROR 	XML格式错误 	XML格式错误 	请检查XML参数格式是否正确</li>
		</ul>
 * </pre>
 * 
 * 
 * @author Jann Liu
 *
 */
public class RefundQueryResponse extends ResponseBase {
	/**
	 * 微信订单号 transaction_id 是 String(32) 1217752501201407033233368018 微信订单号
	 */
	private String transaction_id;

	/**
	 * 商户订单号 out_trade_no 是 String(32) 1217752501201407033233368018 商户系统内部的订单号
	 */
	private String out_trade_no;
	/**
	 * 订单总金额 total_fee 是 Int 100 订单总金额，单位为分，只能为整数， 详见支付金额
	 */
	private Integer total_fee;
	/**
	 * 订单金额货币种类 fee_type 否
	 * 
	 * String(8) CNY 订单金额货币类型，符合ISO 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型
	 */
	private String fee_type;
	/**
	 * 现金支付金额 cash_fee 是 Int 100 现金支付金额，单位为分，只能为整数， 详见支付金额
	 */
	private Integer cash_fee;

	/**
	 * 退款笔数 refund_count 是 Int 1 退款记录数
	 */
	private Integer refund_count;

	/**
	 * 退款单明细列表
	 */
	private List<RefundBill> refundBillItems;

	/**
	 * 商户退款单号 out_refund_no_$n 是String(32) 1217752501201407033233368018 商户退款单号
	 */
	/**
	 * 微信退款单号 refund_id_$n 是 String(28) 1217752501201407033233368018 微信退款单号
	 */

	/**
	 * 退款渠道 refund_channel_$n 否 String(16) ORIGINAL ORIGINAL—原路退款 BALANCE—退回到余额
	 */
	/**
	 * @return the transaction_id
	 */
	public String getTransaction_id() {
		return transaction_id;
	}

	/**
	 * @param transaction_id
	 *            the transaction_id to set
	 */
	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}

	/**
	 * @return the out_trade_no
	 */
	public String getOut_trade_no() {
		return out_trade_no;
	}

	/**
	 * @param out_trade_no
	 *            the out_trade_no to set
	 */
	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	/**
	 * @return the total_fee
	 */
	public Integer getTotal_fee() {
		return total_fee;
	}

	/**
	 * @param total_fee
	 *            the total_fee to set
	 */
	public void setTotal_fee(Integer total_fee) {
		this.total_fee = total_fee;
	}

	/**
	 * @return the fee_type
	 */
	public String getFee_type() {
		return fee_type;
	}

	/**
	 * @param fee_type
	 *            the fee_type to set
	 */
	public void setFee_type(String fee_type) {
		this.fee_type = fee_type;
	}

	/**
	 * @return the cash_fee
	 */
	public Integer getCash_fee() {
		return cash_fee;
	}

	/**
	 * @param cash_fee
	 *            the cash_fee to set
	 */
	public void setCash_fee(Integer cash_fee) {
		this.cash_fee = cash_fee;
	}

	/**
	 * @return the refund_count
	 */
	public Integer getRefund_count() {
		return refund_count;
	}

	/**
	 * @param refund_count
	 *            the refund_count to set
	 */
	public void setRefund_count(Integer refund_count) {
		this.refund_count = refund_count;
	}

	/**
	 * 退款单明细记录列表
	 * 
	 * @return 退款单明细记录列表
	 */
	public List<RefundBill> getRefundBillItems() {
		return refundBillItems;
	}

	/**
	 * 设置退款单明细记录
	 * 
	 * @param refundBillItems
	 *            待设置的退款单明细记录
	 */
	public void setRefundBillItems(List<RefundBill> refundBillItems) {
		this.refundBillItems = refundBillItems;
	}

}
