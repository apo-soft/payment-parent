/**
 * 
 */
package cn.aposoft.ecommerce.payment.wechat.util;

/**
 * 解析退款查询和订单查询中的Coupon对象字段
 * 
 * @author Jann Liu
 *
 */
public interface CouponParser {

	/**
	 * @return the n 第一个$n字段的数字
	 */
	public int getN(String key);

	/**
	 * 判定是否为优惠券批次id
	 * 
	 * @return 判定结果 true/false
	 */
	boolean isCoupon_batch_id(String key);

	/**
	 * 判定是否为优惠券id字段
	 * 
	 * @return 判定结果 true/false
	 */
	public boolean isCoupon_id(String key);

	/**
	 * 判定是否为优惠券金额字段
	 * 
	 * @return 判定结果 true/false
	 */
	public boolean isCoupon_fee(String key);

}
