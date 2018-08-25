package cn.aposoft.ecommerce.wechat.beans.protocol.close_protocol;


import cn.aposoft.ecommerce.wechat.beans.protocol.BaseRequestBeans;


/**
 * https://pay.weixin.qq.com/wiki/doc/api/jsapi_sl.php?chapter=9_3
 * 关闭订单
 * User: rizenguo
 * Date: 2014/10/25
 * Time: 16:42
 */
public class WechatCloseReqData extends BaseRequestBeans {

    private String out_trade_no;


    public String getOut_trade_no() {
        return out_trade_no;
    }

    public WechatCloseReqData setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
        return this;
    }
}
