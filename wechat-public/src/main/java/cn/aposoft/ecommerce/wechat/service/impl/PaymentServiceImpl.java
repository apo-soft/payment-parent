package cn.aposoft.ecommerce.wechat.service.impl;

import cn.aposoft.ecommerce.wechat.beans.protocol.close_protocol.CloseResData;
import cn.aposoft.ecommerce.wechat.beans.protocol.downloadbill_protocol.DownloadBillResData;
import cn.aposoft.ecommerce.wechat.beans.protocol.pay_protocol.WeChatPayResData;
import cn.aposoft.ecommerce.wechat.beans.protocol.pay_query_protocol.WechatPayQueryResData;
import cn.aposoft.ecommerce.wechat.beans.protocol.refund_protocol.WeChatRefundResData;
import cn.aposoft.ecommerce.wechat.beans.protocol.refund_query_protocol.WechatRefundQueryResData;
import cn.aposoft.ecommerce.wechat.config.BaseWechatConfig;
import cn.aposoft.ecommerce.wechat.params.*;
import cn.aposoft.ecommerce.wechat.service.PaymentService;

import java.io.IOException;

/**
 * @author code
 * @Title: PaymentServiceImpl
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/8/19下午6:01
 */
public class PaymentServiceImpl implements PaymentService {
    @Override
    public WeChatPayResData pay(OrderParams orderParams, BaseWechatConfig config) {
        return null;
    }

    @Override
    public WechatPayQueryResData query(OrderQueryParams orderQueryParams, BaseWechatConfig config) {
        return null;
    }

    @Override
    public CloseResData closeOrder(CloseOrderParams params, BaseWechatConfig config) {
        return null;
    }

    @Override
    public WeChatRefundResData refund(RefundParams refund, BaseWechatConfig config) {
        return null;
    }

    @Override
    public WechatRefundQueryResData refundQuery(RefundQueryParams params, BaseWechatConfig config) {
        return null;
    }

    @Override
    public DownloadBillResData downloadBill(DownloadBillParams params, BaseWechatConfig config) {
        return null;
    }

    @Override
    public void close() throws IOException {

    }
}
