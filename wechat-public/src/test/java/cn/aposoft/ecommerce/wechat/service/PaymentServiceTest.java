package cn.aposoft.ecommerce.wechat.service;

import cn.aposoft.ecommerce.wechat.beans.OrderParamsDTO;
import cn.aposoft.ecommerce.wechat.beans.OrderQueryParamsDTO;
import cn.aposoft.ecommerce.wechat.beans.protocol.pay_protocol.WeChatPayResData;
import cn.aposoft.ecommerce.wechat.beans.protocol.pay_query_protocol.WechatPayQueryResData;
import cn.aposoft.ecommerce.wechat.params.OrderQueryParams;
import cn.aposoft.ecommerce.wechat.tencent.WechatConstant;
import com.alibaba.fastjson.JSON;
import org.junit.Assert;
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
        orderParam.setTotal_fee(1)
                .setBody("下单测试")
//                .setTrade_type(TradeTypeEnum.NATIVE.name())
                .setTrade_type(TradeTypeEnum.JSAPI.name())
                .setNotify_url("http://123")
                .setOut_trade_no("123321")
                .setSpbill_create_ip("123.32.15.22")
//                .setOpenid("o44s5uBeQvP0Oof_s3u7SdacmkJ0")
                .setSign_type(WechatConstant.HMACSHA256)
                ;
        WeChatPayResData payResult = paymentService.pay(orderParam);
        Assert.assertNotNull(payResult);
        System.out.println(JSON.toJSONString(payResult));
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

}

enum TradeTypeEnum{
    NATIVE,JSAPI
}
