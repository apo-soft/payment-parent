package cn.aposoft.ecommerce.wechat.service.mock;

import cn.aposoft.ecommerce.wechat.beans.DownloadBillParamsDTO;
import cn.aposoft.ecommerce.wechat.beans.OrderParamsDTO;
import cn.aposoft.ecommerce.wechat.beans.OrderQueryParamsDTO;
import cn.aposoft.ecommerce.wechat.beans.protocol.downloadbill_protocol.WechatDownloadBillResData;
import cn.aposoft.ecommerce.wechat.beans.protocol.pay_protocol.WeChatPayResData;
import cn.aposoft.ecommerce.wechat.beans.protocol.pay_query_protocol.WechatPayQueryResData;
import cn.aposoft.ecommerce.wechat.config.BaseWechatConfig;
import cn.aposoft.ecommerce.wechat.config.WechatPubPropertiesConfig;
import cn.aposoft.ecommerce.wechat.enums.SignTypeEnum;
import cn.aposoft.ecommerce.wechat.httpclient.HttpRequestUtil;
import cn.aposoft.ecommerce.wechat.httpclient.HttpRequestUtilImpl;
import cn.aposoft.ecommerce.wechat.params.DownloadBillParams;
import cn.aposoft.ecommerce.wechat.params.OrderParams;
import cn.aposoft.ecommerce.wechat.params.OrderQueryParams;
import cn.aposoft.ecommerce.wechat.service.impl.BasePaymentServiceImpl;
import cn.aposoft.ecommerce.wechat.tencent.WechatConstant;
import org.apache.http.client.utils.DateUtils;
import org.easymock.ConstructorArgs;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import static org.powermock.api.easymock.PowerMock.createMock;

/**
 * @author code
 * @Title: PaymentServiceMockTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/9/20下午5:34
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(BasePaymentServiceImpl.class)
public class PrepareForBasePaymentServiceMockTest {
    private String pkcs12Path = "/Users/yujinshui/Desktop/千丁互联/项目资料/微信公众号信息/cert/apiclient_cert.p12";
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Mock
    private WechatPubPropertiesConfig config;
    @Mock
    private HttpRequestUtilImpl httpClientUtil;

    protected BasePaymentServiceImpl basePaymentService;

    private ConstructorArgs constructorArgs;

    @Before
    public void setUp() throws Exception {
        //带参构造函数的参数赋值
        constructorArgs = new ConstructorArgs(BasePaymentServiceImpl.class.getConstructor(HttpRequestUtil.class), httpClientUtil);
        //待测类创建实例，并将构造函数的参数传入
        basePaymentService = createMock(BasePaymentServiceImpl.class, constructorArgs);
        //开始监控待测类实例
        basePaymentService = PowerMockito.spy(basePaymentService);
        //config-支付账户参数初始化
        mockitoConfig();
    }


    @Test
    public void pay() throws Exception {


        OrderParams orderParams = getOrderParamsDTO();

        mockResponseAndIgnoreVerifySign(responsePayData());

        WeChatPayResData payResponse = basePaymentService.pay(orderParams, config);
        Assert.assertEquals("1BD02B5A04BDD5283482995C3F121E5B9230FB3A65248716B50FA5C6D4A9031C", payResponse.getSign());

    }


    @Test
    public void query() throws Exception {

        OrderQueryParams orderQueryParams = getOrderQueryParamsDTO();

        mockResponseAndIgnoreVerifySign(responseQueryData());

        WechatPayQueryResData queryResponse = basePaymentService.query(orderQueryParams, config);
        Assert.assertEquals("485D0719791753451F4E1A57034B9D3F", queryResponse.getSign());

    }

    /**
     * HTTP返回值xml设置并设置验签通过
     *
     * @param response
     * @throws Exception
     */
    private void mockResponseAndIgnoreVerifySign(String response) throws Exception {
        //模拟HTTP请求后的返回值
        PowerMockito.doReturn(response).when(httpClientUtil).post(Mockito.any(String.class), Mockito.any(BaseWechatConfig.class), Mockito.any(String.class));

        //验签通过设置
        PowerMockito.doNothing().when(basePaymentService, "checkVerify",
                Mockito.any(String.class), Mockito.any(String.class), Mockito.any(String.class), Mockito.any(SignTypeEnum.class));
    }

    private String responseQueryData() {

        return "<xml><return_code><![CDATA[SUCCESS]]></return_code>\n" +
                "<return_msg><![CDATA[OK]]></return_msg>\n" +
                "<appid><![CDATA[wxd23d0632ad28c805]]></appid>\n" +
                "<mch_id><![CDATA[1510598081]]></mch_id>\n" +
                "<sub_mch_id><![CDATA[1511458511]]></sub_mch_id>\n" +
                "<nonce_str><![CDATA[Bt6pD8HzuWcKWv2i]]></nonce_str>\n" +
                "<sign><![CDATA[485D0719791753451F4E1A57034B9D3F]]></sign>\n" +
                "<result_code><![CDATA[SUCCESS]]></result_code>\n" +
                "<openid><![CDATA[o44s5uBeQvP0Oof_s3u7SdacmkJ0]]></openid>\n" +
                "<is_subscribe><![CDATA[N]]></is_subscribe>\n" +
                "<trade_type><![CDATA[NATIVE]]></trade_type>\n" +
                "<bank_type><![CDATA[CFT]]></bank_type>\n" +
                "<total_fee>1</total_fee>\n" +
                "<fee_type><![CDATA[CNY]]></fee_type>\n" +
                "<transaction_id><![CDATA[4200000139201808179060622869]]></transaction_id>\n" +
                "<out_trade_no><![CDATA[2018081701]]></out_trade_no>\n" +
                "<attach><![CDATA[]]></attach>\n" +
                "<time_end><![CDATA[20180817170723]]></time_end>\n" +
                "<trade_state><![CDATA[SUCCESS]]></trade_state>\n" +
                "<sub_appid><![CDATA[wx34723380b2d8a699]]></sub_appid>\n" +
                "<sub_openid><![CDATA[oDodT0XcpFfrHVR9Kc_VgpFOj8lQ]]></sub_openid>\n" +
                "<sub_is_subscribe><![CDATA[N]]></sub_is_subscribe>\n" +
                "<cash_fee>1</cash_fee>\n" +
                "<trade_state_desc><![CDATA[支付成功]]></trade_state_desc>\n" +
                "</xml>";
    }

    private OrderQueryParams getOrderQueryParamsDTO() {

        OrderQueryParamsDTO dto = new OrderQueryParamsDTO();
        dto.setTransaction_id("4200000139201808179060622869");

        return dto;
    }

    private String responsePayData() {
        return "<xml><return_code><![CDATA[SUCCESS]]></return_code>\n" +
                "<return_msg><![CDATA[OK]]></return_msg>\n" +
                "<appid><![CDATA[wxd23d0632ad28c123]]></appid>\n" +
                "<mch_id><![CDATA[15112320598081]]></mch_id>\n" +
                "<sub_mch_id><![CDATA[151145211511]]></sub_mch_id>\n" +
                "<nonce_str><![CDATA[axSEHKtN5qx1tx71]]></nonce_str>\n" +
                "<sign><![CDATA[1BD02B5A04BDD5283482995C3F121E5B9230FB3A65248716B50FA5C6D4A9031C]]></sign>\n" +
                "<result_code><![CDATA[SUCCESS]]></result_code>\n" +
                "<prepay_id><![CDATA[wx2510483854944624004fa83b3962796053]]></prepay_id>\n" +
                "<trade_type><![CDATA[NATIVE]]></trade_type>\n" +
                "<code_url><![CDATA[weixin://wxpay/bizpayurl?pr=eq9ouCT]]></code_url>\n" +
                "<sub_appid><![CDATA[wx34723380b2d8a129]]></sub_appid>\n" +
                "</xml>";
    }

    private OrderParamsDTO getOrderParamsDTO() {
        OrderParamsDTO orderParam = new OrderParamsDTO();
        String outTradeNo = DateUtils.formatDate(new Date(), "yyyyMMddHHmmss");
        System.out.println("商户订单号：" + outTradeNo);
        orderParam.setTotal_fee(1)
                .setBody("下单测试")
                .setTrade_type("NATIVE")
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
    public void downloadbill() throws Exception {

        DownloadBillParams params = getDownloadBillParamsDTO();

        PowerMockito.doReturn(requestXml()).when(basePaymentService, "createXmlRequest",
                Mockito.any(DownloadBillParams.class), Mockito.any(WechatPubPropertiesConfig.class), Mockito.any());

        mockResponseAndIgnoreVerifySign(responseAllData());

        List<WechatDownloadBillResData> result = basePaymentService.downloadBill(params, config);
        Assert.assertEquals(3, result.size());

    }


    private DownloadBillParams getDownloadBillParamsDTO() {
        DownloadBillParamsDTO params = new DownloadBillParamsDTO();
        params.setBill_date("20180921")
                .setBill_type("ALL");
        return params;
    }


    private String requestXml() {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n" +
                "<xml>\n" +
                "<nonce_str>BMBVFrSGgSa1gQMSwGhq9oDToT0pwl9A</nonce_str>\n" +
                "<bill_date>20180821</bill_date>\n" +
                "<appid>wxd23d0632ad28c805</appid>\n" +
                "<sign>10B78DB18F4D1456776F347F0477B4C0</sign>\n" +
                "<bill_type>ALL</bill_type>\n" +
                "<mch_id>1510598081</mch_id>\n" +
                "</xml>\n";
    }

    /**
     * 返回退款对账单数据，与全部对账单格式有差别
     *
     * @return
     */
    private String responseFefundData() {
        return "交易时间,公众账号ID,商户号,子商户号,设备号,微信订单号,商户订单号,用户标识,交易类型,交易状态,付款银行,货币种类,总金额,企业红包金额,退款申请时间,退款成功时间,微信退款单号,商户退款单号,退款金额,企业红包退款金额,退款类型,退款状态,商品名称,商户数据包,手续费,费率\n" +
                "`2018-08-20 14:40:09,`wx34723380b2d8a699,`1510598081,`1511458511,`,`4200000145201808202300523655,`2018082010,`oDodT0XcpFfrHVR9Kc_VgpFOj8lQ,`NATIVE,`REFUND,`CFT,`CNY,`0.00,`0.00,`2018-08-21 18:13:10,`2018-08-21 18:13:12,`50000707812018082106030155182,`1012413262018082023005236551534846383,`0.01,`0.00,`ORIGINAL,`SUCCESS,`微信下单单元测试-2,`,`0.00000,`1.00%\n" +
                "`2018-08-20 16:38:50,`wx34723380b2d8a699,`1510598081,`1511458511,`,`4200000153201808209352891155,`2018082012,`oDodT0XcpFfrHVR9Kc_VgpFOj8lQ,`NATIVE,`REFUND,`CFT,`CNY,`0.00,`0.00,`2018-08-21 18:11:13,`2018-08-21 18:11:15,`50000307952018082106030149502,`1012413262018082093528911551534846254,`0.01,`0.00,`ORIGINAL,`SUCCESS,`微信下单开发环境测试,`,`0.00000,`1.00%\n" +
                "`2018-08-20 16:33:51,`wx34723380b2d8a699,`1510598081,`1511458511,`,`4200000158201808206112598907,`2018082011,`oDodT0XcpFfrHVR9Kc_VgpFOj8lQ,`NATIVE,`REFUND,`CFT,`CNY,`0.00,`0.00,`2018-08-21 18:12:37,`2018-08-21 18:12:38,`50000307862018082106030153581,`1012413262018082061125989071534846349,`0.01,`0.00,`ORIGINAL,`SUCCESS,`微信下单开发环境测试,`,`0.00000,`1.00%\n" +
                "总交易单数,总交易额,总退款金额,总企业红包退款金额,手续费总金额\n" +
                "`3,`0.00,`0.03,`0.00,`0.00000\n";
    }

    /**
     * 返回全部对账单数据，与退款对账单格式有差别
     *
     * @return
     */
    private String responseAllData() {
        return "交易时间,公众账号ID,商户号,子商户号,设备号,微信订单号,商户订单号,用户标识,交易类型,交易状态,付款银行,货币种类,总金额,企业红包金额,微信退款单号,商户退款单号,退款金额,企业红包退款金额,退款类型,退款状态,商品名称,商户数据包,手续费,费率\n" +
                "`2018-08-21 18:13:12,`wx34723380b2d8a699,`1510598081,`1511458511,`,`4200000145201808202300523655,`2018082010,`oDodT0XcpFfrHVR9Kc_VgpFOj8lQ,`NATIVE,`REFUND,`CFT,`CNY,`0.00,`0.00,`50000707812018082106030155182,`1012413262018082023005236551534846383,`0.01,`0.00,`ORIGINAL,`SUCCESS,`微信下单单元测试-2,`,`0.00000,`1.00%\n" +
                "`2018-08-21 18:11:15,`wx34723380b2d8a699,`1510598081,`1511458511,`,`4200000153201808209352891155,`2018082012,`oDodT0XcpFfrHVR9Kc_VgpFOj8lQ,`NATIVE,`REFUND,`CFT,`CNY,`0.00,`0.00,`50000307952018082106030149502,`1012413262018082093528911551534846254,`0.01,`0.00,`ORIGINAL,`SUCCESS,`微信下单开发环境测试,`,`0.00000,`1.00%\n" +
                "`2018-08-21 18:12:38,`wx34723380b2d8a699,`1510598081,`1511458511,`,`4200000158201808206112598907,`2018082011,`oDodT0XcpFfrHVR9Kc_VgpFOj8lQ,`NATIVE,`REFUND,`CFT,`CNY,`0.00,`0.00,`50000307862018082106030153581,`1012413262018082061125989071534846349,`0.01,`0.00,`ORIGINAL,`SUCCESS,`微信下单开发环境测试,`,`0.00000,`1.00%\n" +
                "总交易单数,总交易额,总退款金额,总企业红包退款金额,手续费总金额\n" +
                "`3,`0.00,`0.03,`0.00,`0.00000\n";
    }

    /**
     * config mock设置
     */
    private void mockitoConfig() {
        PowerMockito.when(config.getAppID()).thenReturn("123");
        PowerMockito.when(config.getMchID()).thenReturn("123");
        PowerMockito.when(config.getSubAppId()).thenReturn("123");
        PowerMockito.when(config.getSubMchId()).thenReturn("123");
        PowerMockito.when(config.getKey()).thenReturn("123");
        PowerMockito.when(config.getStatementPath()).thenReturn("/Users/yujinshui/Desktop/");

        PowerMockito.when(config.getPayUrl()).thenReturn("https://api.mch.weixin.qq.com/pay/unifiedorder");
        PowerMockito.when(config.getNotifyUrl()).thenReturn("http://dev.api.qdingnet.com/qds-payment-admin-web/notify/wechat/receive");
        PowerMockito.when(config.getRefundUrl()).thenReturn("https://api.mch.weixin.qq.com/secapi/pay/refund");
        PowerMockito.when(config.getOrderQueryUrl()).thenReturn("https://api.mch.weixin.qq.com/pay/orderquery");
        PowerMockito.when(config.getCloseOrderUrl()).thenReturn("https://api.mch.weixin.qq.com/pay/closeorder");
        PowerMockito.when(config.getDownloadBillUrl()).thenReturn("https://api.mch.weixin.qq.com/pay/downloadbill");
        PowerMockito.when(config.getRefundQueryUrl()).thenReturn("https://api.mch.weixin.qq.com/pay/refundquery");
        PowerMockito.when(config.connectionsPerRoute()).thenReturn("200");

        try {

            PowerMockito.when(config.getCertStream()).thenReturn(new FileInputStream(new File(pkcs12Path)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
