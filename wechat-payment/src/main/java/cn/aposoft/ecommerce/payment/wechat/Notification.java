/**
 * 
 */
package cn.aposoft.ecommerce.payment.wechat;

import cn.aposoft.ecommerce.payment.wechat.impl.PayBase;

/**
 * 支付成功后的回调结果生成javabean
 * 
 * @author LiuJian
 *
 */
public class Notification extends PayBase {

	private String return_code;// 返回状态码【是】
	private String return_msg;// 返回信息【否】
	// 以下字段在return_code为SUCCESS的时候有返回
	private String result_code;// 业务结果【是】String(16)
	private String err_code;// 错误代码【否】String(32)
	private String err_code_des;// 错误代码描述【否】String(128
	private String openid;// 用户标识【是】String(128
	private String is_subscribe;// 是否关注公众账号【否】String(1)
	private String trade_type;// 交易类型【是】String(16)
	private String bank_type;// 付款银行【是】String(16)
	private String fee_type;// 货币种类【否】String(8)
	private String cash_fee;// 现金支付金额【是】Int
	private String cash_fee_type;// 现金支付货币类型【否】String(16)
	private String coupon_fee;// 代金券或立减优惠金额【否】Int
	private String coupon_count;// 代金券或立减优惠使用数量【否】Int
	private String coupon_id_$n;// 代金券或立减优惠ID【否】String(20)
	private String coupon_fee_$n;// 单个代金券或立减优惠支付金额【否】Int
	private String transaction_id;// 微信支付订单号【是】String(32)
	private String attach;// 商家数据包【否】String(128
	private String time_end;// 支付完成时间【是】String(14)

	public String getReturn_code() {
		return return_code;
	}

	public void setReturn_code(String return_code) {
		this.return_code = return_code;
	}

	public String getReturn_msg() {
		return return_msg;
	}

	public void setReturn_msg(String return_msg) {
		this.return_msg = return_msg;
	}

	public String getResult_code() {
		return result_code;
	}

	public void setResult_code(String result_code) {
		this.result_code = result_code;
	}

	public String getErr_code() {
		return err_code;
	}

	public void setErr_code(String err_code) {
		this.err_code = err_code;
	}

	public String getErr_code_des() {
		return err_code_des;
	}

	public void setErr_code_des(String err_code_des) {
		this.err_code_des = err_code_des;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getIs_subscribe() {
		return is_subscribe;
	}

	public void setIs_subscribe(String is_subscribe) {
		this.is_subscribe = is_subscribe;
	}

	public String getTrade_type() {
		return trade_type;
	}

	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}

	public String getBank_type() {
		return bank_type;
	}

	public void setBank_type(String bank_type) {
		this.bank_type = bank_type;
	}

	public String getFee_type() {
		return fee_type;
	}

	public void setFee_type(String fee_type) {
		this.fee_type = fee_type;
	}

	public String getCash_fee() {
		return cash_fee;
	}

	public void setCash_fee(String cash_fee) {
		this.cash_fee = cash_fee;
	}

	public String getCash_fee_type() {
		return cash_fee_type;
	}

	public void setCash_fee_type(String cash_fee_type) {
		this.cash_fee_type = cash_fee_type;
	}

	public String getCoupon_fee() {
		return coupon_fee;
	}

	public void setCoupon_fee(String coupon_fee) {
		this.coupon_fee = coupon_fee;
	}

	public String getCoupon_count() {
		return coupon_count;
	}

	public void setCoupon_count(String coupon_count) {
		this.coupon_count = coupon_count;
	}

	public String getCoupon_id_$n() {
		return coupon_id_$n;
	}

	public void setCoupon_id_$n(String coupon_id_$n) {
		this.coupon_id_$n = coupon_id_$n;
	}

	public String getCoupon_fee_$n() {
		return coupon_fee_$n;
	}

	public void setCoupon_fee_$n(String coupon_fee_$n) {
		this.coupon_fee_$n = coupon_fee_$n;
	}

	public String getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}

	public String getAttach() {
		return attach;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}

	public String getTime_end() {
		return time_end;
	}

	public void setTime_end(String time_end) {
		this.time_end = time_end;
	}

}
