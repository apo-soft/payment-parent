package cn.aposoft.ecommerce.wechat.beans;

import cn.aposoft.ecommerce.wechat.params.OrderQueryParams;

/**
 * @author code
 * @Title: OrderQueryParamsDTO
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/8/19下午8:35
 */
public class OrderQueryParamsDTO implements OrderQueryParams {

    /**
     * 通道订单号
     */
    private String transaction_id;

    /**
     * 商户订单号
     */
    private String out_trade_no;

    public OrderQueryParamsDTO setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
        return this;
    }

    public OrderQueryParamsDTO setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
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
}
