package cn.aposoft.ecommerce.wechat.scan.beans.protocol.refund_query_protocol;


import cn.aposoft.ecommerce.tencent.WechatSignature;
import cn.aposoft.ecommerce.tencent.WechatUtil;
import cn.aposoft.ecommerce.util.LogPortal;
import cn.aposoft.ecommerce.wechat.scan.beans.protocol.BaseRequestBeans;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * https://pay.weixin.qq.com/wiki/doc/api/jsapi_sl.php?chapter=9_5
 * User: rizenguo
 * Date: 2014/10/25
 * Time: 16:35
 */
public class WechatRefundQueryReqData extends BaseRequestBeans {
    //每个字段具体的意思请查看API文档
    private String transaction_id;
    private String out_trade_no;
    private String out_refund_no;
    private String refund_id;
    private String offset;



    public String getTransaction_id() {
        return transaction_id;
    }

    public WechatRefundQueryReqData setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
        return this;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public WechatRefundQueryReqData setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
        return this;
    }

    public String getOut_refund_no() {
        return out_refund_no;
    }

    public WechatRefundQueryReqData setOut_refund_no(String out_refund_no) {
        this.out_refund_no = out_refund_no;
        return this;
    }

    public String getRefund_id() {
        return refund_id;
    }

    public WechatRefundQueryReqData setRefund_id(String refund_id) {
        this.refund_id = refund_id;
        return this;
    }

    public String getOffset() {
        return offset;
    }

    public WechatRefundQueryReqData setOffset(String offset) {
        this.offset = offset;
        return this;
    }
}
