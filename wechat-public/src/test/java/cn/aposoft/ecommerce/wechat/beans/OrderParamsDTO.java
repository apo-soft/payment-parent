package cn.aposoft.ecommerce.wechat.beans;

import cn.aposoft.ecommerce.wechat.params.OrderParams;

/**
 * @author code
 * @Title: OrderParamsDTO
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/8/19下午8:33
 */
public class OrderParamsDTO implements OrderParams {

    String sign_type;
    private String body;
    private String openid;

    private String out_trade_no;
    private int total_fee;
    private String spbill_create_ip;
    private String notify_url;
    private String trade_type = "JSAPI";


    public OrderParamsDTO setSign_type(String sign_type) {
        this.sign_type = sign_type;
        return this;
    }

    public OrderParamsDTO setBody(String body) {
        this.body = body;
        return this;
    }

    public OrderParamsDTO setOpenid(String openid) {
        this.openid = openid;
        return this;
    }

    public OrderParamsDTO setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
        return this;
    }

    public OrderParamsDTO setTotal_fee(int total_fee) {
        this.total_fee = total_fee;
        return this;
    }

    public OrderParamsDTO setSpbill_create_ip(String spbill_create_ip) {
        this.spbill_create_ip = spbill_create_ip;
        return this;
    }

    public OrderParamsDTO setNotify_url(String notify_url) {
        this.notify_url = notify_url;
        return this;
    }

    public OrderParamsDTO setTrade_type(String trade_type) {
        this.trade_type = trade_type;
        return this;
    }

    @Override
    public String getSign_type() {
        return sign_type;
    }

    @Override
    public String getBody() {
        return body;
    }

    @Override
    public String getOpenid() {
        return openid;
    }

    @Override
    public String getOut_trade_no() {
        return out_trade_no;
    }

    @Override
    public int getTotal_fee() {
        return total_fee;
    }

    @Override
    public String getSpbill_create_ip() {
        return spbill_create_ip;
    }

    @Override
    public String getNotify_url() {
        return notify_url;
    }

    @Override
    public String getTrade_type() {
        return trade_type;
    }


}
