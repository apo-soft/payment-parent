/**
 * 
 */
package cn.aposoft.ecommerce.payment.wechat;

/**
 * 用于订单查询和退款单查询中,Coupon集合的管理
 * {@link https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=9_2}
 * 订单查询中取查询结果中涉及到优惠券$n的三个字段: coupon_batch_id_$n , coupon_id_$n , coupon_fee_$n
 * <p>
 * 退款单查询中去查询结果涉及到优惠券$m的三个字段:coupon_refund_batch_id_$n_$m,coupon_refund_id_$n_$m,
 * coupon_refund_fee_$n_$m
 * 
 * @author Jann Liu
 */
public class Coupon implements Comparable<Coupon> {

	/**
	 * 构建优惠券
	 * 
	 * @param n
	 *            为优惠券序号
	 */
	public Coupon(int n) {
		this.n = n;
	}

	/**
	 * 订单查询:
	 * <p>
	 * 从微信的支付返回报文中读取的sequence : n
	 * 
	 * 退款单查询
	 * <p>
	 * 在退款单中取 : m
	 */
	private final int n;

	/**
	 * 订单查询
	 * <p>
	 * 代金券或立减优惠批次ID coupon_batch_id_$n 否 String(20) 100 代金券或立减优惠批次ID
	 * ,$n为下标，从0开始编号
	 * 
	 * 退款单查询
	 * <p>
	 * 代金券或立减优惠批次ID coupon_refund_batch_id_$n_$m 否 String(20) 100 批次ID
	 * ,$n为下标，$m为下标，从0开始编号
	 */
	private String coupon_batch_id;
	/**
	 * 订单查询
	 * <p>
	 * 代金券或立减优惠ID coupon_id_$n 否 String(20) 10000 代金券或立减优惠ID, $n为下标，从0开始编号
	 * 
	 * 退款单查询
	 * <p>
	 * 代金券或立减优惠ID coupon_refund_id_$n_$m 否 String(20) 10000 代金券或立减优惠ID,
	 * $n为下标，$m为下标，从0开始编号
	 */
	private String coupon_id;

	/**
	 * 订单查询
	 * <p>
	 * 单个代金券或立减优惠支付金额 coupon_fee_$n 否 Int 100 单个代金券或立减优惠支付金额, $n为下标，从0开始编号
	 * 
	 * 退款单查询
	 * <p>
	 * 单个代金券或立减优惠支付金额 coupon_refund_fee_$n_$m 否 Int 100 单个代金券或立减优惠支付金额,
	 * $n为下标，$m为下标，从0开始编号
	 */
	private Integer coupon_fee;

	/**
	 * @return the n
	 */
	public int getN() {
		return n;
	}

	/**
	 * @return the coupon_batch_id
	 */
	public String getCoupon_batch_id() {
		return coupon_batch_id;
	}

	/**
	 * @param coupon_batch_id
	 *            the coupon_batch_id to set
	 */
	public void setCoupon_batch_id(String coupon_batch_id) {
		this.coupon_batch_id = coupon_batch_id;
	}

	/**
	 * @return the coupon_id
	 */
	public String getCoupon_id() {
		return coupon_id;
	}

	/**
	 * @param coupon_id
	 *            the coupon_id to set
	 */
	public void setCoupon_id(String coupon_id) {
		this.coupon_id = coupon_id;
	}

	/**
	 * @return the coupon_fee
	 */
	public Integer getCoupon_fee() {
		return coupon_fee;
	}

	/**
	 * @param coupon_fee
	 *            the coupon_fee to set
	 */
	public void setCoupon_fee(Integer coupon_fee) {
		this.coupon_fee = coupon_fee;
	}

	/**
	 * 根据N比较两个优惠券对象的顺序,用于排序 本比较接口的实现不保证全部情况场景下正确: 仅确保在{@code other}不为空,且
	 * {@code this.getN()} 和 {@code other.getN()}有效时,才能有正确的返回结果
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Coupon other) {
		if (this == other) {
			return 0;
		} else {
			return this.n - other.n;
		}
	}

}
