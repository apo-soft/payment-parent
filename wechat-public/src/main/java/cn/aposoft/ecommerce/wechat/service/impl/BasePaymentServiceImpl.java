package cn.aposoft.ecommerce.wechat.service.impl;

import cn.aposoft.ecommerce.wechat.beans.protocol.close_protocol.WechatCloseReqData;
import cn.aposoft.ecommerce.wechat.beans.protocol.close_protocol.WechatCloseResData;
import cn.aposoft.ecommerce.wechat.beans.protocol.downloadbill_protocol.WechatDownloadBillReqData;
import cn.aposoft.ecommerce.wechat.beans.protocol.downloadbill_protocol.WechatDownloadBillResData;
import cn.aposoft.ecommerce.wechat.beans.protocol.pay_protocol.WeChatPayResData;
import cn.aposoft.ecommerce.wechat.beans.protocol.pay_query_protocol.WechatPayQueryReqData;
import cn.aposoft.ecommerce.wechat.beans.protocol.pay_query_protocol.WechatPayQueryResData;
import cn.aposoft.ecommerce.wechat.beans.protocol.refund_protocol.WeChatRefundReqData;
import cn.aposoft.ecommerce.wechat.beans.protocol.refund_protocol.WeChatRefundResData;
import cn.aposoft.ecommerce.wechat.beans.protocol.refund_query_protocol.WechatRefundQueryReqData;
import cn.aposoft.ecommerce.wechat.beans.protocol.refund_query_protocol.WechatRefundQueryResData;
import cn.aposoft.ecommerce.wechat.config.BaseWechatConfig;
import cn.aposoft.ecommerce.wechat.httpclient.HttpRequestUtil;
import cn.aposoft.ecommerce.wechat.params.*;
import cn.aposoft.ecommerce.wechat.tencent.WechatUtil;
import cn.aposoft.ecommerce.wechat.util.FileUtil;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.util.List;

/**
 * 调用HTTP接口进行访问操作
 *
 * @author code
 * @Title: BasePaymentServiceImpl
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/8/21下午8:57
 */
public class BasePaymentServiceImpl extends AbstractBasePaymentService {
    HttpRequestUtil httpRequestUtil;

    public BasePaymentServiceImpl(HttpRequestUtil httpRequestUtil) {
        this.httpRequestUtil = httpRequestUtil;
    }

    @Override
    public WeChatPayResData pay(OrderParams orderParams, BaseWechatConfig config) throws Exception {

        String xml = createPayRequest(orderParams, config);
        String response = httpRequestUtil.post(xml, config, config.getPayUrl());
        return WechatUtil.getObjectFromXML(response, WeChatPayResData.class);
    }

    @Override
    public WechatPayQueryResData query(OrderQueryParams params, BaseWechatConfig config) throws Exception {
        return httpInvoke(params, config,
                WechatPayQueryReqData.class, WechatPayQueryResData.class, config.getOrderQueryUrl());
    }

    @Override
    public WechatCloseResData closeOrder(CloseOrderParams params, BaseWechatConfig config) throws Exception {
        return httpInvoke(params, config,
                WechatCloseReqData.class, WechatCloseResData.class, config.getCloseOrderUrl());
    }

    @Override
    public WeChatRefundResData refund(RefundParams params, BaseWechatConfig config) throws Exception {
        return httpsInvoke(params, config,
                WeChatRefundReqData.class, WeChatRefundResData.class, config.getRefundUrl());
    }

    @Override
    public WechatRefundQueryResData refundQuery(RefundQueryParams params, BaseWechatConfig config) throws Exception {
        return httpInvoke(params, config,
                WechatRefundQueryReqData.class, WechatRefundQueryResData.class, config.getRefundQueryUrl());
    }

    @Override
    public List<WechatDownloadBillResData> downloadBill(DownloadBillParams params, BaseWechatConfig config) throws Exception {
        String xml = createXmlRequest(params, config, WechatDownloadBillReqData.class);
        String response = httpRequestUtil.post(xml, config, config.getDownloadBillUrl());
        //默认检测对账单路径是否存在，存在，则生成文件记录，不存在，则不进行文件数据记录
        if (StringUtils.isNotEmpty(config.getStatementPath())) {
            String path = config.getStatementPath();
            String pathName = null;
            if (path.lastIndexOf("/") > 0) {//判断路径是否以左斜线结尾，并生成相应的路径
                pathName = config.getStatementPath() + params.getBill_date() + File.separator + params.getBill_type() + ".csv";
            } else {
                pathName = config.getStatementPath() + File.separator + params.getBill_date() + File.separator + params.getBill_type() + ".csv";
            }
            FileUtil.save2Local(response, pathName);
        }
        //解析对账单数据信息
        List<WechatDownloadBillResData> list = convertWechatDownloadBillDataList(response, params);
        return list;
    }

    @Override
    public void close() throws Exception {
        httpRequestUtil.close();
    }

    /**
     * HTTP请求调用封装
     *
     * @param requestParams 请求bean
     * @param config        微信基础配置
     * @param requestBean   请求对象的类名称
     * @param responseBean  返回对象的类名称
     * @param url           需要调用的URL地址
     * @param <T>           泛型
     * @return
     * @throws Exception
     */
    private <T> T httpInvoke(Object requestParams, BaseWechatConfig config,
                             Class requestBean, Class<T> responseBean, String url) throws Exception {
        String xml = createXmlRequest(requestParams, config, requestBean);
        String response = httpRequestUtil.post(xml, config, url);
        return WechatUtil.getObjectFromXML(response, responseBean);
    }


    /**
     * 需要证书的请求
     *
     * @param requestParams
     * @param config
     * @param requestBean
     * @param responseBean
     * @param url
     * @param <T>
     * @return
     * @throws Exception
     */
    private <T> T httpsInvoke(Object requestParams, BaseWechatConfig config,
                              Class requestBean, Class<T> responseBean, String url) throws Exception {
        String xml = createXmlRequest(requestParams, config, requestBean);
        String response = httpRequestUtil.keyCertPost(xml, config, url);
        return WechatUtil.getObjectFromXML(response, responseBean);
    }
}
