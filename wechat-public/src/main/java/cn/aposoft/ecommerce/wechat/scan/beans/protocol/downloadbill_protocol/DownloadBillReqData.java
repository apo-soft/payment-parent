package cn.aposoft.ecommerce.wechat.scan.beans.protocol.downloadbill_protocol;

import cn.aposoft.ecommerce.tencent.RandomStringGenerator;
import cn.aposoft.ecommerce.tencent.WechatConfigure;
import cn.aposoft.ecommerce.tencent.WechatSignature;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * https://pay.weixin.qq.com/wiki/doc/api/jsapi_sl.php?chapter=9_6
 */
public class DownloadBillReqData {
    //每个字段具体的意思请查看API文档
    /**
     * 是
     * 公众账号ID
     */
    private String appid;
    /**
     * 是
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
     * 是
     * 随机字符串
     */
    private String nonce_str;
    /**
     * 是
     * 签名
     */
    private String sign;
    /**
     * 是
     * 对账单日期  格式：20140603
     */
    private String bill_date;
    /**
     * 账单类型
     */
    private String bill_type;
    /**
     * 压缩账单 非必传参数，固定值：GZIP，返回格式为.gzip的压缩包账单。不传则默认为数据流形式。
     */
    private String tar_type;

    /**
     * 请求对账单下载服务
     *
     * @param deviceInfo 商户自己定义的扫码支付终端设备号，方便追溯这笔交易发生在哪台终端设备上
     * @param billDate   下载对账单的日期，格式：yyyyMMdd 例如：20140603
     * @param billType   账单类型
     *                   ALL，返回当日所有订单信息，默认值
     *                   SUCCESS，返回当日成功支付的订单
     *                   REFUND，返回当日退款订单
     *                   REVOKED，已撤销的订单
     */
    public DownloadBillReqData(WechatConfigure configure, String deviceInfo, String billDate, String billType) {

        //微信分配的公众号ID（开通公众号之后可以获取到）
        setAppid(configure.getAppID());

        //微信支付分配的商户号ID（开通公众号的微信支付功能之后可以获取到）
        setMch_id(configure.getMchID());

        setBill_date(billDate);

        setBill_type(billType);


        //随机字符串，不长于32 位
        setNonce_str(RandomStringGenerator.getRandomStringByLength(32));

        //根据API给的签名规则进行签名
        String sign = WechatSignature.getSign(configure.getKey(), toMap());
        setSign(sign);//把签名数据设置到Sign这个属性中


    }

    public String getAppid() {
        return appid;
    }

    public DownloadBillReqData setAppid(String appid) {
        this.appid = appid;
        return this;
    }

    public String getMch_id() {
        return mch_id;
    }

    public DownloadBillReqData setMch_id(String mch_id) {
        this.mch_id = mch_id;
        return this;
    }

    public String getSub_appid() {
        return sub_appid;
    }

    public DownloadBillReqData setSub_appid(String sub_appid) {
        this.sub_appid = sub_appid;
        return this;
    }

    public String getSub_mch_id() {
        return sub_mch_id;
    }

    public DownloadBillReqData setSub_mch_id(String sub_mch_id) {
        this.sub_mch_id = sub_mch_id;
        return this;
    }

    public String getNonce_str() {
        return nonce_str;
    }

    public DownloadBillReqData setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
        return this;
    }

    public String getSign() {
        return sign;
    }

    public DownloadBillReqData setSign(String sign) {
        this.sign = sign;
        return this;
    }

    public String getBill_date() {
        return bill_date;
    }

    public DownloadBillReqData setBill_date(String bill_date) {
        this.bill_date = bill_date;
        return this;
    }

    public String getBill_type() {
        return bill_type;
    }

    public DownloadBillReqData setBill_type(String bill_type) {
        this.bill_type = bill_type;
        return this;
    }

    public String getTar_type() {
        return tar_type;
    }

    public DownloadBillReqData setTar_type(String tar_type) {
        this.tar_type = tar_type;
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
