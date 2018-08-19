package cn.aposoft.ecommerce.wechat.beans.protocol.pay_protocol;

/**
 * User: rizenguo
 * Date: 2014/10/22
 * Time: 16:42
 */


import cn.aposoft.ecommerce.wechat.beans.protocol.BaseResponseBeans;

/**
 * 支付提交Post数据给到API之后，API会返回XML格式的数据，这个类用来装这些数据
 * https://pay.weixin.qq.com/wiki/doc/api/jsapi_sl.php?chapter=9_1
 */
public class WeChatPayResData extends BaseResponseBeans {


    private String device_info;
    private String result_code;
    private String err_code;
    private String err_code_des;


    //业务返回的具体数据（以下字段在return_code 和result_code 都为SUCCESS 的时候有返回）
    private String trade_type;
    private String prepay_id;

    private String code_url;

    public String getDevice_info() {
        return device_info;
    }

    public WeChatPayResData setDevice_info(String device_info) {
        this.device_info = device_info;
        return this;
    }

    public String getResult_code() {
        return result_code;
    }

    public WeChatPayResData setResult_code(String result_code) {
        this.result_code = result_code;
        return this;
    }

    public String getErr_code() {
        return err_code;
    }

    public WeChatPayResData setErr_code(String err_code) {
        this.err_code = err_code;
        return this;
    }

    public String getErr_code_des() {
        return err_code_des;
    }

    public WeChatPayResData setErr_code_des(String err_code_des) {
        this.err_code_des = err_code_des;
        return this;
    }

    public String getTrade_type() {
        return trade_type;
    }

    public WeChatPayResData setTrade_type(String trade_type) {
        this.trade_type = trade_type;
        return this;
    }

    public String getPrepay_id() {
        return prepay_id;
    }

    public WeChatPayResData setPrepay_id(String prepay_id) {
        this.prepay_id = prepay_id;
        return this;
    }

    public String getCode_url() {
        return code_url;
    }

    public WeChatPayResData setCode_url(String code_url) {
        this.code_url = code_url;
        return this;
    }
}
