package cn.aposoft.ecommerce.wechat.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 退款查询动态属性解析parser
 * @author code
 * @Title: RefundCouponParser
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/10/26上午11:21
 */
public class RefundQueryCouponParser implements RefundQueryParser {

    private static final String OUT_REFUND_NO_PREFIX = "out_refund_no_";
    private static final String REFUND_ID_PREFIX = "refund_id_";
    private static final String REFUND_CHANNEL_PREFIX = "refund_channel_";
    private static final String REFUND_FEE_PREFIX = "refund_fee_";
    private static final String SETTLEMENT_REFUND_FEE_PREFIX = "settlement_refund_fee_";


    private static final String COUPON_REFUND_COUNT_PREFIX = "coupon_refund_count_";

    private static final String REFUND_STATUS_PREFIX = "refund_status_";
    private static final String REFUND_ACCOUNT_PREFIX = "refund_account_";
    private static final String REFUND_RECV_ACCOUNT_PREFIX = "refund_recv_accout_";
    private static final String REFUND_SUCCESS_TIME_PREFIX = "refund_success_time_";


    private static final String COUPON_TYPE_PATTERN_TEXT = "^coupon_type_(\\d+)_(\\d+)$";
    private static final String COUPON_REFUND_ID_PATTERN_TEXT = "^coupon_refund_id_(\\d+)_(\\d+)$";
    private static final String COUPON_REFUND_FEE_PATTERN_TEXT = "^coupon_refund_fee_(\\d+)_(\\d+)$";

    private static final Pattern COUPON_TYPE_PATTERN = Pattern.compile(COUPON_TYPE_PATTERN_TEXT);
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
     */
    @Override
    public boolean isRefund_id(String key) {
        return key != null && key.startsWith(REFUND_ID_PREFIX);
    }

    /**
     * 退款渠道 refund_channel_$n 否 String(16) ORIGINAL
     * <p>
     * ORIGINAL—原路退款
     * <p>
     * BALANCE—退回到余额
     * <p>
     * )
     */
    @Override
    public boolean isRefund_channel(String key) {
        return key != null && key.startsWith(REFUND_CHANNEL_PREFIX);
    }

    /**
     * 退款金额 refund_fee_$n 是 Int 100 退款总金额,单位为分,可以做部分退款
     */
    @Override
    public boolean isRefund_fee(String key) {
        return key != null && key.startsWith(REFUND_FEE_PREFIX);
    }


    /**
     * 代金券或立减优惠使用数量 coupon_refund_count_$n 否 Int 1 代金券或立减优惠使用数量 ,$n为下标,从0开始编号
     */
    @Override
    public boolean isCoupon_refund_count(String key) {
        return key != null && key.startsWith(COUPON_REFUND_COUNT_PREFIX);
    }


    /**
     * 退款状态 refund_status_$n 是 String(16) SUCCESS
     * <p>
     * 退款状态：
     * <p>
     * SUCCESS—退款成功
     * <p>
     * FAIL—退款失败
     * <p>
     * PROCESSING—退款处理中
     * <p>
     * NOTSURE—未确定，需要商户原退款单号重新发起
     * <p>
     * CHANGE—转入代发，退款到银行发现用户的卡作废或者冻结了，导致原路退款银行卡失败，资金回流到商户的现金帐号，需要商户人工干预，
     * 通过线下或者财付通转账的方式进行退款。
     */
    @Override
    public boolean isRefund_status(String key) {
        return key != null && key.startsWith(REFUND_STATUS_PREFIX);
    }

    @Override
    public boolean isSettlement_refund_fee(String key) {
        return key != null && key.startsWith(SETTLEMENT_REFUND_FEE_PREFIX);
    }

    @Override
    public boolean isRefund_account(String key) {
        return key != null && key.startsWith(REFUND_ACCOUNT_PREFIX);
    }

    @Override
    public boolean isRefund_recv_accout(String key) {
        return key != null && key.startsWith(REFUND_RECV_ACCOUNT_PREFIX);
    }

    @Override
    public boolean isRefund_success_time(String key) {
        return key != null && key.startsWith(REFUND_SUCCESS_TIME_PREFIX);
    }

    @Override
    public boolean isCoupon_type(String key) {
        return matches(COUPON_TYPE_PATTERN, key);
    }

    ////////////////////////////////////////////////////////////////////
    // 优惠券字段判断

    /**
     * @return the m 第二个$字段后面的数字m
     */
//    @Override
//    public int getM(String key) {
//        Matcher matcher = COMMON_DOUBLE_DOLLAR_PATTERN.matcher(key);
//        return CommonUtil.parseNum(matcher.group(2));
//    }


    /**
     * 退款代金券ID, $n为下标，$m为下标，从0开始编号
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
