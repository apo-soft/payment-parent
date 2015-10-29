package cn.aposoft.ecommerce.payment.wechat.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RefundQueryCouponParser extends AbstractCouponParser implements RefundResultParser {

	private static final String OUT_REFUND_NO_PREFIX = "out_refund_no_$";
	private static final String REFUND_ID_PREFIX = "refund_id_$";
	private static final String REFUND_CHANNEL_PREFIX = "refund_channel_$";
	private static final String REFUND_FEE_PREFIX = "refund_fee_$";
	private static final String COUPON_REFUND_FEE_PREFIX = "coupon_refund_fee_$";

	private static final String COUPON_REFUND_COUNT_PREFIX = "coupon_refund_count_$";

	private static final String REFUND_STATUS_PREFIX = "refund_status_$";

	private static final String COUPON_REFUND_BATCH_ID_PATTERN_TEXT = "^coupon_refund_batch_id_\\$(\\d+)_\\$(\\d+)$";
	private static final String COUPON_REFUND_ID_PATTERN_TEXT = "^coupon_refund_id_\\$(\\d+)_\\$(\\d+)$";
	private static final String COUPON_REFUND_FEE_PATTERN_TEXT = "^coupon_refund_fee_\\$(\\d+)_\\$(\\d+)$";

	private static final Pattern COUPON_REFUND_BATCH_ID_PATTERN = Pattern.compile(COUPON_REFUND_BATCH_ID_PATTERN_TEXT);
	private static final Pattern COUPON_REFUND_ID_PATTERN = Pattern.compile(COUPON_REFUND_ID_PATTERN_TEXT);
	private static final Pattern COUPON_REFUND_FEE_PATTERN = Pattern.compile(COUPON_REFUND_FEE_PATTERN_TEXT);

	/////////////////////////////////////////////////////////////////////
	/**
	 * 商户退款单号 out_refund_no_$n 是 String(32) 1217752501201407033233368018 商户退款单号
	 */
	@Override
	public boolean isOut_refund_no(String key) {
		return key != null && key.startsWith(OUT_REFUND_NO_PREFIX);
	}

	/**
	 * 微信退款单号 refund_id_$n 是 String(28) 1217752501201407033233368018 微信退款单号
	 * 
	 * @see cn.aposoft.ecommerce.payment.wechat.util.RefundResultParser#isRefund_id(java.lang.String)
	 */
	@Override
	public boolean isRefund_id(String key) {
		return key != null && key.startsWith(REFUND_ID_PREFIX);
	}

	/**
	 * 退款渠道 refund_channel_$n 否 String(16) ORIGINAL
	 * 
	 * ORIGINAL—原路退款
	 * 
	 * BALANCE—退回到余额
	 * 
	 * @see cn.aposoft.ecommerce.payment.wechat.util.RefundResultParser#isRefund_channel(String
	 *      )
	 */
	@Override
	public boolean isRefund_channel(String key) {
		return key != null && key.startsWith(REFUND_CHANNEL_PREFIX);
	}

	/**
	 * 退款金额 refund_fee_$n 是 Int 100 退款总金额,单位为分,可以做部分退款
	 * 
	 * @see cn.aposoft.ecommerce.payment.wechat.util.RefundResultParser#isRefund_fee(String)
	 */
	@Override
	public boolean isRefund_fee(String key) {
		return key != null && key.startsWith(REFUND_FEE_PREFIX);
	}

	/**
	 * 代金券或立减优惠退款金额 coupon_refund_fee_$n 否 Int 100
	 * 代金券或立减优惠退款金额<=退款金额，退款金额-代金券或立减优惠退款金额为现金，说明详见代金券或立减优惠
	 * 
	 * @see cn.aposoft.ecommerce.payment.wechat.util.RefundResultParser#isCoupon_refund_fee(String)
	 */
	@Override
	public boolean isCoupon_refund_fee(String key) {
		return key != null && key.startsWith(COUPON_REFUND_FEE_PREFIX);
	}

	/**
	 * 代金券或立减优惠使用数量 coupon_refund_count_$n 否 Int 1 代金券或立减优惠使用数量 ,$n为下标,从0开始编号
	 * 
	 * @see cn.aposoft.ecommerce.payment.wechat.util.RefundResultParser#isCoupon_refund_count(String)
	 */
	@Override
	public boolean isCoupon_refund_count(String key) {
		return key != null && key.startsWith(COUPON_REFUND_COUNT_PREFIX);
	}

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
	 * 
	 * @see cn.aposoft.ecommerce.payment.wechat.util.RefundResultParser#isRefund_status(String)
	 */
	@Override
	public boolean isRefund_status(String key) {
		return key != null && key.startsWith(REFUND_STATUS_PREFIX);
	}

	////////////////////////////////////////////////////////////////////
	// 优惠券字段判断
	/**
	 * @return the m 第二个$字段后面的数字m
	 */
	@Override
	public int getM(String key) {
		Matcher matcher = COMMON_DOUBLE_DOLLAR_PATTERN.matcher(key);
		return CommonUtil.parseNum(matcher.group(2));
	}

	/**
	 * 优惠券批次id {@code coupon_refund_batch_id_$n_$m}
	 * 
	 * @see cn.aposoft.ecommerce.payment.wechat.util.CouponParser#isCoupon_batch_id(
	 *      java.lang.String)
	 */
	@Override
	public boolean isCoupon_batch_id(String key) {
		return matches(COUPON_REFUND_BATCH_ID_PATTERN, key);
	}

	/**
	 * 优惠券id {@code coupon_refund_id_$n_$m}
	 */
	@Override
	public boolean isCoupon_id(String key) {
		return matches(COUPON_REFUND_ID_PATTERN, key);
	}

	/**
	 * 优惠券金额 {@code coupon_refund_fee_$n_$m}
	 */
	@Override
	public boolean isCoupon_fee(String key) {
		return matches(COUPON_REFUND_FEE_PATTERN, key);
	}

	private boolean matches(Pattern pattern, String key) {
		Matcher m = pattern.matcher(key);
		return m.matches();
	}

}
