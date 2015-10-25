package cn.aposoft.ecommerce.payment.wechat;

/**
 * 退款信息
 * 
 * @author Yujinshui
 *
 */
public interface Refund {
	String getAppid();

	String getMch_id();

	String getDevice_info();

	String getNonce_str();

	String getSign();

	Integer getTotal_fee();

	String getOut_trade_no();

	String getTransaction_id();

	String getOut_refund_no();

	Integer getRefund_fee();

	String getRefund_fee_type();

	String getOp_user_id();

}
