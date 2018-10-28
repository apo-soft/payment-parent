package cn.aposoft.ecommerce.wechat.service;

import cn.aposoft.ecommerce.wechat.beans.*;
import cn.aposoft.ecommerce.wechat.beans.protocol.close_protocol.WechatCloseResData;
import cn.aposoft.ecommerce.wechat.beans.protocol.downloadbill_protocol.WechatDownloadBillResData;
import cn.aposoft.ecommerce.wechat.beans.protocol.pay_protocol.WeChatPayResData;
import cn.aposoft.ecommerce.wechat.beans.protocol.pay_query_protocol.WechatPayQueryResData;
import cn.aposoft.ecommerce.wechat.beans.protocol.refund_protocol.WeChatRefundResData;
import cn.aposoft.ecommerce.wechat.beans.protocol.refund_query_protocol.WechatRefundQueryResData;
import cn.aposoft.ecommerce.wechat.enums.SignTypeEnum;
import cn.aposoft.ecommerce.wechat.params.CloseOrderParams;
import cn.aposoft.ecommerce.wechat.params.DownloadBillParams;
import cn.aposoft.ecommerce.wechat.params.OrderQueryParams;
import cn.aposoft.ecommerce.wechat.service.middle.PaymentServiceImpl;
import cn.aposoft.ecommerce.wechat.tencent.WechatConstant;
import cn.aposoft.ecommerce.wechat.util.Base64;
import com.alibaba.fastjson.JSON;
import org.apache.http.client.utils.DateUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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
    public void verifySign()  {

        String xml = "123";
        boolean verify = paymentService.verifySign(xml, SignTypeEnum.HMACSHA256);
        Assert.assertFalse(verify);

          xml = getSuccessXml();
          verify = paymentService.verifySign(xml, SignTypeEnum.HMACSHA256);
        Assert.assertTrue(verify);
    }

    private String getSuccessXml() {
        return ("<xml><appid><![CDATA[wxd23d0632ad28c805]]></appid>\n" +
                "<bank_type><![CDATA[CFT]]></bank_type>\n" +
                "<cash_fee><![CDATA[1]]></cash_fee>\n" +
                "<fee_type><![CDATA[CNY]]></fee_type>\n" +
                "<is_subscribe><![CDATA[N]]></is_subscribe>\n" +
                "<mch_id><![CDATA[1510598081]]></mch_id>\n" +
                "<nonce_str><![CDATA[7CNAOpo5BbmbK8vOiqGoZu7hcufQLkCJ]]></nonce_str>\n" +
                "<openid><![CDATA[o44s5uBeQvP0Oof_s3u7SdacmkJ0]]></openid>\n" +
                "<out_trade_no><![CDATA[2018081701]]></out_trade_no>\n" +
                "<result_code><![CDATA[SUCCESS]]></result_code>\n" +
                "<return_code><![CDATA[SUCCESS]]></return_code>\n" +
                "<sign><![CDATA[DAA9BCD9CE052A6B0843AFABADEEE610EF613750345711C6ECDF35092072C42C]]></sign>\n" +
                "<sub_appid><![CDATA[wx34723380b2d8a699]]></sub_appid>\n" +
                "<sub_is_subscribe><![CDATA[N]]></sub_is_subscribe>\n" +
                "<sub_mch_id><![CDATA[1511458511]]></sub_mch_id>\n" +
                "<sub_openid><![CDATA[oDodT0XcpFfrHVR9Kc_VgpFOj8lQ]]></sub_openid>\n" +
                "<time_end><![CDATA[20180817170723]]></time_end>\n" +
                "<total_fee>1</total_fee>\n" +
                "<trade_type><![CDATA[NATIVE]]></trade_type>\n" +
                "<transaction_id><![CDATA[4200000139201808179060622869]]></transaction_id>\n" +
                "</xml>");
    }

    @Test
    public void pay(){
        payTest();

    }

    private OrderParamsDTO payTest() {
        OrderParamsDTO orderParam = getOrderParamsDTO();
        WeChatPayResData payResult = null;
        //try-with方式实现自动close，要求接口与实现类都必须继承或者实现 AutoCloseable 接口
        try(PaymentService paymentService = new PaymentServiceImpl(config, basePaymentService)) {
            payResult = paymentService.pay(orderParam);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Assert.assertNotNull(payResult);
        System.out.println(JSON.toJSONString(payResult));
        return orderParam;
    }
    private OrderParamsDTO payTest_Close() throws Exception {
        OrderParamsDTO orderParam = getOrderParamsDTO();
        WeChatPayResData payResult = null;
            payResult = paymentService.pay(orderParam);

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
        paymentService.close();
        Assert.assertNotNull(queryResult);
        System.out.println(JSON.toJSONString(queryResult));
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
        OrderParamsDTO orderParams = payTest_Close();
        //关单
        CloseOrderParams params = getCloseParams(orderParams);
        WechatCloseResData closeResult = paymentService.closeOrder(params);
        paymentService.close();
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

        RefundParamsDTO data = getRefundData();
        WeChatRefundResData refundResult = paymentService.refund(data);
        paymentService.close();
        System.out.println("退款返回结果："+JSON.toJSONString(refundResult));
        Assert.assertNotNull(refundResult);
    }

    private RefundParamsDTO getRefundData() {
        RefundParamsDTO data = new RefundParamsDTO();
        data.setOut_refund_no(DateUtils.formatDate(new Date(), "yyyMMddHHmmss"))
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
        paymentService.close();
        System.out.println(JSON.toJSONString(refundQueryResult));
        Assert.assertNotNull(refundQueryResult);

    }

    private RefundQueryParamsDTO getRefundQueryData() {
        RefundQueryParamsDTO paramsDTO = new RefundQueryParamsDTO();
        paramsDTO.setTransaction_id("4200000153201808209352891155");//四个单号四选一，(商户订单号，微信下单订单号，商户退款订单号,微信退款订单号)
        return paramsDTO;
    }

    @Test
    public void downloadBill() throws Exception {
        DownloadBillParams params = getDownloadBillParams();
        List<WechatDownloadBillResData> downloadBillResult = paymentService.downloadBill(params);
        paymentService.close();

        Assert.assertNotNull(downloadBillResult);
    }

    private DownloadBillParams getDownloadBillParams() {
        DownloadBillParamsDTO paramsDTO = new DownloadBillParamsDTO();
        paramsDTO.setBill_type("REFUND")
//                .setBill_date(getYesterday());
                .setBill_date("20180821");
        return paramsDTO;
    }

    private String getYesterday() {
        Date date = org.apache.commons.lang3.time.DateUtils.addDays(new Date(), -1);
        return DateUtils.formatDate(date, "yyyyMMdd");
    }

    @Test
    @Deprecated
    public void createBase64_PKCS12() throws IOException {
//        File filename = new File(pkcs12);
//        FileInputStream inputFromFile = new FileInputStream(filename);
//        byte[] byteData = new byte[inputFromFile.available()];
//        inputFromFile.read(byteData);
//        inputFromFile.close();
//
//        String pkcs12 = Base64.encode(byteData);
//        System.out.println(pkcs12);

        byte[] certData;

        File file = new File(pkcs12);
        InputStream certStream = new FileInputStream(file);
        certData = new byte[(int) file.length()];
        certStream.read(certData);
        certStream.close();
        String pkcs12 = Base64.encode(certData);
        System.out.println(pkcs12);
    }
}


enum TradeTypeEnum {
    NATIVE, JSAPI
}
