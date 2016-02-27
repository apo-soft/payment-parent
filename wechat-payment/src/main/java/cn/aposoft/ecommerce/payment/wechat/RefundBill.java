/**
 * 
 */
package cn.aposoft.ecommerce.payment.wechat;

import java.util.List;

/**
 * {@code RefundBill} 是退款单记录实体 用于封装退款查询响应中,退款单明细对象内容
 * {@link https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=9_5}
 * 
 * @author Jann Liu
 *
 */
public class RefundBill implements Comparable<RefundBill> {

	/**
	 * 退款单实例构造方法
	 * 
	 * @param n
	 *            退款单序号
	 */
	public RefundBill(int n) {
		this.n = n;
	}

	/**
	 * 序号前缀
	 */
	private final int n;
	/**
	 * 商户退款单号 out_refund_no_$n 是 String(32) 1217752501201407033233368018 商户退款单号
	 */
	private String out_refund_no;
	/**
	 * 微信退款单号 refund_id_$n 是 String(28) 1217752501201407033233368018 微信退款单号
	 */
	private String refund_id;
	/**
	 * 退款渠道 refund_channel_$n 否 String(16) ORIGINAL
	 * 
	 * ORIGINAL—原路退款
	 * 
	 * BALANCE—退回到余额
	 */
	private String refund_channel;
	/**
	 * 退款金额 refund_fee_$n 是 Int 100 退款总金额,单位为分,可以做部分退款
	 */
	private Integer refund_fee;
	/**
	 * 代金券或立减优惠退款金额 coupon_refund_fee_$n 否 Int 100
	 * 代金券或立减优惠退款金额<=退款金额，退款金额-代金券或立减优惠退款金额为现金，说明详见代金券或立减优惠
	 */
	private Integer coupon_refund_fee;
	/**
	 * 代金券或立减优惠使用数量 coupon_refund_count_$n 否 Int 1 代金券或立减优惠使用数量 ,$n为下标,从0开始编号
	 */
	private Integer coupon_refund_count;
	/**
	 * 退款状态 refund_status_$n 是 String(16) SUCCESS
	 * 
	 * 退款状态：
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
	 */
	private String refund_status;

	/**
	 * 用于封装查询结果中涉及到优惠券$n的三个字段: coupon_refund_batch_id_$n_$m ,
	 * coupon_refund_id_$n_$m , coupon_refund_fee_$n_$m
	 */
	private List<Coupon> couponItems;

	/**
	 * @return the n
	 */
	public int getN() {
		return n;
	}

	/**
	 * @return the out_refund_no
	 */
	public String getOut_refund_no() {
		return out_refund_no;
	}

	/**
	 * @param out_refund_no
	 *            the out_refund_no to set
	 */
	public void setOut_refund_no(String out_refund_no) {
		this.out_refund_no = out_refund_no;
	}

	/**
	 * @return the refund_id
	 */
	public String getRefund_id() {
		return refund_id;
	}

	/**
	 * @param refund_id
	 *            the refund_id to set
	 */
	public void setRefund_id(String refund_id) {
		this.refund_id = refund_id;
	}

	/**
	 * @return the refund_channel
	 */
	public String getRefund_channel() {
		return refund_channel;
	}

	/**
	 * @param refund_channel
	 *            the refund_channel to set
	 */
	public void setRefund_channel(String refund_channel) {
		this.refund_channel = refund_channel;
	}

	/**
	 * @return the refund_fee
	 */
	public Integer getRefund_fee() {
		return refund_fee;
	}

	/**
	 * @param refund_fee
	 *            the refund_fee to set
	 */
	public void setRefund_fee(Integer refund_fee) {
		this.refund_fee = refund_fee;
	}

	/**
	 * @return the coupon_refund_fee
	 */
	public Integer getCoupon_refund_fee() {
		return coupon_refund_fee;
	}

	/**
	 * @param coupon_refund_fee
	 *            the coupon_refund_fee to set
	 */
	public void setCoupon_refund_fee(Integer coupon_refund_fee) {
		this.coupon_refund_fee = coupon_refund_fee;
	}

	/**
	 * @return the coupon_refund_count
	 */
	public Integer getCoupon_refund_count() {
		return coupon_refund_count;
	}

	/**
	 * @param coupon_refund_count
	 *            the coupon_refund_count to set
	 */
	public void setCoupon_refund_count(Integer coupon_refund_count) {
		this.coupon_refund_count = coupon_refund_count;
	}

	/**
	 * @return the refund_status
	 */
	public String getRefund_status() {
		return refund_status;
	}

	/**
	 * @param refund_status
	 *            the refund_status to set
	 */
	public void setRefund_status(String refund_status) {
		this.refund_status = refund_status;
	}

	/**
	 * @return the couponItems
	 */
	public List<Coupon> getCouponItems() {
		return couponItems;
	}

	/**
	 * @param couponItems
	 *            the couponItems to set
	 */
	public void setCouponItems(List<Coupon> couponItems) {
		this.couponItems = couponItems;
	}

	/**
	 * 根据N比较两个优惠券对象的顺序,用于排序 本比较接口的实现不保证全部情况场景下正确: 仅确保在{@code other}不为空,且
	 * {@code this.getN()} 和 {@code other.getN()}有效时,才能有正确的返回结果
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(RefundBill other) {
		if (this == other) {
			return 0;
		} else {
			return this.n - other.n;
		}
	}
}
