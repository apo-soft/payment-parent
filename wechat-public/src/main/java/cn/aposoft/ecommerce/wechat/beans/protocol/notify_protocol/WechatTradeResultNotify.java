package cn.aposoft.ecommerce.wechat.beans.protocol.notify_protocol;

/**
 * https://pay.weixin.qq.com/wiki/doc/api/jsapi_sl.php?chapter=9_7
 */
public class WechatTradeResultNotify {

    //协议层

    /**
     * SUCCESS/FAIL
     * 此字段是通信标识，非交易标识，交易是否成功需要查看result_code来判断
     */
    private String return_code;//是
    private String return_msg;

    //协议返回的具体数据（以下字段在return_code 为SUCCESS 的时候有返回）

    /**
     * 微信开放平台审核通过的应用APPID
     */
    private String appid;//是

    /**
     * 微信支付分配的商户号
     */
    private String mch_id;//是
    /**
     * 子商户公众账号ID
     */
    private String sub_appid;
    /**
     * 子商户号
     */
    private String sub_mch_id;//是
    /**
     * 微信支付分配的终端设备号
     */
    private String device_info;
    /**
     * 随机字符串，不长于32位
     */
    private String nonce_str;//是

    /**
     * 随机字符串，不长于32位
     */
    private String sign;//是
    /**
     * SUCCESS/FAIL
     */
    private String result_code;//是
    /**
     * 错误返回的信息描述
     */
    private String err_code;

    /**
     * 错误返回的信息描述
     */
    private String err_code_des;
    /**
     * 用户在商户appid下的唯一标识
     */
    private String openid;//是
    /**
     * 用户是否关注公众账号，Y-关注，N-未关注，仅在公众账号类型支付有效
     */
    private String is_subscribe;//是
    /**
     * 用户子标识
     */
    private String sub_openid;
    /**
     * 是否关注子公众账号
     */
    private String sub_is_subscribe;
    /**
     * APP
     */
    private String trade_type;//是
    /**
     * 银行类型，采用字符串类型的银行标识，银行类型见银行列表
     */
    private String bank_type;//是
    /**
     * 订单总金额，单位为分
     */
    private int total_fee;//是
    /**
     * 货币类型，符合ISO4217标准的三位字母代码，默认人民币：CNY
     */
    private String fee_type;
    /**
     * 现金支付金额订单现金支付金额
     */
    private int cash_fee;//是
    /**
     * 货币类型，符合ISO4217标准的三位字母代码，默认人民币：CNY
     */
    private String cash_fee_type;
    /**
     * 应结订单金额
     */
    private int settlement_total_fee;
    /**
     * 代金券或立减优惠金额<=订单总金额，订单总金额-代金券或立减优惠金额=现金支付金额
     * 详见支付金额 https://pay.weixin.qq.com/wiki/doc/api/app/app.php?chapter=4_2
     */
    private int coupon_fee;
    /**
     * 代金券或立减优惠使用数量
     */
    private int coupon_count;
    /**
     * 代金券类型
     */
    private int coupon_type_$n;
    /**
     * 代金券ID
     */
    private String coupon_id_$n;
    /**
     * 单个代金券支付金额
     */
    private int coupon_fee_$n;
    /**
     * 微信支付订单号
     */
    private String transaction_id;//是
    /**
     * 商户系统的订单号，与请求一致。
     */
    private String out_trade_no;
    /**
     * 商家数据包，原样返回
     */
    private String attach;
    /**
     * 支付完成时间
     * 格式 yyyyMMddHHmmss
     */
    private String time_end;//是

    public String getReturn_code() {
        return return_code;
    }

    public WechatTradeResultNotify setReturn_code(String return_code) {
        this.return_code = return_code;
        return this;
    }

    public String getReturn_msg() {
        return return_msg;
    }

    public WechatTradeResultNotify setReturn_msg(String return_msg) {
        this.return_msg = return_msg;
        return this;
    }

    public String getAppid() {
        return appid;
    }

    public WechatTradeResultNotify setAppid(String appid) {
        this.appid = appid;
        return this;
    }

    public String getMch_id() {
        return mch_id;
    }

    public WechatTradeResultNotify setMch_id(String mch_id) {
        this.mch_id = mch_id;
        return this;
    }

    public String getSub_appid() {
        return sub_appid;
    }

    public WechatTradeResultNotify setSub_appid(String sub_appid) {
        this.sub_appid = sub_appid;
        return this;
    }

    public String getSub_mch_id() {
        return sub_mch_id;
    }

    public WechatTradeResultNotify setSub_mch_id(String sub_mch_id) {
        this.sub_mch_id = sub_mch_id;
        return this;
    }

    public String getDevice_info() {
        return device_info;
    }

    public WechatTradeResultNotify setDevice_info(String device_info) {
        this.device_info = device_info;
        return this;
    }

    public String getNonce_str() {
        return nonce_str;
    }

    public WechatTradeResultNotify setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
        return this;
    }

    public String getSign() {
        return sign;
    }

    public WechatTradeResultNotify setSign(String sign) {
        this.sign = sign;
        return this;
    }

    public String getResult_code() {
        return result_code;
    }

    public WechatTradeResultNotify setResult_code(String result_code) {
        this.result_code = result_code;
        return this;
    }

    public String getErr_code() {
        return err_code;
    }

    public WechatTradeResultNotify setErr_code(String err_code) {
        this.err_code = err_code;
        return this;
    }

    public String getErr_code_des() {
        return err_code_des;
    }

    public WechatTradeResultNotify setErr_code_des(String err_code_des) {
        this.err_code_des = err_code_des;
        return this;
    }

    public String getOpenid() {
        return openid;
    }

    public WechatTradeResultNotify setOpenid(String openid) {
        this.openid = openid;
        return this;
    }

    public String getIs_subscribe() {
        return is_subscribe;
    }

    public WechatTradeResultNotify setIs_subscribe(String is_subscribe) {
        this.is_subscribe = is_subscribe;
        return this;
    }

    public String getSub_openid() {
        return sub_openid;
    }

    public WechatTradeResultNotify setSub_openid(String sub_openid) {
        this.sub_openid = sub_openid;
        return this;
    }

    public String getSub_is_subscribe() {
        return sub_is_subscribe;
    }

    public WechatTradeResultNotify setSub_is_subscribe(String sub_is_subscribe) {
        this.sub_is_subscribe = sub_is_subscribe;
        return this;
    }

    public String getTrade_type() {
        return trade_type;
    }

    public WechatTradeResultNotify setTrade_type(String trade_type) {
        this.trade_type = trade_type;
        return this;
    }

    public String getBank_type() {
        return bank_type;
    }

    public WechatTradeResultNotify setBank_type(String bank_type) {
        this.bank_type = bank_type;
        return this;
    }

    public int getTotal_fee() {
        return total_fee;
    }

    public WechatTradeResultNotify setTotal_fee(int total_fee) {
        this.total_fee = total_fee;
        return this;
    }

    public String getFee_type() {
        return fee_type;
    }

    public WechatTradeResultNotify setFee_type(String fee_type) {
        this.fee_type = fee_type;
        return this;
    }

    public int getCash_fee() {
        return cash_fee;
    }

    public WechatTradeResultNotify setCash_fee(int cash_fee) {
        this.cash_fee = cash_fee;
        return this;
    }

    public String getCash_fee_type() {
        return cash_fee_type;
    }

    public WechatTradeResultNotify setCash_fee_type(String cash_fee_type) {
        this.cash_fee_type = cash_fee_type;
        return this;
    }

    public int getSettlement_total_fee() {
        return settlement_total_fee;
    }

    public WechatTradeResultNotify setSettlement_total_fee(int settlement_total_fee) {
        this.settlement_total_fee = settlement_total_fee;
        return this;
    }

    public int getCoupon_fee() {
        return coupon_fee;
    }

    public WechatTradeResultNotify setCoupon_fee(int coupon_fee) {
        this.coupon_fee = coupon_fee;
        return this;
    }

    public int getCoupon_count() {
        return coupon_count;
    }

    public WechatTradeResultNotify setCoupon_count(int coupon_count) {
        this.coupon_count = coupon_count;
        return this;
    }

    public int getCoupon_type_$n() {
        return coupon_type_$n;
    }

    public WechatTradeResultNotify setCoupon_type_$n(int coupon_type_$n) {
        this.coupon_type_$n = coupon_type_$n;
        return this;
    }

    public String getCoupon_id_$n() {
        return coupon_id_$n;
    }

    public WechatTradeResultNotify setCoupon_id_$n(String coupon_id_$n) {
        this.coupon_id_$n = coupon_id_$n;
        return this;
    }

    public int getCoupon_fee_$n() {
        return coupon_fee_$n;
    }

    public WechatTradeResultNotify setCoupon_fee_$n(int coupon_fee_$n) {
        this.coupon_fee_$n = coupon_fee_$n;
        return this;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public WechatTradeResultNotify setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
        return this;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public WechatTradeResultNotify setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
        return this;
    }

    public String getAttach() {
        return attach;
    }

    public WechatTradeResultNotify setAttach(String attach) {
        this.attach = attach;
        return this;
    }

    public String getTime_end() {
        return time_end;
    }

    public WechatTradeResultNotify setTime_end(String time_end) {
        this.time_end = time_end;
        return this;
    }
}
