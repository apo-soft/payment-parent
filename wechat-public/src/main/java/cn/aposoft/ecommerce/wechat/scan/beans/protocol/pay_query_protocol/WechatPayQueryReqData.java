package cn.aposoft.ecommerce.wechat.scan.beans.protocol.pay_query_protocol;


import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * https://pay.weixin.qq.com/wiki/doc/api/jsapi_sl.php?chapter=9_2
 *
 * @author code
 * @date 2018/8/8 下午4:42
 * @return
 */
public class WechatPayQueryReqData {

    //每个字段具体的意思请查看API文档
    private String appid = "";
    private String sub_appid = "";
    private String mch_id = "";
    private String sub_mch_id = "";
    private String transaction_id = "";
    private String out_trade_no = "";
    private String nonce_str = "";
    private String sign = "";

//    /**
//     * 请求支付查询服务
//     *
//     * @param transactionID 是微信系统为每一笔支付交易分配的订单号，通过这个订单号可以标识这笔交易，它由支付订单API支付成功时返回的数据里面获取到。建议优先使用
//     * @param outTradeNo    商户系统内部的订单号,transaction_id 、out_trade_no 二选一，如果同时存在优先级：transaction_id>out_trade_no
//     * @return API返回的XML数据
//     * @throws Exception
//     */
//    public WechatPayQueryReqData(WechatConfigure configure, String outTradeNo) {
//
//        //--------------------------------------------------------------------
//        //以下是测试数据，请商户按照自己的实际情况填写具体的值进去
//        //--------------------------------------------------------------------
//
//        //微信分配的公众号ID（开通公众号之后可以获取到）
//        setAppid(configure.getAppID());
//
//        //微信支付分配的商户号ID（开通公众号的微信支付功能之后可以获取到）
//        setMch_id(configure.getMchID());
//
//        //商户系统自己生成的唯一的订单号
//        setOut_trade_no(outTradeNo);
//
//        //随机字符串，不长于32 位
//        setNonce_str(WechatUtil.generateNonceStr(32));
//
//        //根据API给的签名规则进行签名
//        String sign = WechatSignature.getSign(configure.getKey(), toMap());
//        setSign(sign);//把签名数据设置到Sign这个属性中
//
//
//    }

    public String getAppid() {
        return appid;
    }

    public WechatPayQueryReqData setAppid(String appid) {
        this.appid = appid;
        return this;
    }

    public String getSub_appid() {
        return sub_appid;
    }

    public WechatPayQueryReqData setSub_appid(String sub_appid) {
        this.sub_appid = sub_appid;
        return this;
    }

    public String getMch_id() {
        return mch_id;
    }

    public WechatPayQueryReqData setMch_id(String mch_id) {
        this.mch_id = mch_id;
        return this;
    }

    public String getSub_mch_id() {
        return sub_mch_id;
    }

    public WechatPayQueryReqData setSub_mch_id(String sub_mch_id) {
        this.sub_mch_id = sub_mch_id;
        return this;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public WechatPayQueryReqData setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
        return this;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public WechatPayQueryReqData setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
        return this;
    }

    public String getNonce_str() {
        return nonce_str;
    }

    public WechatPayQueryReqData setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
        return this;
    }

    public String getSign() {
        return sign;
    }

    public WechatPayQueryReqData setSign(String sign) {
        this.sign = sign;
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
