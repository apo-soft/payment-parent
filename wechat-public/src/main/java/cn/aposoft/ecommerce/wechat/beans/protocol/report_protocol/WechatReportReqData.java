package cn.aposoft.ecommerce.wechat.beans.protocol.report_protocol;

import cn.aposoft.ecommerce.wechat.beans.protocol.BaseRequestBeans;

/**
 * https://pay.weixin.qq.com/wiki/doc/api/jsapi_sl.php?chapter=9_8
 * 交易保障请求参数
 *
 * @author code
 * @Title: WechatReportReqData
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/8/19上午8:57
 */
public class WechatReportReqData extends BaseRequestBeans {

    private String device_info;
    /**
     * 接口URL*是
     */
    private String interface_url;
    /**
     * 接口耗时*是-毫秒
     */
    private int execute_time;
    /**
     * 返回状态码*是
     */
    private String return_code;
    /**
     * 返回信息*否
     */
    private String return_msg;
    /**
     * 业务结果*是
     */
    private String result_code;
    /**
     * 错误代码*否
     */
    private String err_code;
    /**
     * 错误代码描述*否
     */
    private String err_code_des;
    /**
     * 商户订单号*否
     */
    private String out_trade_no;
    /**
     * 访问接口IP*是
     */
    private String user_ip;
    /**
     * 商户上报时间*否
     */
    private String time;

    public String getDevice_info() {
        return device_info;
    }

    public WechatReportReqData setDevice_info(String device_info) {
        this.device_info = device_info;
        return this;
    }

    public String getInterface_url() {
        return interface_url;
    }

    public WechatReportReqData setInterface_url(String interface_url) {
        this.interface_url = interface_url;
        return this;
    }

    public int getExecute_time() {
        return execute_time;
    }

    public WechatReportReqData setExecute_time(int execute_time) {
        this.execute_time = execute_time;
        return this;
    }

    public String getReturn_code() {
        return return_code;
    }

    public WechatReportReqData setReturn_code(String return_code) {
        this.return_code = return_code;
        return this;
    }

    public String getReturn_msg() {
        return return_msg;
    }

    public WechatReportReqData setReturn_msg(String return_msg) {
        this.return_msg = return_msg;
        return this;
    }

    public String getResult_code() {
        return result_code;
    }

    public WechatReportReqData setResult_code(String result_code) {
        this.result_code = result_code;
        return this;
    }

    public String getErr_code() {
        return err_code;
    }

    public WechatReportReqData setErr_code(String err_code) {
        this.err_code = err_code;
        return this;
    }

    public String getErr_code_des() {
        return err_code_des;
    }

    public WechatReportReqData setErr_code_des(String err_code_des) {
        this.err_code_des = err_code_des;
        return this;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public WechatReportReqData setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
        return this;
    }

    public String getUser_ip() {
        return user_ip;
    }

    public WechatReportReqData setUser_ip(String user_ip) {
        this.user_ip = user_ip;
        return this;
    }

    public String getTime() {
        return time;
    }

    public WechatReportReqData setTime(String time) {
        this.time = time;
        return this;
    }
}
