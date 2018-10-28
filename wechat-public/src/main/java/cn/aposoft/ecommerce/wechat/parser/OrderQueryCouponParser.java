package cn.aposoft.ecommerce.wechat.parser;

/**
 * 订单查询动态属性解析parser
 * @author code
 * @Title: RefundCouponParser
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/10/26上午11:21
 */
public class OrderQueryCouponParser implements CouponParser {

    /////////////////////////////////////////////////////////////////
    // coupon字符前缀
    private static final String COUPON_ID_PREFIX = "coupon_id_";
    private static final String COUPON_TYPE_PREFIX = "coupon_type_";
    private static final String COUPON_FEE_PREFIX = "coupon_fee_";


    /**
     * 是否为优惠券批次id标识符
     */
    @Override
    public boolean isCoupon_id(String key) {
        return key != null && key.startsWith(COUPON_ID_PREFIX);
    }

    @Override
    public boolean isCoupon_fee(String key) {
        return key != null && key.startsWith(COUPON_FEE_PREFIX);
    }

    /**
     * 代金券类型
     * CASH--充值代金券
     * NO_CASH---非充值优惠券
     * <p>
     * 开通免充值券功能，并且订单使用了优惠券后有返回（取值：CASH、NO_CASH）。$n为下标,从0开始编号，举例：coupon_type_$0
     *
     * @param key
     * @return
     */
    @Override
    public boolean isCoupon_type(String key) {
        return key != null && key.startsWith(COUPON_TYPE_PREFIX);
    }

}
