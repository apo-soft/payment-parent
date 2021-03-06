package cn.aposoft.ecommerce.wechat.params;

import java.io.Serializable;

/**
 * 退款查询对外接口请求param
 *
 * @author code
 * @Title: RefundQueryParams
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/8/19下午5:49
 */
public interface RefundQueryParams extends Serializable {
    public String getTransaction_id();


    public String getOut_trade_no();


    public String getOut_refund_no();


    public String getRefund_id();


}
