/**
 * 
 */
package cn.aposoft.ecommerce.payment.wechat.impl;

import cn.aposoft.ecommerce.payment.wechat.CouponParser;

/**
 * 订单查询的优惠券解析类
 * 
 * @author Jann Liu
 *
 */
public class OrderQueryCouponParser extends AbstractCouponParser implements CouponParser {

	/////////////////////////////////////////////////////////////////
	// coupon字符前缀
	private static final String COUPON_BATCH_ID_PREFIX = "coupon_batch_id_";
	private static final String COUPON_ID_PREFIX = "coupon_id_";
	private static final String COUPON_FEE_PREFIX = "coupon_fee_";

	/**
	 * 是否为优惠券批次id标识符
	 * 
	 * @see cn.aposoft.ecommerce.payment.wechat.CouponParser
	 */
	@Override
	public boolean isCoupon_batch_id(String key) {
		return key != null && key.startsWith(COUPON_BATCH_ID_PREFIX);
	}

	/**
	 * 是否为优惠券批次id标识符
	 * 
	 * @see cn.aposoft.ecommerce.payment.wechat.CouponParser
	 */
	@Override
	public boolean isCoupon_id(String key) {
		return key != null && key.startsWith(COUPON_ID_PREFIX);
	}

	@Override
	public boolean isCoupon_fee(String key) {
		return key != null && key.startsWith(COUPON_FEE_PREFIX);
	}

}
