package cn.aposoft.ecommerce.wechat.service.impl;

import cn.aposoft.ecommerce.wechat.beans.invoke.HttpInvokeParams;
import cn.aposoft.ecommerce.wechat.beans.protocol.BaseRequestBeans;
import cn.aposoft.ecommerce.wechat.beans.protocol.downloadbill_protocol.WechatDownloadBillResData;
import cn.aposoft.ecommerce.wechat.beans.protocol.pay_protocol.WeChatPayReqData;
import cn.aposoft.ecommerce.wechat.beans.protocol.pay_query_protocol.WechatPayQueryReqData;
import cn.aposoft.ecommerce.wechat.beans.protocol.pay_query_protocol.WechatPayQueryResData;
import cn.aposoft.ecommerce.wechat.beans.protocol.refund_protocol.WeChatRefundResData;
import cn.aposoft.ecommerce.wechat.beans.protocol.refund_query_protocol.WechatRefundQueryResData;
import cn.aposoft.ecommerce.wechat.config.BaseWechatConfig;
import cn.aposoft.ecommerce.wechat.enums.BillTypeEnum;
import cn.aposoft.ecommerce.wechat.enums.SignTypeEnum;
import cn.aposoft.ecommerce.wechat.exceptions.VerifySignFailException;
import cn.aposoft.ecommerce.wechat.httpclient.HttpRequestUtil;
import cn.aposoft.ecommerce.wechat.params.DownloadBillParams;
import cn.aposoft.ecommerce.wechat.params.OrderParams;
import cn.aposoft.ecommerce.wechat.params.OrderQueryParams;
import cn.aposoft.ecommerce.wechat.parser.*;
import cn.aposoft.ecommerce.wechat.service.BasePaymentService;
import cn.aposoft.ecommerce.wechat.tencent.WechatConstant;
import cn.aposoft.ecommerce.wechat.tencent.WechatSignature;
import cn.aposoft.ecommerce.wechat.tencent.WechatUtil;
import cn.aposoft.ecommerce.wechat.util.BeanConvertUtils;
import cn.aposoft.ecommerce.wechat.util.LogPortal;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author code
 * @Title: AbstractBasePaymentService
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/8/22下午10:27
 */
public abstract class AbstractBasePaymentService implements BasePaymentService {
    protected HttpRequestUtil httpRequestUtil;

    /**
     * 转换为下单请求参数
     *
     * @param orderParams
     * @param config
     * @return
     */
    protected String createPayRequest(OrderParams orderParams, BaseWechatConfig config) throws Exception {


        WeChatPayReqData data = BeanConvertUtils.convert(orderParams, WeChatPayReqData.class);

        if (StringUtils.isEmpty(data.getSign_type())) {
            data.setSign_type(WechatConstant.HMACSHA256);//默认采用HMACSHA256签名方式处理
        }
        if (StringUtils.isEmpty(data.getNotify_url())) {
            data.setNotify_url(config.getNotifyUrl());//默认notify_url从配置文件中获取
        }

        setAccountData(config, data, WechatConstant.HMACSHA256);

        // 下单请求参数转换
        return WechatUtil.ObjectToXml(data);
    }


    /**
     * 创建xmlRequest信息
     *
     * @param requestBeans
     * @param config
     * @param clazz
     * @return
     * @throws Exception
     */
    protected String createXmlRequest(Object requestBeans, BaseWechatConfig config, Class clazz) throws Exception {
        BaseRequestBeans data = (BaseRequestBeans) BeanConvertUtils.convert(requestBeans, clazz);
        setAccountData(config, data, WechatConstant.MD5);
        return WechatUtil.ObjectToXml(data);
    }

    private void setAccountData(BaseWechatConfig config, BaseRequestBeans data, String signType) {
        data.setAppid(config.getAppID())
                .setMch_id(config.getMchID())
                .setSub_appid(config.getSubAppId())
                .setSub_mch_id(config.getSubMchId())
        ;

        data.generateSign(config.getKey(), data, signType);

    }

    //------

    /**
     * HTTP请求调用封装
     * 包含返回值签名校验操作
     *
     * @param params
     * @param <T>
     * @return
     * @throws Exception
     */
    protected <T> T httpInvoke(HttpInvokeParams<T> params) throws Exception {
        String xml = createXmlRequest(params.getRequestParams(), params.getConfig(), params.getRequestBean());
        String response = httpRequestUtil.post(xml, params.getConfig(), params.getUrl());
        checkVerify(params, response);
        T responseData = WechatUtil.getObjectFromXML(response, params.getResponseBean());
        //动态属性解析并赋值
        convertCouponParams(response, responseData);
        return responseData;
    }


    protected <T> void convertCouponParams(String xml, T responseData) throws Exception {
        Map<String, String> responseMap = WechatUtil.xmlToMap(xml);
        if (responseData instanceof WechatRefundQueryResData) {//退款查询
            // 1.1 解析退款查询动态属性部分
            analysisRefundQueryResData((WechatRefundQueryResData) responseData, responseMap);

        } else if (responseData instanceof WechatPayQueryResData) {//订单查询
            // 1.1 解析订单查询动态属性部分
            analysisOrderQueryResData((WechatPayQueryResData) responseData, responseMap);
        } else if (responseData instanceof WeChatRefundResData) {//退款申请
            // 1.1 解析退款申请动态属性部分
            analysisRefundResData((WeChatRefundResData) responseData, responseMap);
        }
    }
    /**
     * 退款申请动态属性解析
     *
     * @param resData
     * @param responseMap
     */
    protected void analysisRefundResData(WeChatRefundResData resData, Map<String, String> responseMap) {
        CouponParser parser = new RefundCouponParser();
        for (Map.Entry<String, String> entry : responseMap.entrySet()) {
            checkAndSetRefundResData(entry, resData, parser);
        }
    }

    /**
     * 退款申请动态属性赋值
     *
     * @param entry
     * @param resData
     * @param parser
     */
    private void checkAndSetRefundResData(Map.Entry<String, String> entry, WeChatRefundResData resData, CouponParser parser) {
        if (parser.isCoupon_id(entry.getKey())) {
            resData.setCoupon_refund_id_$n(entry.getValue());
        } else if (parser.isCoupon_fee(entry.getKey())) {
            resData.setCoupon_refund_fee_$n(Integer.valueOf(entry.getValue()));
        } else if (parser.isCoupon_type(entry.getKey())) {
            resData.setCoupon_type_$n(entry.getValue());
        }
    }

    /**
     * 解析订单查询返回结果的动态属性
     *
     * @param resData
     * @param responseMap
     */
    protected void analysisOrderQueryResData(WechatPayQueryResData resData, Map<String, String> responseMap) {
        CouponParser parser = new OrderQueryCouponParser();
        for (Map.Entry<String, String> entry : responseMap.entrySet()) {
            checkAndSetOrderQueryResDataCouponValues(entry, resData, parser);
        }
    }

    /**
     * 订单查询返回结果动态属性赋值
     *
     * @param entry
     * @param resData
     * @param parser
     */
    private void checkAndSetOrderQueryResDataCouponValues(Map.Entry<String, String> entry, WechatPayQueryResData resData, CouponParser parser) {
        if (parser.isCoupon_id(entry.getKey())) {
            resData.setCoupon_id_$n(entry.getValue());
        } else if (parser.isCoupon_fee(entry.getKey())) {
            resData.setCoupon_fee_$n(Integer.valueOf(entry.getValue()));
        } else if (parser.isCoupon_type(entry.getKey())) {
            resData.setCoupon_type_$n(entry.getValue());
        }
    }
    /**
     * 解析退款查询返回结果的动态属性
     *
     * @param resData
     * @param responseMap
     */
    protected void analysisRefundQueryResData(WechatRefundQueryResData resData, Map<String, String> responseMap) {
        RefundQueryParser parser = new RefundQueryCouponParser();
        for (Map.Entry<String, String> entry : responseMap.entrySet()) {
            checkAndSetRefundQueryCouponValues(entry, resData, parser);
        }
    }

    /**
     * 动态属性解析赋值
     *
     * @param entry
     * @param resData
     * @param parser
     */
    private void checkAndSetRefundQueryCouponValues(Map.Entry<String, String> entry, WechatRefundQueryResData resData, RefundQueryParser parser) {
        if (parser.isCoupon_id(entry.getKey())) {
            resData.setCoupon_refund_id_$n_$m(entry.getValue());
        } else if (parser.isCoupon_fee(entry.getKey())) {
            resData.setCoupon_refund_fee_$n_$m(Integer.valueOf(entry.getValue()));
        } else if (parser.isOut_refund_no(entry.getKey())) {
            resData.setOut_refund_no_$n(entry.getValue());
        } else if (parser.isRefund_id(entry.getKey())) {
            resData.setRefund_id_$n(entry.getValue());
        } else if (parser.isRefund_channel(entry.getKey())) {
            resData.setRefund_channel_$n(entry.getValue());
        } else if (parser.isRefund_fee(entry.getKey())) {
            resData.setRefund_fee_$n(Integer.valueOf(entry.getValue()));
        } else if (parser.isSettlement_refund_fee(entry.getKey())) {
            resData.setSettlement_refund_fee_$n(Integer.valueOf(entry.getValue()));
        } else if (parser.isCoupon_type(entry.getKey())) {
            resData.setCoupon_type_$n_$m(entry.getValue());
        } else if (parser.isCoupon_refund_count(entry.getKey())) {
            resData.setCoupon_refund_count_$n(Integer.valueOf(entry.getValue()));
        } else if (parser.isRefund_status(entry.getKey())) {
            resData.setRefund_status_$n(entry.getValue());
        } else if (parser.isRefund_account(entry.getKey())) {
            resData.setRefund_account_$n(entry.getValue());
        } else if (parser.isRefund_recv_accout(entry.getKey())) {
            resData.setRefund_recv_accout_$n(entry.getValue());
        } else if (parser.isRefund_success_time(entry.getKey())) {
            resData.setRefund_success_time_$n(entry.getValue());
        }
    }


    /**
     * 需要证书的请求
     * 包含返回值签名校验操作
     *
     * @param params
     * @param <T>
     * @return
     * @throws Exception
     */
    protected <T> T httpsInvoke(HttpInvokeParams<T> params) throws Exception {
        String xml = createXmlRequest(params.getRequestParams(), params.getConfig(), params.getRequestBean());
        String response = httpRequestUtil.keyCertPost(xml, params.getConfig(), params.getUrl());

        checkVerify(params, response);
        T responseData = WechatUtil.getObjectFromXML(response, params.getResponseBean());

        //动态属性解析并赋值
        convertCouponParams(response, responseData);
        return responseData;
    }

    protected <T> void checkVerify(HttpInvokeParams<T> params, String response) throws Exception {
        checkVerify(response, params.getConfig().getKey(), params.getSignTypeEnum());
    }

    protected void checkVerify(String response, String key, SignTypeEnum signTypeEnum) throws Exception {
        boolean verify = WechatSignature.verifySign(WechatUtil.xmlToMap(response), key, signTypeEnum);
        if (!verify) {//签名校验失败
            LogPortal.error("签名校验失败,payResponse=[{}]", response);
            throw new VerifySignFailException("返回结果签名校验失败");

        }
    }

    protected <T> HttpInvokeParams<T> convertInvoke(Object requestParams, BaseWechatConfig config,
                                                    Class requestBean, Class<T> responseBean, String url, SignTypeEnum signTypeEnum) {

        HttpInvokeParams<T> invokeParams = new HttpInvokeParams();
        invokeParams.setRequestParams(requestParams)
                .setConfig(config)
                .setRequestBean(requestBean)
                .setResponseBean(responseBean)
                .setUrl(url)
                .setSignTypeEnum(signTypeEnum);

        return invokeParams;

    }

    //------

    protected List<WechatDownloadBillResData> convertWechatDownloadBillDataList(String responseData, DownloadBillParams params) {
        List<WechatDownloadBillResData> list = new ArrayList<>();

        //解析行数据为一个数组
        String[] dataArrayList = responseData.split("\\n");
        for (String dataArray : dataArrayList) {
            //处理每行数据中的\r,\n，并去掉 ` 符号
            String dataContent = dataArray.replaceAll("\\n", "").replaceAll("\\r", "")
                    .replaceAll("`", "").replaceAll("\uFEFF", "");
            //解析每行数据为一个数组
            String[] lineData = dataContent.split(",");
            //过滤掉对账单标题部分以及统计部分的内容


            if (BillTypeEnum.REFUND.name().equals(params.getBill_type())) {
                if (StringUtils.equals("交易时间", lineData[0]) || lineData.length != 26) {
                    continue;
                }
                list.add(convertWechatDownloadRefundData(lineData, Integer.valueOf(params.getBill_date())));
            } else if (BillTypeEnum.ALL.name().equals(params.getBill_type())
                    || StringUtils.isEmpty(params.getBill_type())) {
                if (StringUtils.equals("交易时间", lineData[0]) || lineData.length != 24) {
                    continue;
                }
                list.add(convertWechatAllData(lineData, Integer.valueOf(params.getBill_date())));
            }
        }
        return list;
    }


    /**
     * 将对账单数据转换为对象类型
     *
     * @param data
     * @param statementDate
     * @return
     */
    private WechatDownloadBillResData convertWechatAllData(String[] data, Integer statementDate) {

        WechatDownloadBillResData dto = new WechatDownloadBillResData();
        try {
            dto.setTradeTime(DateUtils.parseDate(data[0], "yyyy-MM-dd HH:mm:ss"));
        } catch (ParseException e) {
            LogPortal.error("异常信息是:", e);
        }
        dto.setWechatAppid(data[1]);
        dto.setMchId(data[2]);
        dto.setSubMchId(data[3]);
        dto.setDeviceInfo(data[4]);
        dto.setWechatOrderId(data[5]);
        dto.setMchOrderId(data[6]);
        dto.setUserId(data[7]);
        dto.setTradeType(data[8]);
        dto.setTradeStatus(data[9]);
        dto.setPayBank(data[10]);
        dto.setCurrency(data[11]);
        dto.setTotalAmount(data[12]);
        dto.setEnterpriseRedEnvelopeAmount(data[13]);
        dto.setWechatRefundOrderId(data[14]);
        dto.setMchRefundOrderId(data[15]);
        dto.setRefundAmount(data[16]);
        dto.setEnterpriseRedEnvelopeRefundAmount(data[17]);
        dto.setRefundType(data[18]);
        dto.setRefundStatus(data[19]);
        dto.setGoodsName(data[20]);
        dto.setMchDataPackage(data[21]);
        dto.setCounterFee(data[22]);
        dto.setFeeRate(data[23]);
        dto.setStatementDate(statementDate);
        return dto;
    }


    /**
     * 解析退款类型对账单
     *
     * @param data
     * @param statementDate
     */
    private WechatDownloadBillResData convertWechatDownloadRefundData(String[] data, Integer statementDate) {

        WechatDownloadBillResData dto = new WechatDownloadBillResData();
        try {
            dto.setTradeTime(DateUtils.parseDate(data[0], "yyyy-MM-dd HH:mm:ss"));
        } catch (ParseException e) {
            LogPortal.error("异常信息是:", e);
        }

        dto.setWechatAppid(data[1]);
        dto.setMchId(data[2]);
        dto.setSubMchId(data[3]);
        dto.setDeviceInfo(data[4]);
        dto.setWechatOrderId(data[5]);
        dto.setMchOrderId(data[6]);
        dto.setUserId(data[7]);
        dto.setTradeType(data[8]);
        dto.setTradeStatus(data[9]);
        dto.setPayBank(data[10]);
        dto.setCurrency(data[11]);
        dto.setTotalAmount(data[12]);
        dto.setEnterpriseRedEnvelopeAmount(data[13]);
        dto.setRefundApplyTime(data[14]);
        dto.setRefundSuccessTime(data[15]);
        dto.setWechatRefundOrderId(data[16]);
        dto.setMchRefundOrderId(data[17]);
        dto.setRefundAmount(data[18]);
        dto.setEnterpriseRedEnvelopeRefundAmount(data[19]);
        dto.setRefundType(data[20]);
        dto.setRefundStatus(data[21]);
        dto.setGoodsName(data[22]);
        dto.setMchDataPackage(data[23]);
        dto.setCounterFee(data[24]);
        dto.setFeeRate(data[25]);
        dto.setStatementDate(statementDate);

        return dto;
    }
}
