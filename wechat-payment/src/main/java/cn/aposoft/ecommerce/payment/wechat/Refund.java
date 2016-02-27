package cn.aposoft.ecommerce.payment.wechat;

import java.io.Serializable;

/**
 * 退款信息
 * 
 * @author Yujinshui
 *
 */
public interface Refund extends Serializable {

	String getDevice_info();

	String getNonce_str();

	Integer getTotal_fee();

	String getOut_trade_no();

	String getTransaction_id();

	String getOut_refund_no();

	Integer getRefund_fee();

	String getRefund_fee_type();

	String getOp_user_id();

}
