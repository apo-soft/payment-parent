package cn.aposoft.ecommerce.wechat.beans.protocol.report_protocol;


/**
 * https://pay.weixin.qq.com/wiki/doc/api/jsapi_sl.php?chapter=9_8
 * @author code
 * @Title: WechatReportResData
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/8/19上午8:57
 */
public class WechatReportResData {

    //协议层
    private String return_code;
    private String return_msg;
    private String result_code;


    public String getReturn_code() {
        return return_code;
    }

    public WechatReportResData setReturn_code(String return_code) {
        this.return_code = return_code;
        return this;
    }

    public String getReturn_msg() {
        return return_msg;
    }

    public WechatReportResData setReturn_msg(String return_msg) {
        this.return_msg = return_msg;
        return this;
    }

    public String getResult_code() {
        return result_code;
    }

    public WechatReportResData setResult_code(String result_code) {
        this.result_code = result_code;
        return this;
    }
}
