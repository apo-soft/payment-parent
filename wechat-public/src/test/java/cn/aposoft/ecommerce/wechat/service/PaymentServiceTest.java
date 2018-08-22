package cn.aposoft.ecommerce.wechat.service;

import cn.aposoft.ecommerce.wechat.beans.OrderParamsDTO;
import cn.aposoft.ecommerce.wechat.httpclient.HttpRequestUtil;
import cn.aposoft.ecommerce.wechat.httpclient.HttpRequestUtilImpl;
import cn.aposoft.ecommerce.wechat.params.OrderParams;
import cn.aposoft.ecommerce.wechat.service.impl.BasePaymentServiceImpl;
import cn.aposoft.ecommerce.wechat.service.middle.PaymentServiceImpl;
import org.junit.Test;

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
        OrderParamsDTO orderParam = new OrderParamsDTO();
        paymentService.pay(orderParam);
    }

}
