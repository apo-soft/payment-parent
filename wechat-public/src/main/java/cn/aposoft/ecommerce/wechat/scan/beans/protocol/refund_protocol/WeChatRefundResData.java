package cn.aposoft.ecommerce.wechat.scan.beans.protocol.refund_protocol;

/**
 * 退款返回参数
 * https://pay.weixin.qq.com/wiki/doc/api/jsapi_sl.php?chapter=9_4
 */
public class WeChatRefundResData {

    //协议层
    /**
     * 返回状态码
     */
    private String return_code;
    /**
     * 返回信息
     */
    private String return_msg;

    //协议返回的具体数据（以下字段在return_code 为SUCCESS 的时候有返回）
    /**
     * 业务结果
     */
    private String result_code;
    /**
     * 错误代码
     */
    private String err_code;
    /**
     * 错误代码描述
     */
    private String err_code_des;
    /**
     * 公众账号ID
     */
    private String appid;
    /**
     * 商户号
     */
    private String mch_id;
    /**
     * 子商户公众账号ID
     */
    private String sub_appid;
    /**
     * 子商户号
     */
    private String sub_mch_id;
    /**
     * 随机字符串
     */
    private String nonce_str;
    /**
     * 签名
     */
    private String sign;
    /**
     * 微信订单号
     */
    private String transaction_id;
    /**
     * 商户订单号
     */
    private String out_trade_no;
    /**
     * 商户退款单号
     */
    private String out_refund_no;
    /**
     * 微信退款单号
     */
    private String refund_id;
    /**
     * 申请退款金额
     */
    private int refund_fee;
    /**
     * 退款金额
     */
    private int settlement_refund_fee;
    /**
     * 订单金额
     */
    private int total_fee;
    /**
     * 应结订单金额
     */
    private int settlement_total_fee;
    /**
     * 货币种类
     */
    private String fee_type;
    /**
     * 现金支付金额
     */
    private int cash_fee;
    /**
     * 现金退款金额
     */
    private int cash_refund_fee;
    /**
     * 代金券退款总金额
     */
    private int coupon_refund_fee;
    /**
     * 退款代金券使用数量
     */
    private int coupon_refund_count;
    /**
     * 代金券类型
     */
    private String coupon_type_$n;
    /**
     * 退款代金券ID
     */
    private String coupon_refund_id_$n;
    /**
     * 单个代金券退款金额
     */
    private int coupon_refund_fee_$n;


    public String getReturn_code() {
        return return_code;
    }

    public WeChatRefundResData setReturn_code(String return_code) {
        this.return_code = return_code;
        return this;
    }

    public String getReturn_msg() {
        return return_msg;
    }

    public WeChatRefundResData setReturn_msg(String return_msg) {
        this.return_msg = return_msg;
        return this;
    }

    public String getResult_code() {
        return result_code;
    }

    public WeChatRefundResData setResult_code(String result_code) {
        this.result_code = result_code;
        return this;
    }

    public String getErr_code() {
        return err_code;
    }

    public WeChatRefundResData setErr_code(String err_code) {
        this.err_code = err_code;
        return this;
    }

    public String getErr_code_des() {
        return err_code_des;
    }

    public WeChatRefundResData setErr_code_des(String err_code_des) {
        this.err_code_des = err_code_des;
        return this;
    }

    public String getAppid() {
        return appid;
    }

    public WeChatRefundResData setAppid(String appid) {
        this.appid = appid;
        return this;
    }

    public String getMch_id() {
        return mch_id;
    }

    public WeChatRefundResData setMch_id(String mch_id) {
        this.mch_id = mch_id;
        return this;
    }

    public String getSub_mch_id() {
        return sub_mch_id;
    }

    public WeChatRefundResData setSub_mch_id(String sub_mch_id) {
        this.sub_mch_id = sub_mch_id;
        return this;
    }

    public String getNonce_str() {
        return nonce_str;
    }

    public WeChatRefundResData setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
        return this;
    }

    public String getSign() {
        return sign;
    }

    public WeChatRefundResData setSign(String sign) {
        this.sign = sign;
        return this;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public WeChatRefundResData setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
        return this;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public WeChatRefundResData setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
        return this;
    }

    public String getOut_refund_no() {
        return out_refund_no;
    }

    public WeChatRefundResData setOut_refund_no(String out_refund_no) {
        this.out_refund_no = out_refund_no;
        return this;
    }

    public String getRefund_id() {
        return refund_id;
    }

    public WeChatRefundResData setRefund_id(String refund_id) {
        this.refund_id = refund_id;
        return this;
    }

    public int getRefund_fee() {
        return refund_fee;
    }

    public WeChatRefundResData setRefund_fee(int refund_fee) {
        this.refund_fee = refund_fee;
        return this;
    }

    public int getSettlement_refund_fee() {
        return settlement_refund_fee;
    }

    public WeChatRefundResData setSettlement_refund_fee(int settlement_refund_fee) {
        this.settlement_refund_fee = settlement_refund_fee;
        return this;
    }

    public int getTotal_fee() {
        return total_fee;
    }

    public WeChatRefundResData setTotal_fee(int total_fee) {
        this.total_fee = total_fee;
        return this;
    }

    public int getSettlement_total_fee() {
        return settlement_total_fee;
    }

    public WeChatRefundResData setSettlement_total_fee(int settlement_total_fee) {
        this.settlement_total_fee = settlement_total_fee;
        return this;
    }

    public String getFee_type() {
        return fee_type;
    }

    public WeChatRefundResData setFee_type(String fee_type) {
        this.fee_type = fee_type;
        return this;
    }

    public int getCash_fee() {
        return cash_fee;
    }

    public WeChatRefundResData setCash_fee(int cash_fee) {
        this.cash_fee = cash_fee;
        return this;
    }

    public int getCash_refund_fee() {
        return cash_refund_fee;
    }

    public WeChatRefundResData setCash_refund_fee(int cash_refund_fee) {
        this.cash_refund_fee = cash_refund_fee;
        return this;
    }

    public int getCoupon_refund_fee() {
        return coupon_refund_fee;
    }

    public WeChatRefundResData setCoupon_refund_fee(int coupon_refund_fee) {
        this.coupon_refund_fee = coupon_refund_fee;
        return this;
    }

    public int getCoupon_refund_count() {
        return coupon_refund_count;
    }

    public WeChatRefundResData setCoupon_refund_count(int coupon_refund_count) {
        this.coupon_refund_count = coupon_refund_count;
        return this;
    }

    public String getCoupon_type_$n() {
        return coupon_type_$n;
    }

    public WeChatRefundResData setCoupon_type_$n(String coupon_type_$n) {
        this.coupon_type_$n = coupon_type_$n;
        return this;
    }

    public String getCoupon_refund_id_$n() {
        return coupon_refund_id_$n;
    }

    public WeChatRefundResData setCoupon_refund_id_$n(String coupon_refund_id_$n) {
        this.coupon_refund_id_$n = coupon_refund_id_$n;
        return this;
    }

    public int getCoupon_refund_fee_$n() {
        return coupon_refund_fee_$n;
    }

    public WeChatRefundResData setCoupon_refund_fee_$n(int coupon_refund_fee_$n) {
        this.coupon_refund_fee_$n = coupon_refund_fee_$n;
        return this;
    }
}
