/**
 * 
 */
package cn.aposoft.ecommerce.payment.wechat;

/**
 * 专用于退款查询的优惠券解析类
 * 
 * @author Jann Liu
 *
 */
public interface RefundResultParser extends CouponParser {
	////////////////////////////////////////////////////////////////////
	// 退款查询专用字段
	/**
	 * 商户退款单号 out_refund_no_$n 是 String(32) 1217752501201407033233368018 商户退款单号
	 * 
	 * @param key
	 *            带校验字符串
	 * @return 校验结果 true/false
	 */
	public boolean isOut_refund_no(String key);

	/**
	 * 微信退款单号 refund_id_$n 是 String(28) 1217752501201407033233368018 微信退款单号
	 * 
	 * @param key
	 *            带校验字符串
	 * @return 校验结果 true/false
	 */
	public boolean isRefund_id(String key);

	/**
	 * 退款渠道 refund_channel_$n 否 String(16) ORIGINAL
	 * 
	 * ORIGINAL—原路退款
	 * 
	 * BALANCE—退回到余额
	 * 
	 * @param key
	 *            带校验字符串
	 * @return 校验结果 true/false
	 */
	public boolean isRefund_channel(String key);

	/**
	 * 退款金额 refund_fee_$n 是 Int 100 退款总金额,单位为分,可以做部分退款
	 * 
	 * @param key
	 *            带校验字符串
	 * @return 校验结果 true/false
	 */
	public boolean isRefund_fee(String key);

	/**
	 * 代金券或立减优惠退款金额 coupon_refund_fee_$n 否 Int 100
	 * 代金券或立减优惠退款金额<=退款金额，退款金额-代金券或立减优惠退款金额为现金，说明详见代金券或立减优惠
	 * 
	 * @param key
	 *            带校验字符串
	 * @return 校验结果 true/false
	 */
	public boolean isCoupon_refund_fee(String key);

	/**
	 * 代金券或立减优惠使用数量 coupon_refund_count_$n 否 Int 1 代金券或立减优惠使用数量 ,$n为下标,从0开始编号
	 * 
	 * @param key
	 *            带校验字符串
	 * @return 校验结果 true/false
	 */
	public boolean isCoupon_refund_count(String key);

	/**
	 * 代金券或立减优惠批次ID coupon_refund_batch_id_$n_$m 否 String(20) 100 批次ID
	 * ,$n为下标，$m为下标，从0开始编号
	 * 
	 * @param key
	 *            带校验字符串
	 * @return 校验结果 true/false
	 */
	public boolean isRefund_status(String key);

	////////////////////////////////////////////////////////////////////
	// 优惠券使用
	/**
	 * @return the m 第二个$字段后面的数字
	 */
	public int getM(String key);

}
