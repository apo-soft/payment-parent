package cn.aposoft.ecommerce.wechat.beans;

import cn.aposoft.ecommerce.wechat.params.RefundQueryParams;

/**
 * @author code
 * @Title: RefundQueryParamsDTO
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/8/19下午8:48
 */
public class RefundQueryParamsDTO implements RefundQueryParams {

    private String transaction_id;
    private String out_trade_no;
    private String out_refund_no;
    private String refund_id;


    public RefundQueryParamsDTO setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
        return this;
    }

    public RefundQueryParamsDTO setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
        return this;
    }

    public RefundQueryParamsDTO setOut_refund_no(String out_refund_no) {
        this.out_refund_no = out_refund_no;
        return this;
    }

    public RefundQueryParamsDTO setRefund_id(String refund_id) {
        this.refund_id = refund_id;
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
    public String getRefund_id() {
        return refund_id;
    }
}
