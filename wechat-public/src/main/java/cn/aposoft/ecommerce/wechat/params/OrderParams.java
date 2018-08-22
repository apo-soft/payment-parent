package cn.aposoft.ecommerce.wechat.params;

import java.io.Serializable;

/**
 * 下单对外接口请求param
 *
 * @author code
 * @Title: OrderParams
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/8/19下午5:31
 */
public interface OrderParams extends Serializable {

    /**
     * 签名类型，目前支持HMAC-SHA256和MD5，
     *
     * @return
     */
    public String getSign_type();


    public String getBody();


    public String getOut_trade_no();


    public int getTotal_fee();


    public String getSpbill_create_ip();


    public String getNotify_url();


    public String getTrade_type();

    public String getOpenid();


}
