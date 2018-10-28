
package cn.aposoft.ecommerce.wechat.parser;

/**
 * 专用于退款查询的优惠券解析类
 *
 * @author code
 * @Title: RefundCouponParser
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/10/26上午11:21
 */
public interface RefundQueryParser extends CouponParser {
    ////////////////////////////////////////////////////////////////////
    // 退款查询专用字段

    /**
     * 商户退款单号 out_refund_no_$n 是 String(32) 1217752501201407033233368018 商户退款单号
     *
     * @param key 带校验字符串
     * @return 校验结果 true/false
     */
    public boolean isOut_refund_no(String key);

    /**
     * 微信退款单号 refund_id_$n 是 String(28) 1217752501201407033233368018 微信退款单号
     *
     * @param key 带校验字符串
     * @return 校验结果 true/false
     */
    public boolean isRefund_id(String key);

    /**
     * 退款渠道 refund_channel_$n 否 String(16) ORIGINAL
     * <p>
     * ORIGINAL—原路退款
     * <p>
     * BALANCE—退回到余额
     *
     * @param key 带校验字符串
     * @return 校验结果 true/false
     */
    public boolean isRefund_channel(String key);

    /**
     * 退款金额 refund_fee_$n 是 Int 100 退款总金额,单位为分,可以做部分退款
     *
     * @param key 带校验字符串
     * @return 校验结果 true/false
     */
    public boolean isRefund_fee(String key);

    /**
     * 退款金额
     *
     * @param key
     * @return
     */
    public boolean isSettlement_refund_fee(String key);


    /**
     * 代金券或立减优惠使用数量 coupon_refund_count_$n 否 Int 1 代金券或立减优惠使用数量 ,$n为下标,从0开始编号
     *
     * @param key 带校验字符串
     * @return 校验结果 true/false
     */
    public boolean isCoupon_refund_count(String key);


    /**
     * 代金券或立减优惠批次ID coupon_refund_batch_id_$n_$m 否 String(20) 100 批次ID
     * ,$n为下标，$m为下标，从0开始编号
     *
     * @param key 带校验字符串
     * @return 校验结果 true/false
     */
    public boolean isRefund_status(String key);


    /**
     * 退款资金来源
     * REFUND_SOURCE_RECHARGE_FUNDS---可用余额退款/基本账户
     * <p>
     * REFUND_SOURCE_UNSETTLED_FUNDS---未结算资金退款
     * <p>
     * $n为下标，从0开始编号。
     *
     * @param key
     * @return
     */
    public boolean isRefund_account(String key);

    /**
     * 退款入账账户
     * 取当前退款单的退款入账方
     * 1）退回银行卡：
     * <p>
     * {银行名称}{卡类型}{卡尾号}
     * <p>
     * 2）退回支付用户零钱:
     * <p>
     * 支付用户零钱
     * <p>
     * 3）退还商户:
     * <p>
     * 商户基本账户
     * <p>
     * 商户结算银行账户
     * <p>
     * 4）退回支付用户零钱通:
     * <p>
     * 支付用户零钱通
     *
     * @param key
     * @return
     */
    public boolean isRefund_recv_accout(String key);

    /**
     * 退款成功时间，当退款状态为退款成功时有返回。$n为下标，从0开始编号。
     *
     * @param key
     * @return
     */
    public boolean isRefund_success_time(String key);


    ////////////////////////////////////////////////////////////////////
    // 优惠券使用

    /**
     * @return the m 第二个$字段后面的数字
     */
//    public int getM(String key);

}
