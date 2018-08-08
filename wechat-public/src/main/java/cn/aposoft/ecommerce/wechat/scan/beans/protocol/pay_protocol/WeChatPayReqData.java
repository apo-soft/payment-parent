package cn.aposoft.ecommerce.wechat.scan.beans.protocol.pay_protocol;

/**
 * User: rizenguo
 * Date: 2014/10/22
 * Time: 21:29
 */

import cn.aposoft.ecommerce.tencent.RandomStringGenerator;
import cn.aposoft.ecommerce.tencent.WechatConfigure;
import cn.aposoft.ecommerce.tencent.WechatSignature;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * 微信公众号服务商版统一下单接口需要提交的数据
 * URL：https://pay.weixin.qq.com/wiki/doc/api/jsapi_sl.php?chapter=9_1
 */
public class WeChatPayReqData {

    //每个字段具体的意思请查看API文档
    private String appid;
    private String mch_id;
    private String sub_appid;
    private String sub_mch_id;
    private String device_info;
    private String nonce_str;
    private String sign;
    private String sign_type;
    private String body;
    private String detail;
    private String attach;
    private String out_trade_no;
    private String fee_type = "CNY";
    private int total_fee;
    private String spbill_create_ip;
    private String time_start;
    private String time_expire;
    private String goods_tag;
    private String notify_url;
    private String trade_type = "JSAPI";
    private String product_id;
    private String limit_pay;
    private String openid;
    private String sub_openid;
    private Object scene_info;


    public WeChatPayReqData(WechatConfigure configure) {
        //微信分配的公众号ID（开通公众号之后可以获取到）
        setAppid(configure.getAppID());

        //微信支付分配的商户号ID（开通公众号的微信支付功能之后可以获取到）
        setMch_id(configure.getMchID());
    }

    /**
     * @param configure      微信配置信息
     * @param body           要支付的商品的描述信息，用户会在支付成功页面里看到这个信息
     * @param detail         商品名称明细列表
     * @param outTradeNo     商户系统内部的订单号,32个字符内可包含字母, 确保在商户系统唯一
     * @param totalFee       订单总金额，单位为“分”，只能整数
     * @param spBillCreateIP 订单生成的机器IP
     * @param timeStart      订单生成时间， 格式为yyyyMMddHHmmss，如2009年12 月25 日9 点10 分10 秒表示为20091225091010。时区为GMT+8 beijing。该时间取自商户服务器
     * @param timeExpire     订单失效时间，格式同上
     * @param notify_url     通知地址
     */
    public WeChatPayReqData(WechatConfigure configure, String body, String detail, String outTradeNo, int totalFee, String spBillCreateIP, String timeStart, String
            timeExpire, String notify_url) {

        //微信分配的公众号ID（开通公众号之后可以获取到）
        setAppid(configure.getAppID());

        //微信支付分配的商户号ID（开通公众号的微信支付功能之后可以获取到）
        setMch_id(configure.getMchID());

        //要支付的商品的描述信息，用户会在支付成功页面里看到这个信息
        setBody(body);

        setDetail(detail);

        //商户系统内部的订单号,32个字符内可包含字母, 确保在商户系统唯一
        setOut_trade_no(outTradeNo);

        //订单总金额，单位为“分”，只能整数
        setTotal_fee(totalFee);


        //订单生成的机器IP
        setSpbill_create_ip(spBillCreateIP);

        //订单生成时间， 格式为yyyyMMddHHmmss，如2009年12 月25 日9 点10 分10 秒表示为20091225091010。时区为GMT+8 beijing。该时间取自商户服务器
        setTime_start(timeStart);

        //订单失效时间，格式同上
        setTime_expire(timeExpire);


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

    public WeChatPayReqData setAppid(String appid) {
        this.appid = appid;
        return this;
    }

    public String getMch_id() {
        return mch_id;
    }

    public WeChatPayReqData setMch_id(String mch_id) {
        this.mch_id = mch_id;
        return this;
    }

    public String getSub_appid() {
        return sub_appid;
    }

    public WeChatPayReqData setSub_appid(String sub_appid) {
        this.sub_appid = sub_appid;
        return this;
    }

    public String getSub_mch_id() {
        return sub_mch_id;
    }

    public WeChatPayReqData setSub_mch_id(String sub_mch_id) {
        this.sub_mch_id = sub_mch_id;
        return this;
    }

    public String getDevice_info() {
        return device_info;
    }

    public WeChatPayReqData setDevice_info(String device_info) {
        this.device_info = device_info;
        return this;
    }

    public String getNonce_str() {
        return nonce_str;
    }

    public WeChatPayReqData setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
        return this;
    }

    public String getSign() {
        return sign;
    }

    public WeChatPayReqData setSign(String sign) {
        this.sign = sign;
        return this;
    }

    public String getSign_type() {
        return sign_type;
    }

    public WeChatPayReqData setSign_type(String sign_type) {
        this.sign_type = sign_type;
        return this;
    }

    public String getBody() {
        return body;
    }

    public WeChatPayReqData setBody(String body) {
        this.body = body;
        return this;
    }

    public String getDetail() {
        return detail;
    }

    public WeChatPayReqData setDetail(String detail) {
        this.detail = detail;
        return this;
    }

    public String getAttach() {
        return attach;
    }

    public WeChatPayReqData setAttach(String attach) {
        this.attach = attach;
        return this;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public WeChatPayReqData setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
        return this;
    }

    public String getFee_type() {
        return fee_type;
    }

    public WeChatPayReqData setFee_type(String fee_type) {
        this.fee_type = fee_type;
        return this;
    }

    public int getTotal_fee() {
        return total_fee;
    }

    public WeChatPayReqData setTotal_fee(int total_fee) {
        this.total_fee = total_fee;
        return this;
    }

    public String getSpbill_create_ip() {
        return spbill_create_ip;
    }

    public WeChatPayReqData setSpbill_create_ip(String spbill_create_ip) {
        this.spbill_create_ip = spbill_create_ip;
        return this;
    }

    public String getTime_start() {
        return time_start;
    }

    public WeChatPayReqData setTime_start(String time_start) {
        this.time_start = time_start;
        return this;
    }

    public String getTime_expire() {
        return time_expire;
    }

    public WeChatPayReqData setTime_expire(String time_expire) {
        this.time_expire = time_expire;
        return this;
    }

    public String getGoods_tag() {
        return goods_tag;
    }

    public WeChatPayReqData setGoods_tag(String goods_tag) {
        this.goods_tag = goods_tag;
        return this;
    }

    public String getNotify_url() {
        return notify_url;
    }

    public WeChatPayReqData setNotify_url(String notify_url) {
        this.notify_url = notify_url;
        return this;
    }

    public String getTrade_type() {
        return trade_type;
    }

    public WeChatPayReqData setTrade_type(String trade_type) {
        this.trade_type = trade_type;
        return this;
    }

    public String getProduct_id() {
        return product_id;
    }

    public WeChatPayReqData setProduct_id(String product_id) {
        this.product_id = product_id;
        return this;
    }

    public String getLimit_pay() {
        return limit_pay;
    }

    public WeChatPayReqData setLimit_pay(String limit_pay) {
        this.limit_pay = limit_pay;
        return this;
    }

    public String getOpenid() {
        return openid;
    }

    public WeChatPayReqData setOpenid(String openid) {
        this.openid = openid;
        return this;
    }

    public String getSub_openid() {
        return sub_openid;
    }

    public WeChatPayReqData setSub_openid(String sub_openid) {
        this.sub_openid = sub_openid;
        return this;
    }

    public Object getScene_info() {
        return scene_info;
    }

    public WeChatPayReqData setScene_info(Object scene_info) {
        this.scene_info = scene_info;
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
