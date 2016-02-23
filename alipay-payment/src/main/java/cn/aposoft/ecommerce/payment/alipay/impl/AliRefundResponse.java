package cn.aposoft.ecommerce.payment.alipay.impl;

/**
 * 退款请求-返回结果bean
 * <p>
 * 
 * @author Yujinshui
 *
 */
public class AliRefundResponse extends ResponseBase {

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
	private String refund_fee;
	/**
	 * 退款时间
	 * <p>
	 * 退款时间，格式为yyyy-MM-ddHH:mm:ss。
	 */
	private String gmt_refund_pay;

	/**
	 * 退款渠道列表，直接返回refund_detail_item_list的全部内容，不进行解析
	 * <p>
	 * 退款金额的退回渠道，xml格式，可返回多个退款渠道子节点<TradeFundBill>，该节点包含的参数请参见“5.3退款渠道列表信息”。
	 */
	private String refund_detail_item_list;

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

	public String getRefund_fee() {
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

	public void setRefund_fee(String refund_fee) {
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

	public String getGmt_refund_pay() {
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

	public void setGmt_refund_pay(String gmt_refund_pay) {
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

	public String getRefund_detail_item_list() {
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

	public void setRefund_detail_item_list(String refund_detail_item_list) {
		this.refund_detail_item_list = refund_detail_item_list;
	}

	public String toString() {
		return "本地计算的签名值localSign：" + localSign //
				+ "\r\n <br> isAliPay：" + isAliPay //
				+ "\r\n <br> 解析失败时返回returnXml：" + returnXml //
				+ "\r\n <br> sign_type：" + sign_type //
				+ "\r\n <br> sign：" + sign //
				+ "\r\n <br> is_success：" + is_success //
				+ "\r\n <br> error：" + error //
				+ "\r\n <br> result_code：" + result_code //
				+ "\r\n <br> trade_no：" + trade_no //
				+ "\r\n <br> out_trade_no：" + out_trade_no //
				+ "\r\n <br> detail_error_code：" + detail_error_code //
				+ "\r\n <br> detail_error_des：" + detail_error_des //
				+ "\r\n <br> returnXml：" + returnXml //
				+ "\r\n <br> buyer_user_id：" + buyer_user_id //
				+ "\r\n <br> buyer_logon_id：" + buyer_logon_id //
				+ "\r\n <br> fund_change：" + fund_change //
				+ "\r\n <br> refund_fee：" + refund_fee //
				+ "\r\n <br> gmt_refund_pay：" + gmt_refund_pay //
				+ "\r\n <br> refund_detail_item_list：" + refund_detail_item_list;
	}
}