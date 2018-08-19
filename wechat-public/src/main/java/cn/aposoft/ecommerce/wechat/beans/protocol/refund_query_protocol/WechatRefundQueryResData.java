package cn.aposoft.ecommerce.wechat.beans.protocol.refund_query_protocol;

import cn.aposoft.ecommerce.wechat.beans.protocol.BaseResponseBeans;


/**
 * https://pay.weixin.qq.com/wiki/doc/api/jsapi_sl.php?chapter=9_5
 * User: rizenguo
 * Date: 2014/10/25
 * Time: 16:36
 */
public class WechatRefundQueryResData extends BaseResponseBeans {


    //协议返回的具体数据（以下字段在return_code 为SUCCESS 的时候有返回）
    private String result_code;
    private String err_code;
    private String err_code_des;


    private String transaction_id;
    private String out_trade_no;
    private int total_fee;
    private int settlement_total_fee;

    private String fee_type = "CNY";

    private int cash_fee = 0;
    private int refund_count = 0;


    private String out_refund_no_$n;
    private String refund_id_$n;
    private String refund_channel_$n;

    private int total_refund_count;
    private int refund_fee_$n;
    private int settlement_refund_fee_$n;

    /**
     * 代金券类型
     */
    private String coupon_type_$n_$m;
    /**
     * 总代金券退款金额
     */
    private int coupon_refund_fee_$n;
    /**
     * 退款代金券使用数量
     */
    private int coupon_refund_count_$n;
    /**
     * 退款代金券ID
     */
    private String coupon_refund_id_$n_$m;
    /**
     * 单个代金券退款金额
     */
    private int coupon_refund_fee_$n_$m;
    /**
     * 退款状态
     */
    private String refund_status_$n;
    /**
     * 退款资金来源
     */
    private String refund_account_$n;
    /**
     * 退款入账账户
     */
    private String refund_recv_accout_$n;
    /**
     * 退款成功时间
     */
    private String refund_success_time_$n;

    public String getResult_code() {
        return result_code;
    }

    public WechatRefundQueryResData setResult_code(String result_code) {
        this.result_code = result_code;
        return this;
    }

    public String getErr_code() {
        return err_code;
    }

    public WechatRefundQueryResData setErr_code(String err_code) {
        this.err_code = err_code;
        return this;
    }

    public String getErr_code_des() {
        return err_code_des;
    }

    public WechatRefundQueryResData setErr_code_des(String err_code_des) {
        this.err_code_des = err_code_des;
        return this;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public WechatRefundQueryResData setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
        return this;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public WechatRefundQueryResData setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
        return this;
    }

    public int getTotal_fee() {
        return total_fee;
    }

    public WechatRefundQueryResData setTotal_fee(int total_fee) {
        this.total_fee = total_fee;
        return this;
    }

    public int getSettlement_total_fee() {
        return settlement_total_fee;
    }

    public WechatRefundQueryResData setSettlement_total_fee(int settlement_total_fee) {
        this.settlement_total_fee = settlement_total_fee;
        return this;
    }

    public String getFee_type() {
        return fee_type;
    }

    public WechatRefundQueryResData setFee_type(String fee_type) {
        this.fee_type = fee_type;
        return this;
    }

    public int getCash_fee() {
        return cash_fee;
    }

    public WechatRefundQueryResData setCash_fee(int cash_fee) {
        this.cash_fee = cash_fee;
        return this;
    }

    public int getRefund_count() {
        return refund_count;
    }

    public WechatRefundQueryResData setRefund_count(int refund_count) {
        this.refund_count = refund_count;
        return this;
    }

    public String getOut_refund_no_$n() {
        return out_refund_no_$n;
    }

    public WechatRefundQueryResData setOut_refund_no_$n(String out_refund_no_$n) {
        this.out_refund_no_$n = out_refund_no_$n;
        return this;
    }

    public String getRefund_id_$n() {
        return refund_id_$n;
    }

    public WechatRefundQueryResData setRefund_id_$n(String refund_id_$n) {
        this.refund_id_$n = refund_id_$n;
        return this;
    }

    public String getRefund_channel_$n() {
        return refund_channel_$n;
    }

    public WechatRefundQueryResData setRefund_channel_$n(String refund_channel_$n) {
        this.refund_channel_$n = refund_channel_$n;
        return this;
    }

    public int getTotal_refund_count() {
        return total_refund_count;
    }

    public WechatRefundQueryResData setTotal_refund_count(int total_refund_count) {
        this.total_refund_count = total_refund_count;
        return this;
    }

    public int getRefund_fee_$n() {
        return refund_fee_$n;
    }

    public WechatRefundQueryResData setRefund_fee_$n(int refund_fee_$n) {
        this.refund_fee_$n = refund_fee_$n;
        return this;
    }

    public int getSettlement_refund_fee_$n() {
        return settlement_refund_fee_$n;
    }

    public WechatRefundQueryResData setSettlement_refund_fee_$n(int settlement_refund_fee_$n) {
        this.settlement_refund_fee_$n = settlement_refund_fee_$n;
        return this;
    }

    public String getCoupon_type_$n_$m() {
        return coupon_type_$n_$m;
    }

    public WechatRefundQueryResData setCoupon_type_$n_$m(String coupon_type_$n_$m) {
        this.coupon_type_$n_$m = coupon_type_$n_$m;
        return this;
    }

    public int getCoupon_refund_fee_$n() {
        return coupon_refund_fee_$n;
    }

    public WechatRefundQueryResData setCoupon_refund_fee_$n(int coupon_refund_fee_$n) {
        this.coupon_refund_fee_$n = coupon_refund_fee_$n;
        return this;
    }

    public int getCoupon_refund_count_$n() {
        return coupon_refund_count_$n;
    }

    public WechatRefundQueryResData setCoupon_refund_count_$n(int coupon_refund_count_$n) {
        this.coupon_refund_count_$n = coupon_refund_count_$n;
        return this;
    }

    public String getCoupon_refund_id_$n_$m() {
        return coupon_refund_id_$n_$m;
    }

    public WechatRefundQueryResData setCoupon_refund_id_$n_$m(String coupon_refund_id_$n_$m) {
        this.coupon_refund_id_$n_$m = coupon_refund_id_$n_$m;
        return this;
    }

    public int getCoupon_refund_fee_$n_$m() {
        return coupon_refund_fee_$n_$m;
    }

    public WechatRefundQueryResData setCoupon_refund_fee_$n_$m(int coupon_refund_fee_$n_$m) {
        this.coupon_refund_fee_$n_$m = coupon_refund_fee_$n_$m;
        return this;
    }

    public String getRefund_status_$n() {
        return refund_status_$n;
    }

    public WechatRefundQueryResData setRefund_status_$n(String refund_status_$n) {
        this.refund_status_$n = refund_status_$n;
        return this;
    }

    public String getRefund_account_$n() {
        return refund_account_$n;
    }

    public WechatRefundQueryResData setRefund_account_$n(String refund_account_$n) {
        this.refund_account_$n = refund_account_$n;
        return this;
    }

    public String getRefund_recv_accout_$n() {
        return refund_recv_accout_$n;
    }

    public WechatRefundQueryResData setRefund_recv_accout_$n(String refund_recv_accout_$n) {
        this.refund_recv_accout_$n = refund_recv_accout_$n;
        return this;
    }

    public String getRefund_success_time_$n() {
        return refund_success_time_$n;
    }

    public WechatRefundQueryResData setRefund_success_time_$n(String refund_success_time_$n) {
        this.refund_success_time_$n = refund_success_time_$n;
        return this;
    }
}
