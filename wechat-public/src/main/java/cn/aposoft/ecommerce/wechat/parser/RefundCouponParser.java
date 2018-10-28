package cn.aposoft.ecommerce.wechat.parser;

/**
 * 申请退款动态属性解析parser
 *
 * @author code
 * @Title: RefundCouponParser
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/10/26上午11:21
 */
public class RefundCouponParser implements CouponParser {
    private static final String COUPON_REFUND_ID_PREFIX = "coupon_refund_id_";
    private static final String COUPON_TYPE_PREFIX = "coupon_type_";
    private static final String COUPON_REFUND_FEE_PREFIX = "coupon_refund_fee_";

    @Override
    public boolean isCoupon_id(String key) {
        return key != null && key.startsWith(COUPON_REFUND_ID_PREFIX);
    }

    @Override
    public boolean isCoupon_fee(String key) {
        return key != null && key.startsWith(COUPON_REFUND_FEE_PREFIX);
    }

    @Override
    public boolean isCoupon_type(String key) {
        return key != null && key.startsWith(COUPON_TYPE_PREFIX);
    }
}
