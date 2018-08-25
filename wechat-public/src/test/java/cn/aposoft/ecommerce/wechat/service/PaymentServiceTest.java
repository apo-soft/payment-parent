package cn.aposoft.ecommerce.wechat.service;

import cn.aposoft.ecommerce.wechat.beans.*;
import cn.aposoft.ecommerce.wechat.beans.protocol.close_protocol.WechatCloseResData;
import cn.aposoft.ecommerce.wechat.beans.protocol.downloadbill_protocol.WechatDownloadBillResData;
import cn.aposoft.ecommerce.wechat.beans.protocol.pay_protocol.WeChatPayResData;
import cn.aposoft.ecommerce.wechat.beans.protocol.pay_query_protocol.WechatPayQueryResData;
import cn.aposoft.ecommerce.wechat.beans.protocol.refund_protocol.WeChatRefundResData;
import cn.aposoft.ecommerce.wechat.beans.protocol.refund_query_protocol.WechatRefundQueryResData;
import cn.aposoft.ecommerce.wechat.params.CloseOrderParams;
import cn.aposoft.ecommerce.wechat.params.DownloadBillParams;
import cn.aposoft.ecommerce.wechat.params.OrderQueryParams;
import cn.aposoft.ecommerce.wechat.tencent.WechatConstant;
import com.alibaba.fastjson.JSON;
import org.apache.http.client.utils.DateUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * @author code
 * @Title: PaymentServiceTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/8/19下午8:56
 */
public class PaymentServiceTest extends BaseAppTest {

    @Test
    public void pay() throws Exception {
        payTest();

    }

    private OrderParamsDTO payTest() throws Exception {
        OrderParamsDTO orderParam = getOrderParamsDTO();
        WeChatPayResData payResult = paymentService.pay(orderParam);
        Assert.assertNotNull(payResult);
        System.out.println(JSON.toJSONString(payResult));
        return orderParam;
    }


    private OrderParamsDTO getOrderParamsDTO() {
        OrderParamsDTO orderParam = new OrderParamsDTO();
        String outTradeNo = DateUtils.formatDate(new Date(), "yyyyMMddHHmmss");
        System.out.println("商户订单号：" + outTradeNo);
        orderParam.setTotal_fee(1)
                .setBody("下单测试")
                .setTrade_type(TradeTypeEnum.NATIVE.name())
//                .setTrade_type(TradeTypeEnum.JSAPI.name())
                .setNotify_url("http://123")
                .setOut_trade_no(outTradeNo)
                .setSpbill_create_ip("123.32.15.22")
//                .setOpenid("o44s5uBeQvP0Oof_s3u7SdacmkJ0")
                .setSign_type(WechatConstant.HMACSHA256)
        ;
        return orderParam;
    }

    @Test
    public void query() throws Exception {
        OrderQueryParams params = getQueryParams();
        WechatPayQueryResData queryResult = paymentService.query(params);
        Assert.assertNotNull(queryResult);
        System.out.println(queryResult);
    }

    private OrderQueryParams getQueryParams() {
        OrderQueryParamsDTO params = new OrderQueryParamsDTO();

        params//.setOut_trade_no("")
                .setTransaction_id("4200000139201808179060622869")
        ;
        return params;
    }

    /**
     * 通过下单执行对应的订单关闭操作
     *
     * @throws Exception
     */
    @Test
    public void closeOrder() throws Exception {
        //下单
        OrderParamsDTO orderParams = payTest();
        //关单
        CloseOrderParams params = getCloseParams(orderParams);
        WechatCloseResData closeResult = paymentService.closeOrder(params);
        System.out.println(JSON.toJSONString(closeResult));
        Assert.assertNotNull(closeResult);
    }

    private CloseOrderParams getCloseParams(OrderParamsDTO orderParams) {
        CloseOrderParamsDTO params = new CloseOrderParamsDTO();

        if (orderParams == null) {
            params.setOut_trade_no("20180825040552");
        } else {
            params.setOut_trade_no(orderParams.getOut_trade_no());
        }
        return params;
    }

    @Test
    public void refund() throws Exception {

        RefundParamsDTO data = getRefundData(null);
        WeChatRefundResData refundResult = paymentService.refund(data);
        System.out.println(JSON.toJSONString(refundResult));
        Assert.assertNotNull(refundResult);
    }

    private RefundParamsDTO getRefundData(OrderParamsDTO orderParams) {
        RefundParamsDTO data = new RefundParamsDTO();
        data.setOut_refund_no(DateUtils.formatDate(new Date(),"yyyMMddHHmmss"))
                .setTransaction_id("4200000139201808179060622869")
                .setRefund_fee(1)
                .setTotal_fee(1)
                ;
        return data;
    }

    @Test
    public void refundQuery() throws Exception {
        RefundQueryParamsDTO paramsDTO = getRefundQueryData();
        WechatRefundQueryResData refundQueryResult = paymentService.refundQuery(paramsDTO);
        System.out.println(JSON.toJSONString(refundQueryResult));
        Assert.assertNotNull(refundQueryResult);

    }

    private RefundQueryParamsDTO getRefundQueryData() {
        RefundQueryParamsDTO paramsDTO = new RefundQueryParamsDTO();
        paramsDTO.setTransaction_id("4200000139201808179060622869");//四个单号四选一，(商户订单号，微信下单订单号，商户退款订单号,微信退款订单号)
        return paramsDTO;
    }

    @Test
    public void downloadBill() throws Exception {
        DownloadBillParams params = getDownloadBillParams();
        List<WechatDownloadBillResData> downloadBillResult = paymentService.downloadBill(params);

        Assert.assertNotNull(downloadBillResult);
    }

    private DownloadBillParams getDownloadBillParams() {
        DownloadBillParamsDTO paramsDTO = new DownloadBillParamsDTO();
        paramsDTO.setBill_type("REFUND")
//                .setBill_date(getYesterday());
                .setBill_date("20180821");
        return paramsDTO;
    }

    private String getYesterday(){
        Date date = org.apache.commons.lang3.time.DateUtils.addDays(new Date(), -1);
        return DateUtils.formatDate(date,"yyyyMMdd");
    }

}




enum TradeTypeEnum {
    NATIVE, JSAPI
}
