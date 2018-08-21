package cn.aposoft.ecommerce.wechat.service.impl;

import cn.aposoft.ecommerce.wechat.beans.protocol.close_protocol.CloseResData;
import cn.aposoft.ecommerce.wechat.beans.protocol.downloadbill_protocol.DownloadBillResData;
import cn.aposoft.ecommerce.wechat.beans.protocol.pay_protocol.WeChatPayResData;
import cn.aposoft.ecommerce.wechat.beans.protocol.pay_query_protocol.WechatPayQueryResData;
import cn.aposoft.ecommerce.wechat.beans.protocol.refund_protocol.WeChatRefundResData;
import cn.aposoft.ecommerce.wechat.beans.protocol.refund_query_protocol.WechatRefundQueryResData;
import cn.aposoft.ecommerce.wechat.config.BaseWechatConfig;
import cn.aposoft.ecommerce.wechat.httpclient.HttpRequestUtil;
import cn.aposoft.ecommerce.wechat.params.*;
import cn.aposoft.ecommerce.wechat.service.BasePaymentService;

import java.io.IOException;

/**
 * @author code
 * @Title: BasePaymentServiceImpl
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/8/21下午8:57
 */
public class BasePaymentServiceImpl implements BasePaymentService {
    HttpRequestUtil httpRequestUtil;

    public BasePaymentServiceImpl(HttpRequestUtil httpRequestUtil) {
        this.httpRequestUtil = httpRequestUtil;
    }

    @Override
    public WeChatPayResData pay(OrderParams orderParams, BaseWechatConfig config) throws Exception {
        return null;
    }

    @Override
    public WechatPayQueryResData query(OrderQueryParams orderQueryParams, BaseWechatConfig config) throws Exception {
        return null;
    }

    @Override
    public CloseResData closeOrder(CloseOrderParams params, BaseWechatConfig config) throws Exception {
        return null;
    }

    @Override
    public WeChatRefundResData refund(RefundParams refund, BaseWechatConfig config) throws Exception {
        return null;
    }

    @Override
    public WechatRefundQueryResData refundQuery(RefundQueryParams params, BaseWechatConfig config) throws Exception {
        return null;
    }

    @Override
    public DownloadBillResData downloadBill(DownloadBillParams params, BaseWechatConfig config) throws Exception {
        return null;
    }

    @Override
    public void close() throws IOException {

    }
}
