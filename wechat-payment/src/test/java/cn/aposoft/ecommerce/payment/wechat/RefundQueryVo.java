/**
 * 
 */
package cn.aposoft.ecommerce.payment.wechat;

/**
 * 退款查询对象实例
 * {@link https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=9_5}
 * <p>
 * 请求连接: https://api.mch.weixin.qq.com/pay/refundquery
 * 
 * @author Jann Liu
 *
 */
public class RefundQueryVo implements RefundQuery {
	/**
	 * 微信订单号 transaction_id 否 String(28) 1217752501201407033233368018 微信订单号
	 * 
	 * @return
	 */
	private String transaction_id;

	/**
	 * 商户订单号 out_trade_no 是 String(32) 1217752501201407033233368018 商户系统内部的订单号
	 */
	private String out_trade_no;

	/**
	 * 商户退款单号 out_refund_no 否 String(32) 1217752501201407033233368018 商户退款单号
	 * 
	 */
	private String out_refund_no;

	/**
	 * 微信退款单号 refund_id 否 String(28) 1217752501201407033233368018
	 * 
	 * 微信退款单号
	 * refund_id、out_refund_no、out_trade_no、transaction_id四个参数必填一个，如果同时存在优先级为：
	 * 
	 * refund_id>out_refund_no>transaction_id>out_trade_no
	 */
	private String refund_id;

	private String device_info;

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.aposoft.ecommerce.payment.wechat.RefundQuery#getTransaction_id()
	 */
	@Override
	public String getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.aposoft.ecommerce.payment.wechat.RefundQuery#getOut_trade_no()
	 */
	@Override
	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.aposoft.ecommerce.payment.wechat.RefundQuery#getOut_refund_no()
	 */
	@Override
	public String getOut_refund_no() {
		return out_refund_no;
	}

	public void setOut_refund_no(String out_refund_no) {
		this.out_refund_no = out_refund_no;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.aposoft.ecommerce.payment.wechat.RefundQuery#getRefund_id()
	 */
	@Override
	public String getRefund_id() {
		return refund_id;
	}

	public void setRefund_id(String refund_id) {
		this.refund_id = refund_id;
	}

	@Override
	public String getDevice_info() {
		return device_info;
	}

	public void setDevice_info(String device_info) {
		this.device_info = device_info;
	}
}
