package cn.aposoft.ecommerce.wechat.beans.protocol.pay_query_protocol;

import cn.aposoft.ecommerce.wechat.beans.protocol.BaseResponseBeans;

/**
 *
 * User: rizenguo
 * Date: 2014/10/25
 * Time: 13:54
 */
public class WechatPayQueryResData extends BaseResponseBeans {


    private String result_code;
    private String err_code;
    private String err_code_des;

    //以下字段在return_code 和result_code 都为SUCCESS 的时候有返回

    //trade_state的几种可能取值：
    //    SUCCESS--支付成功
    //    REFUND--转入退款
    //    NOTPAY--未支付
    //    CLOSED--已关闭
    //    REVOKED--已撤销
    //    USERPAYING--用户支付中
    //    NOPAY--未支付(确认支付超时)
    //    PAYERROR--支付失败(其他原因，
    //            如银行返回失败)

    //以下字段在trade_state 为SUCCESS 或者REFUND 的时候有返回
    private String device_info;
    private String openid;
    private String is_subscribe;
    private String sub_openid;
    private String sub_is_subscribe;
    private String trade_type;
    private String trade_state;
    private String bank_type;
    private String detail;
    private Integer total_fee;

    private String fee_type;
    private int settlement_total_fee;
    private int cash_fee;
    private String cash_fee_type;
    private int coupon_fee;
    private int coupon_count;
    private String coupon_id_$n;
    private String coupon_type_$n;
    private int coupon_fee_$n;

    private String transaction_id;
    private String out_trade_no;
    private String attach;
    private String time_end;
    private String trade_state_desc;

    public String getResult_code() {
        return result_code;
    }

    public WechatPayQueryResData setResult_code(String result_code) {
        this.result_code = result_code;
        return this;
    }

    public String getErr_code() {
        return err_code;
    }

    public WechatPayQueryResData setErr_code(String err_code) {
        this.err_code = err_code;
        return this;
    }

    public String getErr_code_des() {
        return err_code_des;
    }

    public WechatPayQueryResData setErr_code_des(String err_code_des) {
        this.err_code_des = err_code_des;
        return this;
    }

    public String getDevice_info() {
        return device_info;
    }

    public WechatPayQueryResData setDevice_info(String device_info) {
        this.device_info = device_info;
        return this;
    }

    public String getOpenid() {
        return openid;
    }

    public WechatPayQueryResData setOpenid(String openid) {
        this.openid = openid;
        return this;
    }

    public String getIs_subscribe() {
        return is_subscribe;
    }

    public WechatPayQueryResData setIs_subscribe(String is_subscribe) {
        this.is_subscribe = is_subscribe;
        return this;
    }

    public String getSub_openid() {
        return sub_openid;
    }

    public WechatPayQueryResData setSub_openid(String sub_openid) {
        this.sub_openid = sub_openid;
        return this;
    }

    public String getSub_is_subscribe() {
        return sub_is_subscribe;
    }

    public WechatPayQueryResData setSub_is_subscribe(String sub_is_subscribe) {
        this.sub_is_subscribe = sub_is_subscribe;
        return this;
    }

    public String getTrade_type() {
        return trade_type;
    }

    public WechatPayQueryResData setTrade_type(String trade_type) {
        this.trade_type = trade_type;
        return this;
    }

    public String getTrade_state() {
        return trade_state;
    }

    public WechatPayQueryResData setTrade_state(String trade_state) {
        this.trade_state = trade_state;
        return this;
    }

    public String getBank_type() {
        return bank_type;
    }

    public WechatPayQueryResData setBank_type(String bank_type) {
        this.bank_type = bank_type;
        return this;
    }

    public String getDetail() {
        return detail;
    }

    public WechatPayQueryResData setDetail(String detail) {
        this.detail = detail;
        return this;
    }

    public Integer getTotal_fee() {
        return total_fee;
    }

    public WechatPayQueryResData setTotal_fee(Integer total_fee) {
        this.total_fee = total_fee;
        return this;
    }

    public String getFee_type() {
        return fee_type;
    }

    public WechatPayQueryResData setFee_type(String fee_type) {
        this.fee_type = fee_type;
        return this;
    }

    public int getSettlement_total_fee() {
        return settlement_total_fee;
    }

    public WechatPayQueryResData setSettlement_total_fee(int settlement_total_fee) {
        this.settlement_total_fee = settlement_total_fee;
        return this;
    }

    public int getCash_fee() {
        return cash_fee;
    }

    public WechatPayQueryResData setCash_fee(int cash_fee) {
        this.cash_fee = cash_fee;
        return this;
    }

    public String getCash_fee_type() {
        return cash_fee_type;
    }

    public WechatPayQueryResData setCash_fee_type(String cash_fee_type) {
        this.cash_fee_type = cash_fee_type;
        return this;
    }

    public int getCoupon_fee() {
        return coupon_fee;
    }

    public WechatPayQueryResData setCoupon_fee(int coupon_fee) {
        this.coupon_fee = coupon_fee;
        return this;
    }

    public int getCoupon_count() {
        return coupon_count;
    }

    public WechatPayQueryResData setCoupon_count(int coupon_count) {
        this.coupon_count = coupon_count;
        return this;
    }

    public String getCoupon_id_$n() {
        return coupon_id_$n;
    }

    public WechatPayQueryResData setCoupon_id_$n(String coupon_id_$n) {
        this.coupon_id_$n = coupon_id_$n;
        return this;
    }

    public String getCoupon_type_$n() {
        return coupon_type_$n;
    }

    public WechatPayQueryResData setCoupon_type_$n(String coupon_type_$n) {
        this.coupon_type_$n = coupon_type_$n;
        return this;
    }

    public int getCoupon_fee_$n() {
        return coupon_fee_$n;
    }

    public WechatPayQueryResData setCoupon_fee_$n(int coupon_fee_$n) {
        this.coupon_fee_$n = coupon_fee_$n;
        return this;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public WechatPayQueryResData setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
        return this;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public WechatPayQueryResData setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
        return this;
    }

    public String getAttach() {
        return attach;
    }

    public WechatPayQueryResData setAttach(String attach) {
        this.attach = attach;
        return this;
    }

    public String getTime_end() {
        return time_end;
    }

    public WechatPayQueryResData setTime_end(String time_end) {
        this.time_end = time_end;
        return this;
    }

    public String getTrade_state_desc() {
        return trade_state_desc;
    }

    public WechatPayQueryResData setTrade_state_desc(String trade_state_desc) {
        this.trade_state_desc = trade_state_desc;
        return this;
    }
}
