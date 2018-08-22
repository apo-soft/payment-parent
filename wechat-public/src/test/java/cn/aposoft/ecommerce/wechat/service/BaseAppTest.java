package cn.aposoft.ecommerce.wechat.service;

import cn.aposoft.ecommerce.wechat.config.BaseWechatConfig;
import cn.aposoft.ecommerce.wechat.config.WechatPubPropertiesConfig;
import cn.aposoft.ecommerce.wechat.httpclient.HttpRequestUtil;
import cn.aposoft.ecommerce.wechat.httpclient.HttpRequestUtilImpl;
import cn.aposoft.ecommerce.wechat.service.impl.BasePaymentServiceImpl;
import cn.aposoft.ecommerce.wechat.service.middle.PaymentServiceImpl;
import org.junit.Before;

/**
 * @author code
 * @Title: BaseAppTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/8/19下午8:57
 */
public class BaseAppTest {

    public static BaseWechatConfig config = new WechatPubPropertiesConfig();

    private HttpRequestUtil httpClientUtl = null;
    private BasePaymentService basePaymentService = null;
    PaymentService paymentService = null;

    @Before
    public void config() {

        httpClientUtl = HttpRequestUtilImpl.getInstance(config);
        basePaymentService = new BasePaymentServiceImpl(httpClientUtl);
        paymentService = new PaymentServiceImpl(config, basePaymentService);
    }
}
