package cn.aposoft.ecommerce.wechat.beans;

import cn.aposoft.ecommerce.wechat.params.RefundParams;

/**
 * @author code
 * @Title: RefundParamsDTO
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/8/19下午8:43
 */
public class RefundParamsDTO implements RefundParams {

    private String transaction_id;
    private String out_trade_no;
    private String out_refund_no;
    private int total_fee = 0;
    private int refund_fee = 0;
    private String refund_desc;//fou
    private String notify_url;//fou

    public RefundParamsDTO setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
        return this;
    }

    public RefundParamsDTO setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
        return this;
    }

    public RefundParamsDTO setOut_refund_no(String out_refund_no) {
        this.out_refund_no = out_refund_no;
        return this;
    }

    public RefundParamsDTO setTotal_fee(int total_fee) {
        this.total_fee = total_fee;
        return this;
    }

    public RefundParamsDTO setRefund_fee(int refund_fee) {
        this.refund_fee = refund_fee;
        return this;
    }

    public RefundParamsDTO setRefund_desc(String refund_desc) {
        this.refund_desc = refund_desc;
        return this;
    }

    public RefundParamsDTO setNotify_url(String notify_url) {
        this.notify_url = notify_url;
        return this;
    }

    @Override
    public String getTransaction_id() {
        return transaction_id;
    }

    @Override
    public String getOut_trade_no() {
        return out_trade_no;
    }

    @Override
    public String getOut_refund_no() {
        return out_refund_no;
    }

    @Override
    public int getTotal_fee() {
        return total_fee;
    }

    @Override
    public int getRefund_fee() {
        return refund_fee;
    }

    @Override
    public String getRefund_desc() {
        return refund_desc;
    }

    @Override
    public String getNotify_url() {
        return notify_url;
    }
}
