package cn.aposoft.ecommerce.wechat.beans.protocol.downloadbill_protocol;

import cn.aposoft.ecommerce.wechat.beans.protocol.BaseRequestBeans;
import cn.aposoft.ecommerce.wechat.tencent.WechatSignature;
import cn.aposoft.ecommerce.wechat.tencent.WechatUtil;
import cn.aposoft.ecommerce.wechat.util.LogPortal;

/**
 * User: rizenguo
 * Date: 2014/10/25
 * Time: 16:48
 */
public class DownloadBillReqData extends BaseRequestBeans {
    //每个字段具体的意思请查看API文档

    private String bill_date;
    private String bill_type;
    private String tar_type;
    private String sign_type;

    /**
     * 请求对账单下载服务
     * device_info 商户自己定义的扫码支付终端设备号，方便追溯这笔交易发生在哪台终端设备上
     * bill_date 下载对账单的日期，格式：yyyyMMdd 例如：20140603
     * bill_type 账单类型
     * ALL，返回当日所有订单信息，默认值
     * SUCCESS，返回当日成功支付的订单
     * REFUND，返回当日退款订单
     * REVOKED，已撤销的订单
     */




    public String getBill_date() {
        return bill_date;
    }

    public DownloadBillReqData setBill_date(String bill_date) {
        this.bill_date = bill_date;
        return this;
    }

    public String getBill_type() {
        return bill_type;
    }

    public DownloadBillReqData setBill_type(String bill_type) {
        this.bill_type = bill_type;
        return this;
    }

    public String getTar_type() {
        return tar_type;
    }

    public DownloadBillReqData setTar_type(String tar_type) {
        this.tar_type = tar_type;
        return this;
    }

    public String getSign_type() {
        return sign_type;
    }

    public DownloadBillReqData setSign_type(String sign_type) {
        this.sign_type = sign_type;
        return this;
    }


}
