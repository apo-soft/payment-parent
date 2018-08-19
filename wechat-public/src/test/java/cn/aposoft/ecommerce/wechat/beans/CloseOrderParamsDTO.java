package cn.aposoft.ecommerce.wechat.beans;

import cn.aposoft.ecommerce.wechat.params.CloseOrderParams;

/**
 * @author code
 * @Title: CloseOrderParamsDTO
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/8/19下午8:39
 */
public class CloseOrderParamsDTO implements CloseOrderParams {
    /**
     * 商户订单号
     */
    private String out_trade_no;

    public CloseOrderParamsDTO setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
        return this;
    }

    @Override
    public String getOut_trade_no() {
        return out_trade_no;
    }

}
