package cn.aposoft.ecommerce.wechat.beans.protocol.refund_protocol;

import cn.aposoft.ecommerce.wechat.beans.protocol.BaseRequestBeans;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * 退款申请请求参数
 * https://pay.weixin.qq.com/wiki/doc/api/jsapi_sl.php?chapter=9_4
 */
public class WeChatRefundReqData extends BaseRequestBeans {

    //每个字段具体的意思请查看API文档


    private String transaction_id;
    private String out_trade_no;
    private String out_refund_no;
    private int total_fee = 0;
    private int refund_fee = 0;
    private String refund_fee_type = "CNY";
    private String refund_desc;
    private String refund_account;
    private String notify_url;




    public String getTransaction_id() {
        return transaction_id;
    }

    public WeChatRefundReqData setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
        return this;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public WeChatRefundReqData setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
        return this;
    }

    public String getOut_refund_no() {
        return out_refund_no;
    }

    public WeChatRefundReqData setOut_refund_no(String out_refund_no) {
        this.out_refund_no = out_refund_no;
        return this;
    }

    public int getTotal_fee() {
        return total_fee;
    }

    public WeChatRefundReqData setTotal_fee(int total_fee) {
        this.total_fee = total_fee;
        return this;
    }

    public int getRefund_fee() {
        return refund_fee;
    }

    public WeChatRefundReqData setRefund_fee(int refund_fee) {
        this.refund_fee = refund_fee;
        return this;
    }

    public String getRefund_fee_type() {
        return refund_fee_type;
    }

    public WeChatRefundReqData setRefund_fee_type(String refund_fee_type) {
        this.refund_fee_type = refund_fee_type;
        return this;
    }

    public String getRefund_desc() {
        return refund_desc;
    }

    public WeChatRefundReqData setRefund_desc(String refund_desc) {
        this.refund_desc = refund_desc;
        return this;
    }

    public String getRefund_account() {
        return refund_account;
    }

    public WeChatRefundReqData setRefund_account(String refund_account) {
        this.refund_account = refund_account;
        return this;
    }

    public String getNotify_url() {
        return notify_url;
    }

    public WeChatRefundReqData setNotify_url(String notify_url) {
        this.notify_url = notify_url;
        return this;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<String, Object>();
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            Object obj;
            try {
                obj = field.get(this);
                if (obj != null) {
                    map.put(field.getName(), obj);
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return map;
    }

}
