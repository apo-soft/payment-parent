package cn.aposoft.ecommerce.wechat.beans.protocol.close_protocol;

import cn.aposoft.ecommerce.wechat.beans.protocol.BaseResponseBeans;

/**
 * https://pay.weixin.qq.com/wiki/doc/api/jsapi_sl.php?chapter=9_3
 * 关闭订单返回参数
 * User: rizenguo
 * Date: 2014/10/25
 * Time: 16:43
 */
public class CloseResData extends BaseResponseBeans {


    private String appid;
    private String mch_id;
    private String sub_appid;
    private String sub_mch_id;
    private String nonce_str;
    private String sign;

    private String err_code;
    private String err_code_des;

    public String getAppid() {
        return appid;
    }

    public CloseResData setAppid(String appid) {
        this.appid = appid;
        return this;
    }

    public String getMch_id() {
        return mch_id;
    }

    public CloseResData setMch_id(String mch_id) {
        this.mch_id = mch_id;
        return this;
    }

    public String getSub_appid() {
        return sub_appid;
    }

    public CloseResData setSub_appid(String sub_appid) {
        this.sub_appid = sub_appid;
        return this;
    }

    public String getSub_mch_id() {
        return sub_mch_id;
    }

    public CloseResData setSub_mch_id(String sub_mch_id) {
        this.sub_mch_id = sub_mch_id;
        return this;
    }

    public String getNonce_str() {
        return nonce_str;
    }

    public CloseResData setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
        return this;
    }

    public String getSign() {
        return sign;
    }

    public CloseResData setSign(String sign) {
        this.sign = sign;
        return this;
    }

    public String getErr_code() {
        return err_code;
    }

    public CloseResData setErr_code(String err_code) {
        this.err_code = err_code;
        return this;
    }

    public String getErr_code_des() {
        return err_code_des;
    }

    public CloseResData setErr_code_des(String err_code_des) {
        this.err_code_des = err_code_des;
        return this;
    }
}
