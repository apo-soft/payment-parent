package cn.aposoft.ecommerce.wechat.service.mock;

import cn.aposoft.ecommerce.wechat.beans.DownloadBillParamsDTO;
import cn.aposoft.ecommerce.wechat.beans.protocol.downloadbill_protocol.WechatDownloadBillResData;
import cn.aposoft.ecommerce.wechat.config.BaseWechatConfig;
import cn.aposoft.ecommerce.wechat.config.WechatPubPropertiesConfig;
import cn.aposoft.ecommerce.wechat.httpclient.HttpRequestUtil;
import cn.aposoft.ecommerce.wechat.httpclient.HttpRequestUtilImpl;
import cn.aposoft.ecommerce.wechat.params.DownloadBillParams;
import cn.aposoft.ecommerce.wechat.service.impl.BasePaymentServiceImpl;
import cn.aposoft.ecommerce.wechat.service.middle.PaymentServiceImpl;
import org.easymock.ConstructorArgs;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;

/**
 * @author code
 * @Title: PaymentServiceMockTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/9/20下午5:34
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(PaymentServiceImpl.class)
public class BasePaymentServiceMockTest {
    private String pkcs12Path = "/Users/yujinshui/Desktop/千丁互联/项目资料/微信公众号信息/cert/apiclient_cert.p12";
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Mock
    private WechatPubPropertiesConfig config;
    @Mock
    private HttpRequestUtilImpl httpClientUtil;
    /**
     * 注意，此处进行创建的实例类为 BasePaymentServiceImpl，但是待测试的类为 PaymentServiceImpl(即 @PrepareForTest(PaymentServiceImpl.class))，
     * 如果改为  @PrepareForTest(BasePaymentServiceImpl.class)  当调用 HttpRequestUtilImpl 的实例时，会提示 null 异常。具体为什么会这样尚不清楚
     *
     * 如果要强制使用  @PrepareForTest(BasePaymentServiceImpl.class) 方式，需要通过构造函数注入参数信息，参见 PrepareForBasePaymentServiceMockTest测试类
     */
    @InjectMocks
    protected BasePaymentServiceImpl basePaymentService;

    @Before
    public void setUp() throws Exception {
        basePaymentService = PowerMockito.spy(basePaymentService);
    }


    @Test
    public void downloadbill() throws Exception {
        mockitoConfig();
        DownloadBillParams params = getDownloadBillParamsDTO();

        //此处可以免去执行  createXmlRequest 方法，直接得到返回值，但是，PaymentServiceMockTest类里面，暂时无法对该方法进行监控，问题信息(即使监控也会执行方法体)原因不明。
        PowerMockito.doReturn(requestXml()).when(basePaymentService, "createXmlRequest",
                Mockito.any(DownloadBillParams.class), Mockito.any(WechatPubPropertiesConfig.class), Mockito.any());

        PowerMockito.doReturn(responseAllData()).when(httpClientUtil).post(Mockito.any(String.class), Mockito.any(BaseWechatConfig.class), Mockito.any(String.class));
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
