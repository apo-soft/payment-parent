package cn.aposoft.ecommerce.wechat.scan.beans.protocol.refund_protocol;

import cn.aposoft.ecommerce.tencent.RandomStringGenerator;
import cn.aposoft.ecommerce.tencent.WechatConfigure;
import cn.aposoft.ecommerce.tencent.WechatSignature;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * 退款申请请求参数
 * https://pay.weixin.qq.com/wiki/doc/api/jsapi_sl.php?chapter=9_4
 */
public class WeChatRefundReqData {

    //每个字段具体的意思请查看API文档
    private String appid = "";
    private String mch_id = "";
    private String sub_appid = "";
    private String sub_mch_id = "";

    private String nonce_str = "";
    private String sign = "";
    private String transaction_id = "";
    private String out_trade_no = "";
    private String out_refund_no = "";
    private int total_fee = 0;
    private int refund_fee = 0;
    private String refund_fee_type = "CNY";
    private String refund_desc;
    private String refund_account;
    private String notify_url;


    public WeChatRefundReqData(WechatConfigure configure) {
        //微信分配的公众号ID（开通公众号之后可以获取到）
        setAppid(configure.getAppID());

        //微信支付分配的商户号ID（开通公众号的微信支付功能之后可以获取到）
        setMch_id(configure.getMchID());
    }

    /**
     * 请求退款服务
     *
     * @param transactionID 是微信系统为每一笔支付交易分配的订单号，通过这个订单号可以标识这笔交易，它由支付订单API支付成功时返回的数据里面获取到。建议优先使用
     * @param outTradeNo    商户系统内部的订单号,transaction_id 、out_trade_no 二选一，如果同时存在优先级：transaction_id>out_trade_no
     * @param deviceInfo    微信支付分配的终端设备号，与下单一致
     * @param outRefundNo   商户系统内部的退款单号，商户系统内部唯一，同一退款单号多次请求只退一笔
     * @param totalFee      订单总金额，单位为分
     * @param refundFee     退款总金额，单位为分,可以做部分退款
     * @param opUserID      操作员帐号, 默认为商户号
     * @param refundFeeType 货币类型，符合ISO 4217标准的三位字母代码，默认为CNY（人民币）
     */
    public WeChatRefundReqData(WechatConfigure configure, String transactionID, String outTradeNo, String deviceInfo, String outRefundNo, int totalFee, int refundFee,
                               String
                                       opUserID, String
                                       refundFeeType) {

        //微信分配的公众号ID（开通公众号之后可以获取到）
        setAppid(configure.getAppID());

        //微信支付分配的商户号ID（开通公众号的微信支付功能之后可以获取到）
        setMch_id(configure.getMchID());

        //transaction_id是微信系统为每一笔支付交易分配的订单号，通过这个订单号可以标识这笔交易，它由支付订单API支付成功时返回的数据里面获取到。
        setTransaction_id(transactionID);

        //商户系统自己生成的唯一的订单号
        setOut_trade_no(outTradeNo);

        //微信支付分配的终端设备号，与下单一致

        setOut_refund_no(outRefundNo);

        setTotal_fee(totalFee);

        setRefund_fee(refundFee);


        //随机字符串，不长于32 位
        setNonce_str(RandomStringGenerator.getRandomStringByLength(32));

        //根据API给的签名规则进行签名
        String sign = WechatSignature.getSign(configure.getKey(), toMap());
        setSign(sign);//把签名数据设置到Sign这个属性中

    }

    public void generateSign(String key) {
        //随机字符串，不长于32 位
        setNonce_str(RandomStringGenerator.getRandomStringByLength(32));
        //根据API给的签名规则进行签名
        String sign = WechatSignature.getSign(key, toMap());
        setSign(sign);//把签名数据设置到Sign这个属性中
    }

    public String getAppid() {
        return appid;
    }

    public WeChatRefundReqData setAppid(String appid) {
        this.appid = appid;
        return this;
    }

    public String getMch_id() {
        return mch_id;
    }

    public WeChatRefundReqData setMch_id(String mch_id) {
        this.mch_id = mch_id;
        return this;
    }

    public String getSub_appid() {
        return sub_appid;
    }

    public WeChatRefundReqData setSub_appid(String sub_appid) {
        this.sub_appid = sub_appid;
        return this;
    }

    public String getSub_mch_id() {
        return sub_mch_id;
    }

    public WeChatRefundReqData setSub_mch_id(String sub_mch_id) {
        this.sub_mch_id = sub_mch_id;
        return this;
    }

    public String getNonce_str() {
        return nonce_str;
    }

    public WeChatRefundReqData setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
        return this;
    }

    public String getSign() {
        return sign;
    }

    public WeChatRefundReqData setSign(String sign) {
        this.sign = sign;
        return this;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public WeChatRefundReqData setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
        return this;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public WeChatRefundReqData setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
        return this;
    }

    public String getOut_refund_no() {
        return out_refund_no;
    }

    public WeChatRefundReqData setOut_refund_no(String out_refund_no) {
        this.out_refund_no = out_refund_no;
        return this;
    }

    public int getTotal_fee() {
        return total_fee;
    }

    public WeChatRefundReqData setTotal_fee(int total_fee) {
        this.total_fee = total_fee;
        return this;
    }

    public int getRefund_fee() {
        return refund_fee;
    }

    public WeChatRefundReqData setRefund_fee(int refund_fee) {
        this.refund_fee = refund_fee;
        return this;
    }

    public String getRefund_fee_type() {
        return refund_fee_type;
    }

    public WeChatRefundReqData setRefund_fee_type(String refund_fee_type) {
        this.refund_fee_type = refund_fee_type;
        return this;
    }

    public String getRefund_desc() {
        return refund_desc;
    }

    public WeChatRefundReqData setRefund_desc(String refund_desc) {
        this.refund_desc = refund_desc;
        return this;
    }

    public String getRefund_account() {
        return refund_account;
    }

    public WeChatRefundReqData setRefund_account(String refund_account) {
        this.refund_account = refund_account;
        return this;
    }

    public String getNotify_url() {
        return notify_url;
    }

    public WeChatRefundReqData setNotify_url(String notify_url) {
        this.notify_url = notify_url;
        return this;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<String, Object>();
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            Object obj;
            try {
                obj = field.get(this);
                if (obj != null) {
                    map.put(field.getName(), obj);
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return map;
    }

}
