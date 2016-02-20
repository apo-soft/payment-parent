package cn.aposoft.ecommerce.payment.wechat.util;

import cn.aposoft.ecommerce.payment.wechat.Config;
import cn.aposoft.ecommerce.payment.wechat.OrderVo;
import cn.aposoft.ecommerce.payment.wechat.Test;
import cn.aposoft.ecommerce.payment.wechat.impl.PayRequest;
import cn.aposoft.ecommerce.payment.wechat.impl.PropertiesConfig;
import cn.aposoft.ecommerce.payment.wechat.impl.ReflectEntityUtil;
import cn.aposoft.ecommerce.payment.wechat.impl.SimpleEntityUtil;

public class ReflectionEntityUtilTest {
	private static Config config = new PropertiesConfig("E:/environments/pay/wechat/wechatpay.properties", "utf-8");

	public static void main(String[] args) {

		OrderVo order = Test.setValue(config);
		SimpleEntityUtil utl1 = (SimpleEntityUtil) SimpleEntityUtil.getInstance();
		PayRequest payRequest = utl1.createPayRequest(order, config);
		System.out.println("********************************************");
		String sign1 = utl1.createPaySign(payRequest, config.key());
		System.out.println("********************************************");
		ReflectEntityUtil utl2 = new ReflectEntityUtil();
		String sign2 = utl2.createPaySign(payRequest, config.key());
		System.out.println(sign1);
		System.out.println(sign2);
	}

}
