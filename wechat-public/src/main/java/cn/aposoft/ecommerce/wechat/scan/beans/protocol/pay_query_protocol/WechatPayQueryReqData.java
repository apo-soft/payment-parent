package cn.aposoft.ecommerce.wechat.scan.beans.protocol.pay_query_protocol;


import cn.aposoft.ecommerce.wechat.scan.beans.protocol.BaseRequestBeans;

/**
 * https://pay.weixin.qq.com/wiki/doc/api/jsapi_sl.php?chapter=9_2
 *
 * @author code
 * @date 2018/8/8 下午4:42
 * @return
 */
public class WechatPayQueryReqData extends BaseRequestBeans {

    //每个字段具体的意思请查看API文档

    /**
     * 是微信系统为每一笔支付交易分配的订单号，通过这个订单号可以标识这笔交易，它由支付订单API支付成功时返回的数据里面获取到。建议优先使用
     */
    private String transaction_id;
    /**
     * 商户系统内部的订单号,transaction_id 、out_trade_no 二选一，如果同时存在优先级：transaction_id>out_trade_no
     */
    private String out_trade_no;


//


    public String getTransaction_id() {
        return transaction_id;
    }

    public WechatPayQueryReqData setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
        return this;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public WechatPayQueryReqData setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
        return this;
    }


}
