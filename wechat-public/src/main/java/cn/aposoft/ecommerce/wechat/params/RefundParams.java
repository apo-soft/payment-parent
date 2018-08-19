package cn.aposoft.ecommerce.wechat.params;

import java.io.Serializable;

/**
 * 退款对外接口请求param
 *
 * @author code
 * @Title: RefundParams
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/8/19下午5:43
 */
public interface RefundParams extends Serializable {
    public String getTransaction_id();


    public String getOut_trade_no();


    public String getOut_refund_no();


    public int getTotal_fee();


    public int getRefund_fee();


    public String getRefund_desc();


    public String getNotify_url();


}
