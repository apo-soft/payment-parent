
package cn.aposoft.ecommerce.wechat.parser;

/**
 * 解析退款查询和订单查询中的Coupon对象字段
 * @author code
 * @Title: RefundCouponParser
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/10/26上午11:21
 */
public interface CouponParser {

    /**
     * @return the n 第一个$n字段的数字
     */
//	public int getN(String key);

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

    /**
     * 代金券类型
     *
     * @param key
     * @return
     */
    public boolean isCoupon_type(String key);
}
